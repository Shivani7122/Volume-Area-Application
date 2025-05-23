package com.example.volumeareaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;

import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 1- AdapterView: GridView
    GridView gridView;

    // 2- Data Source: ArrayList<Shapes>
    ArrayList<Shape> shapeArrayList;

    // 3- Adapter: MyCustomAdapter
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gridView = findViewById(R.id.gridView);
        shapeArrayList = new ArrayList<>();

        Shape s1 = new Shape(R.drawable.sphere,"Sphere");
        Shape s2 = new Shape(R.drawable.cylinder,"Cylinder");
        Shape s3 = new Shape(R.drawable.cube,"Cube");
        Shape s4 = new Shape(R.drawable.prism,"Prism");
        Shape s5 = new Shape(R.drawable.pyramid,"Pyramid");
        Shape s6 = new Shape(R.drawable.cuboid,"Cuboid");
        Shape s7 = new Shape(R.drawable.cone,"Cone");
        Shape s8 = new Shape(R.drawable.hemi,"Hemisphere");






        shapeArrayList.add(s1);
        shapeArrayList.add(s2);
        shapeArrayList.add(s3);
        shapeArrayList.add(s4);
        shapeArrayList.add(s5);
        shapeArrayList.add(s6);
        shapeArrayList.add(s7);
        shapeArrayList.add(s8);


        adapter = new MyCustomAdapter(shapeArrayList,getApplicationContext());

        gridView.setAdapter(adapter);
        gridView.setNumColumns(3);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String shapeType = shapeArrayList.get(position).getShapeName();
                Intent i;
                if ("Sphere".equals(shapeType)){
                    i = new Intent(getApplicationContext(), Sphere.class);
                    startActivity(i);
                } else if ("Cube".equals(shapeType)) {
                    i = new Intent(getApplicationContext(), Cube.class);
                    startActivity(i);
                } else if ("Cylinder".equals(shapeType)) {
                    i = new Intent(getApplicationContext(), Cylinder.class);
                    startActivity(i);
                } else if ("Prism".equals(shapeType)) {
                    i = new Intent(getApplicationContext(), Prism.class);
                    startActivity(i);
                } else if ("Cuboid".equals(shapeType)) {
                    i = new Intent(getApplicationContext(), Cuboid.class);
                    startActivity(i);
                } else if ("Cone".equals(shapeType)) {
                    i = new Intent(getApplicationContext(), Cone.class);
                    startActivity(i);
                } else if ("Hemisphere".equals(shapeType)) {
                    i = new Intent(getApplicationContext(), HemiSphere.class);
                    startActivity(i);
                } else{
                    i = new Intent(getApplicationContext(), Pyramid.class);
                    startActivity(i);
                }
            }
        });




    }
}