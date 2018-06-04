package admin.trunghq.useinputcontrols;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    //private Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
        //btnDisplay = (Button) findViewById(R.id.btnDisplay);
    }

    public void onRadioButtonClicked(View view) {
        //	Check to see if a button has been clicked.
        boolean checked = ((android.widget.RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.sameday:
                if (checked) {
                    Toast.makeText(this, "sameday", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nextday:
                if (checked) {
                    Toast.makeText(this, "nextday", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.pickup:
                if (checked) {
                    Toast.makeText(this, "pickup", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * Btn display on click.
     *
     * @param view the view
     */
    public void btnDisplayOnClick(View view) {
        // get selected radio button from radioGroup
        int selectedId = radioSexGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioSexButton = findViewById(selectedId);

        Toast.makeText(this,
                radioSexButton.getText(), Toast.LENGTH_SHORT).show();
    }
}
