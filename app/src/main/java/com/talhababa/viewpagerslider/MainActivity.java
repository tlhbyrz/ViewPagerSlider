package com.talhababa.viewpagerslider;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout linearLayout;

    TextView[] mDots;
    ViewPagerAdapter viewPagerAdapter;

    private int currentPage;

    Button nextbtn,backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        linearLayout = findViewById(R.id.linearlayout);
        nextbtn = findViewById(R.id.button2);
        backbtn = findViewById(R.id.button1);

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewpagerlistener);
    }

    public void addDotsIndicator(int position){

        mDots = new TextView[3];
        linearLayout.removeAllViews();

        for (int i=0;i<mDots.length;i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colortransparent));

            linearLayout.addView( mDots[i]);
        }

        if(mDots.length > 0){
            mDots[position].setTextColor(Color.WHITE);
        }

    }


    ViewPager.OnPageChangeListener viewpagerlistener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);

            currentPage = position;

            if (position == 0){
                nextbtn.setEnabled(true);
                backbtn.setEnabled(false);
                backbtn.setVisibility(View.INVISIBLE);
                nextbtn.setText("next");
                backbtn.setText("");
            }else if (position == mDots.length){
                nextbtn.setEnabled(true);
                backbtn.setEnabled(true);
                backbtn.setVisibility(View.VISIBLE);
                nextbtn.setText("finish");
                backbtn.setText("back");
            }else{
                nextbtn.setEnabled(true);
                backbtn.setEnabled(true);
                backbtn.setVisibility(View.VISIBLE);
                nextbtn.setText("next");
                backbtn.setText("back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
