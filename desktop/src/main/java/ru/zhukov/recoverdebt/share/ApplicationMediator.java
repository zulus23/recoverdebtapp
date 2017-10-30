package ru.zhukov.recoverdebt.share;

import ru.zhukov.recoverdebt.calendar.InvestigatorCalendarController;
import ru.zhukov.recoverdebt.debt.DebtController;
import ru.zhukov.recoverdebt.domain.CurrentUser;

import java.util.WeakHashMap;
import java.util.concurrent.ArrayBlockingQueue;

public class ApplicationMediator {

    private CurrentUser currentUser;

    private ArrayBlockingQueue<DebtController> debtControllerArrayBlockingQueue;
    private ArrayBlockingQueue<InvestigatorCalendarController> investigatorCalendarControllerArrayBlockingQueue;

    public ApplicationMediator(CurrentUser currentUser) {
        this.debtControllerArrayBlockingQueue = new ArrayBlockingQueue<DebtController>(1);
        this.investigatorCalendarControllerArrayBlockingQueue = new ArrayBlockingQueue<InvestigatorCalendarController>(1);
        this.currentUser = currentUser;
    }

    public void registerDebtController(DebtController debtController){
        this.debtControllerArrayBlockingQueue.add(debtController);
    }
    public void unRegisterDebtController(DebtController debtController){
        this.debtControllerArrayBlockingQueue.remove(debtController);
    }

    public  DebtController getDbController(){
        return this.debtControllerArrayBlockingQueue.peek();
    }

    public CurrentUser getCurrentUser() {
        return currentUser;
    }
}
