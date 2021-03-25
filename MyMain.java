// 
// Decompiled by Procyon v0.5.36
// 

package com.internshala.javafxapp;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import java.util.Optional;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.application.Application;

public class MyMain extends Application
{
    public static void main(final String[] args) {
        System.out.println("main");
        launch(args);
    }
    
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }
    
    public void start(final Stage primaryStage) throws Exception {
        System.out.println("start");
        final FXMLLoader loader = new FXMLLoader(this.getClass().getResource("app_layout.fxml"));
        final VBox rootNode = (VBox)loader.load();
        final MenuBar menuBar = this.createMenu();
        rootNode.getChildren().add(0, (Object)menuBar);
        final Scene scene = new Scene((Parent)rootNode);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();
    }
    
    private MenuBar createMenu() {
        final Menu fileMenu = new Menu("File");
        final MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));
        final SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        final MenuItem quitMenuItem = new MenuItem("Quit");
        quitMenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll((Object[])new MenuItem[] { newMenuItem, (MenuItem)separatorMenuItem, quitMenuItem });
        final Menu helpMenu = new Menu("Help");
        final MenuItem aboutApp = new MenuItem("About");
        aboutApp.setOnAction(event -> aboutApp());
        helpMenu.getItems().addAll((Object[])new MenuItem[] { aboutApp });
        final MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll((Object[])new Menu[] { fileMenu, helpMenu });
        return menuBar;
    }
    
    public static void aboutApp() {
        final Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop App");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText("I am just a beginner but soon I will be pro and start developing awesome Java Games.");
        final ButtonType yesBtn = new ButtonType("Yes");
        final ButtonType noBtn = new ButtonType("No");
        alertDialog.getButtonTypes().setAll((Object[])new ButtonType[] { yesBtn, noBtn });
        final Optional<ButtonType> clickedBtn = (Optional<ButtonType>)alertDialog.showAndWait();
        if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn) {
            System.out.println("Yes Button Clicked !");
        }
        else {
            System.out.println("No Button Clicked !");
        }
    }
    
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
