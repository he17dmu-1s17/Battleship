package battleship;

import battleship.gui.SetFleetController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BattleshipLauncher extends Application {
	static FXMLLoader fxml = null;
	private SetFleetController setFleetGUI = null;
	
	@Override
	public void start(Stage primaryStage) {
		
		
		try {
			fxml = new FXMLLoader();
//			fxml.setResources(ResourceBundle.getBundle());
			GridPane root = (GridPane)fxml.load(getClass().getResource("gui/SetFleet.fxml").openStream());
			setFleetGUI = (SetFleetController) fxml.getController();
			setFleetGUI.setOrientationList();
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

}
