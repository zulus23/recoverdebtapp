package ru.zhukov.recoverdebt.base;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.controlsfx.control.MaskerPane;
import ru.zhukov.recoverdebt.action.Action;
import ru.zhukov.recoverdebt.calendar.InvestigatorCalendarController;
import ru.zhukov.recoverdebt.debt.DebtController;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;


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
        miNewDocument.setOnAction(this::OpenCalendar);
        miExit.setOnAction(Action::exit);
        miExit.setAccelerator(KeyCombination.keyCombination("Ctrl+F4"));
        //miNewDocument.setGraphic(new ImageView(new Image(getClass().getResource("/ru/zhukov/assests/image16/document.png").toExternalForm())));
        //miPreferences.setGraphic(new ImageView(new Image(getClass().getResource("/ru/zhukov/assests/image16/application-gear.png").toExternalForm())));
        miPrintDocument.setGraphic(new ImageView(new Image(getClass().getResource("/ru/zhukov/recoverdebt/assests/image16/document-print.png").toExternalForm())));
        //tToolBar.getItems().add(exitButton);


        tToolBar.getItems().add(new Separator(Orientation.VERTICAL));


       // tToolBar.getItems().add(new Separator(Orientation.VERTICAL));


            shoListDebt();



    }

    private void OpenCalendar(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(BasicApplicationController.class.getResource("/ru/zhukov/recoverdebt/calendar/InvestigatorCalendarView.fxml"));
            //fxmlAppLoader.setResources(ResourceBundle.getBundle("Application", new Locale("ru","RU")));
            InvestigatorCalendarController calendarController = new InvestigatorCalendarController();

            fxmlLoader.setController(calendarController);
            AnchorPane debtSetup = fxmlLoader.load();
            AnchorPane anchorPane = new AnchorPane();
            AnchorPane.setTopAnchor(debtSetup, 0.0);
            AnchorPane.setLeftAnchor(debtSetup, 0.0);
            AnchorPane.setRightAnchor(debtSetup, 0.0);
            AnchorPane.setBottomAnchor(debtSetup, 0.0);

            anchorPane.getChildren().add(debtSetup);
            Tab tabDebt = new Tab();

            tabDebt.setText("calendar");
            tabDebt.setContent(anchorPane);
            tpWindowContainer.setTabMinWidth(160);
            tpWindowContainer.setTabMaxWidth(160);
            tpWindowContainer.getTabs().addAll(tabDebt);
            tpWindowContainer.setVisible(true);


        }catch(IOException ex){
            ex.printStackTrace();
        }

    }

    public void shoListDebt(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(BasicApplicationController.class.getResource("/ru/zhukov/recoverdebt/debt/DebtView.fxml"));
            //fxmlAppLoader.setResources(ResourceBundle.getBundle("Application", new Locale("ru","RU")));
            DebtController debtController = new DebtController();

            fxmlLoader.setController(debtController);
            AnchorPane debtSetup = fxmlLoader.load();
            AnchorPane anchorPane = new AnchorPane();
            AnchorPane.setTopAnchor(debtSetup, 0.0);
            AnchorPane.setLeftAnchor(debtSetup, 0.0);
            AnchorPane.setRightAnchor(debtSetup, 0.0);
            AnchorPane.setBottomAnchor(debtSetup, 0.0);

            anchorPane.getChildren().add(debtSetup);
            Tab tabDebt = new Tab();

            tabDebt.setText("debt");
            tabDebt.setContent(anchorPane);
            tpWindowContainer.setTabMinWidth(160);
            tpWindowContainer.setTabMaxWidth(160);
            tpWindowContainer.getTabs().addAll(tabDebt);
            tpWindowContainer.setVisible(true);


        }catch(IOException ex){
            ex.printStackTrace();
        }

    }


    private void setMarkerNotVisible() {
        Platform.runLater(()-> {
            masker.setVisible(false);
        });
    }




}
