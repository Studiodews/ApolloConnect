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

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login extends Activity {
    EditText et1,et2;
    String email,pass,get;
    StringBuilder sb=new StringBuilder();
    ProgressDialog pd;

   static int t=0;
    SharedPreferences s1,s2;
    SharedPreferences.Editor e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        et1=(EditText)findViewById(R.id.Email);
        et2=(EditText)findViewById(R.id.Password);




    }

    public void forget_pass(View view)
    {
        email=et1.getText().toString();

        if(!(email.equals("")))
        {

            s2=getSharedPreferences("logintry", MODE_PRIVATE);
            e2=s2.edit();

            e2.putString("EmailAddress",email);


            e2.commit();
            Intent i=new Intent(getApplicationContext(),PasswordChange.class);
            startActivity(i);
            finish();

        }
        else
        {

            et1.setError("Please Enter Your Email Address.");

        }

    }

    public void register(View view)
    {

        Intent i=new Intent(getApplicationContext(),Register.class);
        startActivity(i);
        finish();

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

    public void login(View view)
    {
        email=et1.getText().toString();
        pass=et2.getText().toString();

        if(!(email.equals("")))
        {
            if(!(pass.equals("")))
            {
                new xyz().execute();







            }
            else
            {
            et2.setError("Please Enter Your Password.");
            }
        }
        else
        {

            et1.setError("Please Enter Your Email Address.");

        }
    }

    public class xyz extends AsyncTask{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(Login.this);
            pd.setMessage("Wait...");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected Object doInBackground(Object[] params) {

            try {
                URL url = new URL("http://www.apollobuilders.co.in/apollo/UserCheck.php");

                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                uc.setRequestMethod("GET");

                BufferedReader bf=new BufferedReader(new InputStreamReader(uc.getInputStream()));
                while ((get=bf.readLine())!=null)
                {

                    sb.append(get);


                }

                get="";
                get=sb.toString();
                Log.d("BufferReader", get);

//                String string=get.substring(get.indexOf('[')+1,get.indexOf(']'));
//
//                Log.d("String",string);

                JSONArray arr=new JSONArray(get);
                JSONObject object=null;

                for(int i=0;i<arr.length();i++)
                {
                    object=arr.getJSONObject(i);
                    String emailcheck=object.optString("Email");
                    String passwordcheck=object.optString("Password");
                    if(emailcheck.equals(email))
                    {

                        if(passwordcheck.equals(pass))
                        {
                            s1=getSharedPreferences("user", MODE_PRIVATE);
                            e1=s1.edit();

                            e1.putString("FirstName",object.optString("FirstName").toString());
                            e1.putString("LastName",object.optString("LastName").toString());
                            e1.putString("Email",object.optString("Email").toString());
                            e1.putString("Phone",object.optString("Phone").toString());
                            e1.putString("Password",object.optString("Password").toString());
                            e1.putString("Type",object.optString("Type").toString());
                            e1.putString("Address", object.optString("Address").toString());
                            e1.putString("Stat", "LoggedIn");
                            e1.commit();


                            finish();

                            t=1;
                        }
                        else {

                            t=0;

                        }


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
            pd.dismiss();

            if(t==0)
            {
                Log.d("dadada","helo check");

                Toast.makeText(Login.this, "Invalid Login Credentials", Toast.LENGTH_SHORT).show();
            }


        }
    }



}
