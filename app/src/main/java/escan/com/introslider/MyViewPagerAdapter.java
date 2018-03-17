package escan.com.introslider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Android7 on 3/17/2018.
 */

public class MyViewPagerAdapter extends PagerAdapter {
    private int[] layout;
    LayoutInflater layoutInflater;
    Context context;
    public MyViewPagerAdapter(int[] layout, Context context) {
        this.layout = layout;
        this.context=context;
    }

    @Override
    public int getCount() {
        return layout.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(layout[position],container,false);
       container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view= (View) object;
        container.removeView(view);
    }
}
