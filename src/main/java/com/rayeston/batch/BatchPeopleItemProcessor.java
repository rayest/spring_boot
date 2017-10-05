package com.rayeston.batch;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by lirui on 2017/10/5.
 */
public class BatchPeopleItemProcessor implements ItemProcessor<BatchPeople, BatchPeople> {

    private Logger logger = LoggerFactory.getLogger(BatchPeopleItemProcessor.class);

    @Override
    public BatchPeople process(final BatchPeople batchPeople) throws Exception {
        final String firstName = batchPeople.getFirstName().toUpperCase();
        final String lastName = batchPeople.getLastName().toUpperCase();
        final BatchPeople transformedBatchPeople = new BatchPeople(firstName, lastName);
        logger.info("Converting (" + batchPeople + ") into (" + transformedBatchPeople + ")");
        return transformedBatchPeople;
    }
}
