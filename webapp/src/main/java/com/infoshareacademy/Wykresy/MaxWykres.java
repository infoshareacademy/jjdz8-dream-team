package com.infoshareacademy.Wykresy;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class MaxWykres extends Application {

    public static double maxi(double []a)
    {
        double max=Double.NEGATIVE_INFINITY;
        for (int i = 0; i <a.length ; i++)
            if(a[i]>max) max=a[i];
        return max;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {



        String Nick1 = "Kasia";
        String Nick2 = "Basia";
        String Nick3 = "Konrad";
        String Nick4= "Antek";

           double   maxiNumbers1[]=new double[]{5.0,4.0,6.0,2.5,3.5} ;
        double   maxiNumbers2[]= new double[]{5.0,6.0,6.0,2.5,3.5};
        double maxiNumbers3[]=new double[]{4.0,4.0,4.0,4.0,4.0,4.0};
        double maxiNumbers4[]=new double[]{2.0,2.0,2.0,2.0,2.0,2.0};
        double maxiNumbers5[]=new double[]{2.5,2.5,2.5};

        CategoryAxis xaxis= new CategoryAxis();
        NumberAxis yaxis = new NumberAxis(1,12,1);
        xaxis.setLabel("Najwyzsza wartosc oceny");
        yaxis.setLabel("Najwyzsza wartosc oceny");

        BarChart<String,Float> bar = new BarChart(xaxis,yaxis);
        bar.setTitle("Wykres najlepszej oceny");
        double maxAll=maxi(maxiNumbers1);
         double maxAll2=maxi(maxiNumbers2);
         double maxAll3=maxi(maxiNumbers3);
         double maxAll4=maxi(maxiNumbers4);

        XYChart.Series<String,Float> series = new XYChart.Series<>();
       // series.getData().add(new XYChart.Data(Euro,maxi(maxiNumbers1)));

        series.getData().add(new XYChart.Data(Nick1,maxAll));
        series.getData().add(new XYChart.Data(Nick2,maxAll2));
        series.getData().add(new XYChart.Data(Nick3,maxAll3));
        series.getData().add(new XYChart.Data(Nick4,maxAll4));


        bar.getData().add(series);


        Group root = new Group();
        root.getChildren().add(bar);
        Scene scene = new Scene(root,600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Maksymalne oceny");
        primaryStage.show();
        scene.getStylesheets().add(getClass().getResource("chart2.css").toExternalForm());
    }
    public static void main(String[] args) {
        launch(args);
    }}




