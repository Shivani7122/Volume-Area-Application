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

public class Sphere extends AppCompatActivity {

    EditText sphere_radius;
    TextView title,result;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sphere_radius = findViewById(R.id.editText_sphere);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String radius = sphere_radius.getText().toString();

                int r = Integer.parseInt(radius);

                //V = (4/3) * pi * r^3

                double volume = (4.0/3) * 3.14159 * r * r * r;
                result.setText("V = "+volume+" m^3");

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String radius = sphere_radius.getText().toString();

                int r = Integer.parseInt(radius);
                //A = 4 * pi * r^2
                double area = 4 * 3.14159 * r * r;
                result.setText("A = "+area+" m^2");
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