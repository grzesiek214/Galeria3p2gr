package com.example.galeria3pt2gr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button buttonWstecz;
    private Button buttonDalej;
    private int aktualneZdjecie = 0;
    private List<Integer> zdjeciaId = new ArrayList<Integer>();

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

        zdjeciaId.add(R.drawable.hauntedhouse);
        zdjeciaId.add(R.drawable.pumpkin);
        zdjeciaId.add(R.drawable.jackolanterns);

        imageView = findViewById(R.id.imageView);
        buttonWstecz = findViewById(R.id.buttonWstecz);


        buttonWstecz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aktualneZdjecie == 0) {
                    aktualneZdjecie = zdjeciaId.size() - 1;
                } else {
                    aktualneZdjecie--;
                }

                imageView.setImageResource(zdjeciaId.get(aktualneZdjecie));
            }
        });

    }
}