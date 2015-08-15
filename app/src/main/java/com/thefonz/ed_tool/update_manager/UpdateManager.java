/**
 * Created by theFONZ on 01/08/2015.
 */

package com.thefonz.ed_tool.update_manager;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import com.thefonz.ed_tool.R;
import com.thefonz.ed_tool.utils.Constants;
import com.thefonz.ed_tool.utils.Helper;
import org.apache.http.util.ByteArrayBuffer;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class UpdateManager extends Application {

    /**
     * This method checks if the device has an active internet
     * connection or not.
     *
     * @param context
     *          - context of the class from where it is called
     * @return
     *      Returns true if there is internet connectivity
     */
    public static Boolean checkInternet(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()){
            return true;
        }
        else if (netInfo != null && (netInfo.getState() == NetworkInfo.State.DISCONNECTED || netInfo.getState() == NetworkInfo.State.DISCONNECTING || netInfo.getState() == NetworkInfo.State.SUSPENDED || netInfo.getState() == NetworkInfo.State.UNKNOWN)){
            return false;
        }
        else{
            return false;
        }
    }

    public static void checkUpdate (final Context context) {
        Boolean checkInternet = checkInternet(context);
        if (!checkInternet) {
            String message = context.getResources().getString(R.string.check_failed);
            Helper.showToast_Short(context, message);
            Helper.LogError(context, Constants.TAG, " checkUpdate", Constants.noNet);
        } else {
            // do update check here
            new Thread(new Runnable() {
                public void run() {
                    try {
                        int remoteV;
                        int localV = Integer.parseInt(String.valueOf(Constants.Vc_Version));
                        URL url = new URL(Constants.VersionCheckURL);
                        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                        String str;
                        while ((str = in.readLine()) != null) {
                            remoteV = Integer.parseInt(String.valueOf(str));
                            if (remoteV > localV) {
                                // Take raw version numbers and add "." separator between each number for user display
                                String FormattedIInstalledVersion = Constants.Vc_Version.replaceAll(".(?=.)", "$0.");
                                String FormattedOnlineVersion = str.replaceAll(".(?=.)", "$0.");
                                showDialogUpdater(context, "      *  New Update Available ! .. \n   ", "  Installed Version: v" + FormattedIInstalledVersion +
                                        "\n  >>> " + "New Update Version: v" + FormattedOnlineVersion, " ", "( Update checks can be turned off in Settings )");
                            }
                        }
                        in.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
        }
    }

    private static void showDialogUpdater(Context context, String line1, String line2, String line3, String line4) {
    String str = "\n\n" +
            line1 + "\n\n" +
            line2 + "\n" +
            "\n" +
            line3 + "\n\n" +
            line4 + "\n\n";
        Intent myIntent = new Intent(context, Dialog_Updater.class);
        myIntent.putExtra("key", str); //Optional parameters
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.getApplicationContext().startActivity(myIntent);
    }

    public static void downloadUpdate(final Context context) {
        // do update download here
        new Thread(new Runnable() {
            public void run() {
                try {
                    File dir = new File(Environment.getExternalStorageDirectory() + "/"
                            + Constants.DownloadDir);
                    URL url = new URL(Constants.NewVersionURL);
                    File file = new File(dir, Constants.FileName);
                    URLConnection ucon = url.openConnection();
                    InputStream is = ucon.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(is);
                    ByteArrayBuffer baf = new ByteArrayBuffer(20000);
                    int current = 0;
                    while ((current = bis.read()) != -1) {
                        baf.append((byte) current);
                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(baf.toByteArray());
                    fos.flush();
                    fos.close();
                    if (file.exists()) {
                        // close the update dialog and initialize installUpdate() method
                        Dialog_Updater.closeMe();
                        installUpdate(context);
                    }
                    else {
                        Helper.LogError(context, Constants.TAG, " downloadUpdate", " Error: Update Not Downloaded ");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void installUpdate(final Context context){
        // Install new update
        File dir = new File(Environment.getExternalStorageDirectory() + "/"
                + Constants.DownloadDir);
        File file = new File(dir, Constants.FileName);
        Intent install_intent = new Intent(Intent.ACTION_VIEW);
        install_intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        install_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.getApplicationContext().startActivity(install_intent);
    }

    public static void fileStructureCheck() {
        // Check folder structure and manipulate if needed
        boolean bool;
        File dir = new File(Environment.getExternalStorageDirectory() + "/"
                + Constants.DownloadDir);
        if (dir.exists()) {
            Helper.DeleteRecursive(dir);
        }
        bool = dir.mkdir();
        System.out.println(" created folder > result : " + bool);
    }
}