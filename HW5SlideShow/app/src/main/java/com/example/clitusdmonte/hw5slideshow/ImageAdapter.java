package com.example.clitusdmonte.hw5slideshow;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by clitus dmonte on 2/23/2018.
 */

class ImageAdapter extends PagerAdapter {
    private ArrayList<ImageDataDAO> arryList;
    private LayoutInflater layoutInflater;
    private Context context;

    public ImageAdapter(Context context, ArrayList<ImageDataDAO> arryList) {
        this.context = context;
        this.arryList = arryList;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return arryList.size();
    }
    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = layoutInflater.inflate(R.layout.activity_slide_show, view,
                false);
        assert imageLayout != null;
        ImageView imageView = imageLayout.findViewById(R.id.displayImageView);
        TextView titleTextview = imageLayout.findViewById(R.id.headingTextView);
        TextView descTextview = imageLayout.findViewById(R.id.descTextView);
        TextView indicatorTextView = imageLayout.findViewById(R.id.indicatorTextView);
        imageView.setImageBitmap(BitmapFactory.decodeResource(context.getResources(),
                arryList.get(position).getImage()));
        titleTextview.setText(arryList.get(position).getTitle());
        titleTextview.setGravity(Gravity.CENTER);
        descTextview.setText(arryList.get(position).getDesc());
        descTextview.setGravity(Gravity.CENTER);
        indicatorTextView.setText(String.valueOf(position + 1));
        indicatorTextView.setGravity(Gravity.CENTER);
        view.addView(imageLayout, 0);
        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
    public void restoreState(Parcelable state, ClassLoader loader) {
    }
    @Override
    public Parcelable saveState() {
        return null;
    }
}
