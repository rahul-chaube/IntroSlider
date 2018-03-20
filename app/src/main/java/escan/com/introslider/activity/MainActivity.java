package escan.com.introslider.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import escan.com.introslider.R;
import escan.com.introslider.adapter.TabFragmentAdapter;
import escan.com.introslider.fragment.Intro;
import escan.com.introslider.fragment.ItemListDialogFragment;
import escan.com.introslider.fragment.PlusOneFragment;

public class MainActivity extends AppCompatActivity implements Intro.OnFragmentInteractionListener, PlusOneFragment.OnFragmentInteractionListener, ItemListDialogFragment.Listener {
    ViewPager viewPager;
    TabLayout tabLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tabs);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabFragmentAdapter myViewPagerAdapter=new TabFragmentAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(myViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
