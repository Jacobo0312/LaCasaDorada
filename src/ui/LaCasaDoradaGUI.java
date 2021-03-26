package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Customer;
import model.Employee;
import model.Ingredient;
import model.LaCasaDorada;
import model.Order;
import model.OrdersDetails;
import model.Product;
import model.User;

public class LaCasaDoradaGUI {

    // User account

    private User loginUser; // Evaluar si es mejor que sea un objeto

    @FXML
    private Label labelUser;

    @FXML
    private MenuItem labelLoginOrLogOut;

    // ----------------------

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

    // Orders

    @FXML
    private TableView<Order> tableOrders;

    @FXML
    private TableColumn<Order, Integer> colOrderCO;

    @FXML
    private TableColumn<Order, String> colOrderST;

    @FXML
    private TableColumn<Order, String> colOrderCU;

    @FXML
    private TableColumn<Order, String> colOrderEmployeeCR;

    @FXML
    private TableColumn<Order, String> colOrderDA;

    @FXML
    private TableColumn<Order, Double> colOrderTO;

    @FXML
    private TableColumn<Order, String> colOrderEmployeeDE;

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

    @FXML
    private TableColumn<Customer, String> colCustomerAV;

    // Employees
    // Create employee
    @FXML
    private TextField createEmployeeFN;

    @FXML
    private TextField createEmployeeLN;

    @FXML
    private TextField createEmployeeID;
    // table employees

    @FXML
    private TableView<Employee> tableEmployees;

    @FXML
    private TableColumn<Employee, String> colEmployeesFN;

    @FXML
    private TableColumn<Employee, String> colEmployeesLN;

    @FXML
    private TableColumn<Employee, String> colEmployeesID;

    @FXML
    private TableColumn<Employee, String> colEmployeeAV;

    // --------

    // Create customer
    @FXML
    private TextField createCustomerFN;

    @FXML
    private TextField createCustomerLN;

    @FXML
    private TextField createCustomerID;

    @FXML
    private TextField createCustomerAD;

    @FXML
    private TextField createCustomerPH;

    @FXML
    private TextField createCustomerCO;

    // -----------------------------------

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
    private RadioButton createProductAdditional;

    @FXML
    private ChoiceBox<String> createProductAV;

    // Create order

    @FXML
    private TextField orderComments;
    @FXML
    private TextField orderAddress;

    // Products

    private ArrayList<OrdersDetails> orderProducts = new ArrayList<OrdersDetails>(); // Intentar trabajar desde el
                                                                                     // modelo
    // customer
    private Customer orderCustomer;

    @FXML
    private Label labelCustomer;

    @FXML
    private RadioButton sizeLittle;

    @FXML
    private ToggleGroup size;

    @FXML
    private RadioButton sizeBig;

    @FXML
    private TextField productAmount;

    @FXML
    private TableView<OrdersDetails> tableOrderProducts;

    @FXML
    private TableColumn<OrdersDetails, String> colOrderNA;

    @FXML
    private TableColumn<OrdersDetails, Integer> colOrderAM;

    @FXML
    private TableColumn<OrdersDetails, Integer> colOrderPR;

    // -----------
    // Customer finder
    @FXML
    private Label labelCustomerFinder;

    @FXML
    private TextField filterField;
    // ------

    //////////

    // Show order
    @FXML
    private Label showOrderID;

    @FXML
    private Label showOrderST;

    @FXML
    private Label showOrderCU;

    @FXML
    private Label showOrderDA;

    @FXML
    private Label showOrderAD;

    @FXML
    private Label showOrderCO;

    @FXML
    private Label showOrderTO;

    // --------------------------------------------

    // Reports

    @FXML
    private TextField dateReportSeparate;

    @FXML
    private ComboBox<String> dateReportOrderHourInit;

    @FXML
    private ComboBox<String> dateReportOrderMinutsInit;

    @FXML
    private ComboBox<String> dateReportOrderHourFinal;

    @FXML
    private ComboBox<String> dateReportOrderMinutsFinal;

    @FXML
    private DatePicker dateReportOrderInit;

    @FXML
    private DatePicker dateReportOrderFinal;

    // -----

    // List Ingredients
    @FXML
    private TableView<Ingredient> TableIngredients;

    @FXML
    private TableColumn<Ingredient, String> TableIngredientsName;

    @FXML
    private TableColumn<Ingredient, String> TableIngredientsStatus;

    @FXML
    private ListView<Ingredient> listIngredietns;

    // Set objects

    // set Customer

    @FXML
    private TextField infoCustomerFN;

    @FXML
    private TextField infoCustomerLN;

    @FXML
    private TextField infoCustomerID;

    @FXML
    private TextField infoCustomerAD;

    @FXML
    private TextField infoCustomerPH;

    @FXML
    private TextField infoCustomerCO;

    private Customer setCustomer;

    @FXML
    private Text infoCustomerCreator;

    @FXML
    private Text infoCustomerModify;

    @FXML
    private ChoiceBox<String> infoCustomerAV;


    //Set employee

    private Employee setEmployee;
    @FXML
    private TextField infoEmployeeFN;

    @FXML
    private TextField infoEmployeeLN;

    @FXML
    private TextField infoEmployeeID;

    @FXML
    private ChoiceBox<String> infoEmployeeAV;
    //

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
        labelUser.setText("User");
        labelLoginOrLogOut.setText("Login");
    }

    // Load Main window

    @FXML
    public void loadMainWindow(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        fxmlLoader.setController(this);
        Parent mainWindow = fxmlLoader.load();
        // pane.getChildren().clear();
        pane.setCenter(mainWindow);
        orderCustomer = null;
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
            loginUser = user;
            loadMainWindow(event);
            labelUser.setText(loginUser.getUser());
            labelLoginOrLogOut.setText("Log out");
            // arreglar el log out
        }

    }

    // Log out
    @FXML
    void logOut(ActionEvent event) throws IOException {
        // labelUser.setText""; creo que que se cambia cargando el welcome
        loadWelcome(event);

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

        User userObj = laCasaDorada.addUser(firstName, lastName, id, user, password);

        if (valid && userObj != null) {

            loginUser = userObj;
            loadMainWindow(event);
            labelUser.setText(loginUser.getUser());
            labelLoginOrLogOut.setText("Log out");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Usuario creado");
            alert.setHeaderText(null);
            alert.setContentText("El nuevo usuario ha sido creado");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error de validacion");
            alert.setHeaderText(null);
            alert.setContentText("Tiene algunos campos sin llenar o su nombre se usuario ya ha sido utilizado");

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
        initializeTableViewEmployees();

                // Double click
                tableEmployees.setOnMouseClicked((MouseEvent eventM) -> {
                    if (eventM.getButton().equals(MouseButton.PRIMARY) && eventM.getClickCount() == 2) {
                        // Agregar ventana de cambio
        
                        setEmployee = tableEmployees.getSelectionModel().getSelectedItem();
                        if (setEmployee != null) {
                            try {
                                loadInfoEmployee(setEmployee);
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
        
                    }
                });

    }

    // load window users------------------------------

    @FXML
    public void loadOrders(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TableOrders.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();;
        pane.setCenter(form);
        initializeTableViewOrders();

        tableOrders.setOnMouseClicked((MouseEvent eventM) -> {
            if (eventM.getButton().equals(MouseButton.PRIMARY) && eventM.getClickCount() == 2) {
                // Agregar ventana de cambio
                System.out.println(tableOrders.getSelectionModel().getSelectedItem().toString());
                /*
                setCustomer = tableCustomers.getSelectionModel().getSelectedItem();
                if (setCustomer != null) {
                    try {
                        loadInfoCustomer(setCustomer);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                */

            }
        });

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

        // Double click
        tableCustomers.setOnMouseClicked((MouseEvent eventM) -> {
            if (eventM.getButton().equals(MouseButton.PRIMARY) && eventM.getClickCount() == 2) {
                // Agregar ventana de cambio

                setCustomer = tableCustomers.getSelectionModel().getSelectedItem();
                if (setCustomer != null) {
                    try {
                        loadInfoCustomer(setCustomer);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        });

    }

    // Load list ingredients
    public void loadIngredients(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListIngredients.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();;
        pane.setCenter(form);

        // laCasaDorada.addIngredients("Manzana", "HABILITADO");
        // laCasaDorada.addIngredients("Manzana", "HABILITADO");
        // laCasaDorada.addIngredients("Cinnamon", "DESHABILITADO");
        initializeTableViewingredients();

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
        colCustomerAV.setCellValueFactory(new PropertyValueFactory<Customer, String>("availability"));


    }

    @FXML
    private void initializeTableViewOrders() {

        ObservableList<Order> observableList;
        observableList = FXCollections.observableArrayList(laCasaDorada.getOrders());
        tableOrders.setItems(observableList);

        colOrderCO.setCellValueFactory(new PropertyValueFactory<Order, Integer>("code"));
        colOrderST.setCellValueFactory(new PropertyValueFactory<Order, String>("status"));
        colOrderCU.setCellValueFactory(new PropertyValueFactory<Order, String>("customer"));
        colOrderEmployeeCR.setCellValueFactory(new PropertyValueFactory<Order, String>("employeeCreate"));
        colOrderDA.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
        colOrderTO.setCellValueFactory(new PropertyValueFactory<Order, Double>("total"));
        colOrderEmployeeDE.setCellValueFactory(new PropertyValueFactory<Order, String>("employeeDelivery"));
    }

    @FXML
    private void initializeTableViewEmployees() {
        ObservableList<Employee> observableList;
        observableList = FXCollections.observableArrayList(laCasaDorada.getEmployees());
        tableEmployees.setItems(observableList);

        colEmployeesFN.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
        colEmployeesLN.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
        colEmployeesID.setCellValueFactory(new PropertyValueFactory<Employee, String>("id"));
        colEmployeeAV.setCellValueFactory(new PropertyValueFactory<Employee, String>("availability"));
    }

    @FXML
    private void initializeTableViewingredients() {
        ObservableList<Ingredient> observableList;
        observableList = FXCollections.observableArrayList(laCasaDorada.getIngredients());
        TableIngredients.setItems(observableList);

        TableIngredientsName.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("name"));
        TableIngredientsStatus.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("status"));
    }
    // ------------------------------------------------------------------------------------------------------------------------------

    // Import data

    @FXML
    public void importData(ActionEvent event) throws IOException {
        laCasaDorada.importProducts("src/data/products.csv");
        laCasaDorada.importCustomers("src/data/customers.csv");
        laCasaDorada.importEmployee("src/data/empleados.csv");

    }

    // ---------------------------------------------

    @FXML
    public void loadCreateProduct(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateProduct.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();
        pane.setCenter(form);
        TableIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        initializeTableViewingredients();
        ObservableList<Ingredient> ingredientsOB = TableIngredients.getSelectionModel().getSelectedItems();
        listIngredietns.setItems(ingredientsOB);

        createProductAV.getItems().addAll("AVAILABLE", "NOT AVAILABLE");

    }

    @FXML
    public void loadCreateEmployee(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateEmployee.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();
        pane.setCenter(form);
        initializeTableViewEmployees();
    }

    @FXML
    public void addEmployee(ActionEvent event) throws IOException {
        boolean valid = true;
        String firstName = createEmployeeFN.getText();
        String lastName = createEmployeeLN.getText();
        String id = createEmployeeID.getText();
        if (firstName.isEmpty() || lastName.isEmpty() || id.isEmpty())
            valid = false;

        if (valid) {
            laCasaDorada.addEmployees(firstName, lastName, id);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Empleado creado");
            alert.setHeaderText(null);
            alert.setContentText("El nuevo empleado ha sido creado");
            alert.showAndWait();
            loadEmployees(event);

        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error de validacion");
            alert.setHeaderText(null);
            alert.setContentText("Tiene algunos campos sin llenar");
            alert.showAndWait();

        }

    }

    @FXML
    public void addProduct(ActionEvent event) throws IOException {
        try {

            boolean valid = true;
            String name = createProductName.getText();

            ObservableList<Ingredient> ingredientsOB = listIngredietns.getItems();

            Ingredient[] ingredients = new Ingredient[ingredientsOB.size()];

            for (int i = 0; i < ingredients.length; i++) {
                ingredients[i] = ingredientsOB.get(i);
            }

            // ingredientsOB.clear();

            // array ingredients no puede estar vacio

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
                type = "PLATO";
            } else if (createProductAdditional.isSelected()) {
                type = "ADICIONAL";
            } else if (createProductDrink.isSelected()) {
                type = "BEBIDA";
            } else
                valid = false;

            if (type.isEmpty())
                valid = false;

            // Comprobar que este todo lleno
            if (valid) {

                laCasaDorada.addProducts(name, ingredients, pricePerSize, availability, type, loginUser);
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

    @FXML
    public void createOrder(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateOrder.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();
        pane.setCenter(form);

        if (orderCustomer != null) {
            labelCustomer.setText("Cliente: " + orderCustomer.getFirstName());
            orderAddress.setText(orderCustomer.getAddress());
            orderComments.setText(orderCustomer.getComments());
        }

        else
            labelCustomer.setText("Sin asignar");

        initializeTableViewProducts();
        initializeTableViewOrderProducts();
        initializeTableViewEmployees();

        ObservableList<Employee> observableList;
        observableList = FXCollections.observableArrayList(laCasaDorada.getEmployees()).filtered(customer -> customer.isAvailability() == true);
        tableEmployees.setItems(observableList);

    }

    @FXML
    public void AddProductToOrder(ActionEvent event) {
        try {
            boolean valid = true;
            Product product = tableProducts.getSelectionModel().getSelectedItem();
            if (product == null)
                valid = false;

            String size = "";

            if (sizeBig.isSelected()) {
                size = "BIG";
            } else if (sizeLittle.isSelected()) {
                size = "LITTLE";
            }

            if (size.isEmpty())
                valid = false;

            int amount = Integer.parseInt(productAmount.getText());

            if (valid) {
                orderProducts.add(new OrdersDetails(product, amount, size));
            }
            // agregar el else con las alertas
            initializeTableViewOrderProducts();

        } catch (Exception e) {
            // Alerta de error
        }

    }

    // Table order details
    @FXML
    private void initializeTableViewOrderProducts() {
        ObservableList<OrdersDetails> observableList;
        observableList = FXCollections.observableArrayList(orderProducts);
        tableOrderProducts.setItems(observableList);

        colOrderNA.setCellValueFactory(new PropertyValueFactory<OrdersDetails, String>("product"));
        colOrderAM.setCellValueFactory(new PropertyValueFactory<OrdersDetails, Integer>("amount"));
        colOrderPR.setCellValueFactory(new PropertyValueFactory<OrdersDetails, Integer>("price"));

    }

    // Customer finder

    @FXML
    public void loadCustomerFinder(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerFinder.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();
        pane.setCenter(form);
        initializeTableViewCustomers();

        ObservableList<Customer> observableList;
        observableList = FXCollections.observableArrayList(laCasaDorada.getCustomers())
                .filtered(customer -> customer.isAvailability() == true);

        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Customer> filteredData = new FilteredList<>(observableList, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (customer.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (customer.getLastName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (customer.getId().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(customer.getPhone()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Customer> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableCustomers.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableCustomers.setItems(sortedData);

    }

    @FXML
    public void addOrder(ActionEvent event) throws IOException {

        // fecha y hora
        LocalDateTime date = LocalDateTime.now();
        // -------------

        // Agregar aqui la direccion
        String comment = orderComments.getText();
        String address = orderAddress.getText();
        Employee employeeDelivery = tableEmployees.getSelectionModel().getSelectedItem();

        // Copiar el arraylist y luego limpiar
        // Agregar direccion

        if (!orderProducts.isEmpty() && orderCustomer != null && !comment.isEmpty() && !address.isEmpty()
                && employeeDelivery != null) {

            // Pasar productos a un array
            OrdersDetails[] products = new OrdersDetails[orderProducts.size()];

            for (int i = 0; i < orderProducts.size(); i++) {
                products[i] = orderProducts.get(i);
            }

            // Limpiar arraylist
            orderProducts.clear();

            laCasaDorada.addOrders(products, orderCustomer, loginUser, employeeDelivery, date, address, comment);
            loadOrders(event);// Mandar a la tabla de orders

            orderCustomer = null;
            // Vaciar order details y volver null order customer

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Orden creada");
            alert.setHeaderText(null);
            alert.setContentText("Se creo la nueva orden");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ingrese todos los campos");

            alert.showAndWait();
        }

    }

    @FXML
    public void addOrderCustomer(ActionEvent event) {

        try {
            Customer customer = tableCustomers.getSelectionModel().getSelectedItem();
            orderCustomer = customer;
            labelCustomer.setText("Cliente: " + orderCustomer.getFirstName());
            createOrder(event);
        } catch (Exception e) {
            labelCustomerFinder.setText("Seleccione un cliente");
        }

    }

    @FXML
    public void loadCreateCustomer(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateCustomer.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();
        pane.setCenter(form);

    }

    @FXML
    public void addCustomer(ActionEvent event) throws IOException {

        String firstName = createCustomerFN.getText();
        String lastName = createCustomerLN.getText();
        String id = createCustomerID.getText();
        String address = createCustomerAD.getText();
        String phone = createCustomerPH.getText();
        String comments = createCustomerCO.getText();

        if (firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || phone.isEmpty() || comments.isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("You must fill each field in the form");

            alert.showAndWait();
        } else {
            laCasaDorada.addCustomers(firstName, lastName, id, address, phone, comments, loginUser);
            createOrder(event);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Customer created");
            alert.setHeaderText(null);
            alert.setContentText("The new customer has been created");

            alert.showAndWait();
        }

    }

    @FXML
    public void showOrder(ActionEvent event) throws IOException {

        try {
            Order order = tableOrders.getSelectionModel().getSelectedItem();
            loadShowOrder(event, order);

        } catch (Exception e) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("Seleccione una orden");

            alert.showAndWait();
        }

    }

    public void loadShowOrder(ActionEvent event, Order order) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ShowOrder.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();
        pane.setCenter(form);

        String code = String.valueOf(order.getCode());
        String total = String.valueOf(order.getTotal());

        showOrderID.setText(code);
        showOrderST.setText(order.getStatus().toString());
        showOrderCU.setText(order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName());
        showOrderAD.setText(order.getAddress());// Cambiar a la de la orden
        showOrderDA.setText(order.getDate());
        showOrderCO.setText(order.getComment());
        showOrderTO.setText(total);

        // Pasar el array a arraylist
        OrdersDetails[] products = order.getProducts();
        for (int i = 0; i < products.length; i++) {
            orderProducts.add(products[i]);
        }

        initializeTableViewOrderProducts();

        // Limpiar arraylist de productos

        orderProducts.clear();

    }

    @FXML
    public void setStatus(ActionEvent event) {
        Order order = tableOrders.getSelectionModel().getSelectedItem();
        laCasaDorada.setStatus(order);
        showOrderST.setText(order.getStatus().toString());

    }

    // reports

    @FXML
    public void loadReports(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Reports.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();
        pane.setCenter(form);

        String[] arrayHours = new String[24];

        for (int i = 0; i < arrayHours.length; i++) {
            if (i < 9) {
                arrayHours[i] = "0" + (i);
            } else {
                arrayHours[i] = "" + (i);
            }
        }

        String[] arrayMinutes = new String[60];

        for (int i = 0; i < arrayMinutes.length; i++) {
            if (i < 9) {
                arrayMinutes[i] = "0" + (i);
            } else {
                arrayMinutes[i] = "" + (i);
            }
        }

        dateReportOrderHourInit.getItems().addAll(arrayHours);
        dateReportOrderHourFinal.getItems().addAll(arrayHours);
        dateReportOrderMinutsInit.getItems().addAll(arrayMinutes);
        dateReportOrderMinutsFinal.getItems().addAll(arrayMinutes);

        dateReportOrderHourInit.setValue("00");
        dateReportOrderMinutsInit.setValue("00");
        dateReportOrderHourFinal.setValue("23");
        dateReportOrderMinutsFinal.setValue("59");

        dateReportOrderInit.setValue(LocalDate.now());
        dateReportOrderFinal.setValue(LocalDate.now());

    }

    @FXML
    public void reportOrders(ActionEvent event) throws FileNotFoundException {

        // Init
        String dateInit = dateReportOrderInit.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String hourInit = dateReportOrderHourInit.getValue();
        String minuteInit = dateReportOrderMinutsInit.getValue();

        LocalDateTime dateTimeInit = LocalDateTime.parse(dateInit + "T" + hourInit + ":" + minuteInit + ":00");

        // Final

        String dateFinal = dateReportOrderFinal.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String hourFinal = dateReportOrderHourFinal.getValue();
        String minuteFinal = dateReportOrderMinutsFinal.getValue();
        LocalDateTime dateTimeFinal = LocalDateTime.parse(dateFinal + "T" + hourFinal + ":" + minuteFinal + ":00");

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new ExtensionFilter("Text", "*.txt"));
        File file = fc.showSaveDialog(pane.getScene().getWindow());
        // Seleccioanr que sea .csv
        // Cambiar el null para mantener la ventane

        laCasaDorada.generateReportOrders(dateTimeInit, dateTimeFinal, file.getAbsolutePath(),
                dateReportSeparate.getText());

    }

    @FXML
    public void reportEmployeesDelivery(ActionEvent event) throws FileNotFoundException {
        // Init
        String dateInit = dateReportOrderInit.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String hourInit = dateReportOrderHourInit.getValue();
        String minuteInit = dateReportOrderMinutsInit.getValue();

        LocalDateTime dateTimeInit = LocalDateTime.parse(dateInit + "T" + hourInit + ":" + minuteInit + ":00");

        // Final

        String dateFinal = dateReportOrderFinal.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String hourFinal = dateReportOrderHourFinal.getValue();
        String minuteFinal = dateReportOrderMinutsFinal.getValue();
        LocalDateTime dateTimeFinal = LocalDateTime.parse(dateFinal + "T" + hourFinal + ":" + minuteFinal + ":00");

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new ExtensionFilter("Text", "*.txt"));
        File file = fc.showSaveDialog(pane.getScene().getWindow());
        // Seleccioanr que sea .csv
        // Cambiar el null para mantener la ventane

        laCasaDorada.reportEmployeesDelivery(dateTimeInit, dateTimeFinal, file.getAbsolutePath(),
                dateReportSeparate.getText());
    }

    @FXML
    public void reportProducts(ActionEvent event) throws FileNotFoundException {
        // Init
        String dateInit = dateReportOrderInit.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String hourInit = dateReportOrderHourInit.getValue();
        String minuteInit = dateReportOrderMinutsInit.getValue();

        LocalDateTime dateTimeInit = LocalDateTime.parse(dateInit + "T" + hourInit + ":" + minuteInit + ":00");

        // Final

        String dateFinal = dateReportOrderFinal.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String hourFinal = dateReportOrderHourFinal.getValue();
        String minuteFinal = dateReportOrderMinutsFinal.getValue();
        LocalDateTime dateTimeFinal = LocalDateTime.parse(dateFinal + "T" + hourFinal + ":" + minuteFinal + ":00");

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new ExtensionFilter("Text", "*.txt"));
        File file = fc.showSaveDialog(pane.getScene().getWindow());
        // Seleccioanr que sea .csv
        // Cambiar el null para mantener la ventane

        laCasaDorada.reportProducts(dateTimeInit, dateTimeFinal, file.getAbsolutePath(), dateReportSeparate.getText());

    }

    public void loadInfoCustomer(Customer customer) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InfoCustomer.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();
        pane.setCenter(form);

        infoCustomerAV.getItems().addAll("HABILITADO", "DESHABILITADO");

        String fn = customer.getFirstName();
        String ln = customer.getLastName();
        String id = customer.getId();
        String address = customer.getAddress();
        String phone = customer.getPhone();
        String comments = customer.getComments();

        Boolean availability = customer.isAvailability();
        String av;
        if (availability) {
            av = "HABILITADO";
        } else {
            av = "DESHABILITADO";
        }

        infoCustomerFN.setText(fn);
        infoCustomerLN.setText(ln);
        infoCustomerID.setText(id);
        infoCustomerAD.setText(address);
        infoCustomerPH.setText(phone);
        infoCustomerCO.setText(comments);
        infoCustomerCreator.setText(customer.getEmployeeCreate().toString());
        infoCustomerModify.setText(customer.getEmployeeModify().toString());
        infoCustomerAV.setValue(av);

    }

    public void loadInfoEmployee(Employee employee) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InfoEmployee.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();
        pane.setCenter(form);

        infoEmployeeAV.getItems().addAll("HABILITADO", "DESHABILITADO");

        String fn = employee.getFirstName();
        String ln = employee.getLastName();
        String id = employee.getId();

        Boolean availability = employee.isAvailability();
        String av;
        if (availability) {
            av = "HABILITADO";
        } else {
            av = "DESHABILITADO";
        }

        infoEmployeeFN.setText(fn);
        infoEmployeeLN.setText(ln);
        infoEmployeeID.setText(id);
        infoEmployeeAV.setValue(av);

    }

    @FXML
    public void setCustomer(ActionEvent event) throws IOException {

        String fn = infoCustomerFN.getText();
        String ln = infoCustomerLN.getText();
        String id = infoCustomerID.getText();
        String address = infoCustomerAD.getText();
        String phone = infoCustomerPH.getText();
        String comments = infoCustomerCO.getText();
        String av = infoCustomerAV.getValue();
        Boolean valid = laCasaDorada.setCustomer(setCustomer, fn, ln, id, address, phone, comments, av);

        if (valid) {
            setCustomer.setEmployeeModify(loginUser);
        }

        loadCustomers(event);

    }

    @FXML
    public void deleteCustomer(ActionEvent event) throws IOException {

        boolean valid = laCasaDorada.deleteCustomer(setCustomer);

        if (valid) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("El cliente ha sido eliminado");
            alert.setHeaderText(null);
            alert.setContentText("El cliente se elimino satisfactoriamente");
            alert.showAndWait();
            loadMainWindow(event);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("El cliente no ha podido ser eliminado");
            alert.setHeaderText(null);
            alert.setContentText("El cliente ha realizado ordenes");
            alert.showAndWait();
        }
        // Pasar todo al modelo

    }



    @FXML
    public void setEmployee(ActionEvent event) throws IOException {

        String fn = infoEmployeeFN.getText();
        String ln = infoEmployeeLN.getText();
        String id = infoEmployeeID.getText();
        String av = infoEmployeeAV.getValue();
        Boolean valid = laCasaDorada.setEmployee(setEmployee, fn, ln, id,av);

        if (valid) {
            //setEmployee.(loginUser);
            //Empleado modificador
        }

        loadEmployees(event);

    }

    @FXML
    public void deleteEmployee(ActionEvent event) throws IOException {

        boolean valid = laCasaDorada.deleteCustomer(setCustomer);

        if (valid) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("El empleado ha sido eliminado");
            alert.setHeaderText(null);
            alert.setContentText("El empleado se elimino satisfactoriamente");
            alert.showAndWait();
            loadMainWindow(event);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("El empleado no ha podido ser eliminado");
            alert.setHeaderText(null);
            alert.setContentText("El empleado ha realizado ordenes");
            alert.showAndWait();
        }
        // Pasar todo al modelo

    }


}
