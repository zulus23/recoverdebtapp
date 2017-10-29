package ru.zhukov.recoverdebt.service;

import ru.zhukov.recoverdebt.domain.CurrentUser;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface AuthenticationService {

    CompletableFuture<Optional<CurrentUser>> authentication(String username, char[] password);
}
