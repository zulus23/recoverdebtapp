package ru.zhukov.recoverdebt.debt;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.table.TableFilter;
import ru.zhukov.recoverdebt.dto.DebtObject;
import ru.zhukov.recoverdebt.service.ServiceDebtable;

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


    public DebtController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     borrower.setCellValueFactory(new PropertyValueFactory<DebtObject,String>("borrower"));
     investigator.setCellValueFactory(new PropertyValueFactory<DebtObject,String>("investigator"));
     status.setCellValueFactory(new PropertyValueFactory<DebtObject,String>("status"));
     dateBeginWork.setCellValueFactory(new PropertyValueFactory<DebtObject,LocalDate>("dateBeginWork"));
     summaDebt.setCellValueFactory(new PropertyValueFactory<DebtObject,BigDecimal>("summaDebt"));
     summaDebtCommin.setCellValueFactory(new PropertyValueFactory<DebtObject,BigDecimal>("summaDebtCommin"));
     summaDebtRemain.setCellValueFactory(new PropertyValueFactory<DebtObject,BigDecimal>("summaDebtRemain"));
     addressRegistration.setCellValueFactory(new PropertyValueFactory<DebtObject,String>("addressRegistration"));
     addressLive.setCellValueFactory(new PropertyValueFactory<DebtObject,String>("addressLive"));
     numberEnforceProceed.setCellValueFactory(new PropertyValueFactory<DebtObject,String>("numberEnforceProceed"));
     dateBeginEnforceProceed.setCellValueFactory(new PropertyValueFactory<DebtObject,LocalDate>("dateBeginEnforceProceed"));

     this.tableDebt.getItems().addAll(ServiceDebtable.mockListDebtObject());
        TableFilter.forTableView(this.tableDebt).apply();

    }
}
