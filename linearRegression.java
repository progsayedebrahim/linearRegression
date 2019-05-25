/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment3;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.regression.LinearRegressionModel;
import org.apache.spark.ml.regression.LinearRegressionTrainingSummary;
import org.apache.spark.ml.linalg.Vectors;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 *
 * @author Sayed
 */
public class linearRegression {
    
    public static void main(String[] args) {
        
        SparkSession session = SparkSession.builder()
               .appName("assignment3")
                  .master("local[*]")
                  .config("spark.sql.warehouse.dir", "file:///D://")
                  .getOrCreate();
    
        Dataset<Row> training = session.read().csv("C://Users//Sayed//Documents//NetBeansProjects//boston dataset//train.csv");
        training.show();
        
         VectorAssembler assemblar = new VectorAssembler()
          .setInputCols(new String[]
         {"ID","crim","zn","indus",
              "chas","nox","rm","age","dis",
              "rad","tax","ptratio","black","lstat","medv"})
         .setOutputCol("features");
             Dataset<Row> featuredata = assemblar.transform(training);
             featuredata.show();
////        
//LinearRegression lr = new LinearRegression()
//  .setMaxIter(10)
//.setRegParam(0.3)
//.setElasticNetParam(0.8);
//
//// Fit the model.
//LinearRegressionModel lrModel = lr.fit(featuredata);
////
////// Print the coefficients and intercept for linear regression.
//System.out.println("Coefficients: "
//  + lrModel.coefficients() + " Intercept: " + lrModel.intercept());
//
////// Summarize the model over the training set and print out some metrics.
//LinearRegressionTrainingSummary trainingSummary = lrModel.summary();
//System.out.println("numIterations: " + trainingSummary.totalIterations());
//System.out.println("objectiveHistory: " + Vectors.dense(trainingSummary.objectiveHistory()));
//trainingSummary.residuals().show();
//System.out.println("RMSE: " + trainingSummary.rootMeanSquaredError());
//System.out.println("r2: " + trainingSummary.r2());
    }
    
}
