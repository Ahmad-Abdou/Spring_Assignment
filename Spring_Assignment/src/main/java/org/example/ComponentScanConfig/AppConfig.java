package org.example.ComponentScanConfig;

import org.example.dao.StudentDao;
import org.example.dao.StudentDaoImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "org.example.*")
public class AppConfig {

    @Bean("StudentDao")
    public StudentDao studentDaoDao(){
        return new StudentDaoImp();
    }

}