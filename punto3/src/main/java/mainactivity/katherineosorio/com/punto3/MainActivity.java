package mainactivity.katherineosorio.com.punto3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bCalc = (Button) findViewById(R.id.bCalc);

        bCalc.setOnClickListener(this);
    }

    public void onClick(View v){

        EditText eQuiz = (EditText) findViewById(R.id.eQuiz);
        EditText eExpos = (EditText) findViewById(R.id.eExpos);
        EditText eProyect = (EditText) findViewById(R.id.eProyFin);
        EditText ePract = (EditText) findViewById(R.id.ePract);
        TextView tResult = (TextView) findViewById(R.id.eResult);

        DecimalFormat form = new DecimalFormat("0.00");

        double result;
        double Quiz = Double.parseDouble(eQuiz.getText().toString());
        double Expo = Double.parseDouble(eExpos.getText().toString());
        double Pract = Double.parseDouble(eProyect.getText().toString());
        double Pory = Double.parseDouble(ePract.getText().toString());

        result = Quiz * 0.15 + Expo * 0.1 + Pract * 0.4 + Pory * 0.35;
        tResult.setText(String.valueOf(form.format(result)));
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