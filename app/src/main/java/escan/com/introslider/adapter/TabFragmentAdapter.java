package escan.com.introslider.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import escan.com.introslider.fragment.Intro;
import escan.com.introslider.fragment.ItemListDialogFragment;
import escan.com.introslider.fragment.PlusOneFragment;

/**
 * Created by Android7 on 3/20/2018.
 */

public class TabFragmentAdapter extends FragmentPagerAdapter {
    Context context;
    public TabFragmentAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0)
        {
            return new Intro();
        }
        else if (position==1)
            return new PlusOneFragment();
        else
            return new ItemListDialogFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Intro";
            case 1:
                return "OPF";
            case 2:
                return "BottomSheet";
                default: return null;
        }
    }
}
