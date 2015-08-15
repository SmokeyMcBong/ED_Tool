/**
 * Created by theFONZ on 01/08/2015.
 */

package com.thefonz.ed_tool;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import com.thefonz.ed_tool.tcp_client.TCPClient;
import com.thefonz.ed_tool.theme_manager.ThemeManager;
import com.thefonz.ed_tool.update_manager.UpdateManager;
import com.thefonz.ed_tool.utils.Constants;
import com.thefonz.ed_tool.utils.Helper;

import java.util.ArrayList;

import static com.thefonz.ed_tool.Tab_ButtonBox.sendKey;

public class ED_Tool extends FragmentActivity implements ActionBar.TabListener {

    private ActionBar actionbar;
    private ViewPager viewpager;

    private static Context contextOfApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Define Application Context
        contextOfApplication = getApplicationContext();

        // Check for active internet connection
        Boolean checkInternet = UpdateManager.checkInternet(contextOfApplication);
        if (!checkInternet) {
            Helper.showToast_Short(contextOfApplication, Constants.noNet);
        }

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean applicationUpdates = SP.getBoolean("applicationUpdates", true);
        boolean raresOnOff = SP.getBoolean("raresOnOff", true);
        boolean calculatorOnOff = SP.getBoolean("calculatorOnOff", true);
        boolean notesOnOff = SP.getBoolean("notesOnOff", true);
        boolean galnetOnOff = SP.getBoolean("galnetOnOff", true);
        boolean redditOnOff = SP.getBoolean("redditOnOff", true);

        boolean rares = false;
        boolean calculator = false;
        boolean notes = false;
        boolean galnet = false;
        boolean reddit = false;

        // Create The Tab List ArrayList depending on which features/tabs are enabled in preferences ..
        ArrayList<Fragment> list = new ArrayList<Fragment>();

        // Button Box tab will be non removable, so always add this Tab to the list
        list.add(new Tab_ButtonBox());

        int maxPageLimit = 1;

        // Make preferences checks and set following tabs accordingly
        if (raresOnOff) {
            rares = true;
            list.add(new Tab_Rares());
            maxPageLimit = maxPageLimit + 1;
        }
        if (calculatorOnOff) {
            calculator = true;
            list.add(new Tab_Calculator());
            maxPageLimit = maxPageLimit + 1;
        }
        if (notesOnOff) {
            notes = true;
            list.add(new Tab_Notes());
            maxPageLimit = maxPageLimit + 1;
        }
        if (galnetOnOff) {
            galnet = true;
            list.add(new Tab_Galnet());
            maxPageLimit = maxPageLimit + 1;
        }
        if (redditOnOff) {
            reddit = true;
            list.add(new Tab_Reddit());
            maxPageLimit = maxPageLimit + 1;
        }

        // Set theme according to Preference setting
        ThemeManager.onActivityCreateSetTheme(this);

        if (applicationUpdates) {
            // Call fileStructureCheck() and checkUpdate() methods if auto update check is enabled
            UpdateManager.fileStructureCheck();
            UpdateManager.checkUpdate(contextOfApplication);
        }

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //instantiate the custom adapter
        FragmentPageTabAdapter ft = new FragmentPageTabAdapter(getSupportFragmentManager(), list);

        // set viewpager
        viewpager = (ViewPager) findViewById(R.id.pager);
        viewpager.setOffscreenPageLimit(maxPageLimit);
        viewpager.setAdapter(ft);

        //add tabs to the action bar
        actionbar = getActionBar();
        assert actionbar != null;
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Button Box tab will be non removable, so keep this here
        actionbar.addTab(actionbar.newTab().setText(R.string.tab_buttonbox).setTabListener(this));

        // check which features/tabs are enabled in preferences and set accordingly
        if (rares) {
            actionbar.addTab(actionbar.newTab().setText(R.string.tab_rares).setTabListener(this));
        }
        if (calculator) {
            actionbar.addTab(actionbar.newTab().setText(R.string.tab_calculator).setTabListener(this));
        }
        if (notes) {
            actionbar.addTab(actionbar.newTab().setText(R.string.tab_notes).setTabListener(this));
        }
        if (galnet) {
            actionbar.addTab(actionbar.newTab().setText(R.string.tab_galnet).setTabListener(this));
        }
        if (reddit) {
            actionbar.addTab(actionbar.newTab().setText(R.string.tab_reddit).setTabListener(this));
        }
        actionbar.setLogo(R.mipmap.ic_launcher);
        actionbar.setDisplayUseLogoEnabled(true);
        actionbar.setDisplayShowHomeEnabled(true);

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                actionbar.setSelectedNavigationItem(arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    public static Context getContextOfApplication(){
        return contextOfApplication;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            sendKey("SERVER_RESTART");
            TCPClient.closeSocket();
            startActivity(new Intent(this, com.thefonz.ed_tool.preferences.AppPreferences.class));
            return true;
        }

        if (id == R.id.action_exit) {
            sendKey("SERVER_RESTART");
            TCPClient.closeSocket();
            finish();
            System.exit(0);
          return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        viewpager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
    }

    public class FragmentPageTabAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> list;

        public FragmentPageTabAdapter(FragmentManager fm, ArrayList<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int index) {
            return list.get(index);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

    @Override
    public void onBackPressed() {
        // Leave blank to do nothing
    }
}