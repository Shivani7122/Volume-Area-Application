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

public class Cone extends AppCompatActivity {

    EditText cone_radius, cone_slant_height;
    TextView title, result;
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cone);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cone_radius = findViewById(R.id.editText_cone2);
        cone_slant_height = findViewById(R.id.editText_cone);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hideKeyboard();
                String radius = cone_radius.getText().toString();
                String slant_height = cone_slant_height.getText().toString();

                int r = Integer.parseInt(radius);
                int l = Integer.parseInt(slant_height);


                //V =1/3 * pi * r^2 * (( (l * l) - (r * r)) ** (1/2))
                double h = ((l * l) - (r * r));
                double volume = (1.0 / 3) * 3.14159 * (r * r) * Math.sqrt(h);
                result.setText("V = " + volume + " m^3");

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hideKeyboard();

                String slant_height = cone_slant_height.getText().toString();
                String radius = cone_radius.getText().toString();

                int l = Integer.parseInt(slant_height);
                int r = Integer.parseInt(radius);

                //CSA = pi * r * l
                double CSA = 3.14159 * r * l;
                result.setText("CSA = " + CSA + " m^2");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hideKeyboard();
                String slant_height = cone_slant_height.getText().toString();
                String radius = cone_radius.getText().toString();

                int l = Integer.parseInt(slant_height);
                int r = Integer.parseInt(radius);

                //TSA = pi * r * ( l + r )
                double TSA = 3.14159 * r * (r + l);
                result.setText("TSA = " + TSA + " m^2");
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