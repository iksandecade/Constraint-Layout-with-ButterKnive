package project.iksandecade.responsivelayoutwithmvvm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editTextEmail)
    EditText etEmail;
    @BindView(R.id.editTextPassword)
    EditText etPassword;

    Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }


    @OnClick(R.id.buttonSubmit)
    void clickSubmit() {
        if (isValid()) {
            Toast.makeText(this, "Congrats Bro!!!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean isValid() {
        boolean status = true;
        boolean read = emailPattern.matcher(etEmail.getText()).matches();
        if (!read) {
            etEmail.setError("Please insert email");
            status = false;
        }
        if (etPassword.getText().toString().trim().equals("")) {
            etPassword.setError("Please insert password");
            status = false;
        }

        return status;
    }

}
