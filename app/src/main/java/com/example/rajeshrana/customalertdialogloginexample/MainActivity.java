package com.example.rajeshrana.customalertdialogloginexample;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button_Dialog;
    private Button button_Login;
    private EditText emailText;
    private EditText passText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onButtonClick();
    }


    public void onButtonClick(){
        button_Dialog = (Button)findViewById(R.id.btn_dialog);

        button_Dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.dialog_login , null);


                button_Login = (Button)mView.findViewById(R.id.btnLogin);
                emailText = (EditText)mView.findViewById(R.id.etEmail);
                passText = (EditText)mView.findViewById(R.id.etPassword);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();



                button_Login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(!emailText.getText().toString().isEmpty() && !passText.getText().toString().isEmpty()){
                            Toast.makeText(MainActivity.this,
                                    R.string.success_login_msg,
                                    Toast.LENGTH_SHORT).show();

                            //dialog.dismiss();

                            Intent intent = new Intent(MainActivity.this , Main3Activity.class );
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this,
                                    R.string.error_login_msg,
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            }
        });



    }
}
