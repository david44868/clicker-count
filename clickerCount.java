package miscellaneous;

import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class clickerCount extends Application{

	private int counter = 0;
	private Scene scene;
	private long startTime;
	
	public void start(Stage primaryStage) {
		
		BorderPane mainPane = new BorderPane();
		mainPane.setPadding(new Insets(20, 20, 20, 20));
		Text start = new Text("CLICKER SPEED TEST");
		start.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 35));
		mainPane.setTop(start);
		mainPane.setAlignment(start, Pos.CENTER);
		Button bt = new Button("CLICK");
		bt.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 35));
		bt.setMinSize(400, 250);
		bt.setTooltip(new Tooltip("How many seconds does it take you to click 10 times?"));
		mainPane.setCenter(bt);
		
		bt.setOnMouseClicked(e -> {  
	    	counter++;
	    	if(counter == 1)
	    	{
	    		startTime = System.currentTimeMillis();
	    	}
	    	Text count = new Text(scene.getWidth() / 2, 
	    	scene.getHeight() / 2, "Clicks: " + counter);
	    	count.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 35));
	    	mainPane.setBottom(count);
	    	mainPane.setAlignment(count, Pos.CENTER);
	    	if(counter == 10)
	    	{
	    		double speed = (System.currentTimeMillis() - startTime)/1000.0;
	    		leaderboard.addScores(speed);
	    		Text time = new Text(scene.getWidth() / 2,     		
	    		scene.getHeight() / 2, "10 Clicks Per " + speed + " seconds");
	    		time.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 35));
	    		mainPane.setBottom(time);
	    		mainPane.setAlignment(time, Pos.CENTER);
	    		mainPane.setCenter(null);
	    		
	    		leaderboard.print();
	    		
	    		Button bt1 = new Button("PLAY AGAIN");
	    		bt1.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 35));
	    		bt1.setMinSize(200, 125);
	    		mainPane.setAlignment(bt1, Pos.CENTER);
	    		//mainPane.setCenter(bt1);
	    		mainPane.setTop(bt1);
	    		
	    		bt1.setOnMouseClicked(e1 -> {	    			
	    			mainPane.setTop(start);
	    			mainPane.setAlignment(start, Pos.CENTER);
	    			mainPane.setCenter(bt);
	    			mainPane.setBottom(null);
	    			counter = 0;
	    		});
	    				
	    	}
		});
		
		scene = new Scene(mainPane, 500, 500);
	    primaryStage.setTitle("Clicker Count");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
