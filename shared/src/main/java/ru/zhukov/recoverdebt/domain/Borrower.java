package ru.zhukov.recoverdebt.domain;


import java.util.List;

/**
 * Модель заемщика
 * @author Zhukov
 *
 * */
public final class Borrower {

    private String name;

    private List<Address> address;
    private List<Phone> phones;
}
