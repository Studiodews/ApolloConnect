package app.apollobuilders.com.apollobuilders;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Register extends Activity {
    EditText fname,lname,email,cemail,phone,pass,cpass,address;
    RadioButton r1,r2,r3,r4;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String emailvalidate;
    String lastname,firstname,emailaddress,password,residdress,type,mobnumber;

    String get="";
    StringBuilder sb=new StringBuilder();
    ProgressDialog pd;
    int Registered=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        r1=(RadioButton)findViewById(R.id.radioButton1);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);
        r4=(RadioButton)findViewById(R.id.radioButton4);


        fname=(EditText)findViewById(R.id.FName);
        lname=(EditText)findViewById(R.id.LName);
        email=(EditText)findViewById(R.id.Email);
        cemail=(EditText)findViewById(R.id.ConfirmEmail);
        pass=(EditText)findViewById(R.id.Password);
        phone=(EditText)findViewById(R.id.Phone);
        cpass=(EditText)findViewById(R.id.ConfirmPassword);
        address=(EditText)findViewById(R.id.Address);

//        Bundle b=getIntent().getExtras();
//        int k=b.getInt("varun");

//        if(k==1)
//        {
//            javabeans jb=new javabeans();
//            jb.setFirstName(firstname);
//            jb.setLastName(lastname);
//            jb.setLastName(emailaddress);
//            jb.setPhone(mobnumber);
//            jb.setEmail(emailaddress);
//            jb.setPassword(password);
//            jb.setAddress(residdress);
//        }
//


    }

    public void Radiobtn1(View view)
    {
        r2.setChecked(false);
        r3.setChecked(false);
        r4.setChecked(false);
        type="Owner";
    }

    public void Radiobtn2(View view)
    {
        r1.setChecked(false);
        r3.setChecked(false);
        r4.setChecked(false);
        type="Tenant";
    }

    public void Radiobtn3(View view)
    {
        r1.setChecked(false);
        r2.setChecked(false);
        r4.setChecked(false);
        type="Visitor";
    }

    public void Radiobtn4(View view)
    {
        r1.setChecked(false);
        r2.setChecked(false);
        r3.setChecked(false);
        type="Others";
    }


    public void cancel(View view)
    {

        finish();

    }

    public void submit(View view)
    {
        Registered=0;
        emailvalidate=email.getText().toString();

        if(!(fname.getText().toString().equals("")))
        {
            if(!(lname.getText().toString().equals("")))
            {

                if(!(emailvalidate.equals(""))&&(emailvalidate.matches(emailPattern)))
                {

                    if((cemail.getText().toString().equals(email.getText().toString())))
                    {

                        if(!(phone.getText().toString().equals(""))&&(phone.getText().length()<=16))
                        {

                            if(!(pass.getText().toString().equals("")))
                            {

                                if(cpass.getText().toString().equals(pass.getText().toString()))
                                {

                                    if((r1.isChecked())||(r2.isChecked())||(r3.isChecked()||(r4.isChecked()))) {

                                        if (!(address.getText().toString().equals(""))) {

                                            firstname=fname.getText().toString();
                                            lastname=lname.getText().toString();
                                            emailaddress=email.getText().toString();
                                            mobnumber=phone.getText().toString();
                                            password=pass.getText().toString();
                                            residdress=address.getText().toString();


                                            new asyn().execute();


                                            //finish();


                                        } else {

                                            address.setError("Enter Your Address");
                                        }

                                    }

                                    else {

                                        Toast.makeText(Register.this, "Please Select One From The Above Options", Toast.LENGTH_SHORT).show();
                                    }

                                }

                                else {

                                    Toast.makeText(Register.this, "Password Do Not Match", Toast.LENGTH_SHORT).show();
                                }

                            }
                            else {

                                pass.setError("Enter Your Password");
                            }

                        }
                        else {

                            phone.setError("Please Enter Your Phone Number");
                        }

                    }
                    else {

                        Toast.makeText(Register.this, "Your Email Do Not Match", Toast.LENGTH_SHORT).show();
                    }

                }

                else {

                    email.setError("InCorrect Email Address");
                }


            }
            else {

                lname.setError("Please Enter Your Last Name");
            }


        }
        else {

            fname.setError("Please Enter Your First Name");

        }






    }


    public class asyn extends AsyncTask{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(Register.this);
            pd.setMessage("Loading...");
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
                Log.d("BufferReader",get);

//                String string=get.substring(get.indexOf('[')+1,get.indexOf(']'));
//
//                Log.d("String",string);

                JSONArray arr=new JSONArray(get);
                JSONObject object=null;

                for(int i=0;i<arr.length();i++)
                {
                    object=arr.getJSONObject(i);
                    String check=object.optString("Email");
                    if(check.equals(emailaddress))
                    {

                        Registered=1;
                        Log.d("Email",check);

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

            if(Registered==0)
            {

                Intent i = new Intent(getApplicationContext(), EmailVerification.class);
                i.putExtra("Email", emailaddress);
                i.putExtra("fname", firstname);
                i.putExtra("lname", lastname);
                i.putExtra("phone", mobnumber);
                i.putExtra("pass", password);
                i.putExtra("address", residdress);
                i.putExtra("type", type);
                startActivity(i);
            }

            else {

                Toast.makeText(Register.this, "This Email Address is already Registered", Toast.LENGTH_SHORT).show();
            }



        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();


        finish();
    }
}
