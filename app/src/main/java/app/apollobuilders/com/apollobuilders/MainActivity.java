package app.apollobuilders.com.apollobuilders;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
    int i=0;Boolean b=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ///////////////////////////////////////////////////////
        b=isNetworkAvailable();

//        ConnectivityManager con=(ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
//
//
//
//        if(con!=null)
//        {
//            NetworkInfo net[]= con.getAllNetworkInfo();
//
//            for(int i=0;i<net.length;i++) {
//                if ((net[i].getTypeName().toString().equals("mobile")) || (net[i].getTypeName().toString().equals("WIFI"))) {
//                    if (net[i].isConnected()) {
//
//                        b = true;
//
//                    }
//                    // b=true;
//
//                    // Log.d("connection", net[i].getTypeName());
//
//                }
//
//            }
//
//
//        }

        if(b==true) {

            Thread t = new Thread() {

                public void run() {

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    if (i == 1) {

                    } else {
                        Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                        startActivity(i);
                        finish();
                    }

                }

            };

            t.start();

        }
            else {
            AlertDialog.Builder ab = new AlertDialog.Builder(this);
            ab.setMessage("Please check your internet connection.");
            ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    finish();

                }
            });

            AlertDialog a = ab.create();
            a.setCancelable(false);
            a.show();
        }
//////////////////////////////////////////////
    }
    public void clk(View view)
    {
        i=1;

        Intent i = new Intent(getApplicationContext(), Main2Activity.class);

        startActivity(i);
        finish();
    }

    private boolean isNetworkAvailable(){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
