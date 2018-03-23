package app.apollobuilders.com.apollobuilders;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HisDisplay extends Activity {


    ProgressDialog pd;
   static String type,subject,date,email,location,details,status,fname,lname,contact,p1,p2,p3,p4,p5;

    String get;
    SharedPreferences s1;
    StringBuilder sb=new StringBuilder();

    TextView t1,t2,t3,t4,t5,t6,t13,t14,t7,t8,t9;

    ImageView i1,i2,i3,i4,i5;

    InputStream is;
    Bitmap bMap;
    BitmapDrawable bd;
    static BitmapDrawable bd1,bd2,bd3,bd4,bd5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_his_display);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        s1=getSharedPreferences("user", MODE_PRIVATE);
        email=s1.getString("Email", "");

        t1=(TextView)findViewById(R.id.TextEmail);
        t2=(TextView)findViewById(R.id.TextDate);
        t3=(TextView)findViewById(R.id.TextSubject);
        t4=(TextView)findViewById(R.id.TextDetails);
        t5=(TextView)findViewById(R.id.TextLocation);
        t6=(TextView)findViewById(R.id.TextStatus);
        t13=(TextView)findViewById(R.id.textView13);
        t14=(TextView)findViewById(R.id.textView14);
        t7=(TextView)findViewById(R.id.FName);
        t8=(TextView)findViewById(R.id.LName);
        t9=(TextView)findViewById(R.id.Phone);

        i1=(ImageView)findViewById(R.id.imageView13);
        i2=(ImageView)findViewById(R.id.imageView14);
        i3=(ImageView)findViewById(R.id.imageView15);
        i4=(ImageView)findViewById(R.id.imageView16);
        i5=(ImageView)findViewById(R.id.imageView17);



        Bundle b = getIntent().getExtras();
        date = b.get("date").toString();
        subject = b.get("subject").toString();
        type = b.get("Type").toString();

        Log.d("TypeDatavarun",type);

        new abc().execute();

    }


    class abc extends AsyncTask {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(HisDisplay.this);
            pd.setMessage("Loading...");
            pd.setCancelable(false);
            pd.show();


        }

        @Override
        protected Object doInBackground(Object[] params) {

           if(type.equals("Issue"))
           {
               try {
                   URL url = new URL("http://www.apollobuilders.co.in/apollo/Historyf1.php");

                   HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                   uc.setRequestMethod("GET");

                   BufferedReader bf=new BufferedReader(new InputStreamReader(uc.getInputStream()));
                   while ((get=bf.readLine())!=null)
                   {

                       sb.append(get);


                   }

                   get="";
                   get=sb.toString();
                   Log.d("BufferReaderrrr", get);

//                String string=get.substring(get.indexOf('[')+1,get.indexOf(']'));
//
//                Log.d("String",string);

                   JSONArray arr=new JSONArray(get);
                   JSONObject object=null;

                   for(int i=0;i<arr.length();i++)
                   {
                       object=arr.getJSONObject(i);
                       String check1=object.optString("SubDate");
                       String check2=object.optString("Subject");
                       String check3=object.optString("Email");
                       if((check1.equals(date))&&(check2.equals(subject))&&(email.equals(check3)))
                       {

                           fname=object.optString("FirstName");
                           lname=object.optString("LastName");
                           contact=object.optString("Contact");
                           location=object.optString("Location");
                           status=object.optString("Status");
                           details=object.optString("Details");
                           p1=object.optString("Picone");
                           p2=object.optString("Pictwo");
                           p3=object.optString("Picthree");
                           p4=object.optString("Picfour");
                           p5=object.optString("Picfive");

                       }


                   }
               }
               catch (Exception e) {
                   Log.d("Exception",e.toString());
               }



           }

           if(type.equals("Complaint"))
           {

               try {
                   URL url = new URL("http://www.apollobuilders.co.in/apollo/Historyf2.php");

                   HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                   uc.setRequestMethod("GET");

                   BufferedReader bf=new BufferedReader(new InputStreamReader(uc.getInputStream()));
                   while ((get=bf.readLine())!=null)
                   {

                       sb.append(get);


                   }

                   get="";
                   get=sb.toString();
                   Log.d("BufferReaderrrr", get);

//                String string=get.substring(get.indexOf('[')+1,get.indexOf(']'));
//
//                Log.d("String",string);

                   JSONArray arr=new JSONArray(get);
                   JSONObject object=null;

                   for(int i=0;i<arr.length();i++)
                   {
                       object=arr.getJSONObject(i);
                       String check1=object.optString("SubDate");
                       String check2=object.optString("Subject");
                       String check3=object.optString("Email");
                       Log.d("Date",check1);
                       Log.d("Subject",check1);
                       Log.d("Email",check1);
                       if((check1.equals(date))&&(check2.equals(subject))&&(email.equals(check3)))
                       {

                           fname=object.optString("FirstName");
                           lname=object.optString("LastName");
                           contact=object.optString("Contact");
                           location=object.optString("Location");
                           status=object.optString("Status");
                           details=object.optString("Details");
                           p1=object.optString("Picone");
                           p2=object.optString("Pictwo");
                           p3=object.optString("Picthree");
                           p4=object.optString("Picfour");
                           p5=object.optString("Picfive");

                       }


                   }
               }
               catch (Exception e) {
                   Log.d("Exception",e.toString());
               }


           }

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            pd.dismiss();
            new xyz().execute();

            t7.setText(fname);
            t8.setText(lname);
            t9.setText(contact);
            t1.setText(email);
            t2.setText(date);
            t3.setText(subject);
            t4.setText(details);
            t5.setText(location);
            t6.setText(status);
            t13.setText(type+" Details");
            t14.setText(type+" Location");
        }
    }

    public class xyz extends AsyncTask
    {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(HisDisplay.this);
            pd.setMessage("downloading");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected Object doInBackground(Object[] params) {

            Log.d("pic1",p1);
            Log.d("pic2",p2);
            Log.d("pic3",p3);
            Log.d("pic4",p4);
            Log.d("pic5",p5);

            if(p1!=null)
            {bd1=service(p1);}

            if(p2!=null)
            {bd2=service(p2);}

            if(p3!=null)
            {bd3=service(p3);}

            if(p4!=null)
            {bd4=service(p4);}

            if(p5!=null)
            {bd5=service(p5);}

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);


            if(p1!=null){
            i1.setBackgroundDrawable(bd1);}

            if(p2!=null){
                i2.setBackgroundDrawable(bd2);}

            if(p3!=null){
                i3.setBackgroundDrawable(bd3);}

            if(p4!=null){
                i4.setBackgroundDrawable(bd4);}

            if(p5!=null){
                i5.setBackgroundDrawable(bd5);}

            pd.dismiss();
        }


    }

    public BitmapDrawable service(String url)
    {
        try {
            URL ul = new URL(url);

            HttpURLConnection uu=(HttpURLConnection)ul.openConnection();

            uu.setRequestMethod("GET");

            is=uu.getInputStream();
           bMap = BitmapFactory.decodeStream(is);
            bd=new BitmapDrawable(bMap);

            if (is!= null) {
                is.close();
            }


        }
        catch (Exception e){

            Log.d("data_string",e.toString());
            return null;
        }
        return bd;
    }

    public void cancel(View view)
    {

        finish();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();


    }
}