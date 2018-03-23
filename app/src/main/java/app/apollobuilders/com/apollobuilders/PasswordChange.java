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

public class PasswordChange extends Activity {

    SharedPreferences s1,s2;
    SharedPreferences.Editor e1;
    EditText et1,et2,et3,et4;
    ProgressDialog pd;
    String email,str="",password;
    String pass;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    int i;
    char c,a[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','Z','0','1','2','3','4','5','6','7','8','9'};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_password_change);


        et2=(EditText)findViewById(R.id.editTextcode);
        et3=(EditText)findViewById(R.id.editPassword);
        et4=(EditText)findViewById(R.id.editTextConfirmPass);



        for(i=0;i<4;i++)
        {
            c=a[(int)Math.floor(Math.random()*a.length)];
            str+=c;

        }

        Log.d("Captcha",str);
    }

    public void send(View view)
    {


        s1=getSharedPreferences("user",MODE_PRIVATE);
        e1=s1.edit();

        s2=getSharedPreferences("logintry",MODE_PRIVATE);
        email = s1.getString("Email", "");
        email=s2.getString("EmailAddress","");

           new acyn().execute();




    }

    public void confirm(View view)
    {
        if(et2.getText().toString().equals(str))
        {
            if(!(et3.getText().toString().equals(""))) {
                if (et3.getText().toString().equals(et4.getText().toString())) {


                    pass=et4.getText().toString();
                    Log.d("Password",pass);
                    new acyn2().execute();

                } else
                {
                    et4.setError("Password Do not Match.");
                    
                }

            }
            else
            {
                et3.setError("Enter New Password.");

            }

        }
        else
        {
            Toast.makeText(PasswordChange.this, "Invalid Verification Code", Toast.LENGTH_LONG).show();

        }



    }

    public void cancel(View view)
    {
        Intent i=new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(i);

        finish();

    }

    public class acyn extends AsyncTask {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(PasswordChange.this);

            pd.setMessage("Sending Mail...");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected Object doInBackground(Object[] params) {

            try {

                Log.d("dadadad",email);
                URL url=new URL("http://www.apollobuilders.co.in/apollo/Mailing.php?to="+email+"&message="+str);
                HttpURLConnection uc=(HttpURLConnection)url.openConnection();
                uc.setRequestMethod("GET");

                InputStream s=uc.getInputStream();
                int ss;
                while((ss=s.read())!=-1)
                {
                    Log.d("Print", Character.toString((char) ss));


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



    public class acyn2 extends AsyncTask{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pd=new ProgressDialog(PasswordChange.this);
            pd.setMessage("Wait...");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected Object doInBackground(Object[] params) {

            try
            {

                URL url=new URL("http://www.apollobuilders.co.in/apollo/PassChange.php?Password="+pass+"&Email="+email);
                HttpURLConnection uc=(HttpURLConnection)url.openConnection();
                uc.setRequestMethod("GET");


                InputStream s=uc.getInputStream();
                int ss;
                while((ss=s.read())!=-1)
                {
                    Log.d("Print", Character.toString((char) ss));


                }


            }
            catch (Exception e)
            {

                Log.d("Exception2",e.toString());

            }


            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            pd.dismiss();

            Toast.makeText(PasswordChange.this, "Password Sucessfully Changed.", Toast.LENGTH_LONG).show();
            e1.putString("Stat", "LoggedOut");
            Intent i=new Intent(PasswordChange.this,Main2Activity.class);
            startActivity(i);
            finish();

        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i=new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(i);
        finish();
    }
}
