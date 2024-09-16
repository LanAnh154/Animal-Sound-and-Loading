package com.example.animalsound;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final int[] colors = {
            Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.LTGRAY
    };

    private final int[] icons = {
            R.drawable.penguin, R.drawable.icons8_cat_100, R.drawable.icons8_dog_100
    };

    private LinearLayout layout;
    private ImageView animalImage;
    private ProgressBar progressBar;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.main_layout);
        animalImage = findViewById(R.id.animal_image);
        progressBar = findViewById(R.id.custom_progress_bar);
        random = new Random();


        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBackgroundAndImage();
            }
        });


        changeBackgroundAndImage();
    }

    private void changeBackgroundAndImage() {
        // Hiện ProgressBar
        progressBar.setVisibility(View.VISIBLE);


        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int randomColor = colors[random.nextInt(colors.length)];
                int randomIcon = icons[random.nextInt(icons.length)];

                layout.setBackgroundColor(randomColor);
                animalImage.setImageResource(randomIcon);

                // Ẩn ProgressBar
               progressBar.setVisibility(View.GONE);
            }
        }, 1000);
    }
}