package com.nhndooray.edu.springcore2;

import com.nhndooray.edu.springcore2.job.ScheduledApplication03;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.support.CronExpression;

import java.time.LocalDateTime;

public class CronExpressionTest02 {

    @Test
    public void testCronExpressionForMacroKeyword() {
        String schedule = "@yearly";

        LocalDateTime dateTime = LocalDateTime.of(2023, 10, 11, 12, 13);
        CronExpression expression = CronExpression.parse(schedule);
        Assertions.assertEquals("2024-01-01T00:00", expression.next(dateTime).toString());
    }


    @Test
    public void testCronExpression_weekdays_01() {

        LocalDateTime dateTime = LocalDateTime.of(2023, 9, 11, 12, 13);

        // 2023-10-01 (일요일)
        // 2023-10-02 (월요일) <-- 2일이면서 평일
        // 2023-10-03 (화요일)
        Assertions.assertEquals("2023-10-02T00:00", CronExpression.parse("0 0 0 2W * *").next(dateTime).toString());
    }

    @Test
    public void testCronExpression_weekdays_02() {

        LocalDateTime dateTime = LocalDateTime.of(2023, 9, 11, 12, 13);

        // 2023-10-06 (금요일)
        // 2023-10-07 (토요일)
        // 2023-10-08 (일요일)
        // 2023-10-09 (월요일)
        Assertions.assertEquals("2023-10-06T00:00", CronExpression.parse("0 0 0 7W * *").next(dateTime).toString());
        Assertions.assertEquals("2023-10-09T00:00", CronExpression.parse("0 0 0 8W * *").next(dateTime).toString());
    }


    @Test
    public void testCronExpression_weekdays_03() {

        LocalDateTime dateTime = LocalDateTime.of(2023, 12, 1, 12, 13);
        CronExpression expression = CronExpression.parse("0 0 0 LW * *");

        // 2023-12-29 (금요일)  <-- 마지막 평일
        // 2023-12-30 (토요일)
        // 2023-12-31 (일요일)
        Assertions.assertEquals("2023-12-29T00:00", expression.next(dateTime).toString());
    }
}
