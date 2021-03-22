package controller;

import javadb.CustomerDAO;
import javadb.DBaccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Customer;
import main.ApplicationLauncher;

import java.util.List;

public class KlantenBeheerController {
    private CustomerDAO customerDAO;
    private DBaccess dBaccess;

    @FXML
    ListView<Customer> customerList;

    @FXML
    TextField warningText;

    public KlantenBeheerController() {
        super();
        this.dBaccess = ApplicationLauncher.getDBaccess();
    }

    public void setup() {
        this.customerDAO = new CustomerDAO(dBaccess);
        List<Customer> allCustomers = customerDAO.getAllCustomers();
        for (Customer c : allCustomers) {
            customerList.getItems().add(c);
        }
    }

    @FXML
    public void doChangeCustomer(ActionEvent event) {
        Customer customer = customerList.getSelectionModel().getSelectedItem();
        // TODO: als de gebruiker geen klant heeft aangeklikt dan gaat het mis. Zorg voor code die dit afvangt.
        // TODO: Let wel: Er is een Textfield 'warningText' beschikbaar. Die staat op invisible.
        ApplicationLauncher.getSceneManager().showExistingCustomerScene(customer);

    }

    // TODO: Schrijf een methode, zodat je terug kunt naar het menu. Koppel deze methode aan de knop in het juist FXML-bestand.

}
