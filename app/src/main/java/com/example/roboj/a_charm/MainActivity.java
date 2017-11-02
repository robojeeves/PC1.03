package com.example.roboj.a_charm;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.CircleProgress;
import com.github.lzyzsd.circleprogress.DonutProgress;

public class MainActivity extends AppCompatActivity {
    private Button b_login;
    private Button b_add10, b_add15, b_sub25;
    private EditText tf_email, tf_password;
    private DonutProgress pb_creditHrs;
    private TextView tv_forgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        b_login = (Button) findViewById(R.id.b_login);
        tf_email = (EditText) findViewById(R.id.tf_email);
        tf_password = (EditText) findViewById(R.id.tf_password);
        tv_forgotPassword = (TextView) findViewById(R.id.tv_forgotPassword);
        tv_forgotPassword.setMovementMethod(LinkMovementMethod.getInstance());

       //OpenStudentAdvisory();

        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tf_email.getText().toString().contains("@patriots.uttyler.edu") &&
                        !tf_password.getText().toString().isEmpty())
                {
                    OpenStudentAdvisory();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Invalid Username/password combination.", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    private void OpenStudentAdvisory(){
        setContentView(R.layout.student_advisory);
    }

    private void OpenReportScreen() {
        setContentView(R.layout.sa_report);

        b_add10 = (Button) findViewById(R.id.b_add10);
        b_add15 = (Button) findViewById(R.id.b_add15);
        b_sub25 = (Button) findViewById(R.id.b_sub25);
        pb_creditHrs = (DonutProgress) findViewById(R.id.pb_creditHrs);

        b_add10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb_creditHrs.setProgress(pb_creditHrs.getProgress()+10);
                //pb_creditHrs.incrementProgressBy(10);
            }
        });
        b_add15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb_creditHrs.setProgress(pb_creditHrs.getProgress()+15);
                //pb_creditHrs.incrementProgressBy(15);
            }
        });
        b_sub25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb_creditHrs.setProgress(pb_creditHrs.getProgress()-25);
                //pb_creditHrs.incrementProgressBy(-25);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
