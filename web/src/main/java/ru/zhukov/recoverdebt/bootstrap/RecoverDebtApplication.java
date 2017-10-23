package ru.zhukov.recoverdebt.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ru.zhukov.recoverdebt"})
public class RecoverDebtApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecoverDebtApplication.class,args);
    }

}
