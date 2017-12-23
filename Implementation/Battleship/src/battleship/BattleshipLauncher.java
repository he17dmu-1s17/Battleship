package battleship;

import java.io.IOException;

import battleship.gui.SetFleetController;
import battleship.logic.BattleshipControllerImp;
import battleship.logic.Player;
import battleship.logic.PlayerImp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BattleshipLauncher extends Application {
	static FXMLLoader fxml = null;
	private SetFleetController setFleetGUI = null;
	public static BattleshipControllerImp battleshipController;
	private static GridPane root;
	
	@Override
	public void start(Stage primaryStage) {
		initializeGame();
		fxml = new FXMLLoader();
		try {
			root = (GridPane) fxml.load(getClass().getResource("gui/SetFleet.fxml").openStream());
			setFleetGUI = (SetFleetController) fxml.getController();
			setFleetGUI.setOrientationList();
			setFleetGUI.setFleetList();
			setFleetGUI.setPlayerName();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Battleship");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (IOException e) {}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void initializeGame() {
		Player player1 = new PlayerImp("Player 1");
		Player player2 = new PlayerImp("Player 2");
		battleshipController = new BattleshipControllerImp(player1, player2);
	}
}
