package ru.zhukov.recoverdebt.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

/** Модель долга
 * @author Zhukov
 * */
public class Debt {
    private Long id;

    private String number;
    private Borrower borrower;
    private Investigator investigator;
    private BigDecimal sum;
    private LocalDate dateBeginWork;





}
