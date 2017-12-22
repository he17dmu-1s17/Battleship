package battleship.gui;

import battleship.logic.*;
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
    	ShipClass shipClass;
    	int column;
    	int row;
    	boolean isHorizontal;
    	BattleshipController BS;
    	
    	try {
    	BS.placeShip(shipClass, column, row, isHorizontal);
    	Grid grid = BS.getFleetGrid();
    	for (int col = 1; col<size; col++) {
    		for ( int ro = 1; ro<size; ro++) {
    			if (grid.isOccupied(col,ro)) {
    				getNodeFromGridPane(fleetBoard, col, ro).setStyle("-fx-background-color: pink");
    			} else {
    				getNodeFromGridPane(fleetBoard, col, ro).setStyle("-fx-background-color: blue");
    			}
    			
    			
    			
    		}
    	}
    	}
    catch(OutOfBoundsException oob) {
    	
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
