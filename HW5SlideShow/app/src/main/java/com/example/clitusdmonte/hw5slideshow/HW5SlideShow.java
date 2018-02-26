package com.example.clitusdmonte.hw5slideshow;

/**
 * Created by clitus dmonte on 2/22/2018.
 */
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class HW5SlideShow extends AppCompatActivity {
    Context context;
    SeekBar timmerSeekBar;
    Button startSlideShowButton;
    TextView textView2;
    int timmer = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw5_slide_show);
        context = this;
        timmerSeekBar = (SeekBar) findViewById(R.id.timmerSeekBar);
        startSlideShowButton = (Button) findViewById(R.id.startSlideShowButton);
        textView2 = (TextView) findViewById(R.id.textView2);

        timmerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBaPprogressValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBaPprogressValue = i;
                timmer = seekBaPprogressValue;
                textView2.setText(String.valueOf(seekBaPprogressValue));
                textView2.setGravity(Gravity.CENTER);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(context, seekBaPprogressValue + "",
                        Toast.LENGTH_SHORT).show();
            }
        });

        startSlideShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSlideShowActivity(timmer);
                Toast.makeText(context, "Interval: " + timmer + "",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void startSlideShowActivity(int time) {
        if (time != 0) {
            Intent intent = new Intent(HW5SlideShow.this, SlideShowImagesActivity.class);
            intent.putExtra("interval", time);
            this.startActivity(intent);
        } else {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
            alertBuilder.setMessage("Please choose a value higher than 0");
            alertBuilder.setCancelable(true);
            alertBuilder.setPositiveButton(
                    "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = alertBuilder.create();
            alert.show();
        }
    }
}
