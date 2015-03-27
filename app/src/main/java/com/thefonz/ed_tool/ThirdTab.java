package com.thefonz.ed_tool;

/**
 * Created by thefonz on 18/03/15.
 */

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.thefonz.ed_tool.rss.RssItem;
import com.thefonz.ed_tool.rss.RssReader;
import com.thefonz.ed_tool.utils.Utils;

public class ThirdTab extends Fragment {

    private ListView mList;
    ArrayAdapter<String> adapter;

    protected final static String TAG = "ED-Tool";
    protected final static String RSSFEEDURL = "http://www.elitedangerous.com/news/galnet/rss";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.third_tab, container,false);

        Utils.checkInternet(this.getActivity());

        final Button button_back = (Button) rootView
                .findViewById(R.id.button_back);
        final Button button_forward = (Button) rootView
                .findViewById(R.id.button_forward);
        final Button button_refresh = (Button) rootView
                .findViewById(R.id.button_refresh);

        // Set ListView, ArrayAdapter and RSS feed
        mList = (ListView) rootView.findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(getActivity(), R.layout.basic_list_item);
        new GetRssFeed().execute((RSSFEEDURL));


        // Define back,forward and refresh RSS control buttons
        button_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    String msg = getString(R.string.placeholder);
                    Utils.showToast_Short(getActivity(), msg);
                }
        });
        button_forward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = getString(R.string.placeholder);
                Utils.showToast_Short(getActivity(), msg);
                }
        });
        button_refresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = getString(R.string.refreshing);
                Utils.showToast_Short(getActivity(), msg);
                adapter = new ArrayAdapter<String>(getActivity(), R.layout.basic_list_item);
                new GetRssFeed().execute((RSSFEEDURL));
            }
        });
        return rootView;
    }

    private class GetRssFeed extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            try {
                RssReader rssReader = new RssReader(params[0]);
                for (RssItem item : rssReader.getItems())
                    adapter.add(item.getTitle());
            } catch (Exception e) {
                final String LOGMETHOD = " GetRssFeed ";
                final String LOGBODY = " Error Parsing Data ";
                Utils.LogError(getActivity(), TAG, LOGMETHOD, LOGBODY);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
            mList.setAdapter(adapter);
        }
    }
}