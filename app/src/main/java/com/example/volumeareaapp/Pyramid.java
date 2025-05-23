package com.example.volumeareaapp;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pyramid extends AppCompatActivity {


    EditText pyr_height,pyr_side;
    TextView title,result;
    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pyramid);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pyr_height = findViewById(R.id.editText_pyr1);
        pyr_side = findViewById(R.id.editText_pyr);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String height = pyr_height.getText().toString();
                String side = pyr_side.getText().toString();


                int l = Integer.parseInt(height);
                int s = Integer.parseInt(side);
                int P = 4 * s;
                int A = s * s;



                double h = ((l * l) - ((s/2) * (s/2)));
                double volume = (1.0/3) * A * Math.sqrt(h);
                result.setText("V = "+volume+" m^3");

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String height = pyr_height.getText().toString();
                String side = pyr_side.getText().toString();


                int l = Integer.parseInt(height);
                int s = Integer.parseInt(side);
                int P = 4 * s;
                int A = s * s;


                //CSA = 2 * pi * r * h
                double LSA = (1.0/2) * P * l;
                result.setText("LSA = "+LSA+" m^2");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String height = pyr_height.getText().toString();
                String side = pyr_side.getText().toString();


                int l = Integer.parseInt(height);
                int s = Integer.parseInt(side);
                int P = 4 * s;
                int A = s * s;


                //TSA =  2 * pi * r (h + r )
                double TSA = (1.0/2) * P * l + A ;
                result.setText("TSA = "+TSA+" m^2");
            }
        });


    }
    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        View currentFocus = getCurrentFocus();
        if (imm != null && currentFocus != null) {
            imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }
}