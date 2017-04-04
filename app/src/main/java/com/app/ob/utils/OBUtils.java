package com.app.ob.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by niranjan on 04/04/17.
 */

public class OBUtils {

    public static final String EXTRA_EXAM_OBJ = "extra_exam_obj" ;

    public static boolean checkIfInternetAvialable(Context ctx) {
        boolean isConnected = false;
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        isConnected = ni != null && ni.isConnected();
        return isConnected;
    }

    public static boolean isConnected(final Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        boolean isConnected = checkIfInternetAvialable(ctx);
        if (!isConnected) {
            Toast.makeText(ctx, "No internet connnection, please try again later.", Toast.LENGTH_LONG).show();
        }
        return isConnected;
    }

}
