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

public class Prism extends AppCompatActivity {

    EditText prism_length,prism_width,prism_height;
    TextView title,result;
    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prism);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        prism_height = findViewById(R.id.editText_prism2);
        prism_width = findViewById(R.id.editText_prism1);
        prism_length = findViewById(R.id.editText_prism);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String height = prism_height.getText().toString();
                String length = prism_length.getText().toString();
                String width = prism_width.getText().toString();

                int h = Integer.parseInt(height);
                int l = Integer.parseInt(length);
                int w = Integer.parseInt(width);

                //V = w * h * l

                double volume = w * h * l ;
                result.setText("V = "+volume+" m^3");

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String height = prism_height.getText().toString();
                String length = prism_length.getText().toString();
                String width = prism_width.getText().toString();

                int h = Integer.parseInt(height);
                int l = Integer.parseInt(length);
                int w = Integer.parseInt(width);

                //LSA = 2 ( l + w ) h
                double LSA = 2 * ( l + w) * h ;
                result.setText("LSA = "+LSA+" m^2");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String height = prism_height.getText().toString();
                String length = prism_length.getText().toString();
                String width = prism_width.getText().toString();

                int h = Integer.parseInt(height);
                int l = Integer.parseInt(length);
                int w = Integer.parseInt(width);

                //TSA =  2 (lh +wh + lw )
                double TSA = 2 * ( (l * h) + (w * h) + (l * w))  ;
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