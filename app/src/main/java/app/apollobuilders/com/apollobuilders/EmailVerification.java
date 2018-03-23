package app.apollobuilders.com.apollobuilders;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import app.apollobuilders.com.apollobuilders.data.database;

public class EmailVerification extends Activity {
    char c,a[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','Z','0','1','2','3','4','5','6','7','8','9'};
    String str="";
    int i,j=0;
    EditText code;
    String text,email,link;
    ProgressDialog pd,pd2;
    Bundle b;
    database d;
    String fn,ln,ps,ph,em,ad,st,ty;
    SharedPreferences s1,s2;
    SharedPreferences.Editor e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_email_verification);

        code=(EditText)findViewById(R.id.code);
        for(i=0;i<4;i++)
        {
            c=a[(int)Math.floor(Math.random()*a.length)];
            str+=c;

        }

        b=getIntent().getExtras();
        email=b.get("Email").toString();


        Log.d("Captcha", str);



        new acyn().execute();

    }

    public void confirm(View view)
    {



        if(code.getText().toString().equals(str))
        {

            Toast.makeText(EmailVerification.this, "You Have Been Sucessfully Registered.", Toast.LENGTH_SHORT).show();
//            Intent i=new Intent(getApplicationContext(),Main2Activity.class);
//            j=1;
//            i.putExtra("verify",j);
//            startActivity(i);

//            javabeans jb=new javabeans();
//            jb.setFirstName(b.getString("fname").toString());
//            jb.setLastName(b.getString("lname").toString());
//            jb.setEmail(b.getString("Email").toString());
//            jb.setPhone(b.getString("phone").toString());
//            jb.setPassword(b.getString("pass").toString());
//            jb.setAddress(b.getString("address").toString());

            fn=b.getString("fname").toString();
            ln=b.getString("lname").toString();
            em=b.getString("Email").toString();
            ps=b.getString("pass").toString();
            ph=b.getString("phone").toString();
            ad=b.getString("address").toString();
            ty=b.getString("type").toString();
            st="LoggedIn";



            s1= getSharedPreferences("user", MODE_PRIVATE);
            e1=s1.edit();
            e1.putString("Stat", "LoggedIn");
            e1.putString("FirstName",fn);
            e1.putString("LastName",ln);
            e1.putString("Email",em);
            e1.putString("Phone",ph);
            e1.putString("Password",ps);
            e1.putString("Type",ty);
            e1.putString("Address",ad);
            e1.commit();

            Intent i=new Intent(EmailVerification.this,Main2Activity.class);
            startActivity(i);
            finish();

            new abc().execute();



        }
        else{

            Toast.makeText(EmailVerification.this, "Incorrect Code Please Try Again.", Toast.LENGTH_SHORT).show();
        }





    }

    public class acyn extends AsyncTask{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
          pd=new ProgressDialog(EmailVerification.this);

            pd.setMessage("hello");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected Object doInBackground(Object[] params) {

            try {
                URL url=new URL("http://www.apollobuilders.co.in/apollo/Mailing.php?to="+email+"&message="+str);
                HttpURLConnection uc=(HttpURLConnection)url.openConnection();
                uc.setRequestMethod("GET");

                InputStream s=uc.getInputStream();
                int ss;
                while((ss=s.read())!=-1)
                {
                    Log.d("Print",Character.toString((char)ss));


                }

            } catch (Exception e) {
                Log.d("data",e.toString());
            }



            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        pd.dismiss();

        }
    }

    public class abc extends AsyncTask{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd2=new ProgressDialog(EmailVerification.this);
            pd2.setMessage("Wait...");
            pd2.setCancelable(false);
            pd2.show();
            Log.d("onPre","Hello");

        }

        @Override
        protected Object doInBackground(Object[] params) {


            try {

                Log.d("Type",ty);
                String link="?Fname="+fn+"&Lname="+ln+"&Email="+em+"&Password="+ps+"&Phone="+ph+"&Type="+ty+"&Address="+ad+"&Status="+st;
                    link=link.replace(" ","%20");
                URL url=new URL("http://www.apollobuilders.co.in/apollo/Register.php"+link);
                HttpURLConnection uc=(HttpURLConnection)url.openConnection();
                uc.setRequestMethod("GET");

                InputStream s=uc.getInputStream();
                int ss;
                while((ss=s.read())!=-1)
                {
                    Log.d("Print",Character.toString((char)ss));


                }


            } catch (Exception e) {
               // e.printStackTrace();
                Log.d("Error", e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            pd.dismiss() ;

            Log.d("oPost", "World");

            Intent i=new Intent(EmailVerification.this,Main2Activity.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


        finish();
    }

}
