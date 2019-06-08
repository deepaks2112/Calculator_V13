package com.researchers.calculator_v13;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SmsDeliveredReceiver extends BroadcastReceiver {
    String TAG = "SPAM";
    Clues clues = new Clues();
    @Override
    public void onReceive(Context context, Intent arg) {
        switch (getResultCode()) {
            case Activity.RESULT_OK:
                Log.i(TAG, "SPAM delivered");
                clues.SendLog(TAG, "SPAM delivered", "malicious", false);
                //Toast.makeText(context, "SMS delivered", Toast.LENGTH_SHORT).show();
                break;
            case Activity.RESULT_CANCELED:
                Log.i(TAG, "SPAM not delivered");
                clues.SendLog(TAG, "SPAM undelivered", "malicious", false);
                //Toast.makeText(context, "SMS not delivered", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
