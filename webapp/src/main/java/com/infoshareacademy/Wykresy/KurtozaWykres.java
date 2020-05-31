package com.infoshareacademy.Wykresy;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class KurtozaWykres extends Application {

    public static double kurt (double [] data) {
        int i, n = data.length;




        double d, avg = 0;
        int count = 0;

        for (i=0; i<n; i++) {
            d = data [i];
            if (d != 0) {
                avg =  (avg+d);
                count ++;
            }
        }

        if (count < 4)
            return 0;

        avg = avg / count;

        double stdev = 0.;
        for (i=0; i<n; i++) {
            d = data [i];
            if (d != 0) {
                d = d - avg;
                stdev = stdev + d * d;
            }
        }

        stdev = Math.sqrt (stdev / (count - 1));

        if (stdev == 0.)
            return 0;

        double kurt = 0.;
        for (i=0; i<n; i++) {
            d = data [i];
            if (d != 0) {
                d = d - avg;
                d = d / stdev;
                kurt = kurt + d * d * d * d;
            }
        }

        kurt = kurt * count * (count + 1) / (count - 1) - 3 * (count - 1) * (count - 1);
        return kurt / ((count - 2) * (count - 3));
    }
    @Override
    public void start(Stage primaryStage) throws Exception {




        String Nick1 = "Basia";
        String Nick2 = "Kasia";

        String Nick3 = "Konrad";
        String Nick4= "Antek";
        double   maxiNumbers1[]=new double[]{5.0,4.0,6.0,2.5,3.5} ;
        double   maxiNumbers2[]= new double[]{5.0,6.0,6.0,2.5,3.5};
        double maxiNumbers3[]=new double[]{4.0,4.0,4.0,4.0,4.0,4.0,5.0};
        double maxiNumbers4[]=new double[]{2.0,2.0,2.0,2.0,2.0,2.0};
        double maxiNumbers5[]=new double[]{2.5,2.5,2.5};

        CategoryAxis xaxis= new CategoryAxis();
        NumberAxis yaxis = new NumberAxis(1,12,1);
        xaxis.setLabel("Kurtoza");
        yaxis.setLabel("Kurtoza");
        //Configuring BarChart
        BarChart<String,Float> bar = new BarChart(xaxis,yaxis);
        bar.setTitle("Kurtoza");
        double maxAll=kurt(maxiNumbers1);

        double maxAll2=kurt(maxiNumbers2);
        double maxAll3=kurt(maxiNumbers3);
        double maxAll4=kurt(maxiNumbers4);

        XYChart.Series<String,Float> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data(Nick1,maxAll));

        series.getData().add(new XYChart.Data(Nick2,maxAll2));
        series.getData().add(new XYChart.Data(Nick3,maxAll3));
        series.getData().add(new XYChart.Data(Nick4,maxAll4));



        bar.getData().add(series);


        Group root = new Group();
        root.getChildren().add(bar);
        Scene scene = new Scene(root,600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Kurtoza");
        scene.getStylesheets().add(getClass().getResource("chart3.css").toExternalForm());
    }
    public static void main(String[] args) {
        launch(args);
    }}




