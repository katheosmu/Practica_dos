package mainactivity.katherineosorio.com.punto5;

import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spcity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spcity = (Spinner) findViewById(R.id.spinner);

        loadSpinnerProvincias();

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_id);
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
        }

        final TextView nomb = (TextView) findViewById(R.id.tNombre);
        final TextView corr = (TextView) findViewById(R.id.tCorreo);
        final TextView tele = (TextView) findViewById(R.id.tTelefono);
        final TextView sex = (TextView) findViewById(R.id.Sex);
        final TextView cities = (TextView) findViewById(R.id.Cities);
        final TextView naci = (TextView) findViewById(R.id.Naci);
        final TextView Hobb = (TextView) findViewById(R.id.Hobb);

        final TextView tName =(TextView)findViewById(R.id.Nombre);
        final TextView tMail =(TextView)findViewById(R.id.tMail);
        final TextView tTele =(TextView)findViewById(R.id.tTele);
        final TextView tSex = (TextView) findViewById(R.id.tSex);

        final EditText eName = (EditText) findViewById(R.id.eNombre);
        final EditText eMail = (EditText) findViewById(R.id.eCorreo);
        final EditText etele = (EditText) findViewById(R.id.eTelefono);

        Button boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomb.setText("Nombre ");
                corr.setText("Correo ");
                tele.setText("Telefono ");
                sex.setText("Sexo ");
                cities.setText("Ciudad ");
                Hobb.setText("Hobbies ");
                naci.setText("Nacimiento ");

                tName.setText(eName.getText());
                tMail.setText(eMail.getText());
                tTele.setText(etele.getText());

            }
        });

    }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos,
                                   long id) {

            switch (parent.getId()) {
                case R.id.spinner:

                    // Retrieves an array
                    TypedArray arrayLocalidades = getResources().obtainTypedArray(R.array.ciudades);
                    arrayLocalidades.recycle();

                    // Create an ArrayAdapter using the string array and a default
                    // spinner layout
                    ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(
                            this, android.R.layout.simple_spinner_item,android.R.id.text1);

                    // Specify the layout to use when the list of choices appears
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    // Apply the adapter to the spinner
                    this.spcity.setAdapter(adapter);

                    break;

            }
        }

        @Override
    public void onNothingSelected(AdapterView<?> parent) {
            // Callback method to be invoked when the selection disappears from this
            // view. The selection can disappear for instance when touch is
            // activated or when the adapter becomes empty.
        }


    private void loadSpinnerProvincias() {

        // Create an ArrayAdapter using the string array and a default spinner
        // layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ciudades, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        this.spcity.setAdapter(adapter);

        // This activity implements the AdapterView.OnItemSelectedListener
        this.spcity.setOnItemSelectedListener(this);

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
