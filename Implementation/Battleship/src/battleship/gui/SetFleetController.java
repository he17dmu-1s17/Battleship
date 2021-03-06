package battleship.gui;

import java.io.IOException;
import battleship.BattleshipLauncher;
import battleship.logic.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
		for (int column = 1; column < size; column++) {
			for (int row = 1; row < size; row++) {
				if (fleetBoard.getColumnIndex((Node) event.getSource()) == column
						& fleetBoard.getRowIndex((Node) event.getSource()) == row) {
					((ToggleButton) getNodeFromGridPane(fleetBoard, column, row)).setSelected(true);
				} else ((ToggleButton) getNodeFromGridPane(fleetBoard, column, row)).setSelected(false);
			}
		}
	}

	@FXML
	void done(ActionEvent event) {
		if (BS.isReadyToStart()) {
			BS.setupDone();
			try {
				FXMLLoader fxml = new FXMLLoader();
				GridPane playGrid = (GridPane)fxml.load(BattleshipLauncher.class.getResource("gui/Play.fxml").openStream());
				Scene playScene = new Scene(playGrid);
				Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
				window.setScene(playScene);
				window.setTitle("Battleship");
				window.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (BS.isCurrentPlayerReady()) {
			BS.setupDone();
			setPlayerName();
			status.setText("Next player");
			updateGrid();
		} else {
			status.setText("Not all ships placed");
		}
	}

	@FXML
	private void setship(ActionEvent event) {
		ShipClass shipClass = fleet.getValue();
		int column = -1;
		int row = -1;
		try {
			column = fleetBoard.getColumnIndex((Node) isSelected()) - 1;
			row = fleetBoard.getRowIndex((Node) isSelected()) - 1;
		} catch (Exception ex) {
			status.setText("No starting point selected");
		}
		boolean isHorizontal;
		isHorizontal = orientation.getValue();

		if (column != -1 && row != -1) {
			try {
				BS.placeShip(shipClass, column, row, isHorizontal);
				updateGrid();
				status.setText("Whoop!");
			} catch (OutOfBoundsException oob) {
				status.setText("oob");
			} catch (AlreadyPlacedException ap) {
				status.setText("ap");
			} catch (SquareOccupiedException so) {
				status.setText("so");
			}
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
				if (grid.isOccupied(column - 1, row - 1)) {
					getNodeFromGridPane(fleetBoard, column, row).setStyle("-fx-background-color: pink");
				} else {
					getNodeFromGridPane(fleetBoard, column, row).setStyle("-fx-background-color: blue");
				}

			}
		}
	}

	public void setOrientationList() {
		orientation.setItems(isHorizontal);
		orientation.getSelectionModel().select(0);
	}

	public void setFleetList() {
		fleet.setItems(fleets);
		fleet.getSelectionModel().select(0);
	}

	private ToggleButton isSelected() {
		for (int column = 1; column < size; column++) {
			for (int row = 1; row < size; row++) {
				ToggleButton toggle = (ToggleButton) getNodeFromGridPane(fleetBoard, column, row);
				if (toggle.isSelected()) {
					return toggle;
				}
			}
		}
		return null;
	}
	
	public void setPlayerName() {
		playerName.setText(BS.getCurrentPlayerName());
	}
}
