package com.example.pro_currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] cur = {"VND", "USD", "JPY", "CNY", "EUR", "GBP", "CAD", "AUD", "HKD",
                 "SGD", "MYR" , "IDR", "THB", "PHP", "MMK"};
    //Ti gia ngay 27/10
    double[] conv = {1, 23175.00, 220.99, 3452.46, 27381.26 , 30165.00, 17534.24, 16489.01, 2990.28,
            17018.00, 5560.22, 1.5798, 740.89, 478.9213, 17.97};

    EditText amt;
    TextView res;
    Spinner spinnerFrom;
    Spinner spinnerTo;
    int from;
    int to;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amt=(EditText)findViewById(R.id.amt);
        res=(TextView)findViewById(R.id.res);
        spinnerFrom=(Spinner)findViewById(R.id.spinnerFrom);
        spinnerTo=(Spinner)findViewById(R.id.spinnerTo);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,cur);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        from = pos;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                to = pos;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        amt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    result = ((double)Integer.parseInt(String.valueOf(amt.getText()))*conv[from])/conv[to];
                    res.setText(String.valueOf(result));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}