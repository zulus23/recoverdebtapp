package ru.zhukov.recoverdebt.action;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

/**
 * Created by Gukov on 25.10.2017.
 */
public class Action {


    public static  void exit(Event actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Вы действительно хотите закрыть программу?");
        alert.setTitle("Подтверждение закрытия");
        alert.setHeaderText("");
        alert.showAndWait().ifPresent(response ->{
            if(response== ButtonType.CANCEL && actionEvent.getEventType().getName()== WindowEvent.WINDOW_CLOSE_REQUEST.getName()){
                actionEvent.consume();

            }
            if(response== ButtonType.OK && actionEvent.getEventType().getName() == ActionEvent.ACTION.getName()){
                Platform.exit();
            }

        });
    }


    public static  void  showErrorInformation(String s){
        Alert alert = new Alert(Alert.AlertType.ERROR, s);
        alert.setTitle("Ошибка");
        alert.setHeaderText("");
        alert.show();
    }



}
