package com.dynamicdevz.dynamiccalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.dynamicdevz.dynamiccalculator.MainActivity.Operation.*;

//Model - View - Controller
public class MainActivity extends AppCompatActivity {

    //user enters 8
    //- display in textview

    //clicks divide
    //- store 8 in variable, clear textview

    //user enters 2
    //-display in textview

    //user equals - enum
    //-divide stored variable with value in textview
    //expected = 4.0 - display in textview

    enum Operation {
        DIVIDE,
        ADDITION,
        SUBTRACT,
        MULTIPLY,
        NEGATE,
        MODULUS
    }

    private Operation OP = null;
    private double current = 0.0;
    private TextView outputTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputTV = findViewById(R.id.value_textview);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(NUM_KEY, outputTV.getText().toString().trim());
    }

    public static final String NUM_KEY = "KEY";

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        outputTV.setText(savedInstanceState.getString(NUM_KEY));
    }

    public void onCalcClick(View view){


        Pattern.matches("\\s\\d", " 8");
        switch (view.getId()){
            case R.id.one_button:
                handleClick(1);
                break;
            case R.id.two_button:
                handleClick(2);
                break;
            case R.id.three_button:
                handleClick(3);
                break;
            case R.id.four_button:
                handleClick(4);
                break;
            case R.id.five_button:
                handleClick(5);
                break;
            case R.id.six_button:
                handleClick(6);
                break;
            case R.id.seven_button:
                handleClick(7);
                break;
            case R.id.eight_button:
                handleClick(8);
                break;
            case R.id.nine_button:
                handleClick(9);
                break;
            case R.id.zero_button:
                handleClick(0);
                break;
            case R.id.divide_button:
                operation(DIVIDE);
                break;
            case R.id.multiply_button:
                operation(MULTIPLY);
                break;
            case R.id.plus_button:
                operation(ADDITION);
                break;
            case R.id.modulus_button:
                operation(MODULUS);
                break;
            case R.id.minus_button:
                operation(SUBTRACT);
                break;
            case R.id.equal_button:
                calculateOutput();
                break;
            case R.id.ac_button:
                clearAll();
                break;
        }
    }

    private void clearAll() {
        current = 0.0;
        outputTV.setText("0");

    }

    private void calculateOutput() {
        if(OP == null) {
            new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.Theme_AppCompat))
                    .setTitle("Operation Error!")
                    .setMessage("Please select operator.")
                    .setPositiveButton("Thanks", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create().show();
            return;
        }

        double ans = 0.0;
        switch (OP){
            case ADDITION:
                ans = current + Double.parseDouble(outputTV.getText().toString().trim());
                outputTV.setText(ans+"");
                break;
            case MULTIPLY:
                ans = current * Double.parseDouble(outputTV.getText().toString().trim());
                outputTV.setText(ans+"");
                break;
            case SUBTRACT:
                ans = current - Double.parseDouble(outputTV.getText().toString().trim());
                outputTV.setText(ans+"");
                break;
            case DIVIDE:
                ans = current / Double.parseDouble(outputTV.getText().toString().trim());
                outputTV.setText(ans+"");
                break;
            case MODULUS:
                ans = current % Double.parseDouble(outputTV.getText().toString().trim());
                outputTV.setText(ans+"");
                break;

        }

    }

    private void operation(Operation operation) {
        OP = operation;
        current = Double.parseDouble(outputTV.getText().toString().trim());
        outputTV.setText("0");
    }

    private void handleClick(int i) {

        String curr = outputTV.getText().toString();
        if(Double.parseDouble(curr) > 0){
            outputTV.setText(curr+i);
        } else
            outputTV.setText(i +"");
    }
}











