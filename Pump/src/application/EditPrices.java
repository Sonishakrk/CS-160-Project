package application;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class EditPrices extends Main {
     private double new87octanePrice;
    private double new91octanePrice;
    private double newDieselPrice;
    
    EditPrices() {  // constructor
        // 1) read the current prices from the store
        new87octanePrice = store.getPrice87octane();
        new91octanePrice = store.getPrice91octane();
        newDieselPrice = store.getPriceDiesel();
        
        BorderPane editPricesPane = new BorderPane();
        VBox vbox = new VBox();
        GridPane gridPrices = new GridPane();
        // edit 87 octane
        Label lbl87octane = new Label("Regular (87)");
        gridPrices.add(lbl87octane, 0, 0);
        TextField txt87octane = new TextField();
        txt87octane.setMaxWidth(65.0);
        double new87x9_10 = (int)(new87octanePrice*100)/100.00; 
        txt87octane.setText(String.format("%.2f", new87x9_10));
        gridPrices.add(txt87octane, 2, 0);
        // edit 91 octane
        Label lbl91octane = new Label("   Super (91)");
        gridPrices.add(lbl91octane, 0, 1);
        TextField txt91octane = new TextField();
        txt91octane.setMaxWidth(65.0);
        double new91x9_10 = (int)(new91octanePrice*100)/100.00; 
        txt91octane.setText(String.format("%.2f", new91x9_10));
        gridPrices.add(txt91octane, 2, 1);
        // edit diesel price
        Label lblDiesel = new Label ("         Diesel");
        gridPrices.add(lblDiesel, 0, 2);
        TextField txtDiesel = new TextField();
        txtDiesel.setMaxWidth(65.0);
        double newDieselx9_10 = (int)(newDieselPrice*100)/100.00; 
        txtDiesel.setText(String.format("%.2f", newDieselx9_10));
        gridPrices.add(txtDiesel, 2, 2);
        gridPrices.setHgap(5.0);

        // message at the bottom
        Label msg = new Label("Prices are updated at the pump\nwith the next transaction\n\n\n");
        vbox.getChildren().addAll(gridPrices, msg);
        
        editPricesPane.setCenter(vbox);
        DialogBox editPricesDialog = new DialogBox(editPricesPane, "Edit Fuel Prices", "Accept", "Cancel", 250, 240);
        
        //  3) if the [Accept] button is clicked, update the store
        if (editPricesDialog.getClickedButton().equals("Accept")) {
            try {
                // update the new price for 87 octane
                new87octanePrice = Double.valueOf(txt87octane.getText()) + 0.009;
                if (new87octanePrice < 0) 
                    throw new IllegalArgumentException ("Non-numeric");               
                store.setPrice87octane(new87octanePrice);

                // update the new price for 91 octane
                new91octanePrice = Double.valueOf(txt91octane.getText()) + 0.009;
                if (new91octanePrice < 0) 
                    throw new IllegalArgumentException ("Non-numeric");               
                store.setPrice91octane(new91octanePrice);

                // update the new price for diesel
                newDieselPrice = Double.valueOf(txtDiesel.getText()) + 0.009;
                if (newDieselPrice < 0) 
                    throw new IllegalArgumentException ("Non-numeric");               
                store.setPriceDiesel(newDieselPrice);
                
                Log logFile = new Log();
                logFile.write("Price-update:" 
                        + String.format(" 87-octane %.3f", store.getPrice87octane())
                        + String.format(" 91-octane %.3f", store.getPrice91octane())
                        + String.format(" Diesel %.3f", store.getPriceDiesel())
                    );     
            } 
            catch (NumberFormatException e) {
                editPricesError();
            }  
            catch (IllegalArgumentException e) {
                editPricesError(); 
            }
        }
    }
    
    private void editPricesError() {
            BorderPane errorPane = new BorderPane();
            errorPane.setCenter(new Label("Fuel values must be\npositive numeric values"));
            new DialogBox(errorPane, "Error", "Ok", 240, 240);    
    }
    
}
