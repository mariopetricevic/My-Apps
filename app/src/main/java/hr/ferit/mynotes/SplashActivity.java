package hr.ferit.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences settings=getSharedPreferences("PREPS", 0 );
        password=settings.getString("password", "");


        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(password.equals("")){

                    Intent intent=new Intent(getApplicationContext() , CreatePassActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent=new Intent(getApplicationContext(), EnterPassActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 1000);
    }
}
