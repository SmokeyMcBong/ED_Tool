/**
 * Created by theFONZ on 02/04/15.
 */

package com.thefonz.ed_tool;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.thefonz.ed_tool.note_manager.NoteManager;
import com.thefonz.ed_tool.utils.Constants;
import com.thefonz.ed_tool.utils.Helper;

import java.io.File;
import java.util.Objects;

public class Tab_Notes extends Fragment {

    private static SharedPreferences myNotePrefs;
    private static EditText textmsg;
    private static TextView currentFile;
    private static Button button_save;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        final View myFragmentView = inflater.inflate(R.layout.tab_notes, container, false);

        textmsg = (EditText) myFragmentView.findViewById(R.id.editText1);
        currentFile = (TextView) myFragmentView.findViewById(R.id.currentfile);
        button_save = (Button) myFragmentView.findViewById(R.id.button1);
        final Button button_newnote = (Button) myFragmentView.findViewById(R.id.newNote);
        final Button button_manager = (Button) myFragmentView.findViewById(R.id.noteOpen);

        // Get SharedPreferences - 'myPrefs'
        myNotePrefs = this.getActivity().getSharedPreferences("myNotePrefs", Context.MODE_WORLD_READABLE);

        String fileName = myNotePrefs.getString("fileName", "");
        final File dir = new File(Environment.getExternalStorageDirectory() + "/"
                + Constants.NoteBackupDir);

        // get filename from preferences
        NoteManager.CheckForFile(fileName);
        NoteManager.ReadNote(fileName);

        button_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String fileName = myNotePrefs.getString("fileName", "");
                String text = textmsg.getText().toString();
                NoteManager.SaveNote(text, fileName);

                //display file saved message
                String msg = getString(R.string.note_saved);
                final Button button_save = (Button) getActivity().findViewById(R.id.button1);
                button_save.setBackgroundResource(android.R.drawable.btn_default);
                button_save.setEnabled(false);
                button_save.setText(R.string.saved);
                Helper.showToast_Short(getActivity(), msg);
            }
        });

        button_newnote.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NoteManager.showDialog(getActivity(), "create");
            }
        });

        button_manager.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NoteManager.showDialog(getActivity(), "open");
            }
        });

        textmsg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                final String fileName = myNotePrefs.getString("fileName", "");
                if (Objects.equals(fileName, "")) {
                    NoteManager.showDialog(getActivity(), "create");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String fileName = myNotePrefs.getString("fileName", "");
                File file = new File(dir, fileName);
                String str_et = textmsg.getText().toString();
                NoteManager.checkDiff(getActivity(), file, str_et);
            }
        });

        return myFragmentView;
    }

    // Attempt to set screen orientation to full sensor
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            Activity a = getActivity();
            if(a != null) a.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        }
    }

    public static void clear() {
        textmsg.setText("");
    }

    public static void updateTitle(String newfilename) {
        currentFile.setText(newfilename);
    }

    public static void setNote(String noteBody, String fileNameHeader) {
        textmsg.setText(noteBody);
        currentFile.setText(fileNameHeader);
    }

    public static void showSaveNow(Context context) {
        button_save.setEnabled(true);
        button_save.setBackgroundColor(context.getResources().getColor(R.color.my_teal));
        button_save.setText(context.getString(R.string.save_now));
    }
}