package Mouse;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
   }

@Override
public void start(Stage primaryStage) throws Exception {
	primaryStage.setTitle("Mouse Clicker");
	Button button1 = new Button();
	button1.setText("Start");
	Button loop = new Button();
	loop.setText("Loop");
	GridPane grid = new GridPane();
	grid.setAlignment(Pos.CENTER);
	grid.setHgap(10);
	grid.setVgap(10);
	grid.setPadding(new Insets(0, 0, 0, 0));
	Text scenetitle = new Text("Mouse Clicker");
	scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	grid.add(scenetitle, 0, 0, 2, 1);
	Label clicks = new Label("How Many Clicks:");
	grid.add(clicks, 0, 1);
	TextField hClicks = new TextField();
	grid.add(hClicks, 1, 1);
	Label perSecond = new Label("How many milisecond(1000 milisedond = 1 second) between the clicks?");
	grid.add(perSecond, 0, 2);
	TextField hSecond = new TextField();
	Clicker click = new Clicker(0,0);
	button1.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent arg0) {
			try {
			Clicker click = new Clicker(Integer.parseInt(hClicks.getText()),Integer.parseInt(hSecond.getText()));
			click.someClick();
			}
			catch (NumberFormatException e)
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("BAD DATA");
				alert.setHeaderText("BAD DATA");
				alert.setContentText("DATA MUST BE A NUMBER");
				alert.showAndWait();
			}
		}
    });
	loop.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent arg0) {
			if(loop.getText()=="Loop")
			try {
			Clicker click = new Clicker(Integer.parseInt(hSecond.getText()));
			click.loopCLick();
			loop.setText("Stop");
			}
			catch (NumberFormatException e)
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("BAD DATA");
				alert.setHeaderText("BAD DATA");
				alert.setContentText("DATA MUST BE A NUMBER");
				alert.showAndWait();
			}
		}
    });
	
	grid.add(hSecond, 1, 2);
	grid.add(button1, 1, 3);
	grid.add(loop, 0, 3);
	primaryStage.setScene(new Scene (grid,700,160));
	primaryStage.show();
}
}