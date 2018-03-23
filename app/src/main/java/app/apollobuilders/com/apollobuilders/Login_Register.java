package app.apollobuilders.com.apollobuilders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Login_Register extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login__register);



    }

    public void cancel(View view)
    {

        finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i=new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(i);
        finish();


    }

    public void login(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
        finish();
    }

    public void register(View view)
    {

        Intent i=new Intent(getApplicationContext(),Register.class);
        startActivity(i);
        finish();

    }


}
