package battleship.gui;

import battleship.logic.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SetFleetController {
	private int size = 11;
	BattleshipController BS = null;
	ObservableList<Boolean> isHorizontal;
	
	@FXML
	private GridPane fleetBoard;

	@FXML
	private ComboBox<?> fleet;

	@FXML
	private ComboBox<?> orientation;

	@FXML
	private Button setship;

	@FXML
	private Label playerName;
	
	@FXML
	private Label status;

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
		ShipClass shipClass = null;
		int column = -1;
		int row = -1;
		boolean isHorizontal = true;
		
		try {
			BS.placeShip(shipClass, column, row, isHorizontal);
			updateGrid();
		} catch (OutOfBoundsException oob) {

		} catch (AlreadyPlacedException ap) {

		} catch (SquareOccupiedException so) {
			
		}
	}

	public Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
		for (Node node : gridPane.getChildren()) {
			if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
				return node;
			}
		}
		return null;
	}
	
	private void updateGrid() {
		Grid grid = BS.getFleetGrid();
		for (int column = 1; column < size; column++) {
			for (int row = 1; row < size; row++) {
				if (grid.isOccupied(column-1, row-1)) {
					getNodeFromGridPane(fleetBoard, column, row).setStyle("-fx-background-color: pink");
				} else {
					getNodeFromGridPane(fleetBoard, column, row).setStyle("-fx-background-color: blue");
				}

			}
		}
	}
}
