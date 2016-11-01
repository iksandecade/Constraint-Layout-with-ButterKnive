package project.iksandecade.responsivelayoutwithmvvm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editTextName)
    EditText etName;
    @BindView(R.id.editTextPassword)
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonSubmit)
    void clickSubmit() {
        if (isValid()){
            Toast.makeText(this, "Congrats Bro!!!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean isValid() {
        boolean status = true;
        if (etName.getText().toString().trim().equals("")) {
            etName.setError("Please insert name");
            status = false;
        }
        if (etPassword.getText().toString().trim().equals("")) {
            etPassword.setError("Please insert password");
            status = false;
        }

        return status;
    }

}
