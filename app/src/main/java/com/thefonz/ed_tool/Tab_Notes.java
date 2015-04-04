package com.thefonz.ed_tool;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.thefonz.ed_tool.utils.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by thefonz on 02/04/15.
 */
public class Tab_Notes extends Fragment {

    EditText textmsg;
    static final int READ_BLOCK_SIZE = 100;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        final View myFragmentView = inflater.inflate(R.layout.tab_notes, container, false);

        textmsg = (EditText) myFragmentView.findViewById(R.id.editText1);

//        String msg = "Reading Notes..";
//        Utils.showToast_Short(this.getActivity(), msg);
        ReadNote(myFragmentView);

        final Button button_save = (Button) myFragmentView.findViewById(R.id.button1);

        button_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SaveNote(myFragmentView);
            }
        });

        return myFragmentView;
    }

    // write text to file
    public void SaveNote(View v) {
        // add-write text into file
        try {
            FileOutputStream fileout=getActivity().openFileOutput("mytextfile.txt", Context.MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            String text = textmsg.getText().toString();
            outputWriter.write(text);
            outputWriter.write('\n');
            outputWriter.close();

            //display file saved message
            String msg = "Note saved !";
            Utils.showToast_Short(this.getActivity(), msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read text from file
    public void ReadNote(View v) {
        //reading text from file
        try {
            FileInputStream fileIn=getActivity().openFileInput("mytextfile.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            InputRead.close();
            textmsg.setText(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}