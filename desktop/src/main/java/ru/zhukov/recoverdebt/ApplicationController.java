package ru.zhukov.recoverdebt;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.zhukov.recoverdebt.login.LoginController;


import java.io.IOException;

public class ApplicationController {
    private static final ApplicationController applicationController = new ApplicationController();

    public void createLoginWindow(){
        try {

            FXMLLoader fxmlLoginLoader = new FXMLLoader(ApplicationController.class.getResource("/ru/zhukov/recoverdebt/login/LoginView.fxml"));
            LoginController loginController = new LoginController(applicationController);
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
}
