package com.researchers.calculator_v13;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;

//import android.telephony.SmsManager;

public class SmsSentReceiver extends BroadcastReceiver {
    String TAG = "SPAM";
    Clues clues = new Clues();
    @Override
    public void onReceive(Context context, Intent arg) {
        switch(getResultCode()) {
            case Activity.RESULT_OK:
                Log.i(TAG, "SPAM sent");
                clues.SendLog(TAG, "SPAM sent", "malicious", false);
                //Toast.makeText(context, "SPAM sent", Toast.LENGTH_SHORT).show();
                break;
            case SmsManager.RESULT_ERROR_NO_SERVICE:
                Log.i(TAG, "No service");
                clues.SendLog(TAG, "Error: No service", "malicious", false);
                //Toast.makeText(context, "No service", Toast.LENGTH_SHORT).show();
                break;
            case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                Log.i(TAG, "Generic failure");
                clues.SendLog(TAG, "Error: Generic failure", "malicious", false);
                //Toast.makeText(context, "Generic failure", Toast.LENGTH_SHORT).show();
                break;
            case SmsManager.RESULT_ERROR_NULL_PDU:
                Log.i(TAG, "Null PDU");
                clues.SendLog(TAG, "Error: Null pdu", "malicious", false);
                //Toast.makeText(context, "Null PDU", Toast.LENGTH_SHORT).show();
                break;
            case SmsManager.RESULT_ERROR_RADIO_OFF:
                Log.i(TAG, "Radio off");
                clues.SendLog(TAG, "Error: Radio off", "malicious", false);
                //Toast.makeText(context, "Radio off", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
