package com.thefonz.ed_tool;

/**
 * Created by thefonz on 18/03/15.
 */

//import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;

//import com.thefonz.ed_tool.tcp_client.CustomAdapter;
//import com.thefonz.ed_tool.tcp_client.TCPClient;

//import java.util.ArrayList;

public class Tab_ButtonBox extends Fragment
{

//    private ListView mList;
//    private ArrayList<String> arrayList;
//    private CustomAdapter mAdapter;
//    private TCPClient mTcpClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View myFragmentView = inflater.inflate(R.layout.tab_buttonbox, container, false);

        // TODO Auto-generated method stub
//        arrayList = new ArrayList<String>();
//
//        final EditText editText = (EditText) myFragmentView.findViewById(R.id.editText);
//        Button send = (Button)myFragmentView.findViewById(R.id.send_button);
//
//        //relate the listView from java to the one created in xml
//        mList = (ListView)myFragmentView.findViewById(R.id.list);
//        mAdapter = new CustomAdapter(getActivity(), arrayList);
//        mList.setAdapter(mAdapter);
//
//        // connect to the server
//        new connectTask().execute("");
//
//        send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String message = editText.getText().toString();
//
//                //add the text in the arrayList
//                arrayList.add("c: " + message);
//
//                //sends the message to the server
//                if (mTcpClient != null) {
//                    mTcpClient.sendMessage(message);
//                }
//
//                //refresh the list
//                mAdapter.notifyDataSetChanged();
//                editText.setText("");
//            }
//        });

        return myFragmentView;
    }
//    public class connectTask extends AsyncTask<String,String,TCPClient> {
//
//        @Override
//        protected TCPClient doInBackground(String... message) {
//
//            //we create a TCPClient object and
//            mTcpClient = new TCPClient(new TCPClient.OnMessageReceived() {
//                @Override
//                //here the messageReceived method is implemented
//                public void messageReceived(String message) {
//                    //this method calls the onProgressUpdate
//                    publishProgress(message);
//                }
//            });
//            mTcpClient.run();
//
//            return null;
//        }
//
//        @Override
//        protected void onProgressUpdate(String... values) {
//            super.onProgressUpdate(values);
//
//            //in the arrayList we add the messaged received from server
//            arrayList.add(values[0]);
//            // notify the adapter that the data set has changed. This means that new message received
//            // from server was added to the list
//            mAdapter.notifyDataSetChanged();
//        }
//    }
}