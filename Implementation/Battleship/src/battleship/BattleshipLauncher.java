package battleship;

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
	
	@Override
	public void start(Stage primaryStage) {
		initializeGame();
		
		try {
			fxml = new FXMLLoader();
//			fxml.setResources(ResourceBundle.getBundle());
			GridPane root = (GridPane)fxml.load(getClass().getResource("gui/SetFleet.fxml").openStream());
			setFleetGUI = (SetFleetController) fxml.getController();
			setFleetGUI.setOrientationList();
			setFleetGUI.setFleetList();
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Battleship");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
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
