package com.example.demo.domain.regex;

import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegexTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void replaceAllDisNumTest() {
        logger.info(Regex.replaceAllDisNum("  11weq1aswe*%.223"));
    }

    @Test
    public void splitAppointIntervalTest() {
        logger.info(Regex.splitAppointInterval("aaaafefefbbbb"));
    }

    @Test
    public void matchesTest() {
        // 邮箱格式
        String regexEmail = "[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+";
        Assert.assertFalse(Regex.matches("a", regexEmail));
        Assert.assertFalse(Pattern.matches(regexEmail, "a"));
        Assert.assertTrue(Pattern.matches(regexEmail, "a@-.s"));
        Assert.assertTrue(Regex.matches("a@gmail.com", regexEmail));
    }
}
