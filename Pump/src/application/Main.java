package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application {
    protected String title = "Gas Station";
    protected String version = "Version 1.0";
    protected String loginID;
    protected String fuelPumpFolder;    
    protected GridPane storeAndPumps;                   // base pane
    protected static Pane storePane;
    protected static Store store;                       // left pane
    protected Menu fuelPumpMenu;
    protected static final int MAX_PUMPS = 4;
    protected static Pump[] pump = new Pump[MAX_PUMPS]; // new pane for each pump
    protected Stage stage;
    private VBox root;
    
   

    @Override
    public void start(Stage primaryStage) {    

        stage = primaryStage;           
        root = new VBox();
        root.setStyle("-fx-background-color: #F0E0C0;");
        root.setPadding(new Insets(5, 10, 0, 10)); 
        
        storeAndPumps = new GridPane();
        storeAndPumps.add(createStore(), 0, 0);
        storeAndPumps.add(createFuelPump(), Pump.pumpCount+1, 0);
        // Set column1 (store) so pumps don't move on top of it
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setMinWidth(170);
        storeAndPumps.getColumnConstraints().add(column1); 
        
        // add the menu, title, store and pump to the display
        fuelPumpMenu = new Menu();
        root.getChildren().addAll(
                fuelPumpMenu.addMenuBar(stage, storeAndPumps), 
                createTitle(title), 
                storeAndPumps);

        // make the scene visible
        Scene scene = new Scene(root);    
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    private HBox createTitle(String title) {  // BorderPane TOP position
        HBox hbox  = new HBox();
        hbox.setAlignment(Pos.CENTER);
        Font font36B = Font.font("Ariel", FontWeight.BOLD, 36); // title
        Label lblTitle = new Label(title);
        lblTitle.setFont(font36B); 
        hbox.getChildren().add(lblTitle);
        return hbox;
    }
     
    private Pane createStore() {
        storePane = new Pane();
        store = new Store(storePane);
        return storePane;
    }
    
    protected Pane createFuelPump() {
        Pane fuelPump = new Pane();
        pump[Pump.pumpCount] = new Pump(fuelPump);
        Pump.pumpCount++;
        return fuelPump;    
    }  
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
} // end of class JavaFX_FuelPumpProject