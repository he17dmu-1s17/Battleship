package battleship.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SetFleetController {
	private int size = 11;

	@FXML
    private GridPane fleetBoard;
	
    @FXML
    private ComboBox<?> fleet;

    @FXML
    private ComboBox<?> orientation;

    @FXML
    private Button setship;

    @FXML
    private Label PlayerName;

    @FXML
    private Button done;

    @FXML
    void clicked(ActionEvent event) {

    }

    @FXML
    void done(ActionEvent event) {

    }

    @FXML
    void setship(ActionEvent event) {
    	try {
    	battleshipController.placeShip(shipClass, column, row, isHorizontal);
    	Grid grid = battleshipController.getFleetGrid();
    	for (int column = 1; column<size; column++) {
    		for ( int row = 1; row<size; row++) {
    			if (grid.isOccupied(column,row)) {
    				getNodeFromGridPane(fleetBoard, column, row).setStyle("-fx-background-color: pink");
    			} else {
    				getNodeFromGridPane(fleetBoard, column, row).setStyle("-fx-background-color: blue");
    			}
    			
    			
    			
    		}
    	}
    	}
    catch(outofbounds) {
    	
    }
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
	    for (Node node : gridPane.getChildren()) {
	        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
	            return node;
	        }
	    }
	    return null;
	}
}
