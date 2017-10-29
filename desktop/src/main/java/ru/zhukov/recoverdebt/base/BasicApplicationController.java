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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.controlsfx.control.MaskerPane;
import org.controlsfx.control.StatusBar;
import ru.zhukov.recoverdebt.action.Action;
import ru.zhukov.recoverdebt.calendar.InvestigatorCalendarController;
import ru.zhukov.recoverdebt.debt.DebtController;
import ru.zhukov.recoverdebt.share.ApplicationMediator;

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
    private BorderPane borderPane;

    @FXML
    private MenuItem miExit;
    @FXML
    private MenuItem miDebtList;

    @FXML
    private MenuItem miCalendar;
    @FXML
    private MenuItem miPreferences;
    @FXML
    private MenuItem miPrintDocument;

    @FXML
    private MenuItem miClose;


    @FXML
    private AnchorPane mainWindow;

    @FXML
    private TabPane tpWindowContainer;
    @FXML
    StackPane stackPane;

    private Tab currentTab;
    private ProgressBar progressBarCreateAccountRecord;

    private StatusBar statusBar;

    private MaskerPane masker;

    private Locale localeApplication;

    private ApplicationMediator applicationMediator;

    public BasicApplicationController(ApplicationMediator applicationMediator){
        localeApplication = new Locale("ru","RU");
        this.applicationMediator = applicationMediator;

        masker = new MaskerPane();
        masker.setVisible(false);
        masker.setText("Формирую файл. Ожидайте...");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        this.resourceBundle = resources;
        //miDebtList.setOnAction(this::OpenCalendar);
        miDebtList.setOnAction((e)->shoListDebt());
        miCalendar.setOnAction(this::OpenCalendar);
        miCalendar.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        miExit.setOnAction(Action::exit);
        miExit.setAccelerator(KeyCombination.keyCombination("Ctrl+F4"));
        //miNewDocument.setGraphic(new ImageView(new Image(getClass().getResource("/ru/zhukov/assests/image16/document.png").toExternalForm())));
        //miPreferences.setGraphic(new ImageView(new Image(getClass().getResource("/ru/zhukov/assests/image16/application-gear.png").toExternalForm())));
        miPrintDocument.setGraphic(new ImageView(new Image(getClass().getResource("/ru/zhukov/recoverdebt/assests/image16/document-print.png").toExternalForm())));
        //tToolBar.getItems().add(exitButton);

        Button debtViewShow = new Button();
        debtViewShow.setGraphic(new ImageView(new Image(getClass().getResource("/ru/zhukov/recoverdebt/assests/image32/listdebt.png").toExternalForm())));
        debtViewShow.setTooltip(new Tooltip("Показать список должников"));
        debtViewShow.setOnAction((e)->shoListDebt());
        Button calendarShow = new Button();
        calendarShow.setGraphic(new ImageView(new Image(getClass().getResource("/ru/zhukov/recoverdebt/assests/image32/calendar.png").toExternalForm())));
        calendarShow.setTooltip(new Tooltip("Показать календарь"));
        calendarShow.setOnAction(this::OpenCalendar);

        Button addCommentButton = new Button();
        addCommentButton.setGraphic(new ImageView(new Image(getClass().getResource("/ru/zhukov/recoverdebt/assests/image32/document_note-add.png").toExternalForm())));
        addCommentButton.setTooltip(new Tooltip("Добавить комментарии"));
        //addCommentButton.setAccelerator(KeyCombination.keyCombination("Ctrl+F4"));
        //addCommentButton.setOnAction(this::OpenCalendar);


        tToolBar.getItems().add(debtViewShow);
        tToolBar.getItems().add(new Separator(Orientation.VERTICAL));
        tToolBar.getItems().add(addCommentButton);
        tToolBar.getItems().add(new Separator(Orientation.VERTICAL));
        tToolBar.getItems().add(calendarShow);

        statusBar = new StatusBar();

        this.borderPane.setBottom(statusBar);

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
