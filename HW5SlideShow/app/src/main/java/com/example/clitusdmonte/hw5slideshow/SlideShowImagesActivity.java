package com.example.clitusdmonte.hw5slideshow;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by clitus dmonte on 2/22/2018.
 */

public class SlideShowImagesActivity extends AppCompatActivity {
    public static final String[] moviesTitles = new String[]{"Iron Man", "The Incredible Hulk", "Iron Man two",
            "Thor", "Captain America: The First Avenger", "The Avengers", "Iron Man 3",
            "Thor: The Dark World", "Captain America: The Winter Soldier", "Avengers: Age of Ultron",
            "Ant-Man", "Deadpool", "Captain America: Civil War"};

    public static final String[] moviesDesc = new String[]{"2008 ‧ Science fiction film/Thriller ‧ 2h 6m",
            "2008 ‧ Science fiction film/Thriller ‧ 2h 15m", " 2010 ‧ Science fiction film/Action ‧ 2h 4m",
            " 2011 ‧ Fantasy/Science fiction film ‧ 1h 55m", "2011 ‧ Science fiction film/Thriller ‧ 2h 4m",
            "2012 ‧ Fantasy/Science fiction film ‧ 2h 23m", "2013 ‧ Science fiction film/Action ‧ 2h 10m",
            "2013 ‧ Fantasy/Science fiction film ‧ 1h 52m", "2010 ‧ Science fiction film/Action ‧ 2h 4m",
            "2014 ‧ Science fiction film/Thriller ‧ 2h 16m",
            "2015 ‧ Science fiction film/Action ‧ 2h 22m", "2015 ‧ Science fiction film/Thriller ‧ 1h 58m",
            "2016 ‧ Science fiction film/Action ‧ 1h 48m", "2016 ‧ Science fiction film/Thriller ‧ 2h 28m"};

    public static final Integer[] moviesImages = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten,
            R.drawable.eleven, R.drawable.twelve, R.drawable.thirteen};

    int intervalTime;
    private static ViewPager viewPager;
    private static int currentPage = 0;
    private static int pageNo = 0;
    Timer swipeSecondsTimer;
    ArrayList<ImageDataDAO> imageArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);
        intervalTime = getIntent().getIntExtra("interval", 1);
        imageArrayList = new ArrayList<ImageDataDAO>();
        populateList();
        init();
    }
    @Override
    public void onBackPressed() {
        swipeSecondsTimer.cancel();
        currentPage = 0;
        super.onBackPressed();
    }
    public void populateList() {
        for (int i = 0; i < moviesTitles.length; i++) {
            imageArrayList.add(new ImageDataDAO(moviesImages[i], moviesTitles[i], moviesDesc[i]));
        }
    }
    private void init() {
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new ImageAdapter(SlideShowImagesActivity.this,
                imageArrayList));
        pageNo = imageArrayList.size();
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == pageNo) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };
        swipeSecondsTimer = new Timer();
        swipeSecondsTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 1000, intervalTime * 1000);
    }



}
