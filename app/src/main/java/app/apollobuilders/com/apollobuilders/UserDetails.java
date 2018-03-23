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
import android.widget.RadioButton;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserDetails extends Activity {

    String fn,ln,em,ph,ps,ty,ad,fn2,ln2,em2,ph2,ty2,ad2;

    EditText et1,et2,et3,et4,et5;

    RadioButton r1,r2,r3,r4;

    ProgressDialog pd;
    SharedPreferences s1;
    SharedPreferences.Editor e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_details);

        s1=getSharedPreferences("user",MODE_PRIVATE);
        e1=s1.edit();

        et1=(EditText)findViewById(R.id.FName);
        et2=(EditText)findViewById(R.id.LName);
        et3=(EditText)findViewById(R.id.Email);
        et4=(EditText)findViewById(R.id.Phone);
        et5=(EditText)findViewById(R.id.Address);

        r1=(RadioButton)findViewById(R.id.radioButton1);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);
        r4=(RadioButton)findViewById(R.id.radioButton4);

        s1=getSharedPreferences("user", MODE_PRIVATE);
        fn=s1.getString("FirstName", "");
        ln=s1.getString("LastName", "");
        em=s1.getString("Email", "");
        ph=s1.getString("Phone", "");
        ty=s1.getString("Type", "");
        ad=s1.getString("Address", "");
        ps=s1.getString("Password", "");


        et1.setText(fn);
        et2.setText(ln);
        et3.setText(em);
        et4.setText(ph);
        et5.setText(ad);

        Log.d("Tyeppepepepe",ty);


        if(ty.equals("Owner"))
        {
            r1.setChecked(true);
            r2.setChecked(false);
            r3.setChecked(false);
            r4.setChecked(false);

        }

        else if (ty.equals("Tenant"))
        {

            r1.setChecked(false);
            r2.setChecked(true);
            r3.setChecked(false);
            r4.setChecked(false);
        }

        else if(ty.equals("Visitor"))
        {
            r1.setChecked(false);
            r2.setChecked(false);
            r3.setChecked(true);
            r4.setChecked(false);

        }
        else {

            r1.setChecked(false);
            r2.setChecked(false);
            r3.setChecked(false);
            r4.setChecked(true);
        }
    }

    public void Radiobtn1(View view)
    {
        r2.setChecked(false);
        r3.setChecked(false);
        r4.setChecked(false);
        ty="Owner";
    }

    public void Radiobtn2(View view)
    {
        r1.setChecked(false);
        r3.setChecked(false);
        r4.setChecked(false);
        ty="Tenant";
    }

    public void Radiobtn3(View view)
    {
        r1.setChecked(false);
        r2.setChecked(false);
        r4.setChecked(false);
        ty="Visitor";
    }

    public void Radiobtn4(View view)
    {
        r1.setChecked(false);
        r2.setChecked(false);
        r3.setChecked(false);
        ty="Others";
    }


    public void changepassclk(View view)
    {
      Intent i=new Intent(getApplicationContext(),PasswordChange.class);
        startActivity(i);
        finish();

    }

    public void logoutclk(View view)
    {
        e1.clear();
        e1.putString("stat", "LoggedOut");
        e1.commit();


        finish();

    }

    public void cancel(View view){


        finish();
    }

    public void submit(View view){

        e1.putString("Stat", "LoggedOut");
        e1.commit();

        fn2=et1.getText().toString();
        ln2=et2.getText().toString();
        ph2=et4.getText().toString();
        ad2=et5.getText().toString();



        Log.d("Firstname",et1.getText().toString());
        Log.d("lastname",et2.getText().toString());
        Log.d("Fphonee",et4.getText().toString());
        Log.d("addressas",et5.getText().toString());
      //  Log.d("Submit", "hello how r u");
        if(r1.isChecked())
        {
            ty2="Owner";

        }
        else if(r2.isChecked())
        {

            ty2="Tenant";
        }
        else if (r3.isChecked())
        {

            ty2="Visitor";
        }
        else
        {
            ty2="Others";
        }


        new acyn2().execute();
        finish();


    }

    public class acyn2 extends AsyncTask {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pd=new ProgressDialog(UserDetails.this);
            pd.setMessage("Wait...");
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected Object doInBackground(Object[] params) {

            try
            {
                URL url=new URL("http://www.apollobuilders.co.in/apollo/UserUpdate.php?FirstName="+fn2+"&LastName="+ln2+"&Email="+em+"&Phone="+ph2+"&Type="+ty2+"&Address="+ad2);
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

                Log.d("Exception2", e.toString());

            }


            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            pd.dismiss();

        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();


        finish();
    }
}
