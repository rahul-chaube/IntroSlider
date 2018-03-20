package escan.com.introslider.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import escan.com.introslider.adapter.MyViewPagerAdapter;
import escan.com.introslider.Utility.PrefManager;
import escan.com.introslider.R;

public class Welcome extends AppCompatActivity {
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int [] layouts;
    private Button btnSkip,btnNext;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefManager=new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch())
        {
            loadHomeScreen();
            finish();
        }

        if (Build.VERSION.SDK_INT >=21)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        setContentView(R.layout.activity_welcome);
        viewPager=findViewById(R.id.view_pager);
        dotsLayout=findViewById(R.id.layoutDots);
        btnSkip=findViewById(R.id.btn_skip);
        btnNext=findViewById(R.id.btn_next);
        layouts=new int[]{R.layout.welcome_slide1,
                R.layout.welcome_slide2,
                R.layout.welcome_slide3,
                R.layout.welcome_slide4};
        // Adding Dots Layout
        addBottomDots(0);
        //making notification bar transperant
        changeStatusBarColor();

        myViewPagerAdapter=new MyViewPagerAdapter(layouts,this);
        viewPager.setAdapter(myViewPagerAdapter);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
                if (position==layouts.length-1)
                {
                    // check for last screen
                    btnNext.setText(getString(R.string.start));
                    btnSkip.setVisibility(View.GONE);
                }
                else
                {
                    btnNext.setText(getString(R.string.next));
                    btnSkip.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHomeScreen();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current=getItem(+1);
                if (current<layouts.length)
                {
                    viewPager.setCurrentItem(current);
                }
                else
                    loadHomeScreen();
            }
        });

    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
        {
            Window window=getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void addBottomDots(int currentPage) {
        dots=new TextView[layouts.length];
        int []colorActive=getResources().getIntArray(R.array.array_dot_active);
        int []colorInActive=getResources().getIntArray(R.array.array_dot_inactive);
        dotsLayout.removeAllViews();
        for (int j = 0; j < dots.length; j++) {
            dots[j]=new TextView(this);
            dots[j].setText(Html.fromHtml("&#8226"));
            dots[j].setTextSize(35);
            dots[j].setTextColor(colorActive[j]);
            dotsLayout.addView(dots[j]);

        }
        if (dots.length>0)
        {
            dots[currentPage].setTextColor(colorActive[currentPage]);
        }
    }


    private void loadHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
