package ru.zhukov.recoverdebt;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.zhukov.recoverdebt.action.Action;
import ru.zhukov.recoverdebt.base.BasicApplicationController;
import ru.zhukov.recoverdebt.domain.CurrentUser;
import ru.zhukov.recoverdebt.login.LoginController;
import ru.zhukov.recoverdebt.service.AuthenticationService;
import ru.zhukov.recoverdebt.service.AuthenticationServiceInMemory;
import ru.zhukov.recoverdebt.share.ApplicationMediator;


import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;

public class ApplicationController {
    private static final ApplicationController applicationController = new ApplicationController();



    private LoginController loginController;
    private BasicApplicationController baseWindowController;

    private ApplicationMediator applicationMediator;

    //private CurrentUser currentUser;


    private  ApplicationController() {

    }

    public void createLoginWindow(){
        try {

            FXMLLoader fxmlLoginLoader = new FXMLLoader(ApplicationController.class.getResource("/ru/zhukov/recoverdebt/login/LoginView.fxml"));
            loginController = new LoginController(applicationController);
            fxmlLoginLoader.setController(loginController);

            AnchorPane login = fxmlLoginLoader.load();
            //fx:controller="ru.zhukov.ru.zhukov.recoverdebt.login.LoginController"
            ///  loginController.setMainController(applicationController);


            Stage loginStage = new Stage();
            loginStage.initOwner(null);
            loginStage.initModality(Modality.APPLICATION_MODAL);
            loginStage.setResizable(false);
            loginStage.setTitle("Взыскание долга");
            Scene scene = new Scene(login);
            loginStage.getIcons().add(new Image(getClass().getResource("/ru/zhukov/recoverdebt/assests/image/proforma-to_employee.png").toExternalForm()));
            loginStage.setScene(scene);
            loginStage.show();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static ApplicationController Instance(){
        return  applicationController;
    }

    public void authentication(String username, String password){
        AuthenticationService authenticationService = new AuthenticationServiceInMemory();


        authenticationService.authentication(username,password.toCharArray())
                         .whenComplete((user,ex)-> {
                             if (!user.isPresent()) {
                                 Platform.runLater(() -> { this.exceptionReporter(new RuntimeException("Ошибка доступа к БД"));});
                             } else {
                                 Platform.runLater(() -> {
                                     applicationMediator = new ApplicationMediator(user.get());
                                     this.createApplicationWindow();
                                     loginController.close();
                                 });


                             }

                         });
    }

    private void createApplicationWindow() {
        try {
            FXMLLoader fxmlAppLoader = new FXMLLoader(ApplicationController.class.getResource("/ru/zhukov/recoverdebt/base/BasicApplicationView.fxml"));
            fxmlAppLoader.setResources(ResourceBundle.getBundle("Application", new Locale("ru","RU")));
            baseWindowController = new BasicApplicationController(applicationMediator);

            fxmlAppLoader.setController(baseWindowController);
            AnchorPane app = fxmlAppLoader.load();
            Stage stage = new Stage();
            stage.setOnCloseRequest(Action::exit);
            stage.initOwner(null);
            stage.setTitle(applicationMediator.getCurrentUser().getName());
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setMinWidth(800);
            stage.setMinHeight(400);
            stage.setMaximized(true);
            stage.getIcons().add(new Image(getClass().getResource("/ru/zhukov/recoverdebt/assests/image/proforma-to_employee.png").toExternalForm()));
            Scene scene = new Scene(app);
            //stage.setTitle(String.format("РџРµСЂРµРґР°С‡Р° РґР°РЅРЅС‹С… РёР· РђРёРў - %s",nameEnterprise));
          /*  stage.setOnShown(e->{
                baseWindowController.shoListDebt();
            });*/

            stage.setScene(scene);
            stage.show();

        }catch(IOException ex){
            ex.printStackTrace();
        }

    }

    public RuntimeException exceptionReporter(Throwable t) {
        loginController.setTextError(t.getMessage());
        return new RuntimeException(t);
    }

}
