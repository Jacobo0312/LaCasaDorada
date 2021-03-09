package ui;

import java.io.IOException;
import java.util.function.DoubleToIntFunction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.Customer;
import model.LaCasaDorada;
import model.Product;
import model.User;

public class LaCasaDoradaGUI {

    @FXML
    private BorderPane pane;

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField createUserFN;

    @FXML
    private TextField createUserLN;

    @FXML
    private PasswordField createUserPA;

    @FXML
    private TextField createUserId;

    @FXML
    private TextField createUserUS;

    // Tables

    // Product

    @FXML
    private TableView<Product> tableProducts;

    @FXML
    private TableColumn<Product, String> colProductsNA;

    @FXML
    private TableColumn<Product, String> colProductsIN;

    @FXML
    private TableColumn<Product, String> colProductsPR;

    @FXML
    private TableColumn<Product, String> colProductsAV;

    @FXML
    private TableColumn<Product, String> colProductsTY;

    // Customers

    @FXML
    private TableView<Customer> tableCustomers;

    @FXML
    private TableColumn<Customer, String> colCustomerFN;

    @FXML
    private TableColumn<Customer, String> colCustomerLN;

    @FXML
    private TableColumn<Customer, String> colCustomerID;

    @FXML
    private TableColumn<Customer, String> colCustomerAD;

    @FXML
    private TableColumn<Customer, String> colCustomerPH;

    @FXML
    private TableColumn<Customer, String> colCustomerCO;

    // --------

    // Create Products
    @FXML
    private TextField createProductName;

    @FXML
    private TextField createProductIngre;

    @FXML
    private TextField createProductSizeSmall;

    @FXML
    private TextField createProductBig;

    @FXML
    private RadioButton createProductDrink;

    @FXML
    private ToggleGroup createProductType;

    @FXML
    private RadioButton createProductDish;

    @FXML
    private RadioButton createProductDessert;

    @FXML
    private ChoiceBox<String> createProductAV;

    //////////

    private LaCasaDorada laCasaDorada;

    public LaCasaDoradaGUI(LaCasaDorada controller) {
        laCasaDorada = controller;
    }

    // Window of welcome--------------------------------------------
    @FXML
    public void loadWelcome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        fxmlLoader.setController(this);
        Parent login = fxmlLoader.load();
        // pane.getChildren().clear();
        pane.setCenter(login);
    }

    // Load Main window

    @FXML
    public void loadMainWindow(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        fxmlLoader.setController(this);
        Parent mainWindow = fxmlLoader.load();
        // pane.getChildren().clear();
        pane.setCenter(mainWindow);
    }

    // Options of the login----------------------------------------

    @FXML
    public void login(ActionEvent event) throws IOException {
        User user = laCasaDorada.getUser(txtUser.getText(), txtPassword.getText());

        if (user == null) {
            txtUser.clear();
            txtPassword.clear();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Log in incorrect");
            alert.setHeaderText(null);
            alert.setContentText("The username and password given are incorrect");

            alert.showAndWait();

        } else {
            // loginUser = user.getUsername();
            loadMainWindow(event);

        }

    }

    // Load window of form----------------------------------------------

    @FXML
    public void loadFormulario(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Form.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();;
        pane.setCenter(form);
    }

    // Create a new user------------------------------------------------------------

    @FXML
    public void addUser(ActionEvent event) throws IOException {
        boolean valid = true;
        String firstName = createUserFN.getText();
        String lastName = createUserLN.getText();
        String id = createUserId.getText();
        String user = createUserUS.getText();
        String password = createUserPA.getText();
        if (firstName.isEmpty() || lastName.isEmpty() || id.isEmpty() || user.isEmpty() || password.isEmpty())
            valid = false;

        if (valid) {

            laCasaDorada.addUser(firstName, lastName, id, user, password);

            loadMainWindow(event);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Account created");
            alert.setHeaderText(null);
            alert.setContentText("The new user has been created");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("You must fill each field in the form");

            alert.showAndWait();

        }

    }

    // load window users------------------------------

    @FXML
    public void loadUsers(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TableUsers.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();;
        pane.setCenter(form);
    }

    // ------------------------------------------------------LOAD
    // WINDOWS------------------------------------------------------------------------

    // load window Products------------------------------

    @FXML
    public void loadProducts(ActionEvent event) throws IOException {

        // Test
        // int price[] = {2,2};
        // String ing[] = {"dssdgsgs"};
        // laCasaDorada.addProducts("name", ing, price, true, "DISH");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TableProducts.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();;
        pane.setCenter(form);
        initializeTableViewProducts();
    }

    // load window Employees------------------------------

    @FXML
    public void loadEmployees(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TableEmployees.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();;
        pane.setCenter(form);
    }

    // load window users------------------------------

    @FXML
    public void loadOrders(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TableOrders.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();;
        pane.setCenter(form);
    }

    // load window customers------------------------------
    @FXML
    public void loadCustomers(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TableCustomers.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();;
        pane.setCenter(form);
        initializeTableViewCustomers();
    }

    // -------------------------------------------------------INITIALIALIZE
    // TABLES--------------------------------------------------------

    // Table products

    @FXML
    private void initializeTableViewProducts() {
        ObservableList<Product> observableList;
        observableList = FXCollections.observableArrayList(laCasaDorada.getProducts());
        tableProducts.setItems(observableList);

        colProductsNA.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        colProductsIN.setCellValueFactory(new PropertyValueFactory<Product, String>("ingredients"));
        colProductsPR.setCellValueFactory(new PropertyValueFactory<Product, String>("pricePerSize"));
        colProductsAV.setCellValueFactory(new PropertyValueFactory<Product, String>("availability"));
        colProductsTY.setCellValueFactory(new PropertyValueFactory<Product, String>("type"));

    }

    // Table customers

    @FXML
    private void initializeTableViewCustomers() {
        ObservableList<Customer> observableList;
        observableList = FXCollections.observableArrayList(laCasaDorada.getCustomers());
        tableCustomers.setItems(observableList);

        colCustomerFN.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
        colCustomerLN.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));
        colCustomerID.setCellValueFactory(new PropertyValueFactory<Customer, String>("id"));
        colCustomerAD.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
        colCustomerPH.setCellValueFactory(new PropertyValueFactory<Customer, String>("phone"));
        colCustomerCO.setCellValueFactory(new PropertyValueFactory<Customer, String>("comments"));
    }

    // ------------------------------------------------------------------------------------------------------------------------------

    // Import data

    @FXML
    public void importData(ActionEvent event) throws IOException {

        laCasaDorada.importProducts("src/data/products.csv");
        laCasaDorada.importCustomers("src/data/customers.csv");

    }

    ////
    // Load window create product

    public void loadCreateProduct(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateProduct.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();
        pane.setCenter(form);

        createProductAV.getItems().addAll("AVAILABLE", "NOT AVAILABLE");

    }

    // Create product

    @FXML
    public void addProduct(ActionEvent event) throws IOException {
        try {

            boolean valid = true;
            String name = createProductName.getText();
            String[] ingredients = createProductIngre.getText().split(" ");
            double priceSmall = Double.parseDouble(createProductSizeSmall.getText());
            double priceBig = Double.parseDouble(createProductBig.getText());

            double[] pricePerSize = { priceSmall, priceBig };

            Boolean availability = false;
            String stringAV = (String) createProductAV.getValue();
            if (stringAV.isEmpty()) {
                valid = false;
            } else {
                if (stringAV == "AVAILABLE")
                    availability = true;
            }

            String type = "";
            if (createProductDish.isSelected()) {
                type = "DISH";
            } else if (createProductDessert.isSelected()) {
                type = "DESSERT";
            } else if (createProductDrink.isSelected()) {
                type = "DRINK";
            } else
                valid = false;

            if (type.isEmpty())
                valid = false;

            // Comprobar que este todo lleno
            if (valid) {

                laCasaDorada.addProducts(name, ingredients, pricePerSize, availability, type);
                loadProducts(event);

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Product created");
                alert.setHeaderText(null);
                alert.setContentText("The new product has been created");

                alert.showAndWait();

            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Validation Error");
                alert.setHeaderText(null);
                alert.setContentText("You must fill each field in the form");

                alert.showAndWait();

            }

        } catch (Exception e) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("You must fill each field in the form");

            alert.showAndWait();
        }

    }

}
