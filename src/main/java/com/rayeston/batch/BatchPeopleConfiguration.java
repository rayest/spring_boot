package com.rayeston.batch;

import com.qiniu.storage.BucketManager;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by lirui on 2017/10/6.
 */
@Configuration
@EnableBatchProcessing
public class BatchPeopleConfiguration {

    @Resource
    public JobBuilderFactory jobBuilderFactory;

    @Resource
    public StepBuilderFactory stepBuilderFactory;

    @Resource
    public DataSource dataSource;

    @Bean
    public FlatFileItemReader<BatchPeople> reader() {
        FlatFileItemReader<BatchPeople> reader = new FlatFileItemReader<BatchPeople>();
        reader.setResource(new ClassPathResource("batch-data.csv"));
        reader.setLineMapper(new DefaultLineMapper<BatchPeople>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "firstName", "lastName" });
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<BatchPeople>() {{
                setTargetType(BatchPeople.class);
            }});
        }});
        return reader;
    }

    @Bean
    public BatchPeopleItemProcessor processor() {
        return new BatchPeopleItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<BatchPeople> writer() {
        JdbcBatchItemWriter<BatchPeople> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<BatchPeople>());
        writer.setSql("INSERT INTO batch_people (first_name, last_name) VALUES (:firstName, :lastName)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<BatchPeople, BatchPeople> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

}
