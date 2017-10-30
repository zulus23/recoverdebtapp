package ru.zhukov.recoverdebt.setup;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ru.zhukov.recoverdebt.action.Action;
import ru.zhukov.recoverdebt.exception.BaseException;
import ru.zhukov.recoverdebt.utils.SetupApplication;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class SetupController implements Initializable {

    @FXML
    private TextField tPathToDB;
    @FXML
    private Button bSave;
    @FXML
    private Button bCancel;
    @FXML
    private AnchorPane setupApplicationViewPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tPathToDB.setText(SetupApplication.getInstance().readPathDB());

        bSave.disableProperty().bind(tPathToDB.textProperty().isEmpty());
        bSave.setOnAction(this::SaveCommand);
        bCancel.setOnAction(e -> this.closeWindow());
    }

    private void SaveCommand(ActionEvent actionEvent) {
        try {
            SetupApplication.getInstance().savePathDB(tPathToDB.getText());
        }catch (BaseException ex){
            Action.showErrorInformation(ex.getMessage());
        }
        closeWindow();

    }

    private void closeWindow(){
        Optional.of(this.setupApplicationViewPane).map(e -> (Stage)e.getScene().getWindow()).ifPresent(e ->e.close());

    }

}
