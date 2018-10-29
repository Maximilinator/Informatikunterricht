package Zahlenraetsel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ZahlenraetselGUI extends Application implements javafx.event.EventHandler<ActionEvent> {

	Stage window;
	Scene settings, game, win, failure;

	// Buttons, Labels, Textfields etc...
	Button bSettingsContinue, bGameCheck, bRetry;
	Label maxNumberShower, welcome;
	
	// H- and VBoxes
	HBox hBoxLayout1, hBoxLayout2, hBoxLayout3, hBoxLayout4, hBoxLayout5;
	VBox vBoxLayout1;

	AppCode appcode = new AppCode();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
		window.setTitle("Zahlenraten - Einstellungen");
		
		//Scene1 - Settings
		SettingsScene settingsScene = new SettingsScene();
		
		// Scene2
		HBox hBoxLayout5 = new HBox(5);
		hBoxLayout5.setAlignment(Pos.BASELINE_RIGHT);
		VBox vBoxlayout1 = new VBox(30);
		vBoxlayout1.setAlignment(Pos.BASELINE_CENTER);
		StackPane sPLayout1 = new StackPane();
		sPLayout1.setAlignment(Pos.BASELINE_CENTER);

		TextField tipInput = new TextField();
		Label tipInputLayer = new Label("Hier Tipp abgeben!");

		Button checkTip = new Button("Prüfe");
		checkTip.setOnAction(e -> {
			settingsScene.tipShower.setText(appcode.tipHigherLower(tipInput.getText()));
			tryShower.setText(appcode.getTriesLeftAsString());
			if (tipShower.getText().equals("Richtig!")) {
				window.setScene(win);
				window.setTitle("Zahlenraten - Gewonnen :D");
			} else if (appcode.getTriesLeft() < 0) {
				window.setScene(failure);
				window.setTitle("Zahlenraten - Verloren D:");
			}
		});
		checkTip.setAlignment(Pos.BASELINE_CENTER);

		hBoxLayout5.getChildren().addAll(tryShow, tryShower);
		sPLayout1.getChildren().addAll(tipInput, tipInputLayer);
		vBoxlayout1.getChildren().addAll(tipShower, sPLayout1, checkTip);

		VBox overlay2 = new VBox(40);
		overlay2.getChildren().addAll(hBoxLayout5, vBoxlayout1);
		overlay2.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		game = new Scene(overlay2, 500, 300);

		// Scene3
		HBox hBoxLayout6 = new HBox(80);

		Button retry = new Button("Nochmal");
		retry.setOnAction(e -> {
			window.setScene(settings);
			tipInput.setText("");
			maxNumberSlider.setValue(50.0);
			maxTriesSlider.setValue(10.0);
			window.setTitle("Zahlenraten - Einstellungen");
		});
		Label won = new Label("Hurra, du hast gewonnen!");
		hBoxLayout6.getChildren().addAll(retry, bSettingsClose);

		VBox overlay3 = new VBox(won, hBoxLayout6);
		overlay3.setSpacing(100);
		overlay3.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		win = new Scene(overlay3, 500, 300);

		// Scene4
		HBox hBoxLayout7 = new HBox(80);

		Button retry2 = new Button("Nochmal");
		retry2.setOnAction(e -> {
			window.setScene(settings);
			tipInput.setText("");
			maxNumberSlider.setValue(50.0);
			maxTriesSlider.setValue(10.0);
			window.setTitle("Zahlenraten - Einstellungen");
		});
		
		Button close = new Button("Schließen");
		close.setOnAction(e -> {
			System.exit(0);
		});

		Label failed = new Label("Du hast leider verloren!\nProbier' es doch einfach noch einmal! :)");
		hBoxLayout7.getChildren().addAll(retry2, close);

		VBox overlay4 = new VBox(failed, hBoxLayout7);
		overlay4.setSpacing(100);
		overlay4.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		failure = new Scene(overlay4, 500, 300);

		window.setScene(settings);
		window.show();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}
}
