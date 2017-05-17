import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.geometry.*;

public class HoursSpent extends Application implements EventHandler<ActionEvent>{	
	private final Text labelGames = new Text("Games");
	private final Text labelDrawing = new Text("Drawing");
	private final Text labelMaya = new Text("Maya");
	private Text timeGames = new Text(""); //not final because the value needs to be changed
	private Text timeDrawing = new Text("");
	private Text timeMaya = new Text("");
	private final TextField addGames = new TextField();
	private final TextField addDrawing = new TextField();
	private final TextField addMaya = new TextField();
	private final Button updateGames = new Button();
	private final Button updateDrawing = new Button();
	private final Button updateMaya = new Button();
	private Category games = new Category("Games.txt");
	private Category drawing = new Category("Drawing.txt");
	private Category maya = new Category("Maya.txt");

	@Override
	public void start(Stage stage) {
		//creating panes
		BorderPane border = new BorderPane();
		Pane gamesPane = new Pane();
		Pane drawingPane  = new Pane();
		Pane mayaPane = new Pane();
		
		//adding elements to panes
		gamesPane.getChildren().addAll(labelGames, timeGames, addGames, updateGames);
		drawingPane.getChildren().addAll(labelDrawing, timeDrawing, addDrawing, updateDrawing);
		mayaPane.getChildren().addAll(labelMaya, timeMaya, addMaya, updateMaya);
		
		//editing button titles and setting actions
		updateGames.setText("Update");
		updateGames.setOnAction(this);
		updateDrawing.setText("Update");
		updateDrawing.setOnAction(this);
		updateMaya.setText("Update");
		updateMaya.setOnAction(this);
		
		//editing games pane
		labelGames.setLayoutY(5);
		addGames.setLayoutY(15);
		updateGames.setLayoutY(50);
		timeGames.setLayoutY(97);
		
		//editing drawing pane
		labelDrawing.setLayoutY(5);
		labelDrawing.setLayoutX(50);
		addDrawing.setLayoutY(15);
		addDrawing.setLayoutX(50);
		updateDrawing.setLayoutY(50);
		updateDrawing.setLayoutX(50);
		timeDrawing.setLayoutY(97);
		timeDrawing.setLayoutX(50);
		
		//editing maya pane
		labelMaya.setLayoutY(5);
		addMaya.setLayoutY(15);
		updateMaya.setLayoutY(50);
		timeMaya.setLayoutY(97);
		
		//organizing border pane
		border.setPadding(new Insets(10, 20, 10, 20));
		border.setLeft(gamesPane);
		border.setCenter(drawingPane);
		border.setRight(mayaPane);
		
		//setting scene and stage
		Scene scene = new Scene(border, 580, 125);
		stage.setTitle("Hours Spent");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
		//display the time when the program is first run
		timeGames.setText(games.getTime()); 
		timeDrawing.setText(drawing.getTime()); 
		timeMaya.setText(maya.getTime()); 

	}
	
	public void handle(ActionEvent event) {
		//handles the update buttons, updating the displayed times
		if(updateGames == event.getSource()) {
			//add time in the text field to the Category class
			games.setTime(addGames.getText());
			
			//clear text field
			addGames.clear();
			
			//get and display time
			timeGames.setText(games.getTime()); 
		}
		
		if(updateDrawing == event.getSource()) {
			//add time in the text field to the Category class
			drawing.setTime(addDrawing.getText());
			
			//clear text field
			addDrawing.clear();
			
			//get and display time
			timeDrawing.setText(drawing.getTime()); 
		}
		
		if(updateMaya == event.getSource()) {
			//add time in the text field to the Category class
			maya.setTime(addMaya.getText());
			
			//clear text field
			addMaya.clear();
			
			//get and display time
			timeMaya.setText(maya.getTime()); 
		}
	}
	
	public static void main(String[] args) { launch(args); } //end main
}
