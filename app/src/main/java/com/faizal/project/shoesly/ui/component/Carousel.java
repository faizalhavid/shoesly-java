package com.faizal.project.shoesly.ui.component;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import com.faizal.project.shoesly.R;
import com.faizal.project.shoesly.ui.adapter.CarouselAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class Carousel extends FrameLayout {
        private ViewPager2 viewPager;
        private TabLayout tabLayout;
        private TabLayoutMediator tabLayoutMediator;
        private Handler handler;
        private Runnable runnable;
        private long interval = 3000; //3 seconds

        public Carousel(Context context) {
            super(context);
            init(context);
        }

        public Carousel(@NonNull Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }

        public Carousel(@NonNull Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(context);
        }

        private void init(Context context) {
            LayoutInflater.from(context).inflate(R.layout.view_carousel, this, true);
            viewPager = findViewById(R.id.viewPager);
            tabLayout = findViewById(R.id.tabDots);
            // Do not attach TabLayoutMediator here
            handler = new Handler(Looper.getMainLooper());
            runnable = new Runnable() {
                @Override
                public void run() {
                    int currentItem = viewPager.getCurrentItem();
                    int itemCount = viewPager.getAdapter().getItemCount();
                    int nextItem = (currentItem + 1) % itemCount;
                    viewPager.setCurrentItem(nextItem, true);
                    handler.postDelayed(this, interval);
                }
            };
            setupPageTransformer();
        }

        public void setupTabLayoutMediator() {
            if (tabLayoutMediator == null) {
                tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {});
                tabLayoutMediator.attach();
            }
        }

        public void setAdapter(CarouselAdapter adapter) {
            viewPager.setAdapter(adapter);
            setupTabLayoutMediator(); // Attach TabLayoutMediator after setting the adapter
            start();
        }

        public void start() {
            handler.postDelayed(runnable, interval);
        }

        public void stop() {
            handler.removeCallbacks(runnable);
        }

        private void setupPageTransformer() {
            viewPager.setPageTransformer((page, position) -> {
                // Customize transformation here
                page.setAlpha(0.7f + (1 - Math.abs(position)) * 0.3f);
            });
        }
}