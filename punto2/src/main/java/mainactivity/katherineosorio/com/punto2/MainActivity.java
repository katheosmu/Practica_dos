package mainactivity.katherineosorio.com.punto2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import static mainactivity.katherineosorio.com.punto2.R.id.rDiv;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
     int flag=0;

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


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rSuma:
                if (checked)
                    flag = 0;
                    // Pirates are the best
                    break;
            case R.id.rRes:
                if (checked)
                    flag = 1;
                    // Ninjas rule
                    break;
            case R.id.rMult:
                if(checked)
                    flag=2;
                break;
            case R.id.rDiv:
                if(checked)
                    flag=3;
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
        EditText eop1 = (EditText) findViewById(R.id.eOperand1);
        EditText eop2 = (EditText) findViewById(R.id.eOperand2);
        final TextView tresult = (TextView) findViewById(R.id.tResult);

        double result;
        double op1 = Double.parseDouble(eop1.getText().toString());
        double op2 = Double.parseDouble(eop2.getText().toString());


    // Check which radio button was clicked
    switch (flag) {
        case 0:
            result = op1 + op2;
            tresult.setText(String.valueOf(result));
            break;
        case 1:
            result = op1 - op2;
            tresult.setText(String.valueOf(result));
            break;
        case 2:
            result = op1 * op2;
            tresult.setText(String.valueOf(result));
            break;
        case 3:
            result = op1 / op2;
            tresult.setText(String.valueOf(result));
            break;
    }



    }
}
