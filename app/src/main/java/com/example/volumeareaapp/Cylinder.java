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

public class Cylinder extends AppCompatActivity {

    EditText cyl_height,cyl_radius;
    TextView title,result;
    Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cyl_height = findViewById(R.id.editText_cyl1);
        cyl_radius = findViewById(R.id.editText_cyl);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String height = cyl_height.getText().toString();
                String radius = cyl_radius.getText().toString();


                int h = Integer.parseInt(height);
                int r = Integer.parseInt(radius);


                //V = pi * r^2 * h

                double volume = 3.14159 * r * r * h;
                result.setText("V = "+volume+" m^3");

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String height = cyl_height.getText().toString();
                String radius = cyl_radius.getText().toString();


                int h = Integer.parseInt(height);
                int r = Integer.parseInt(radius);


                //CSA = 2 * pi * r * h
                double CSA = 2 * 3.14159 * r * h ;
                result.setText("CSA = "+CSA+" m^2");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String height = cyl_height.getText().toString();
                String radius = cyl_radius.getText().toString();


                int h = Integer.parseInt(height);
                int r = Integer.parseInt(radius);

                //TSA =  2 * pi * r (h + r )
                double TSA = 2 * 3.14159 * r  * ( h + r ) ;
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