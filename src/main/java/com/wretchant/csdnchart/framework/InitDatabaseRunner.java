package com.wretchant.csdnchart.framework;


import com.wretchant.csdnchart.annotation.InfoLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Slf4j
@Component
public class InitDatabaseRunner implements ApplicationRunner {

    @Value("${spring.application.name}")
    private String name;


    @InfoLog("初始化数据库")
    @Override
    public void run(ApplicationArguments args) throws Exception {



    }
}
