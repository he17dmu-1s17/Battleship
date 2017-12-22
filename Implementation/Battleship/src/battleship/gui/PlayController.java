package battleship.gui;

import battleship.logic.BattleshipController;
import battleship.logic.BattleshipControllerImp;
import battleship.logic.Grid;
import battleship.logic.Player;
import battleship.logic.SquareStatus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PlayController {

	@FXML
	private GridPane playerOneTarget;

	@FXML
	private GridPane playerTwoTarget;

	@FXML
	private Label PlayerName;

	@FXML
	private Label PlayerName2;

	@FXML
    void clicked(ActionEvent event) {
    	setGridPaneEnabled();
    	updateOpponentGrid();
    }
    	
	private void setGridPaneEnabled() {
		if (PlayerName.getText().equals(controller.getCurrentPlayerName())) {
			playerOneTarget.setDisable(false);
			playerTwoTarget.setDisable(true);
		} else {
			playerOneTarget.setDisable(true);
			playerTwoTarget.setDisable(false);
		}
	}
	BattleshipController controller = new BattleshipControllerImp();
	private void setPlayerName() {
		
		PlayerName.setText(controller.getPlayer1Name());
		PlayerName2.setText(controller.getPlayer2Name());
	}

	private void updateOpponentGrid() {
		if (PlayerName.getText().equals(controller.getCurrentPlayerName())) {
			updateGrid(playerOneTarget, controller.getTargetGrid(isPlayerOnesTurn()));
		} else {
			updateGrid(playerTwoTarget, controller.getTargetGrid(isPlayerOnesTurn()));
		}
	}
	private boolean isPlayerOnesTurn() {
		return controller.getPlayer1Name().equals(controller.getCurrentPlayerName());
	}
	
	private void updateGrid(GridPane grid, Grid currentPlayerGrid) {
		SetFleetController setFleetController = new SetFleetController();
		for(int column = 0; column < 10; column++) {
			for(int row = 0; row < 10; row++) {
				Button button = (Button) setFleetController.getNodeFromGridPane(grid, column, row);
				SquareStatus status = currentPlayerGrid.getSquareStatus(column,row);
				switch (status) {
				case Hit:
					button.setStyle("-fx-background-color: red");
					break;
				case Miss:
					button.setStyle("-fx-background-color: darkblue");
					break;
				case Sunk:
					button.setStyle("-fx-background-color: black");
					break;
				} 
			}
		}
	}
}