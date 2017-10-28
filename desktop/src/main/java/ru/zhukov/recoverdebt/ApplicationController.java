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
import ru.zhukov.recoverdebt.login.LoginController;


import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ApplicationController {
    private static final ApplicationController applicationController = new ApplicationController();

    private LoginController loginController;
    private BasicApplicationController baseWindowController;

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
/*        DBAuthenticationService dbAuthenticationService = new DBAuthenticationService();*/

        /*dbAuthenticationService.authentication(username,password,database)

                .handleAsync((user,ex)->{
                    if(user==null){
                        Platform.runLater(()-> exceptionReporter(new SQLException("РћС€РёР±РєР° РёРґРµРЅС‚РёС„РёРєР°С†РёРё.\nРџРѕРїСЂРѕР±СѓР№С‚Рµ РµС‰Рµ СЂР°Р·.")));
                    } else{
                        currentUser = (CurrentUser) user;
*/
                        Platform.runLater(()->{this.createApplicationWindow();loginController.close();});
  /*                  }
                    return "";

                }).exceptionally(this::exceptionReporter);

  */      //Platform.runLater(()->this.createApplicationWindow());





    }

    private void createApplicationWindow() {
        try {
            FXMLLoader fxmlAppLoader = new FXMLLoader(ApplicationController.class.getResource("/ru/zhukov/recoverdebt/base/BasicApplicationView.fxml"));
            fxmlAppLoader.setResources(ResourceBundle.getBundle("Application", new Locale("ru","RU")));
            baseWindowController = new BasicApplicationController();

            fxmlAppLoader.setController(baseWindowController);
            AnchorPane app = fxmlAppLoader.load();
            Stage stage = new Stage();
            stage.setOnCloseRequest(Action::exit);
            stage.initOwner(null);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setMinWidth(800);
            stage.setMinHeight(400);
            stage.setMaximized(true);
            stage.getIcons().add(new Image(getClass().getResource("/ru/zhukov/recoverdebt/assests/image/proforma-to_employee.png").toExternalForm()));
            Scene scene = new Scene(app);
            //stage.setTitle(String.format("РџРµСЂРµРґР°С‡Р° РґР°РЅРЅС‹С… РёР· РђРёРў - %s",nameEnterprise));

            stage.setScene(scene);
            stage.show();

        }catch(IOException ex){
            ex.printStackTrace();
        }

    }


}
