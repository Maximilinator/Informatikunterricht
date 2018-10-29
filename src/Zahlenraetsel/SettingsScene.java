package Zahlenraetsel;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SettingsScene extends ZahlenraetselGUI {
	
	public SettingsScene() {
		buildScene();
	}

	public void buildScene() {
		hBoxLayout1 = new HBox(10);
		hBoxLayout1.setAlignment(Pos.BASELINE_CENTER);
		hBoxLayout2 = new HBox(10);
		hBoxLayout2.setAlignment(Pos.BASELINE_CENTER);
		hBoxLayout3 = new HBox(80);
		hBoxLayout3.setAlignment(Pos.BASELINE_CENTER);
		hBoxLayout4 = new HBox(30);
		hBoxLayout4.setAlignment(Pos.CENTER);

		Label welcome = new Label("Herzlich Willkommen zum Zahlenraten!");
		welcome.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		Label sliderShow = new Label("Zahlenspektrum 0 bis:");
		Label sliderShow2 = new Label("Anzahl der Versuche");

		Slider maxNumberSlider = new Slider(10, 100, 50);

		Label maxNumberShower = new Label();
		maxNumberShower.textProperty().bind(maxNumberSlider.valueProperty().asString());

		Slider maxTriesSlider = new Slider(5, 15, 10);

		Label maxTriesShower = new Label();
		maxTriesShower.textProperty().bind(maxTriesSlider.valueProperty().asString());

		Label tryShow = new Label("Versuche übrig: ");
		Label tryShower = new Label();

		TextField tipShower = new TextField();

		Button bSettingsContinue = new Button("OK");
		bSettingsContinue.setOnAction(e -> {
			appcode.setMaxNumber((int) maxNumberSlider.getValue());
			appcode.setTriesLeft((int) maxTriesSlider.getValue());
			appcode.start();
			tryShower.setText(appcode.getTriesLeftAsString());
			tipShower.setText("Geben sie ihren ersten Tipp im Spektrum von 1 bis " + appcode.getMaxNumber() + " ab!");
			window.setTitle("Zahlenraten - Das Spiel");
			window.setScene(game);
		});
		Button bSettingsClose = new Button("Schließen");
		bSettingsClose.setOnAction(e -> {
			System.exit(0);
		});

		hBoxLayout1.getChildren().addAll(sliderShow, maxNumberShower);
		hBoxLayout2.getChildren().addAll(sliderShow2, maxTriesShower);
		hBoxLayout3.getChildren().addAll(bSettingsContinue, bSettingsClose);
		hBoxLayout4.getChildren().add(welcome);

		VBox overlay = new VBox(hBoxLayout4, hBoxLayout1, maxNumberSlider, hBoxLayout2, maxTriesSlider, hBoxLayout3);
		overlay.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		overlay.setSpacing(30);
		settings = new Scene(overlay, 500, 300);

	}
}
