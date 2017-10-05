package com.rayeston.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.rayeston.foundation.DateUtils.yyyy_MM_dd_HH_mm_ss;

/**
 * Created by lirui on 2017/10/5.
 */
@Component
public class ScheduledTasks implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        logger.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Override
    public void run(String... strings) throws Exception {
        reportCurrentTime();
    }
}
