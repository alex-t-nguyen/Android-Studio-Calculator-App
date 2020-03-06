package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean operatorPressed = false;
    private boolean numberPressed = false;
    private double tempNum = 0;
    private String currentOperator = "";
    private int num2Index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView calculatorScreen = findViewById(R.id.CalculatorScreen);
        final Button b0 = findViewById(R.id.b0);
        final Button b1 = findViewById(R.id.b1);
        final Button b2 = findViewById(R.id.b2);
        final Button b3 = findViewById(R.id.b3);
        final Button b4 = findViewById(R.id.b4);
        final Button b5 = findViewById(R.id.b5);
        final Button b6 = findViewById(R.id.b6);
        final Button b7 = findViewById(R.id.b7);
        final Button b8 = findViewById(R.id.b8);
        final Button b9 = findViewById(R.id.b9);
        final Button bEqual = findViewById(R.id.bEqual);
        final Button bAdd = findViewById(R.id.bAdd);
        final Button bSubtract = findViewById(R.id.bSubtract);
        final Button bMultiply = findViewById(R.id.bMultiply);
        final Button bDivide = findViewById(R.id.bDivide);
        final Button bDecimal = findViewById(R.id.bDecimal);
        final Button bDelete = findViewById(R.id.bDelete);
        final Button bClear = findViewById(R.id.bClear);

        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            public void onClick(View v) {
                int id = v.getId();
                switch (id) {
                    case R.id.b0:
                        calculatorScreen.append("0");
                        numberPressed = true;

                        break;

                    case R.id.b1:
                        calculatorScreen.append("1");
                        numberPressed = true;

                        break;

                    case R.id.b2:
                        calculatorScreen.append("2");
                        numberPressed = true;

                        break;

                    case R.id.b3:
                        calculatorScreen.append("3");
                        numberPressed = true;

                        break;

                    case R.id.b4:
                        calculatorScreen.append("4");
                        numberPressed = true;

                        break;

                    case R.id.b5:
                        calculatorScreen.append("5");
                        numberPressed = true;

                        break;

                    case R.id.b6:
                        calculatorScreen.append("6");
                        numberPressed = true;

                        break;

                    case R.id.b7:
                        calculatorScreen.append("7");
                        numberPressed = true;

                        break;

                    case R.id.b8:
                        calculatorScreen.append("8");
                        numberPressed = true;

                        break;

                    case R.id.b9:
                        calculatorScreen.append("9");
                        numberPressed = true;

                        break;

                    case R.id.bEqual:
                        if(operatorPressed && numberPressed) {
                            if (currentOperator.equals("+")) {
                                String num2String = calculatorScreen.getText().toString().substring(num2Index);
                                double num2 = Double.parseDouble(num2String);
                                tempNum += num2;
                                calculatorScreen.setText(String.valueOf(tempNum));
                            } else if (currentOperator.equals("-")) {
                                String num2String = calculatorScreen.getText().toString().substring(num2Index);
                                double num2 = Double.parseDouble(num2String);
                                tempNum -= num2;
                                calculatorScreen.setText(String.valueOf(tempNum));
                            } else if (currentOperator.equals("*")) {
                                String num2String = calculatorScreen.getText().toString().substring(num2Index);
                                double num2 = Double.parseDouble(num2String);
                                tempNum *= num2;
                                calculatorScreen.setText(String.valueOf(tempNum));
                            } else if (currentOperator.equals("/")) {
                                String num2String = calculatorScreen.getText().toString().substring(num2Index);
                                double num2 = Double.parseDouble(num2String);
                                tempNum /= num2;
                                calculatorScreen.setText(String.valueOf(tempNum));
                            }
                            operatorPressed = false;
                        }
                        break;

                    case R.id.bAdd:
                        if(numberPressed) {
                            num2Index = calculatorScreen.getText().toString().length() + 1;
                            tempNum = Double.parseDouble(calculatorScreen.getText().toString());
                            calculatorScreen.append("+");
                            operatorPressed = true;
                            currentOperator = "+";
                        }
                        numberPressed = false;
                        break;

                    case R.id.bSubtract:
                        if(numberPressed) {
                            num2Index = calculatorScreen.getText().toString().length() + 1;
                            tempNum = Double.parseDouble(calculatorScreen.getText().toString());
                            calculatorScreen.append("-");
                            operatorPressed = true;
                            currentOperator = "-";
                        }
                        else
                            calculatorScreen.append("-");
                        numberPressed = false;
                        break;

                    case R.id.bMultiply:
                        if(numberPressed) {
                            num2Index = calculatorScreen.getText().toString().length() + 1;
                            tempNum = Double.parseDouble(calculatorScreen.getText().toString());
                            calculatorScreen.append("*");
                            operatorPressed = true;
                            currentOperator = "*";
                        }
                        numberPressed = false;
                        break;


                    case R.id.bDivide:
                        if(numberPressed) {
                            num2Index = calculatorScreen.getText().toString().length() + 1;
                            tempNum = Double.parseDouble(calculatorScreen.getText().toString());
                            calculatorScreen.append("/");
                            operatorPressed = true;
                            currentOperator = "/";
                        }
                        numberPressed = false;
                        break;


                    case R.id.bDecimal:
                        calculatorScreen.append(".");
                        break;
                }
            }
        };
        b0.setOnClickListener(calculatorListener);
        b1.setOnClickListener(calculatorListener);
        b2.setOnClickListener(calculatorListener);
        b3.setOnClickListener(calculatorListener);
        b4.setOnClickListener(calculatorListener);
        b5.setOnClickListener(calculatorListener);
        b6.setOnClickListener(calculatorListener);
        b7.setOnClickListener(calculatorListener);
        b8.setOnClickListener(calculatorListener);
        b9.setOnClickListener(calculatorListener);
        bEqual.setOnClickListener(calculatorListener);
        bAdd.setOnClickListener(calculatorListener);
        bSubtract.setOnClickListener(calculatorListener);
        bMultiply.setOnClickListener(calculatorListener);
        bDivide.setOnClickListener(calculatorListener);
        bDecimal.setOnClickListener(calculatorListener);
        bDelete.setOnClickListener(calculatorListener);
        bClear.setOnClickListener(calculatorListener);

        final Button delete = findViewById(R.id.bDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = calculatorScreen.getText().toString();
                if(number.length() > 0)
                    calculatorScreen.setText(number.substring(0,number.length() - 1));

            }
        });

        final Button clear = findViewById(R.id.bClear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorScreen.setText("");
            }
        });
    }
}