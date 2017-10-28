package ru.zhukov.recoverdebt.bootstrap;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.zhukov.recoverdebt.ApplicationController;

public class BootstrapApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationController.Instance().createLoginWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
