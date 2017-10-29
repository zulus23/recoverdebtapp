package ru.zhukov.recoverdebt.debt;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.table.TableFilter;
import ru.zhukov.recoverdebt.dto.DebtObject;
import ru.zhukov.recoverdebt.service.ServiceDebtable;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class DebtController implements Initializable {

    private ServiceDebtable serviceDebtable;

    @FXML
    private TableView<DebtObject> tableDebt;
    @FXML
    private TableColumn<DebtObject,String> borrower;
    @FXML
    private TableColumn<DebtObject,String> investigator;
    @FXML
    private TableColumn<DebtObject,String> status;
    @FXML
    private TableColumn<DebtObject,LocalDate> dateBeginWork;
    @FXML
    private TableColumn<DebtObject,BigDecimal> summaDebt;
    @FXML
    private TableColumn<DebtObject,BigDecimal> summaDebtCommin;
    @FXML
    private TableColumn<DebtObject,BigDecimal> summaDebtRemain;
    @FXML
    private TableColumn<DebtObject,String> addressRegistration;
    @FXML
    private TableColumn<DebtObject,String> addressLive;
    @FXML
    private TableColumn<DebtObject,String> numberEnforceProceed;
    @FXML
    private TableColumn<DebtObject,LocalDate> dateBeginEnforceProceed;
    @FXML
    private TableColumn<DebtObject,String> lastComment;


    public DebtController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         borrower.setCellValueFactory(new PropertyValueFactory<DebtObject,String>("borrower"));
         borrower.setMinWidth(200);
        // borrower.setPrefWidth(110);
         investigator.setCellValueFactory(new PropertyValueFactory<DebtObject,String>("investigator"));
        investigator.setMinWidth(170);
         status.setCellValueFactory(new PropertyValueFactory<DebtObject,String>("status"));
         status.setMinWidth(100);
         dateBeginWork.setCellValueFactory(new PropertyValueFactory<DebtObject,LocalDate>("dateBeginWork"));
         dateBeginWork.setMinWidth(100);
         summaDebt.setCellValueFactory(new PropertyValueFactory<DebtObject,BigDecimal>("summaDebt"));
         summaDebt.setMinWidth(100);
         summaDebtCommin.setCellValueFactory(new PropertyValueFactory<DebtObject,BigDecimal>("summaDebtCommin"));
         summaDebtCommin.setMinWidth(100);
         summaDebtRemain.setCellValueFactory(new PropertyValueFactory<DebtObject,BigDecimal>("summaDebtRemain"));
         summaDebtRemain.setMinWidth(100);
         addressRegistration.setCellValueFactory(new PropertyValueFactory<DebtObject,String>("addressRegistration"));
        addressRegistration.setMinWidth(200);
         addressLive.setCellValueFactory(new PropertyValueFactory<DebtObject,String>("addressLive"));
         addressLive.setMinWidth(200);
         numberEnforceProceed.setCellValueFactory(new PropertyValueFactory<DebtObject,String>("numberEnforceProceed"));
         numberEnforceProceed.setMinWidth(100);
         dateBeginEnforceProceed.setCellValueFactory(new PropertyValueFactory<DebtObject,LocalDate>("dateBeginEnforceProceed"));
         dateBeginEnforceProceed.setMinWidth(100);
         lastComment.setCellValueFactory(new PropertyValueFactory<DebtObject,String>("lastComment"));
         lastComment.setMinWidth(200);

         this.tableDebt.getItems().addAll(ServiceDebtable.mockListDebtObject());
            TableFilter.forTableView(this.tableDebt).apply();
            this.tableDebt.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2)
                   showDebtDetail();
            });

    }


    public void showDebtDetail(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(DebtController.class.getResource("/ru/zhukov/recoverdebt/debt/DebtDetailView.fxml"));
            //fxmlAppLoader.setResources(ResourceBundle.getBundle("Application", new Locale("ru","RU")));
            DebtDetailController debtDetailController = new DebtDetailController();

            fxmlLoader.setController(debtDetailController);
            AnchorPane debtSetup = fxmlLoader.load();
            AnchorPane anchorPane = new AnchorPane();
            AnchorPane.setTopAnchor(debtSetup, 0.0);
            AnchorPane.setLeftAnchor(debtSetup, 0.0);
            AnchorPane.setRightAnchor(debtSetup, 0.0);
            AnchorPane.setBottomAnchor(debtSetup, 0.0);

            anchorPane.getChildren().add(debtSetup);
            Stage detailDebtDialog = new Stage();
            detailDebtDialog.setTitle("Карточка долга");
            detailDebtDialog.initModality(Modality.WINDOW_MODAL);
            detailDebtDialog.initOwner(this.tableDebt.getParent().getScene().getWindow());
            Scene scene = new Scene(anchorPane);
            detailDebtDialog.setScene(scene);

            detailDebtDialog.showAndWait();


        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
