
package application;

import java.io.File;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class About extends Main {
     private final Border simpleBorder = new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    
    About() {
        BorderPane aboutPane = new BorderPane();
        Label aboutMessage = new Label(
                title + " - " + version + "\n" +
                "Jahan Ghofraniha, San Jose State University\n\n" +
                "The project demostrates:\n" +
                "A state machine\n" +
                "Dynamic creation of objects\n" +
                "BorderPane, FlowPane, GridPane, HBox, VBox\n" +
                "Combining graphics and JavaFX controls\n" +
                "Menus, timers, and dialog boxes\n" +
                "Reading and Writing disk files\n" +
                "Printing images and text"
        );
        aboutMessage.setPadding(new Insets(0, 5, 0, 0));
        aboutMessage.setBorder(simpleBorder);
        
        VBox vbox = new VBox();

        
        Label instructions = new Label( 
                "To purchase fuel:\n" +
                "1) Deposit money at the store\n" +
                "2) Select a grade of fuel\n" +
                "3) Click the [Start] button\n\n" +
                "Either let the fuel deposit be used\n" +
                "or click the [Stop] button to stop\n" +
                "the pump and see the change.\n\n" +
                "Click the [Clear] button to start\n" +
                "a new sale"
        );
        instructions.setBorder(simpleBorder);
        
        aboutPane.setPadding(new Insets(5));
        aboutPane.setLeft(aboutMessage);        // display the About message
        

        String loginID = System.getenv("USER");
        if (loginID == null) loginID = System.getenv("USERNAME");
        String fuelPumpFilename = 
                "/Users/" + loginID + "/Documents/FuelPump/FuelPump225x164.png";  
        File fuelPumpFile = new File(fuelPumpFilename);          
        Image picFuelPump = new Image(fuelPumpFile.toURI().toString());
        ImageView ivFuelPump = new ImageView(picFuelPump);
        ivFuelPump.toBack();
        aboutPane.setRight(ivFuelPump);         
        
        vbox.getChildren().addAll(ivFuelPump, instructions);
        vbox.setPadding(new Insets(0, 5, 0, 10));

        aboutPane.setRight(vbox);       // display the Help message
        new DialogBox(aboutPane, "Java Fuel Pump Simulator", "Ok", 600, 550);
    }
    
}
