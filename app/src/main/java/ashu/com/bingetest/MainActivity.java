package ashu.com.bingetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPhoneNumber;
    private String stringPhoneNumber;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhoneNumber=findViewById(R.id.id_phoneNumber);
        stringPhoneNumber=editTextPhoneNumber.getText().toString();



    }
}
