/**
 * Created by theFONZ on 16/08/2015.
 */

package com.thefonz.ed_tool.note_manager;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import com.thefonz.ed_tool.Tab_Notes;
import com.thefonz.ed_tool.utils.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class NoteManager extends Application {

    private static final int READ_BLOCK_SIZE = 100;

    // new note creator
    public static void createnewFile(Context context, String filename) {
        // Get SharedPreferences - 'myPrefs'
        SharedPreferences myNotePrefs = context.getSharedPreferences("myNotePrefs", Context.MODE_WORLD_READABLE);
        SharedPreferences.Editor editor = myNotePrefs.edit();
        editor.putString("fileName", filename);
        editor.commit();
        String string = "";
        final File dir = new File(Environment.getExternalStorageDirectory() + "/"
                + Constants.NoteBackupDir);

        File file = new File(dir , filename);

        if(!file.exists()) {
            // add-write text into file
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(string.getBytes());
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Tab_Notes.clear();
        Tab_Notes.updateTitle(filename);
    }

    // write note to file
    public static void SaveNote(String text, String fileName) {
        // add-write text into file
        final File dir = new File(Environment.getExternalStorageDirectory() + "/"
                + Constants.NoteBackupDir);
        File file = new File(dir , fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(text.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // when editText text is changed check if editText text matches saved file text
    public static void checkDiff(Context context, File file, String str_et) {
        try {
            FileInputStream fileIn = new FileInputStream (new File(String.valueOf(file)));
            InputStreamReader InputRead = new InputStreamReader(fileIn);

            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String str = "";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                str = String.copyValueOf(inputBuffer,0,charRead);
            }
            InputRead.close();

            if (!Objects.equals(str, str_et)) {
                Tab_Notes.showSaveNow(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //open saved note
    public static void ReadNote(String fileName) {
        //reading text from file
        final File dir = new File(Environment.getExternalStorageDirectory() + "/"
                + Constants.NoteBackupDir);
        File file = new File(dir , fileName);
        try {
            FileInputStream fileIn = new FileInputStream (new File(String.valueOf(file)));
            InputStreamReader InputRead = new InputStreamReader(fileIn);

            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;

            while ((charRead = InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring = String.copyValueOf(inputBuffer,0,charRead);
                s += readstring;
            }
            InputRead.close();
            Tab_Notes.setNote(s, fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**/
    /*rename saved note ..*/
    /**/



    // delete saved note
    public static void deleteNote(String filename){
        final File dir = new File(Environment.getExternalStorageDirectory() + "/"
                + Constants.NoteBackupDir);
        File file = new File(dir , filename);
        if (file.exists()) {
            file.delete();
        }
    }

    // Check for note file
    public static void CheckForFile(String fileName) {
        if (!Objects.equals(fileName, "")) {
            String string = "";
            final File dir = new File(Environment.getExternalStorageDirectory() + "/"
                    + Constants.NoteBackupDir);

            File file = new File(dir , fileName);

            if(!file.exists()) {
                // add-write text into file
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(string.getBytes());
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Show dialog, hide elements based on 'use' input
    public static void showDialog(Context context, String use) {
        Intent myIntent = new Intent(context, Dialog_Notes.class);
        myIntent.putExtra("what_use", use);
        context.startActivity(myIntent);
    }
}