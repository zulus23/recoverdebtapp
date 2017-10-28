package ru.zhukov.recoverdebt.login;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.controlsfx.control.MaskerPane;

import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import ru.zhukov.recoverdebt.ApplicationController;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by Zhukov on 15.03.2016.
 */
public class LoginController  implements Initializable{

    @FXML
    private Button bLogin;
    @FXML
    private Button bCancelLogin;
    @FXML
    private TextField tUserName;
    @FXML
    private PasswordField tPassword;

    @FXML
    private Label tError;

    @FXML
    private StackPane stackPane;



    private ApplicationController applicationController;

    private MaskerPane masker;
    public LoginController(ApplicationController mainController) {
        this.applicationController = mainController;

        masker = new MaskerPane();
        masker.setVisible(false);
        masker.setText("Выполняю проверку. Ожидайте...");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        BooleanBinding booleanBinding = Bindings.or(tUserName.textProperty().isEmpty(),tPassword.textProperty().isEmpty());
        bLogin.disableProperty().bind(booleanBinding);
        bCancelLogin.setOnAction(event -> Platform.exit());
        bLogin.setOnAction(e -> eventLoginAction(e));
        stackPane.getChildren().addAll(masker);


    }

    public void setMainController(ApplicationController mainController){


    }

    private void eventLoginAction(ActionEvent event){

         masker.setVisible(true);
      //  applicationController.authentication(tUserName.getText(),tPassword.getText(),currenSelect);
    }



    public void setTextError(String s) {
           masker.setVisible(false);
           tError.setVisible(true);
           tError.setText(s);

    }
    public void close(){
        Optional.of(this.bLogin).map(e -> (Stage)e.getScene().getWindow()).ifPresent(e ->e.close());
    }





}


