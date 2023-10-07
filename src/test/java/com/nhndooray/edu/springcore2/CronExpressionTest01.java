package com.nhndooray.edu.springcore2;

import com.nhndooray.edu.springcore2.job.ScheduledApplication03;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.support.CronExpression;

import java.time.LocalDateTime;

public class CronExpressionTest01 {

    // TODO - 06
    @Test
    public void testCronExpression() {

        CronExpression cronExpression = CronExpression.parse(ScheduledApplication03.EVERY_10_SECOND);

        LocalDateTime dt = LocalDateTime.of(2023, 10, 16, 0, 0, 7);
        dt = cronExpression.next(dt);
        Assertions.assertEquals("2023-10-16T00:00:10", dt.toString());

        dt = cronExpression.next(dt);
        Assertions.assertEquals("2023-10-16T00:00:20", dt.toString());

        dt = cronExpression.next(dt);
        Assertions.assertEquals("2023-10-16T00:00:30", dt.toString());

        dt = cronExpression.next(dt);
        Assertions.assertEquals("2023-10-16T00:00:40", dt.toString());
    }

}
