package app.apollobuilders.com.apollobuilders;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Main23Activity extends Activity {

    String get;
    StringBuilder sb=new StringBuilder();
    static String imgname;

    ImageView i1,i2,i3,i4,i5;
    EditText et1,et2,et3,et4,et5,et6,et7;
    static int j1=0,j2=0,j3=0,j4=0,j5=0;

    SharedPreferences s1;
    String stt,email;

    String em,sbj,dtl,loc,fn,ln,ph;

    android.app.AlertDialog.Builder adb;
    android.app.AlertDialog ad;


    int c=0;
    String link;
    Bitmap bitmap1,bitmap2,bitmap3,bitmap4,bitmap5;
    ProgressDialog pd;
    ArrayList<NameValuePair> mm1;
    String imageStr1,imageStr2,imageStr3,imageStr4,imageStr5;
    byte[] image1,image2,image3,image4,image5;
    String pic1,pic2,pic3,pic4,pic5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main23);
        s1=getSharedPreferences("user", MODE_PRIVATE);
        stt= s1.getString("Stat", "LoggedOut");
        email=s1.getString("Email","");

        i1=(ImageView)findViewById(R.id.imageView13);
        i2=(ImageView)findViewById(R.id.imageView14);
        i3=(ImageView)findViewById(R.id.imageView15);
        i4=(ImageView)findViewById(R.id.imageView16);
        i5=(ImageView)findViewById(R.id.imageView17);


        et1=(EditText)findViewById(R.id.editTextEmail2);
        et2=(EditText)findViewById(R.id.editTextComplaint);
        et3=(EditText)findViewById(R.id.editTextDetails2);
        et4=(EditText)findViewById(R.id.editTextLocation2);
        et5=(EditText)findViewById(R.id.FName);
        et6=(EditText)findViewById(R.id.LName);
        et7=(EditText)findViewById(R.id.editTextPhone);


        if(stt.equals("LoggedIn"))
        {

            et1.setText(email);
            et1.setFocusable(false);
            et5.setText(s1.getString("FirstName", ""));
            et6.setText(s1.getString("LastName", ""));
            et7.setText(s1.getString("Phone",""));
            et5.setFocusable(false);
            et6.setFocusable(false);
            et7.setFocusable(false);

        }
        mm1 = new ArrayList<NameValuePair>();


        new imgget().execute();
    }

    public void imgclk(View v)
    {
        c++;
        if(c>5)
        {
            AlertDialog.Builder ab=new AlertDialog.Builder(Main23Activity.this);
            ab.setMessage("You can not send more then 5 images.");
            ab.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            Dialog d=ab.create();
            d.setCancelable(false);
            d.show();

        }
        else {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i, 5);
        }




    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(c==1)
        {
            try {
                Bitmap b1 = (Bitmap) data.getExtras().get("data");
                if (b1 != null) {
                    i1.setImageBitmap(b1);
                    i1.setScaleType(ImageView.ScaleType.FIT_XY);
                    j1 = 1;
                } else {
                    Toast.makeText(Main23Activity.this, "Try Again.", Toast.LENGTH_LONG).show();
                }
            }catch (Exception e)
            {}

        }

        if(c==2)
        {
            try {
                Bitmap b2 = (Bitmap) data.getExtras().get("data");
                if (b2 != null) {
                    i2.setImageBitmap(b2);
                    i2.setScaleType(ImageView.ScaleType.FIT_XY);
                    j2 = 1;
                } else {
                    Toast.makeText(Main23Activity.this, "Try Again.", Toast.LENGTH_LONG).show();
                }
            }catch (Exception e)
            {}
        }

        if(c==3)
        {
            try {
                Bitmap b3 = (Bitmap) data.getExtras().get("data");
                if (b3 != null) {
                    i3.setImageBitmap(b3);
                    i3.setScaleType(ImageView.ScaleType.FIT_XY);
                    j3 = 1;
                } else {
                    Toast.makeText(Main23Activity.this, "Try Again.", Toast.LENGTH_LONG).show();
                }
            }catch (Exception e)
            {}
        }

        if(c==4)
        {
            try {
                Bitmap b4 = (Bitmap) data.getExtras().get("data");
                if (b4 != null) {
                    i4.setImageBitmap(b4);
                    i4.setScaleType(ImageView.ScaleType.FIT_XY);
                    j4 = 1;
                } else {
                    Toast.makeText(Main23Activity.this, "Try Again.", Toast.LENGTH_LONG).show();
                }
            }catch (Exception e)
            {}
        }

        if(c==5)
        {
            try{
            Bitmap b5=(Bitmap)data.getExtras().get("data");
            if(b5!=null){
                i5.setImageBitmap(b5);
                i5.setScaleType(ImageView.ScaleType.FIT_XY);
                j5=1;}
            else
            {
                Toast.makeText(Main23Activity.this, "Try Again.", Toast.LENGTH_LONG).show();
            }
        }
            catch (Exception e)
            {}
        }



    }

    public void cancel(View view)
    {

        finish();

    }

    public void submitComp(View view)
    {

        if(!(et5.getText().toString().equals(""))) {
            if(!(et6.getText().toString().equals(""))) {

                if (!(et7.getText().toString().equals(""))) {

                    if(!(et1.getText().toString().equals("")))
        {

            if(!(et2.getText().toString().equals("")))
            {

                if(!(et3.getText().toString().equals("")))
                {

                    if(!(et4.getText().toString().equals("")))
                    {



                        if(j1==1) {
                            bitmap1 = ((BitmapDrawable) i1.getDrawable()).getBitmap();
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            bitmap1.compress(Bitmap.CompressFormat.PNG, 100, stream);
                            image1 = stream.toByteArray();


                            imageStr1 = Base64.encodeToString(image1, Base64.DEFAULT);

                            int i=Integer.parseInt(imgname);
                            i=i+1;
                            Log.d("1p", "" + i);

                            imgname=""+i;
                            mm1.add(new BasicNameValuePair("img1", imageStr1));
                            mm1.add(new BasicNameValuePair("imgname1", ""+i));

                            pic1="http://apollobuilders.co.in/apollo/ComplaintPics/"+imgname+".png";

                        }

                        else
                        {
                            pic1=null;
                            mm1.add(new BasicNameValuePair("img1", null));
                            mm1.add(new BasicNameValuePair("imgname1", null));

                        }


                        if(j2==1) {
                            bitmap2 = ((BitmapDrawable) i2.getDrawable()).getBitmap();
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            bitmap2.compress(Bitmap.CompressFormat.PNG, 100, stream);
                            image2 = stream.toByteArray();


                            imageStr2 = Base64.encodeToString(image2, Base64.DEFAULT);

                            int i=Integer.parseInt(imgname);
                            i=i+1;
                            Log.d("2p",""+i);

                            imgname=""+i;

                            mm1.add(new BasicNameValuePair("img2", imageStr2));
                            mm1.add(new BasicNameValuePair("imgname2",""+i));

                            pic2="http://apollobuilders.co.in/apollo/ComplaintPics/"+imgname+".png";

                        }

                        else
                        {
                            pic2=null;
                            mm1.add(new BasicNameValuePair("img2", null));
                            mm1.add(new BasicNameValuePair("imgname2", null));
                        }


                        if(j3==1) {
                            bitmap3 = ((BitmapDrawable) i3.getDrawable()).getBitmap();
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            bitmap3.compress(Bitmap.CompressFormat.PNG, 100, stream);
                            image3 = stream.toByteArray();


                            imageStr3 = Base64.encodeToString(image3, Base64.DEFAULT);

                            int i=Integer.parseInt(imgname);
                            i=i+1;
                            Log.d("3p",""+i);

                            imgname=""+i;

                            mm1.add(new BasicNameValuePair("img3", imageStr3));
                            mm1.add(new BasicNameValuePair("imgname3", ""+i));

                            pic3="http://apollobuilders.co.in/apollo/ComplaintPics/"+imgname+".png";
                        }

                        else
                        {
                            pic3=null;
                            mm1.add(new BasicNameValuePair("img3", null));
                            mm1.add(new BasicNameValuePair("imgname3", null));
                        }


                        if(j4==1) {
                            bitmap4 = ((BitmapDrawable) i4.getDrawable()).getBitmap();
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            bitmap4.compress(Bitmap.CompressFormat.PNG, 100, stream);
                            image4 = stream.toByteArray();


                            imageStr4 = Base64.encodeToString(image4, Base64.DEFAULT);

                            int i=Integer.parseInt(imgname);
                            i=i+1;
                            Log.d("4p",""+i);

                            imgname=""+i;

                            mm1.add(new BasicNameValuePair("img4", imageStr4));
                            mm1.add(new BasicNameValuePair("imgname4", ""+i));

                            pic4="http://apollobuilders.co.in/apollo/ComplaintPics/"+imgname+".png";
                        }

                        else
                        {
                            pic4=null;
                            mm1.add(new BasicNameValuePair("img4", null));
                            mm1.add(new BasicNameValuePair("imgname4", null));
                        }


                        if(j5==1) {
                            bitmap5 = ((BitmapDrawable) i5.getDrawable()).getBitmap();
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            bitmap5.compress(Bitmap.CompressFormat.PNG, 100, stream);
                            image5 = stream.toByteArray();


                            imageStr5 = Base64.encodeToString(image5, Base64.DEFAULT);

                            int i=Integer.parseInt(imgname);
                            i=i+1;
                            Log.d("5p",""+i);

                            imgname=""+i;

                            mm1.add(new BasicNameValuePair("img5", imageStr5));
                            mm1.add(new BasicNameValuePair("imgname5", ""+i));

                            pic5="http://apollobuilders.co.in/apollo/ComplaintPics/"+imgname+".png";

                        }

                        else
                        {
                            pic5=null;
                            mm1.add(new BasicNameValuePair("img5", null));
                            mm1.add(new BasicNameValuePair("imgname5", null));
                        }

                        if(isConnected()) {
                            new Asctask().execute();
                        }
                        else{

                            adb=new android.app.AlertDialog.Builder(this);
                            adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ad.dismiss();
                                }
                            });

                            adb.setMessage("Please check your internet connection.");
                            ad=adb.create();
                            ad.show();


                        }

                    }
                    else{

                        et4.setError("Enter Your Location");
                    }

                }
                else{

                    et3.setError("Enter The Details");
                }

            }

            else {

                et2.setError("Enter The Issue");
            }
        }
        else {
            et1.setError("Enter Your Email Address");
        }
                }
                else {

                    et7.setError("Please Enter your Contact Number");
                }
            }

            else{

                et6.setError("Please Enter Your Last Name");
            }
        }
        else {

            et5.setError("Please Enter Your First Name");
        }



    }


    public class Asctask extends AsyncTask
    {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pd=new ProgressDialog(Main23Activity.this);
            pd.setMessage("Uploading...");
            pd.setCancelable(false);
            pd.show();

            em=et1.getText().toString();
            em=em.replace(" ", "%20");
            Log.d("Email",em);

            sbj=et2.getText().toString();
            sbj=sbj.replace(" ", "%20");
            Log.d("Subject",sbj);

            dtl=et3.getText().toString();
            dtl=dtl.replace(" ", "%20");
            Log.d("Details", dtl);

            loc=et4.getText().toString();
            loc=loc.replace(" ", "%20");
            Log.d("Location",loc);


            fn=et5.getText().toString();
            fn=fn.replace(" ","%20");
            Log.d("Fname",fn);

            ln=et6.getText().toString();
            ln=ln.replace(" ","%20");
            Log.d("Lname",ln);

            ph=et7.getText().toString();
            ph=ph.replace(" ","%20");
            Log.d("Phone",ph);
//            Log.d("picAddress1",pic1);
//            Log.d("picAddress2",pic2);
//            Log.d("picAddress3",pic3);
//            Log.d("picAddress4",pic4);
//            Log.d("picAddress5",pic5);

            link="FName="+fn+"&LName="+ln+"&Contact="+ph+"&Email="+em+"&Subject="+sbj+"&Details="+dtl+"&Location="+loc+"&Picone="+pic1+"&Pictwo="+pic2+"&Picthree="+pic3+"&Picfour="+pic4+"&Picfive="+pic5;
        }

        @Override
        protected Object doInBackground(Object[] params) {


            try {


                if((j1==1)||(j2==1)||(j3==1)||(j4==1)||(j5==1)) {
                    HttpClient c = new DefaultHttpClient();
                    HttpPost p = new HttpPost("http://apollobuilders.co.in/apollo/PicsUpComplaint.php");
                    p.setEntity(new UrlEncodedFormEntity(mm1));
                    HttpResponse rs = c.execute(p);
                    HttpEntity ee = rs.getEntity();
                    InputStream im = ee.getContent();

                    int i;
                    while ((i = im.read()) != -1) {
                        Log.d("data", Character.toString((char) i));

                    }

                }

                URL url=new URL("http://apollobuilders.co.in/apollo/Complaint.php?"+link);
                HttpURLConnection uc=(HttpURLConnection)url.openConnection();
                uc.setRequestMethod("GET");


                InputStream s=uc.getInputStream();
                int ss;
                while((ss=s.read())!=-1)
                {
                    Log.d("Print", Character.toString((char) ss));


                }

            }catch(Exception e){
                Log.d("Exception",e.toString());
            }

            try
            {

                Log.d("ImageNameUpdate",imgname);
                URL url=new URL("http://www.apollobuilders.co.in/apollo/ImageNameUpdate.php?Name="+imgname);
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
            Toast.makeText(Main23Activity.this, "Your Complaint Have been Registered You Will Get Updates Details via your Email.", Toast.LENGTH_LONG).show();
            finish();
        }


    }

    public class imgget extends AsyncTask
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] params) {

            try {
                URL url = new URL("http://www.apollobuilders.co.in/apollo/ImageNameGet.php");

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

                String string=get.substring(get.indexOf('[') + 1, get.indexOf(']'));

                Log.d("String",string);

                JSONObject object=new JSONObject(string);


                imgname=object.optString("Name");

                Log.d("name",imgname);


            }
            catch (Exception e) {
                Log.d("Exception",e.toString());
            }





            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

        }
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }

    private boolean isConnected()
    {
        ConnectivityManager cm=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni=cm.getActiveNetworkInfo();
        return ni!=null&&ni.isConnected();


    }
}
