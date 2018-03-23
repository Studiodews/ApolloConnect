package app.apollobuilders.com.apollobuilders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Main211Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main211);

        Intent i=new Intent(getApplicationContext(),Login_Register.class);
        startActivity(i);
        finish();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();


        finish();
    }

}
