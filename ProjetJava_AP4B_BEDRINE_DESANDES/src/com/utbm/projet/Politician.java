package com.utbm.projet;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class Politician extends Faction {
	
	public String factionName;
    public int boostNumber;
    public String boostDomain;
	public Button politicianButton = new Button();
	public Label factionNameLabel = new Label();
	public Label infoFactionLabel = new Label();
	public Label boostFactionLabel = new Label();
	public VBox factionInfosPolitician = new VBox(20);

	public void politicianInfos() {
		DropShadow dropShadow1 = new DropShadow();
		dropShadow1.setRadius(1.9);
		dropShadow1.setColor(Color.WHITE);
		DropShadow dropShadow2 = new DropShadow();
		dropShadow2.setRadius(8.0);
		dropShadow2.setHeight(20.0);
		dropShadow2.setWidth(20.0);
		dropShadow2.setColor(Color.WHITE);
		
		factionName = "Politicien";
		boostNumber = -15;
		boostDomain = "Co�t d'un leader";
		politicianButton.setBackground(new Background(new BackgroundImage(
				new Image(this.getClass().getResourceAsStream("/resources/images/factions/logoPolitician.png")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(0, 0, false, false, false, true))));
		politicianButton.setMinSize(100, 100);
		politicianButton.setCursor(Cursor.HAND);
		politicianButton.effectProperty()
				.bind(Bindings.when(politicianButton.hoverProperty()).then(dropShadow2).otherwise(dropShadow1));
		Tooltip tt = new Tooltip();
		tt.setText(factionName);
		tt.setFont(Font.font(getClass().getResource("/resources/fonts/nasa.ttf").toString(), FontWeight.BOLD, 14));
		tt.setShowDelay(Duration.ZERO);
		tt.setHideDelay(Duration.ZERO);
		politicianButton.setTooltip(tt);

		factionNameLabel.setText(factionName);
		factionNameLabel.setTextFill(Color.web("2E7BD8"));

		infoFactionLabel.setText("Informations sur la faction :");
		infoFactionLabel.setTextFill(Color.web("2E7BD8"));

		boostFactionLabel.setText(boostDomain + " : " + boostNumber + " %");
		boostFactionLabel.setTextFill(Color.web("2E7BD8"));
		
		factionInfosPolitician.getChildren().addAll(infoFactionLabel, boostFactionLabel);
	}

	public void onPoliticianButtonClick(ActionEvent e, BorderPane factionBorder, Faction faction) {
		factionBorder.setRight(factionInfosPolitician);
		faction.setFactionName(factionName);
	}
}