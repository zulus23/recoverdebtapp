package ru.zhukov.recoverdebt.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = {"id"})
public class DebtObject {
    private Long id;
    private String borrower;
    private String investigator;
    private String status;
    private LocalDate dateBeginWork;
    private BigDecimal summaDebt;
    private BigDecimal summaDebtCommin;
    private BigDecimal summaDebtRemain;
    private String addressRegistration;
    private String addressLive;
    private String numberEnforceProceed;
    private LocalDate dateBeginEnforceProceed;
    private LocalDate dateEndEnforceProceed;
    private LocalDate birthdayBorrower;
    private String phoneBorrower;
    private String rosp;
    private String spi;
    private String phoneSpi;
    private String nameCourt;
    private String addressCourt;
    private LocalDate dateCourt;
    private String numberCourtProceed;
    private String descriptionCourt;
    private String lastComment;







}
