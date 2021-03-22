package controller;

import javadb.CustomerDAO;
import javadb.DBaccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Customer;
import main.ApplicationLauncher;

public class CreateUpdateKlantController {
    private CustomerDAO customerDAO;
    private DBaccess dBaccess;
    private Customer customer;

    @FXML
    private Label titleLabel;

    @FXML
    private TextField klantnummerTextfield;

    @FXML
    private TextField voorlettersTextfield;

    @FXML
    private TextField tussenvoegselTextfield;

    @FXML
    private TextField achternaamTextfield;

    @FXML
    private TextField mobielTextfield;



    public CreateUpdateKlantController() {
        super();
        this.dBaccess = ApplicationLauncher.getDBaccess();
        this.customerDAO = new CustomerDAO(dBaccess);
    }

    @FXML
    public void doStore(ActionEvent actionEvent) {
        createCustomer();
        if (customer != null) {
            if (klantnummerTextfield.getText().equals(("klantnummer"))) {
                customerDAO.storeCustomer(customer);
                klantnummerTextfield.setText(String.valueOf(customer.getCustomerId()));
                Alert opgeslagen = new Alert(Alert.AlertType.INFORMATION);
                opgeslagen.setContentText("Klant opgeslagen");
                opgeslagen.show();
            } else {
                int id = Integer.valueOf(klantnummerTextfield.getText());
                customer.setCustomerId(id);
                customerDAO.updateCustomer(customer);
                Alert gewijzigd = new Alert(Alert.AlertType.INFORMATION);
                gewijzigd.setContentText("Klant gewijzigd");
                gewijzigd.show();
            }
        }
    }

    private void createCustomer() {
        StringBuilder warningText = new StringBuilder();
        boolean correcteInvoer = true;
        String initials = voorlettersTextfield.getText();
        String prefix = tussenvoegselTextfield.getText();
        String surname = achternaamTextfield.getText();
        String mobile = mobielTextfield.getText();

        if (initials.isEmpty()) {
            warningText.append("Je moet voorletters invullen\n");
            correcteInvoer = false;
        }
        if (!correcteInvoer) {
            Alert foutmelding = new Alert(Alert.AlertType.ERROR);
            foutmelding.setContentText(warningText.toString());
            foutmelding.show();
            customer = null;
        } else {
            customer = new Customer(initials, prefix, surname, mobile);
        }
    }

    public void setup(Customer customer) {
        titleLabel.setText("Wijzig klant");
        klantnummerTextfield.setText(String.valueOf(customer.getCustomerId()));
        voorlettersTextfield.setText(customer.getInitials());
        tussenvoegselTextfield.setText(customer.getPrefix());
        achternaamTextfield.setText(customer.getSurName());
        mobielTextfield.setText(customer.getMobilePhone());
    }

    @FXML
    public void doBackToMenu(ActionEvent actionEvent) {
        dBaccess.closeConnection();
        System.out.println("Connection closed");
        ApplicationLauncher.getSceneManager().showWelcomeScene();
    }

    @FXML
    public void doBackToList(ActionEvent actionEvent) {
        dBaccess.closeConnection();
        System.out.println("Connection closed");
        ApplicationLauncher.getSceneManager().showCustomerListScene();
    }
}
