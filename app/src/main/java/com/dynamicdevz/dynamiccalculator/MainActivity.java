package com.dynamicdevz.dynamiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//Model - View - Controller
public class MainActivity extends AppCompatActivity {

    private TextView outputTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputTV = findViewById(R.id.value_textview);
    }


    public void onCalcClick(View view){
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
        }
    }

    private void handleClick(int i) {

        String current = outputTV.getText().toString();
        if(Integer.parseInt(current) > 0){
            outputTV.setText(current+i);
        } else
            outputTV.setText(i +"");
    }
}











