package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener, UI_Interface {

    TextView num1;
    TextView num2;

    TextView result_text;
    TextView result_show;

    EditText enter_num1;
    EditText enter_num2;

    Button result;

    Spinner operations;
    final String[] paths = {"add", "subtract", "multiply", "divide"}; // getResources().getStringArray(R.array.paths)

    String n1;
    String n2;

    double a;
    double b;

    private ArrayAdapter<String> mAdapter;

    Util_Interface cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_initializer();
        cal = new Calculator_Utility(this);

    }

    private void view_initializer(){

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        result_text = findViewById(R.id.result_text);
        result_show = findViewById(R.id.result_show);
        result_show.setText("0");

        enter_num1 = findViewById(R.id.enter_num1);
        enter_num2 = findViewById(R.id.enter_num2);

        result = findViewById(R.id.result);
        result.setOnClickListener(this);

        operations = findViewById(R.id.operations);
        mAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, paths);

        // Associate the ArrayAdapter with the Spinner.
        operations.setAdapter(mAdapter);

        // Set the default selection of the operations to be "add".
        operations.setSelection(mAdapter.getPosition("add"));

    }

    @Override
    public void onClick(View view) {

        String value = operations.getSelectedItem().toString();
        int operation_id = Arrays.asList(paths).indexOf(value) + 1;

        n1 = enter_num1.getText().toString();
        try {
            a = Double.parseDouble(n1);
        }
        catch (Exception e){
            a = 0;
            enter_num1.setText("Enter a number");
        }

        n2 = enter_num2.getText().toString();
        try {
            b = Double.parseDouble(n2);
        }
        catch (Exception e){
            b = 0;
            enter_num2.setText("Enter a number");
        }

        cal.process(a, b, operation_id);

    }



    @Override
    public void print(String answer){
        result_show.setText(answer);
    }

}