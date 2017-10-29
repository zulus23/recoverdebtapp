package ru.zhukov.recoverdebt.service;

import ru.zhukov.recoverdebt.domain.TypeDebt;
import ru.zhukov.recoverdebt.dto.DebtObject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface ServiceDebtable {

      List<DebtObject>  listDebtObject();

    static List<DebtObject>  mockListDebtObject(){
        DebtObject debtObject =  new DebtObject();
        debtObject.setBorrower("Аббасова Тахмина Мамед Кызы");
        debtObject.setInvestigator("Золотарев В.В.");
        debtObject.setStatus(TypeDebt.COURT.toString());
        debtObject.setDateBeginWork(LocalDate.of(2017,10,20));
        debtObject.setSummaDebt(new BigDecimal("146424.95"));
        debtObject.setSummaDebtCommin(new BigDecimal("1333.86000000002"));
        debtObject.setSummaDebtRemain(new BigDecimal("145091.09"));
        debtObject.setAddressRegistration("Мценский р-н, д. Меркулово, д. 38");
        debtObject.setAddressLive("Мценский р-н, д. Меркулово, д. 38");
        debtObject.setNumberEnforceProceed("22901/15/57005-ИП");
        debtObject.setDateBeginEnforceProceed(LocalDate.of(2015,11,16));
        debtObject.setBirthdayBorrower(LocalDate.of(1970,6,12));
        debtObject.setRosp("Мценский РОСП");
        debtObject.setSpi("Овчинникова Лариса Владимировна");
        debtObject.setLastComment("Позвонить домой");


        DebtObject debtObject1 =  new DebtObject();
        debtObject1.setBorrower("Морнева Людмила Николаевна");
        debtObject1.setInvestigator("ЦАФ");
        debtObject1.setStatus(TypeDebt.COURT.toString());
        debtObject1.setDateBeginWork(LocalDate.of(2017,10,20));
        debtObject1.setSummaDebt(new BigDecimal("52257.46"));
        debtObject1.setSummaDebtCommin(new BigDecimal("0"));
        debtObject1.setSummaDebtRemain(new BigDecimal("52257.46"));
        debtObject1.setAddressRegistration("г. Орел, ул. Маринченко, д. 2, кв.49");
        debtObject1.setAddressLive("г. Орел, ул. Маринченко, д. 2, кв.49");
        debtObject1.setNumberEnforceProceed("");

        debtObject1.setRosp("Северный РОСП");
        debtObject1.setSpi("Егорова А.А.");
        debtObject1.setLastComment("Позвонить соседям");


        return Arrays.asList(debtObject,debtObject1);
    }



}
