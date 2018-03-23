package app.apollobuilders.com.apollobuilders;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class Main2Activity extends Activity {

    SharedPreferences s1;
    SharedPreferences.Editor e1;
    String stat;
    AlertDialog ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main2);
        s1=getSharedPreferences("user", MODE_PRIVATE);


    }


    public void issueclk(View view)
    {
        stat = s1.getString("Stat", "LoggedOut");
        if(stat.equals("LoggedIn")) {
            Intent i = new Intent(getApplicationContext(), Main22Activity.class);
            startActivity(i);
        }
        else {

           // Toast.makeText(Main2Activity.this, "Please Login to submit an issue.", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder ab=new AlertDialog.Builder(this);
            ab.setMessage("Please Login to submit an issue.");
            ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                ad.dismiss();
                }
            });

            ad=ab.create();
            ad.show();
        }

    }

    public void comloaintclk(View view)
    {
       stat = s1.getString("Stat", "LoggedOut");
        if(stat.equals("LoggedIn")) {
            Intent i=new Intent(getApplicationContext(),Main23Activity.class);
            startActivity(i);
        }
        else {

            // Toast.makeText(Main2Activity.this, "Please Login to submit an issue.", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder ab=new AlertDialog.Builder(this);
            ab.setMessage("Please Login to submit a Complaint.");
            ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    ad.dismiss();
                }
            });

            ad=ab.create();
            ad.show();
        }

    }

    public void complimentclk(View view)
    {
        stat = s1.getString("Stat", "LoggedOut");
        if(stat.equals("LoggedIn")) {
            Intent i=new Intent(getApplicationContext(),Main24Activity.class);
            startActivity(i);
        }
        else {

            // Toast.makeText(Main2Activity.this, "Please Login to submit an issue.", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder ab = new AlertDialog.Builder(this);
            ab.setMessage("Please Login to give a Compliment.");
            ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    ad.dismiss();
                }
            });

            ad = ab.create();
            ad.show();
        }

    }

    public void suggestionclk(View view)
    {


        stat = s1.getString("Stat", "LoggedOut");
        if(stat.equals("LoggedIn")) {
            Intent i=new Intent(getApplicationContext(),Main25Activity.class);
            startActivity(i);

        }
        else {

            // Toast.makeText(Main2Activity.this, "Please Login to submit an issue.", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder ab = new AlertDialog.Builder(this);
            ab.setMessage("Please Login to give a Suggestion.");
            ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    ad.dismiss();
                }
            });

            ad = ab.create();
            ad.show();
        }


    }

    public void historyclk(View view)
    {


        String ss=s1.getString("Stat","LoggedOut");
        Log.d("ss",ss);

        if(ss.equals("LoggedIn")) {


            Intent i = new Intent(getApplicationContext(), Fetch.class);
            startActivity(i);


        }

        else {

            Toast.makeText(Main2Activity.this, "Please Login To See History.", Toast.LENGTH_LONG).show();
        }
    }

    public void notificationclk(View view)
    {
        String ss=s1.getString("Stat","LoggedOut");
        if(ss.equals("LoggedIn")) {


            Intent i = new Intent(getApplicationContext(), Fetch2.class);
            startActivity(i);


        }

        else {

            Toast.makeText(Main2Activity.this, "Please Login To See Notifications.", Toast.LENGTH_LONG).show();
        }
    }

    public void communityclk(View view)
    {
        Intent i=new Intent(getApplicationContext(),CommunityManaged.class);
        startActivity(i);

    }

    public void aboutusclk(View view)
    {
        Intent i=new Intent(getApplicationContext(),Main29Activity.class);
        startActivity(i);

    }

    public void contactusclk(View view)
    {
        Intent i=new Intent(getApplicationContext(),Main210Activity.class);
        startActivity(i);

    }

    public void userprofileclk(View view) {

        stat = s1.getString("Stat", "LoggedOut");
        Log.d("User", stat);

        if (stat.equals("LoggedOut")) {
            Intent i = new Intent(getApplicationContext(), Main211Activity.class);
            startActivity(i);

        }
        else
        {
            Intent i=new Intent(getApplicationContext(),UserDetails.class);
            startActivity(i);


        }
    }
}
