/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

import java.math.BigDecimal;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 *
 * @author Gleywson
 */
public class TipCalculatorController implements Initializable {
    
    //formata os valores para moedas e percetagens
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    
    private BigDecimal tipPercentage = new BigDecimal(0.15); // 15% padrão
    
    
    //controles da Gui definidos na FXML e usados pelo código do controlador
    @FXML
    private Label tipPercentageLabel;
    @FXML
    private TextField amountTexField;
    @FXML
    private TextField tipTextField;
    @FXML
    private Slider tipPercentageSlider;
    @FXML
    private TextField totalTextField;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    //calcula e exibe o valor de gorjeta e o valor total
    @FXML
    private void calculateButtonPressed(ActionEvent event) {
        try{
            BigDecimal amount = new BigDecimal(amountTexField.getText());
            BigDecimal tip = amount.multiply(tipPercentage);
            BigDecimal total = total = amount.add(tip);
            
            tipTextField.setText(currency.format(tip));
            totalTextField.setText(currency.format(total));
        } catch (NumberFormatException ex) {
            amountTexField.setText("Entre com o valor");
            amountTexField.selectAll();
            amountTexField.requestFocus();
        }
    }
    
}
