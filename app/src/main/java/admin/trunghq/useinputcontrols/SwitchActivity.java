package admin.trunghq.useinputcontrols;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class SwitchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
    }

    public void onSwitchClick(View view) {
        Switch aSwitch = (Switch) findViewById(R.id.my_switch);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                StringBuffer onOff = new StringBuffer().append("On or off?");
                if (isChecked) {//	The	switch	is	enabled
                    onOff.append("ON	");
                } else {    //	The	switch	is	disabled
                    onOff.append("OFF	");
                }
                Toast.makeText(getApplicationContext(), onOff.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
