package ru.zhukov.recoverdebt.base;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Task;
import javafx.event.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.util.StringConverter;
import org.controlsfx.control.MaskerPane;
import ru.zhukov.recoverdebt.action.Action;


import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Gukov on 24.03.2016.
 */

public class BasicApplicationController implements Initializable {



    private ResourceBundle resourceBundle;

    @FXML
    private ToolBar tToolBar;

    @FXML
    private MenuItem miExit;
    @FXML
    private MenuItem miNewDocument;

    @FXML
    private MenuItem miPreferences;
    @FXML
    private MenuItem miPrintDocument;






    @FXML
    private MenuItem miDeleteRecord;

    @FXML
    private MenuItem miClose;

    /* ------- Справочники -----------*/
    @FXML
    private MenuItem miCostHelper;
    @FXML
    private MenuItem miDepartmentSetup;
    @FXML
    private MenuItem miAccountHelper;

    @FXML
    private MenuItem miAccountInPay;

    /* ----------------------------- */

    /* ------------ Action ---------*/
    @FXML
    private MenuItem miCreateFileTransferTo1C;




    @FXML
    private AnchorPane mainWindow;

    @FXML
    private TabPane tpWindowContainer;
    @FXML
    StackPane stackPane;



    private Tab currentTab;
    private ProgressBar progressBarCreateAccountRecord;




    private int month;
    private int year;

/*    private CurrentUser currentUser;*/

    private MaskerPane masker;

    private Locale localeApplication;


    public BasicApplicationController(){
        localeApplication = new Locale("ru","RU");

        masker = new MaskerPane();
        masker.setVisible(false);
        masker.setText("Формирую файл. Ожидайте...");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.resourceBundle = resources;
        miExit.setOnAction(Action::exit);
        miExit.setAccelerator(KeyCombination.keyCombination("Ctrl+F4"));
        //miNewDocument.setGraphic(new ImageView(new Image(getClass().getResource("/ru/zhukov/assests/image16/document.png").toExternalForm())));
        //miPreferences.setGraphic(new ImageView(new Image(getClass().getResource("/ru/zhukov/assests/image16/application-gear.png").toExternalForm())));
        miPrintDocument.setGraphic(new ImageView(new Image(getClass().getResource("/ru/zhukov/recoverdebt/assests/image16/document-print.png").toExternalForm())));
        //tToolBar.getItems().add(exitButton);


        tToolBar.getItems().add(new Separator(Orientation.VERTICAL));


       // tToolBar.getItems().add(new Separator(Orientation.VERTICAL));






    }


    private void setMarkerNotVisible() {
        Platform.runLater(()-> {
            masker.setVisible(false);
        });
    }




}
