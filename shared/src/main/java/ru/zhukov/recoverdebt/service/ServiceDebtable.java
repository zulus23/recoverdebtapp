package ru.zhukov.recoverdebt.service;

import ru.zhukov.recoverdebt.domain.TypeDebt;
import ru.zhukov.recoverdebt.dto.DebtObject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface ServiceDebtable {

      default List<DebtObject>  listDebtObject(){
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


          return Arrays.asList(debtObject);
      }



}
