package ru.zhukov.recoverdebt.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication(scanBasePackages = {"ru.zhukov.recoverdebt"})
public class RecoverDebtApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecoverDebtApplication.class,args);
    }

}
