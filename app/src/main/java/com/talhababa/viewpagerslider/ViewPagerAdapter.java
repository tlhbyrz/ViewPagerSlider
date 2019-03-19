package com.talhababa.viewpagerslider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter {

    LayoutInflater layoutInflater;
    Context context;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return basliklar.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(RelativeLayout) object ;
    }

    private int[] img = {
            R.drawable.ellipse3,
            R.drawable.ellipse4,
            R.drawable.ellipse5
    };

    private String[] basliklar = {
            "ARABALAR",
            "MAKINALAR",
            "TELEFONLAR"
    };

    private String[] icerikler = {
            "Eve dogru giderkene yapilan dogru giderkene yapilan dogru giderkene yapilan dogru giderkene yapilan",
            "MAKINALAR dogru giderkene yapilan dogru giderkene yapilan dogru giderkene yapilan dogru giderkene yapilan",
            "TELEFONLAR dogru giderkene yapilan dogru giderkene yapilan dogru giderkene yapilan dogru giderkene yapilan"
    };

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.viewpagerlayout,container,false);

        ImageView imageView = view.findViewById(R.id.imageview);
        TextView headers = view.findViewById(R.id.header);
        TextView contexts = view.findViewById(R.id.content);


        imageView.setImageResource(img[position]);
        headers.setText(basliklar[position]);
        contexts.setText(icerikler[position]);

        container.addView(view);

        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
