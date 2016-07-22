package com.example.rssreader;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;

public class eldeeb {
    private final Context context;
    eldeeb(Context context){this.context=context;}

    // public void toast(String text, boolean long){ if(long)Toast.makeText(context, text, Toast.LENGTH_SHORT).show(); else Toast.makeText(context, text, Toast.LENGTH_SHORT).show();}
    public void toast(String text){ Toast.makeText(context, text, Toast.LENGTH_SHORT).show();}
   // public String get(String url){try {return readStream(new DefaultHttpClient().execute(new HttpGet(url)).getEntity().getContent());}catch (IOException e) {return "";} //e.printStackTrace();}
    public boolean write(String file,String data,boolean append){ FileOutputStream outputStream;try{if(append)outputStream=context.openFileOutput(file,context.MODE_PRIVATE|context.MODE_APPEND); else outputStream=context.openFileOutput(file,context.MODE_PRIVATE);outputStream.write(data.getBytes());outputStream.close();return true; } catch (Exception e) {return false;}}  
    public boolean write (String file , String data){return write(file,data,false);}







    public String read(String file){
        try {return readStream(context.openFileInput(file));}
        catch (FileNotFoundException e) { return ""; } //"ERROR: File not found"
        catch (IOException e) {return ""; }//ERROR: Can not read file

    }

    public String readStream(InputStream stream){ //convert inputstream to string
        if ( stream != null ){
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(stream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ( (receiveString = bufferedReader.readLine()) != null ){stringBuilder.append(receiveString); }
                stream.close();
                return stringBuilder.toString();
            } catch (IOException e) { return "";}
        }else return "";
    }

    public boolean exists(String file){
        File f= new File(context.getFilesDir(),file);
        return f.exists();
    }
    public void del(String file){
        new File(context.getFilesDir(),file).delete();
    }
    public void retry(String url,int mins){
        //check connection ... if(on)Run get() .. else Run retry() aften $n mins;
    }
    public class notify{
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        private  int id;
         public notify(int id,String title , String text ,int icon , int pic,int number){
            //int icon = R.drawable.icon , or String icon="icon" -> getResources().getIdentefier(icon,"drawable",context.getpackageName())
            this.id = id;
            builder.setSmallIcon(icon)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setNumber(number)
                    .setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setTicker(title);
            if(pic!=0)builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(),pic));

        }

        public notify big (String text , String summary){
            builder.setStyle(new NotificationCompat.BigTextStyle()
                    //.setBigContentTitle(title)
                    .bigText(text)
                    .setSummaryText(summary));
            return this;
        }

        public notify onclick(Intent i){
            builder.setContentIntent(PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT));
            return this;
        }

        public  notify action(int icon ,String title  , Intent i){
            builder.addAction(icon, title, PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT));
            return this;
        }

        public notify change(String sound,long vibration,int led){
            return this;
        }
        public void show(){
            final NotificationManager manager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
            manager.notify(id, builder.build());
        }

    }

    public Intent browser(String url){return new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));}
    public Intent share(String text){return new Intent().setAction(Intent.ACTION_SEND).putExtra(Intent.EXTRA_TEXT, text).setType("text/plain");}
    public Intent sms(String to,String text){return new Intent(Intent.ACTION_VIEW).setType("vnd.android-dir/mms-sms").putExtra("address", to).putExtra("sms_body",text); }
    public Intent call(String number){return new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number)); }
    public Intent email(String to,String subject,String body){return new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",to, null)).setType("message/rfc822").putExtra(Intent.EXTRA_SUBJECT, subject).putExtra(Intent.EXTRA_TEXT, body); }


}
