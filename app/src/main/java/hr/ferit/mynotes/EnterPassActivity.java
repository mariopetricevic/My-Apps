package hr.ferit.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPassActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_pass);


        SharedPreferences settings=getSharedPreferences("PREPS", 0 );
        password=settings.getString("password", "");

        editText=findViewById(R.id.editTextenterPass);
        button=findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=editText.getText().toString();

                if (text.equals(password)){
                    Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(EnterPassActivity.this, "Netočna lozinka", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
