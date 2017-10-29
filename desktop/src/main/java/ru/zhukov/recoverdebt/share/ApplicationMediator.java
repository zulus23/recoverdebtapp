package ru.zhukov.recoverdebt.share;

import ru.zhukov.recoverdebt.domain.CurrentUser;

public class ApplicationMediator {

    private CurrentUser currentUser;


    public ApplicationMediator(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    public CurrentUser getCurrentUser() {
        return currentUser;
    }
}
