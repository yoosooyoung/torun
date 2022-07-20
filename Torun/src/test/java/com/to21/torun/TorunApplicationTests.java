package com.to21.torun;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.to21.torun.mapper.TimeMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class TorunApplicationTests {

    @Autowired
    private TimeMapper timeMapper;

    @Test
    public void testGetTime() {
        log.info("timeMapper class name: " + timeMapper.getClass().getName());
        log.info("timeMapper time: " + timeMapper.getTime());
    }
}
