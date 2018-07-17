package in.websuite.web.tabslider;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;
    TabLayout mTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager=(ViewPager)findViewById(R.id.view_page);
        mTabLayout=(TabLayout)findViewById(R.id.tab_layout);

        MyPageAdapter ma=new MyPageAdapter();
        ma.al1.add(new FirstFragment());
        ma.al1.add(new SecondFragment());
        ma.al1.add(new ThirdFragment());
        ma.al2.add("First 1");
        ma.al2.add("Second 2");
        ma.al2.add("Third 3");

        mViewPager.setAdapter(ma);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    class MyPageAdapter extends FragmentPagerAdapter
    {

        ArrayList<Fragment> al1=new ArrayList<Fragment>();
        ArrayList<String> al2=new ArrayList<String>();
        MyPageAdapter()
        {
            super(getSupportFragmentManager());
        }

        @Override
        public Fragment getItem(int position) {
            return al1.get(position);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return al2.get(position);
        }
        @Override
        public int getCount() {
            return al1.size();
        }
    }
}
