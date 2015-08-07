package com.github.hiro.demo.referrerdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

public class InstallReferrerReceiver extends BroadcastReceiver {

    private static final String LOG_TAG = "ReferrerReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();


        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            Bundle args = intent.getExtras();

            if (args == null) {
                return;
            }

            for (String key : args.keySet()) {
                Log.d(LOG_TAG, key + " = " + args.get(key));
            }

            String referrer = args.getString("referrer");
            if (!TextUtils.isEmpty(referrer)) {
                saveReferrer(context, referrer);
            }
        }
    }

    public static void saveReferrer(Context context, String referrer) {
        SharedPreferences prefs = context.getSharedPreferences("referrer", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("referrer", referrer);
        editor.apply();
    }

    public static String getSavedReferrer(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("referrer", Context.MODE_PRIVATE);
        return prefs.getString("referrer", null);
    }

}
