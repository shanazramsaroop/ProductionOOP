
/*
 * This program allows a user to enter products into a database and keep track of what products are recorded.
 * @author Shanaz Ramsaroop
 * Date: 19/09/2020
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * The controller file
 *
 * @author Shanaz Ramsaroop
 */
public class Controller implements Initializable {

    //Production Line Tab

    /**
     * The text field for product name.
     */
    @FXML
    private TextField txtProductName;
    /**
     * The text field for manufacturer.
     */
    @FXML
    private TextField txtManufacture;
    /**
     * The choice box for the item type.
     */
    @FXML
    private ChoiceBox<ItemType> choiceItemType;
    /**
     * The table view for the products.
     */
    @FXML
    private TableView<Product> productTable;
    /**
     * The table column for the name column.
     */
    @FXML
    private TableColumn<?, ?> nameCol;
    /**
     * The table column for the manufacturer column.
     */
    @FXML
    private TableColumn<?, ?> manuCol;
    /**
     * The table column for the item type column.
     */
    @FXML
    private TableColumn<?, ?> typeCol;
    /**
     * The observable list for products.
     */
    ObservableList<Product> productLine = FXCollections.observableArrayList();

    //Produce Tab
    /**
     * The combo box for the number of products recorded.
     */
    @FXML
    private ComboBox<Integer> cmbQuantity;
    /**
     * The list view for the products.
     */
    @FXML
    private ListView<Product> listView;

    //Production Log Tab
    /**
     * The text area for the recorded products.
     */
    @FXML
    private TextArea txtProdLog;

    //Employee Tab
    /**
     * The text field for employee name.
     */
    @FXML
    private TextField txtEmployeeName;
    /**
     * The text field for employee password.
     */
    @FXML
    private TextField txtEmployeePw;

    // initialise method
    /**
     * Initialize method
     *
     * @param location
     *
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // displays different types in choice box in PRODUCTION LINE tab
        for (ItemType type : ItemType.values()) {
            choiceItemType.getItems().setAll(ItemType.values());
        }

        // displays numbers 1-10 in combo box in PRODUCE tab
        for (int i = 1; i <= 10; i++) {
            cmbQuantity.getItems().add(i);
        }

        cmbQuantity.getSelectionModel().selectFirst();
        choiceItemType.getSelectionModel().selectFirst();

        setupProductLineTable();

        loadExistingProductList();

        loadProductionLog();

    }

    // Production Line Tab methods
    /**
     * Adds product to the Product table and loads the product list onto the screen
     *
     * @param event
     */
    @FXML
    void addProduct(ActionEvent event) {

        connectToProd();

        loadProductList();

        listView.setItems(productLine);
        listView.setItems(productLine);

    }

    /**
     * Creates the Product table and stores the information entered into the table
     */
    public void connectToProd() {
        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/Products";

        //  Database credentials
        final String USER = "";
        final String PASS = "";
        Connection conn = null;
        //Statement stmt = null;

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String productName = txtProductName.getText();
            String manufacturer = txtManufacture.getText();
            ItemType itemType = choiceItemType.getValue();
            String itemTypeString = itemType.code;

            //create a new instance of product with the details given by user
            Product product = new Product(productName, manufacturer, itemType);

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Product( type, manufacturer, name) " +
                    "VALUES ( ?, ? , ?)");

            pstmt.setString(1, itemTypeString);
            pstmt.setString(2, manufacturer);
            pstmt.setString(3, productName);

            productLine.add(product);

            listView.getItems().add(product);

            pstmt.executeUpdate();

            // STEP 4: Clean-up environment
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the new Product object from the Product database table and adds it to the productLine ObservableList
     */
    public void loadProductList() {

        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/Products";

        //  Database credentials
        final String USER = "";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            stmt = conn.createStatement();

            String sql = "SELECT NAME,MANUFACTURER,TYPE FROM Product";

            ResultSet rs = stmt.executeQuery(sql);

            String productName;
            String manufacturer;
            String itemTypeString;

            while (rs.next()) {

                listView.setItems(productLine);
                listView.setItems(productLine);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * Create Product objects from the Product database table and add them to the productLine ObservableList
     */
    public void loadExistingProductList() {

        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/Products";

        //  Database credentials
        final String USER = "";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            stmt = conn.createStatement();

            String sql = "SELECT NAME,MANUFACTURER,TYPE FROM Product";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                // get values from product database
                String productName = rs.getString(1);
                String manufacturer = rs.getString(2);
                String itemTypeString = rs.getString(3);

                if (itemTypeString.equals("AU")) {
                    Product prodFromDB = new Product(productName, manufacturer, ItemType.AUDIO);
                    productLine.add(prodFromDB);

                } else if (itemTypeString.equals("VI")) {
                    Product prodFromDB = new Product(productName, manufacturer, ItemType.VISUAL);
                    productLine.add(prodFromDB);

                } else if (itemTypeString.equals("AM")) {
                    Product prodFromDB = new Product(productName, manufacturer, ItemType.AUDIO_MOBILE);
                    productLine.add(prodFromDB);
                } else if (itemTypeString.equals("VM")) {
                    Product prodFromDB = new Product(productName, manufacturer, ItemType.VISUAL_MOBILE);
                    productLine.add(prodFromDB);

                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * Sets up the production line table in the product line tab
     */
    public void setupProductLineTable() {
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        manuCol.setCellValueFactory(new PropertyValueFactory("manufacturer"));
        typeCol.setCellValueFactory(new PropertyValueFactory("type"));
        productTable.setItems(productLine);
    }


    // Produce Tab methods

    /**
     *
     *
     * @param actionEvent
     */
    public void recordProduction(ActionEvent actionEvent) {

        int numProdRec = cmbQuantity.getValue();
        int recCount = 0;

        //store the selected product from listView into a new instance of Product
        Product product = listView.getSelectionModel().getSelectedItem();

        ArrayList<ProductionRecord> productionRun = new ArrayList<ProductionRecord>();

        ProductionRecord recProd = new ProductionRecord(product);
        productionRun.add(recProd);

        while (recCount < numProdRec) {

            //store the selected product into a new instance of ProductionRecord
            ProductionRecord productRec = new ProductionRecord(product);

            addToProductionDB(productionRun);

            //loadProductionLog();

            showProduction(productionRun);

            productionRun.add(productRec);

            recCount++;
        }

        //System.out.println(numProdRec + 1);

    }

    public void addToProductionDB(ArrayList productionRun) {

        for (int i = 0; i < productionRun.size(); i++) {

            final String JDBC_DRIVER = "org.h2.Driver";
            final String DB_URL = "jdbc:h2:./res/Products";

            //  Database credentials
            final String USER = "";
            final String PASS = "";
            Connection conn = null;

            try {
                // STEP 1: Register JDBC driver
                Class.forName(JDBC_DRIVER);

                //STEP 2: Open a connection
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                //STEP 3: Execute a query
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ProductionRecord( production_num, " +
                        "product_id, serial_num, date_produced) VALUES ( ?, ? , ?, ?)");

                java.util.Date dateProd = new java.util.Date();
                //Timestamp time = new Timestamp();

                //store the selected product from listView into a new instance of Product
                Product product = listView.getSelectionModel().getSelectedItem();

                //store the selected product into a new instance of ProductionRecord
                ProductionRecord productRec = new ProductionRecord(product);

                System.out.println(productionRun.get(i));

                pstmt.setInt(1, productRec.getProductionNum());
                pstmt.setInt(2, productRec.getProductID());
                pstmt.setString(3, productRec.getSerialNum());

                //format date:
                pstmt.setDate(4, new java.sql.Date(productRec.getProdDate().getTime()));
                //System.out.println(new java.sql.Date(product.getProdDate().getTime()));

                pstmt.executeUpdate();


                // STEP 4: Clean-up environment
                pstmt.close();
                conn.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void showProduction(ArrayList productionLog) {

        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/Products";

        //  Database credentials
        final String USER = "";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;

        //ArrayList<ProductionRecord> productionLog = new ArrayList<ProductionRecord>();

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql = "SELECT PRODUCTION_NUM,PRODUCT_ID,SERIAL_NUM,SERIAL_NUM,DATE_PRODUCED FROM PRODUCTIONRECORD";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                // get values from product database
                int prodNum = rs.getInt(1);
                int prodID = rs.getInt(2);
                String serialNum = rs.getString(3);
                java.util.Date prodDate = rs.getDate(4);

                ProductionRecord recordFromDB = new ProductionRecord(prodNum, prodID, serialNum, prodDate);

                productionLog.add(recordFromDB);

                txtProdLog.appendText(recordFromDB.toString() + "\n");

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void loadProductionLog() {
        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/Products";

        //  Database credentials
        final String USER = "";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql = "SELECT * FROM PRODUCTIONRECORD";

            int prodNum;
            int prodID;
            String serialNum;
            java.util.Date prodDate;

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                prodNum = rs.getInt(1);
                prodID = rs.getInt(2);
                serialNum = rs.getString(3);
                prodDate = rs.getTimestamp("DATE_PRODUCED");

                ProductionRecord record = new ProductionRecord(prodNum);

                txtProdLog.appendText(record.toString() + "\n");


            }

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void enterEmployee(ActionEvent event) {

        String name = txtEmployeeName.getText();
        String password = txtEmployeePw.getText();

        Employee newEmp = new Employee(name, password);

    }


}
