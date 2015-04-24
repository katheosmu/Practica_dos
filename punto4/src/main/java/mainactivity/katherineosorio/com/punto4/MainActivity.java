package mainactivity.katherineosorio.com.punto4;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    static final float PI  = (float) 3.1416;
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bCalc = (Button) findViewById(R.id.bCalc);

        bCalc.setOnClickListener(this);
    }

    public void OnRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        RadioGroup radiogr = (RadioGroup) findViewById(R.id.radiog);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rCuadrado:
                    flag = 0;
                    radiogr.setEnabled(false);
                // Pirates are the best
                break;
            case R.id.rTria:
                flag = 1;
                radiogr.setEnabled(false);
                // Ninjas rule
                break;
            case R.id.rRecta:
                flag=2;
                radiogr.setEnabled(false);
                break;
            case R.id.rCirc:
                    flag=3;
                radiogr.setEnabled(false);
                break;

        }


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

    @Override
    public void onClick(View v) {

        TextView tresult = (TextView) findViewById(R.id.tResult);

        double result=0;
        DecimalFormat form = new DecimalFormat("0.00");

        // Check which radio button was clicked
        switch (flag) {
            case 0:
                EditText elado1 = (EditText) findViewById(R.id.lado1);
                double lado1 = Double.parseDouble(elado1.getText().toString());

                result = lado1*lado1;
                break;
            case 1:
                EditText ealtura = (EditText) findViewById(R.id.altura);
                EditText ebase = (EditText) findViewById(R.id.base);
                double altura = Double.parseDouble(ealtura.getText().toString());
                double base = Double.parseDouble(ebase.getText().toString());
                result = base*altura/2;
                break;
            case 2:
                elado1 = (EditText) findViewById(R.id.lado1);
                EditText elado2 = (EditText) findViewById(R.id.lado2);
                lado1 = Double.parseDouble(elado1.getText().toString());
                double lado2 = Double.parseDouble(elado2.getText().toString());
                result = lado1*lado2;
                break;
            case 3:
                EditText eradio = (EditText) findViewById(R.id.radio);
                double radio = Double.parseDouble(eradio.getText().toString());
                result = PI*radio*radio;
                break;
        }

        tresult.setText(String.valueOf(form.format(result)));

    }
}
