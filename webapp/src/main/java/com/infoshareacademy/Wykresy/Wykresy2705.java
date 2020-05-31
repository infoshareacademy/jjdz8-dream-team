package com.infoshareacademy.Wykresy;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Wykresy2705 extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {

            String Euro = "Kasia";
            String Pound = "Basia";
            String A_Dollar = "Konrad";
            String frenc = "Antek";


            CategoryAxis xaxis = new CategoryAxis();
            NumberAxis yaxis = new NumberAxis(1, 12, 1);
            xaxis.setLabel("Srednia");
            yaxis.setLabel("Srednia");

            BarChart<String, Float> bar = new BarChart(xaxis, yaxis);
            bar.setTitle("Wykres sredniej");

            XYChart.Series<String, Float> series = new XYChart.Series<>();
            series.getData().add(new XYChart.Data(Euro, 3.5,Color.AQUA));
            series.getData().add(new XYChart.Data(Pound, 4, Color.INDIGO));
            series.getData().add(new XYChart.Data(frenc, 2.5));
            series.getData().add(new XYChart.Data(A_Dollar, 6));


            bar.getData().add(series);

            // configuring group and scene
            Group root = new Group();
            root.getChildren().add(bar);
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Srednia");
            primaryStage.show();

            scene.getStylesheets().add(getClass().getResource("chart.css").toExternalForm());

        }
        public static void main(String[] args) {
            launch(args);
        }
    }

