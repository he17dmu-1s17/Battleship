package battleship.gui;

import battleship.BattleshipLauncher;
import battleship.logic.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SetFleetController {
	private int size = 11;
	BattleshipController BS = BattleshipLauncher.battleshipController;
	ObservableList<Boolean> isHorizontal = FXCollections.observableArrayList(true, false);
	ObservableList<ShipClass> fleets = BS.getShipList();
	
	@FXML
	private GridPane fleetBoard;

    @FXML
    private ToggleGroup gridToggle;
    
	@FXML
	private ComboBox<ShipClass> fleet;

	@FXML
	private ComboBox<Boolean> orientation;

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
//		for (int column = 1; column < size; column++) {
//			for (int row = 1; row < size; row++) {
//				if (fleetBoard.getColumnIndex((Node) event.getSource()) != column && fleetBoard.getRowIndex((Node) event.getSource()) != row) {
//					System.out.println(column);System.out.println(row);
//					
//					((ToggleButton) getNodeFromGridPane(fleetBoard, column, row)).setSelected(false);
//				}
//			}
//		}
	}

	@FXML
	void done(ActionEvent event) {
		if (BS.isCurrentPlayerReady()) {
			BS.setupDone();
		}
	}

	@FXML
	void setship(ActionEvent event) {
		ShipClass shipClass = fleet.getValue();
		int column = fleetBoard.getColumnIndex((Node) event.getSource())-1;
		int row = fleetBoard.getRowIndex((Node) event.getSource())-1;
		boolean isHorizontal = orientation.getValue();
		
		try {
			BS.placeShip(shipClass, column, row, isHorizontal);
			updateGrid();
			status.setText("Whoop!");
		} catch (OutOfBoundsException oob) {
			status.setText("Noob");
		} catch (AlreadyPlacedException ap) {
			status.setText("Noob");
		} catch (SquareOccupiedException so) {
			status.setText("Noob");
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

	public void setOrientationList() {
		orientation.setItems(isHorizontal);
	}
	
	public void setFleetList() {
		fleet.setItems(fleets);
	}
}
