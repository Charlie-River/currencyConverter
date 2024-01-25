package com.example.currencyconverter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ToggleGroup;

public class HelloController {

    //This is our array of exchange rates
    private static final double[][] exchangeRates = {
            //USD    EUR    JPY    GBP
            {1.0,    0.84,  110.7,  0.91}, //USD
            {1.19,   1.0,   131.8,  0.86} ,//EUR
            {0.009,  0.0076, 0.0065, 0.0083}, //JPY
            {1.39, 1.16, 152.8, 1.0}, //GBP
    };

    //This is our convert method which takes the values it is given and finds them in the array
    public static double convert(double amount, String sourceCurrency, String targetCurrency) {
        int sourceIndex = getCurrencyIndex(sourceCurrency);
        int targetIndex = getCurrencyIndex(targetCurrency);
        return amount*exchangeRates[sourceIndex][targetIndex];
    }

    //Initializing our target and source currency variables
    public static String targetCurrency = "GBP";
    public static String sourceCurrency = "GBP";

    //This method will be used to set a new target currency, with the buttons provided
    public static void setTargetCurrency(String newTargetCurrency){
        targetCurrency = newTargetCurrency;
    }

    //setting the users original currency type
    public static void setSourceCurrency(String newSourceCurrency){
        sourceCurrency = newSourceCurrency;
    }

    //This is used to get the index of each currency later used for the calculation
    public static int getCurrencyIndex(String currency) {
        return switch (currency) {
            case "USD" -> 0;
            case "EUR" -> 1;
            case "JPY" -> 2;
            case "GBP" -> 3;
            default -> 100;
        };
    }

    //Creating button variables so that they can be used onAction also
    @FXML
    private ToggleButton sourceGBP;
    @FXML
    private ToggleButton sourceUSD;
    @FXML
    private ToggleButton sourceEUR;
    @FXML
    private ToggleButton sourceJPY;
    @FXML
    private ToggleGroup tgSource;
    @FXML
    private ToggleButton targetGBP;
    @FXML
    private ToggleButton targetUSD;
    @FXML
    private ToggleButton targetEUR;
    @FXML
    private ToggleButton targetJPY;
    @FXML
    private ToggleGroup tgTarget;

    //Creating variables for the textfield and label
    @FXML
    private TextField inputAmount;
    double amount;
    @FXML
    private Label answerText;

    private Alert errorAlert;

    //Input validation
    private boolean validateInput(String input) {
        if (input.trim().isEmpty() || input.matches(".*[a-zA-Z].*")) {
            showErrorAlert("Invalid input", "Please enter a number");
        } else {
            return false;
        }
        return false;
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //The submit button onAction, takes the text field answer uses it in the conversion and then prints the answer out to the user

    //button events to change target and source values
    //ideally get two methods and change using ID? removes redundant code & repeats
    @FXML
    public void setSourceGBP(ActionEvent e) {
        setSourceCurrency("GBP");
        System.out.println(sourceCurrency);
    }

    @FXML
    public void setSourceUSD(ActionEvent e) {
        setSourceCurrency("USD");
        System.out.println(sourceCurrency);
    }

    @FXML
    public void setSourceEUR(ActionEvent e) {
        setSourceCurrency("EUR");
        System.out.println(sourceCurrency);
    }

    @FXML
    public void setSourceJPY(ActionEvent e) {
        setSourceCurrency("JPY");
        System.out.println(sourceCurrency);
    }

    @FXML
    public void setTargetGBP(ActionEvent e) {
        setTargetCurrency("GBP");
        System.out.println(targetCurrency);
    }

    @FXML
    public void setTargetUSD(ActionEvent e) {
        setTargetCurrency("USD");
        System.out.println(targetCurrency);
    }

    @FXML
    public void setTargetEUR(ActionEvent e) {
        setTargetCurrency("EUR");
        System.out.println(targetCurrency);
    }

    @FXML
    public void setTargetJPY(ActionEvent e) {
        setTargetCurrency("JPY");
        System.out.println(targetCurrency);
    }

    //The submit button onAction, takes the text field answer uses it in the conversion and then prints the answer out to the user
    public void submit(ActionEvent e){
        validateInput(inputAmount.getText());
        amount = Integer.parseInt(inputAmount.getText());
        System.out.println(amount);
        double convertedAmount = convert(amount, sourceCurrency, targetCurrency);
        System.out.println(convertedAmount);
        answerText.setText(amount + " in " + sourceCurrency + " is: " + convertedAmount + " " + targetCurrency);
        answerText.setVisible(true);
    }

}


