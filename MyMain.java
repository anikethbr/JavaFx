package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {
	public static void main(String args[]){
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar =createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature converter tool");
		primaryStage.show();
	}
	private MenuBar createMenu(){
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem= new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println("clicked"));

		SeparatorMenuItem SeparatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem= new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {Platform.exit();
		System.exit(0);});

		fileMenu.getItems().addAll(newMenuItem,SeparatorMenuItem,quitMenuItem);

		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(event->{aboutApp();});

		helpMenu.getItems().addAll(aboutApp);


		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop Application");
		alertDialog.setHeaderText("Learning JavaFx");
		alertDialog.setContentText("I am just a beginner But soon I will be pro and start developing awesome java games");

		ButtonType yesButton = new ButtonType("Yes");
		ButtonType noButton = new ButtonType("no");
		alertDialog.getButtonTypes().addAll(yesButton,noButton);
		Optional<ButtonType> clickedButton=alertDialog.showAndWait();
		if(clickedButton.isPresent()&&clickedButton.get()==yesButton){
		System.out.println("Yes Button clicked");
		}else{
			System.out.println("NO Button Clicked");
		}
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop");
		super.stop();
	}
}
