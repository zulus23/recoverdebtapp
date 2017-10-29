package ru.zhukov.recoverdebt.service;

import ru.zhukov.recoverdebt.domain.CurrentUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class AuthenticationServiceInMemory implements AuthenticationService {



    @Override
    public CompletableFuture<Optional<CurrentUser>> authentication(String username, char[] password) {


        if(username.equals("user1") && String.valueOf(password).equals("1")){
            return  CompletableFuture.supplyAsync(() ->Optional.of(new CurrentUser("Иванов Иван Иванович")));
        }


        return  CompletableFuture.supplyAsync(()->Optional.empty());
    }





}
