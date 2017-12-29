package jack.ultrajack.jac.healthwatcher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    public ImageButton Log;
    public EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8;
    private Toast mainToast;
    public Spinner GenderSpin;
    public String m1="Male";
    public String m2="Female";
    public String nameStr,weightStr,heightStr,ageStr,passStr,usrStr,usrStrlow,passConStr,emailStr;
    private int age,weight,height;

    int c,y=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            Log = (ImageButton) findViewById(R.id.Login);
            ed1 = (EditText) findViewById(R.id.edth);
            ed2 = (EditText) findViewById(R.id.edtw);

            ed4 = (EditText) findViewById(R.id.edta);


            GenderSpin = (Spinner) findViewById(R.id.SGender);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.Gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        GenderSpin.setAdapter(adapter);


        Log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heightStr = ed1.getText().toString();
                weightStr = ed2.getText().toString();
                ageStr = ed4.getText().toString();


                if (ageStr.isEmpty()  || heightStr.isEmpty() || weightStr.isEmpty()  ) {
                    mainToast = Toast.makeText(getApplicationContext(), "Please fill all your data ", Toast.LENGTH_SHORT);
                    mainToast.show();
                }



                    age = Integer.parseInt(ageStr);
                    weight = Integer.parseInt(weightStr);
                    height = Integer.parseInt(heightStr);



                    String text = GenderSpin.getSelectedItem().toString();
                    int k = 0;

                    if (text.equals(m1)) //If gender is male K = 1
                        k = 1;
                    if (text.equals(m2)) //If gender is female K = 2
                        k = 2;


                    Intent i = new Intent(v.getContext(), Primary.class);
                    mainToast = Toast.makeText(getApplicationContext(), "Let's measure bp!! ", Toast.LENGTH_SHORT);
                    mainToast.show();
                    i.putExtra("age",age);
                i.putExtra("weight",weight);
                i.putExtra("height",height);
                i.putExtra("gender",k);
                    startActivity(i);
                    finish();


                }


        });
    }
}

