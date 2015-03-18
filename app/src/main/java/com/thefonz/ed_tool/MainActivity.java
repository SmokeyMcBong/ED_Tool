package com.thefonz.ed_tool;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener
{
    ActionBar actionbar;
    ViewPager viewpager;
    FragmentPageTabAdapter ft;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciate the custom adapter
        ft = new FragmentPageTabAdapter(getSupportFragmentManager());

        viewpager = (ViewPager) findViewById(R.id.pager);
        viewpager.setAdapter(ft);

        //add tabs to the action bar
        actionbar = getActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionbar.addTab(actionbar.newTab().setText(R.string.first_tab).setTabListener(this));
        actionbar.addTab(actionbar.newTab().setText(R.string.second_tab).setTabListener(this));
        actionbar.addTab(actionbar.newTab().setText(R.string.third_tab).setTabListener(this));

        actionbar.setLogo(R.mipmap.ic_launcher);
        actionbar.setDisplayUseLogoEnabled(true);
        actionbar.setDisplayShowHomeEnabled(true);


        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageSelected(int arg0)
            {
                actionbar.setSelectedNavigationItem(arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2)
            {
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrollStateChanged(int arg0)
            {
                // TODO Auto-generated method stub
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "This is a place-holder message ",
                    Toast.LENGTH_SHORT);

            toast.show();
          return true;
        }
        if (id == R.id.action_about)
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "This is a place-holder message ",
                    Toast.LENGTH_SHORT);

            toast.show();
          return true;
        }
        if (id == R.id.action_exit)
        {
            finish();
          return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft)
    {
        viewpager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft)
    {
        // TODO Auto-generated method stub
    }

    public class FragmentPageTabAdapter extends FragmentPagerAdapter
    {
        public FragmentPageTabAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int arg0)
        {
            switch (arg0)
            {
                case 0:
                    return new FirstTab();
                case 1:
                    return new SecondTab();
                case 2:
                    return new ThirdTab();

                default:
                    break;
            }
            return null;
        }

        @Override
        public int getCount()
        {
            return 3;
        }
    }
}