package admin.trunghq.useinputcontrols;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToogleActiviy extends AppCompatActivity {
    ToggleButton toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toogle_activiy);
        toggle = (ToggleButton) findViewById(R.id.my_toggle);
        toggle.setChecked(true);
    }

    public void onToggleClick(View view) {


        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                StringBuffer onOff = new StringBuffer().append("On or off?");
                if (isChecked) {
                    //	The	toggle	is	enabled
                    onOff.append("ON");
                } else {
                    //	The	toggle	is	disabled
                    onOff.append("OFF");
                }
                Toast.makeText(getApplicationContext(), onOff.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
