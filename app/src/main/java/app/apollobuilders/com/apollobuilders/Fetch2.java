package app.apollobuilders.com.apollobuilders;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import app.apollobuilders.com.apollobuilders.data.javabeans3;

public class Fetch2 extends Activity {


    SharedPreferences s1;
    StringBuilder sb1=new StringBuilder();
    StringBuilder sb2=new StringBuilder();
    StringBuilder sb3=new StringBuilder();
    StringBuilder sb4=new StringBuilder();


    static ArrayList<String> Date1=new ArrayList<String>();
    static ArrayList<String> Date2=new ArrayList<String>();
    static ArrayList<String> Date3=new ArrayList<String>();
    static ArrayList<String> Date4=new ArrayList<String>();

    static ArrayList<String> Subject1=new ArrayList<String>();
    static ArrayList<String> Subject2=new ArrayList<String>();
    static ArrayList<String> Subject3=new ArrayList<String>();
    static ArrayList<String> Subject4=new ArrayList<String>();


    ProgressDialog pd;
    String email;
    String get1,get2,get3,get4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_fetch2);

        s1=getSharedPreferences("user", MODE_PRIVATE);
        email=s1.getString("Email", "");


        new ff().execute();
    }


    public class ff extends AsyncTask {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pd=new ProgressDialog(Fetch2.this);
            pd.setMessage("Loading");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected Object doInBackground(Object[] params) {

            try {
                URL url = new URL("http://www.apollobuilders.co.in/apollo/Historyf1.php");

                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                uc.setRequestMethod("GET");

                BufferedReader bf=new BufferedReader(new InputStreamReader(uc.getInputStream()));
                while ((get1=bf.readLine())!=null)
                {

                    sb1.append(get1);


                }

                get1="";
                get1=sb1.toString();
                Log.d("BufferReader", get1);

//                String string=get.substring(get.indexOf('[')+1,get.indexOf(']'));
//
//                Log.d("String",string);

                JSONArray arr=new JSONArray(get1);
                JSONObject object=null;

                for(int i=arr.length()-1;i>=0;i--)
                {
                    object=arr.getJSONObject(i);
                    String check=object.optString("Email");
                    String check2=object.optString("Status");
                    if((check.equals(email))&&(!(check2.equals("Pending"))))
                    {
                        Date1.add(object.optString("SubDate"));
                        Subject1.add(object.optString("Subject"));


                    }


                }
            }
            catch (Exception e) {
                Log.d("Exception",e.toString());
            }


            try {
                URL url = new URL("http://www.apollobuilders.co.in/apollo/Historyf2.php");

                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                uc.setRequestMethod("GET");

                BufferedReader bf=new BufferedReader(new InputStreamReader(uc.getInputStream()));
                while ((get2=bf.readLine())!=null)
                {

                    sb2.append(get2);


                }

                get2="";
                get2=sb2.toString();
                Log.d("BufferReader", get2);

//                String string=get.substring(get.indexOf('[')+1,get.indexOf(']'));
//
//                Log.d("String",string);

                JSONArray arr=new JSONArray(get2);
                JSONObject object=null;

                for(int i=arr.length()-1;i>=0;i--)
                {
                    object=arr.getJSONObject(i);
                    String check=object.optString("Email");
                    String check2=object.optString("Status");
                    if((check.equals(email))&&(!(check2.equals("Pending"))))
                    {
                        Date2.add(object.optString("SubDate"));
                        Subject2.add(object.optString("Subject"));


                    }


                }
            }
            catch (Exception e) {
                Log.d("Exception",e.toString());
            }


            try {
                URL url = new URL("http://www.apollobuilders.co.in/apollo/Historyf3.php");

                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                uc.setRequestMethod("GET");

                BufferedReader bf=new BufferedReader(new InputStreamReader(uc.getInputStream()));
                while ((get3=bf.readLine())!=null)
                {

                    sb3.append(get3);


                }

                get3="";
                get3=sb3.toString();
                Log.d("BufferReader", get3);

//                String string=get.substring(get.indexOf('[')+1,get.indexOf(']'));
//
//                Log.d("String",string);

                JSONArray arr=new JSONArray(get3);
                JSONObject object=null;

                for(int i=arr.length()-1;i>=0;i--)
                {
                    object=arr.getJSONObject(i);
                    String check=object.optString("Email");
                    String check2=object.optString("Status");
                    if((check.equals(email))&&(!(check2.equals("Pending"))))
                    {
                        Date3.add(object.optString("SubDate"));
                        Subject3.add(object.optString("Subject"));


                    }


                }
            }
            catch (Exception e) {
                Log.d("Exception",e.toString());
            }


            try {
                URL url = new URL("http://www.apollobuilders.co.in/apollo/Historyf4.php");

                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                uc.setRequestMethod("GET");

                BufferedReader bf=new BufferedReader(new InputStreamReader(uc.getInputStream()));
                while ((get4=bf.readLine())!=null)
                {

                    sb4.append(get4);


                }

                get4="";
                get4=sb4.toString();
                Log.d("BufferReader", get4);

//                String string=get.substring(get.indexOf('[')+1,get.indexOf(']'));
//
//                Log.d("String",string);

                JSONArray arr=new JSONArray(get4);
                JSONObject object=null;

                for(int i=arr.length()-1;i>=0;i--)
                {
                    object=arr.getJSONObject(i);
                    String check=object.optString("Email");
                    String check2=object.optString("Status");
                    Log.d("you are here",check2);
                    if((check.equals(email))&&(!(check2.equals("Pending"))))
                    {
                        Date4.add(object.optString("SubDate"));
                        Subject4.add(object.optString("Subject"));


                    }


                }
            }
            catch (Exception e) {
                Log.d("Exception",e.toString());
            }


            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            javabeans3 jb=new  javabeans3();

            jb.setDate1(Date1);
            jb.setDate2(Date2);
            jb.setDate3(Date3);
            jb.setDate4(Date4);

            jb.setSubject1(Subject1);
            jb.setSubject2(Subject2);
            jb.setSubject3(Subject3);
            jb.setSubject4(Subject4);

            pd.dismiss();


            Intent i=new Intent(Fetch2.this,Notification.class);
            startActivity(i);
            finish();
        }
    }

}
