package com.example.task21;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //Create Variables

    Button buttonLength;
    Button buttonWeight;
    Button buttonTemperature;

    Button buttonConvert;

    Spinner spinnerSourceUnit;
    Spinner spinnerDestinationUnit;

    EditText editFromValue;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link to variables with findbyviewid
        buttonLength = findViewById(R.id.buttonLength);
        buttonWeight = findViewById(R.id.buttonWeight);
        buttonTemperature = findViewById(R.id.buttonTemperature);

        buttonConvert = findViewById(R.id.buttonConvert);

        spinnerSourceUnit = findViewById(R.id.spinnerSourceUnit);
        spinnerDestinationUnit = findViewById(R.id.spinnerDestinationUnit);

        editFromValue = findViewById(R.id.editFromValue);
        textView = findViewById(R.id.textView);

        //adapter length
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.SpinnerItemsLength, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //adapter 2 weight
        ArrayAdapter<CharSequence>adapter2=ArrayAdapter.createFromResource(this, R.array.SpinnerItemsWeight, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //adapter 3 temperature
        ArrayAdapter<CharSequence>adapter3=ArrayAdapter.createFromResource(this, R.array.SpinnerItemsTemperature, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerSourceUnit.setAdapter(adapter);
        spinnerDestinationUnit.setAdapter(adapter);

        //onclick spinner items
        //length
        buttonLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerSourceUnit.setAdapter(adapter);
                spinnerDestinationUnit.setAdapter(adapter);
            }
        });
        //weight
        buttonWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerSourceUnit.setAdapter(adapter2);
                spinnerDestinationUnit.setAdapter(adapter2);
            }
        });
        //temperature
        buttonTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerSourceUnit.setAdapter(adapter3);
                spinnerDestinationUnit.setAdapter(adapter3);
            }
        });

        //Convert button Logic
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //selected input unit toString
                String inputSourceUnit = spinnerSourceUnit.getSelectedItem().toString();
                String inputDestinationUnit = spinnerDestinationUnit.getSelectedItem().toString();

                //conversion values
                double inputValue = Double.parseDouble(editFromValue.getText().toString());

                double foot = 0;
                double pound = 0;
                double celsius = 0;
                double output = 0;

                //input switch
                switch (inputSourceUnit){
                    //Length
                    case "Inch":
                        foot = inputValue * .0833;
                        break;
                    case "Foot":
                        foot = inputValue;
                        break;
                    case "Yard":
                        foot = inputValue * 3;
                        break;
                    case "Centimetre":
                        foot = inputValue / 30.48;
                        break;
                    case "Meter":
                        foot = inputValue * 3.281;
                        break;
                    //Weight
                    case "Pound":
                        pound = inputValue;
                        break;
                    case "Ounce":
                        pound = inputValue / 16;
                        break;
                    case "Ton":
                        pound = inputValue * 2000;
                        break;
                    case "Gram":
                        pound = inputValue / 453.6;
                        break;
                    case "Kilogram":
                        pound = inputValue * 2.205;
                        break;
                    //Temperature
                    case "Celsius":
                        celsius = inputValue;
                        break;
                    case "Fahrenheit":
                        celsius = (inputValue - 32) / 1.8;
                        break;
                    case "Kelvin":
                        celsius = inputValue - 273.15;
                        break;
                    default:
                        foot = 0;
                        celsius = 0;
                        pound = 0;
                        break;
                }

                //output switch
                switch (inputDestinationUnit){
                    //Length
                    case "Inch":
                        output = foot * 12;
                        break;
                    case "Foot":
                        output = foot;
                        break;
                    case "Yard":
                        output = foot /3;
                        break;
                    case "Centimetre":
                        output = foot * 30.48;
                        break;
                    case "Meter":
                        output = foot / 3.281;
                        break;
                    //Weight
                    case "Pound":
                        output = pound;
                        break;
                    case "Ounce":
                        output = pound * 16;
                        break;
                    case "Ton":
                        output = pound / 2000;
                        break;
                    case "Gram":
                        output = pound * 453.6;
                        break;
                    case "Kilogram":
                        output = pound / 2.205;
                        break;
                    //Temperature
                    case "Celsius":
                        output = celsius;
                        break;
                    case "Fahrenheit":
                        output = (celsius * 1.8) + 32;
                        break;
                    case "Kelvin":
                        output = celsius + 273.15;
                        break;
                    default:
                        output = 0;
                        break;
                }
                //output to textview
                textView.setText(inputValue + " " + inputSourceUnit + " = " + output + " " + inputDestinationUnit);



            }
        });


    }
}