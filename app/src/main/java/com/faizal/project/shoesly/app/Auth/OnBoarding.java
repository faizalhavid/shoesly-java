package com.faizal.project.shoesly.app.Auth;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.faizal.project.shoesly.R;
import com.faizal.project.shoesly.ui.adapter.CarouselAdapter;
import com.faizal.project.shoesly.ui.component.Carousel;

import java.util.Arrays;
import java.util.List;

public class OnBoarding extends AppCompatActivity {
    private Carousel carousel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_onboarding);
        carousel = findViewById(R.id.carouselView);

        List<Integer> images = Arrays.asList(
                R.drawable.onboarding_1_illustration,
                R.drawable.onboarding_2_illustration,
                R.drawable.onboarding_3_illustration
        );

        CarouselAdapter adapter = new CarouselAdapter(this, images);
        carousel.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carousel.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        carousel.stop();
    }
}