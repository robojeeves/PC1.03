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
import java.util.ResourceBundle;

import com.github.lzyzsd.circleprogress.CircleProgress;
import com.github.lzyzsd.circleprogress.DonutProgress;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button b_login;
    private EditText tf_email, tf_password;
    private DonutProgress dp_completionStatus;
    private TextView tv_completionStatus, tv_core, tv_degreeCore, tv_lowerDivision, tv_upperDivision, tv_supportCourses;
    private ProgressBar pb_core, pb_degreeCore, pb_lowerDivision, pb_upperDivision, pb_supportCourses;
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
                if(!tf_email.getText().toString().contains("@patriots.uttyler.edu"))
                {
                    tf_email.append("@patriots.uttyler.edu");
                }
                if(!tf_password.getText().toString().isEmpty())
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

        // Create references to all progress bars
        dp_completionStatus = (DonutProgress) findViewById(R.id.dpCompletionStatus );
        pb_core = (ProgressBar) findViewById(R.id.pb_CoreCurriculum);
        pb_degreeCore = (ProgressBar) findViewById(R.id.pb_DegreeCore);
        pb_lowerDivision = (ProgressBar) findViewById(R.id.pb_LowerDivision);
        pb_upperDivision = (ProgressBar) findViewById(R.id.pb_UpperDivision);
        pb_supportCourses = (ProgressBar) findViewById(R.id.pb_SupportCourses);

        // Create references to Text Views
        tv_completionStatus = (TextView) findViewById(R.id.tv_CompletionStatus);
        tv_core = (TextView) findViewById(R.id.tv_CoreCurriculum);
        tv_degreeCore = (TextView) findViewById(R.id.tv_DegreeCore);
        tv_lowerDivision = (TextView) findViewById(R.id.tv_LowerDivision);
        tv_upperDivision = (TextView) findViewById(R.id.tv_UpperDivision);
        tv_supportCourses = (TextView) findViewById(R.id.tv_SupportCourses);


        //Set Values for each progress bar
        String progress = Integer.toString(56); // Sets progress for completion status bar
        int core = 100, degreeCore = 85, lowerDivision = 50, upperDivision = 35, supportCourses = 45;
        dp_completionStatus.setDonut_progress(progress);
        dp_completionStatus.setText(progress + "%");

        //Assign values to the progress bars
        pb_core.setProgress(core);
        pb_degreeCore.setProgress(degreeCore);
        pb_lowerDivision.setProgress(lowerDivision);
        pb_upperDivision.setProgress(upperDivision);
        pb_supportCourses.setProgress(supportCourses);

        // set labels for each bar
        tv_completionStatus.setText("Completion Status\n 67/120 Hrs");
        tv_core.setText(R.string.core);
        tv_core.append(" " + Integer.toString(core) + "%");
        tv_degreeCore.setText(R.string.degreeCore);
        tv_degreeCore.append(" " + Integer.toString(degreeCore) + "%");
        tv_lowerDivision.setText(R.string.lowerDivision);
        tv_lowerDivision.append(" " + Integer.toString(lowerDivision) + "%");
        tv_upperDivision.setText(R.string.upperDivision);
        tv_upperDivision.append(" " + Integer.toString(upperDivision) + "%");
        tv_supportCourses.setText(R.string.supportCourses);
        tv_supportCourses.append(" " + Integer.toString(supportCourses) + "%");


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
