package ru.zhukov.recoverdebt.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = {"ru.zhukov.recoverdebt"})
@ComponentScan(basePackages = "ru.zhukov.recoverdebt")
public class RecoverDebtApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecoverDebtApplication.class,args);
    }

}
