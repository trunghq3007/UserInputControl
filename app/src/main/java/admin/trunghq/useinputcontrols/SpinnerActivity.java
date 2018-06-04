package admin.trunghq.useinputcontrols;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        //Create	the	spinner.
        Spinner spinner = (Spinner) findViewById(R.id.label_spinner);


        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }


        //Create	ArrayAdapter	using	the	string	array	and	default	spinner	layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        //Specify	the	layout	to	use	when	the	list	of	choices	appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        //Apply	the	adapter	to	the	spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    /* @Override
     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

     }

     @Override
     public void onNothingSelected(AdapterView<?> parent) {

     }
 */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String spinner_item = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(this, spinner_item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
