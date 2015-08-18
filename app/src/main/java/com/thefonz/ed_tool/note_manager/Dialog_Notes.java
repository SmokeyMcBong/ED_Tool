/**
 * Created by theFONZ on 16/08/2015.
 */

package com.thefonz.ed_tool.note_manager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.*;
import com.thefonz.ed_tool.R;
import com.thefonz.ed_tool.theme_manager.ThemeManager;
import com.thefonz.ed_tool.utils.Constants;
import com.thefonz.ed_tool.utils.Helper;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Dialog_Notes extends FragmentActivity {

    private static SharedPreferences myNotePrefs;
    private static ArrayAdapter arrayAdapter;
    private static ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        String str = intent.getStringExtra("what_use"); //if it's a string you stored.

        // Set theme according to Preference setting
        ThemeManager.setKeepScreenOn(this);
        ThemeManager.setImmersive(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_notes);

        final TableRow tablerow_create = (TableRow) findViewById(R.id.savename_header);
        final TableRow tablerow_createheader = (TableRow) findViewById(R.id.savename_row);
        final TableRow tablerow_opensaved = (TableRow) findViewById(R.id.opensaved);
        final TableRow tablerow_holdtodelete = (TableRow) findViewById(R.id.holdtodelete);
        final TableRow tablerow_padding = (TableRow) findViewById(R.id.padding);
        listView = (ListView) findViewById(R.id.list);

        final EditText enterfilename = (EditText) this.findViewById(R.id.enterfilename);
        enterfilename.setSingleLine(true);

        final Button createFile = (Button) this.findViewById(R.id.savefilename);

        // Get SharedPreferences - 'myPrefs'
        myNotePrefs = this.getSharedPreferences("myNotePrefs", Context.MODE_WORLD_READABLE);

        // Find out which type of dialog is needed, then define which elements are shown and which are not
        if (Objects.equals(str, "create")) {
            tablerow_opensaved.setVisibility(View.GONE);
            listView.setVisibility(View.GONE);
            tablerow_holdtodelete.setVisibility(View.GONE);
            tablerow_padding.setVisibility(View.GONE);
        }
        if (Objects.equals(str, "open")) {
            tablerow_create.setVisibility(View.GONE);
            tablerow_createheader.setVisibility(View.GONE);
        }

        File f = new File(Environment.getExternalStorageDirectory() , Constants.NoteBackupDir);
        if (!f.exists()) {
            f.mkdir();
        }
        // Get all filenames within a folder and store them all to an array here
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
        if (f.list() == null) {
            Helper.showToast_Short(getApplicationContext(), "No Saved Notes Found");
        }

        // Create Adapter and define which array's they use
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.dialog_notes_row, R.id.TextItem, names);

        // Set Adapter
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                String selected = (String) adapter.getItemAtPosition(position);

                SharedPreferences.Editor editor = myNotePrefs.edit();
                editor.putString("fileName", selected);
                editor.commit();
                NoteManager.ReadNote(selected);
                finish();
            }
        });

        listView.setLongClickable(true);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View v, int position,
                                           long arg3) {
                String selectedDelete = (String) adapter.getItemAtPosition(position);
                confirmDelete(selectedDelete);
                return true;
            }
        });

        createFile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String filename = String.valueOf(enterfilename.getText());
                if (!Objects.equals(filename, "")) {
                    NoteManager.createnewFile(getApplicationContext(), filename);
                    finish();
                }
            }
        });

        Button goBack = (Button) findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void confirmDelete(final String selectedDelete) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Dialog_Notes.this);
        builder.setTitle(" Delete " + selectedDelete + " ?");
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                deleteAndUpdate(selectedDelete);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void deleteAndUpdate(String selectedDelete) {
        final File dir = new File(Environment.getExternalStorageDirectory() + "/"
                + Constants.NoteBackupDir);
        // delete note
        NoteManager.deleteNote(selectedDelete);
        // update listView contents to reflect this file deletion
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(dir.list()));
        arrayAdapter.clear();
        arrayAdapter.addAll(names);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        Helper.showToast_Short(getApplicationContext(), selectedDelete + " Deleted ");
    }
}