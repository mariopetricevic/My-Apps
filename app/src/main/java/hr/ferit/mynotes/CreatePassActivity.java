package hr.ferit.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePassActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pass);

        editText1=findViewById(R.id.enterpass1);
        editText2=findViewById(R.id.enterpass2);
        button =findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1=editText1.getText().toString();
                String text2=editText2.getText().toString();

                if(text1.equals("") || text2.equals("")){
                    Toast.makeText(CreatePassActivity.this, "Nema unesene šifre", Toast.LENGTH_SHORT).show();

                }
                else{
                    if (text1.equals(text2)){
                        SharedPreferences settings=getSharedPreferences("PREPS", 0);
                        SharedPreferences.Editor editor=settings.edit();
                        editor.putString("password", text1);
                        editor.apply();

                        //udi u apk
                        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(CreatePassActivity.this,"Lozinka nije ispravna", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}
