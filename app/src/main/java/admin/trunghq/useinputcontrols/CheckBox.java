package admin.trunghq.useinputcontrols;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * @author Hà Quang Trung
 * @version 1.0.0
 * @description
 * @desc Technical Director, FPT-Software.
 * @created ${Date}
 * @updated ${Date}
 * @modified by
 * @updated on ${Date}
 * @since 1.0
 */
public class CheckBox extends AppCompatActivity {


    private static final String DEBUG_TAG = "DEBUG_TAG";
    android.widget.CheckBox chocolate;
    android.widget.CheckBox sprinkles;
    android.widget.CheckBox nuts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_box);
        chocolate = findViewById(R.id.checkbox1_chocolate);
        sprinkles = findViewById(R.id.checkbox2_sprinkles);
        nuts = findViewById(R.id.checkbox3_nuts);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Log.d(DEBUG_TAG, "Action	was	DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE):
                Log.d(DEBUG_TAG, "Action	was	MOVE");
                return true;
            case (MotionEvent.ACTION_UP):
                Log.d(DEBUG_TAG, "Action	was	UP");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Log.d(DEBUG_TAG, "Action	was	CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                Log.d(DEBUG_TAG, "Movement	occurred	outside	bounds	" + "of	current	screen	element");
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

    /**
     * Btn submit onclick.
     *
     * @param view the view
     */
    public void btnSubmitOnclick(View view) {

        StringBuffer toppings = new StringBuffer().append("Content: ");
        if (chocolate.isChecked()) {
            toppings.append("chocolate ");
        }
        if (sprinkles.isChecked()) {
            toppings.append("sprinkles ");
        }
        if (nuts.isChecked()) {
            toppings.append("nuts ");
        }
        Toast.makeText(this, toppings, Toast.LENGTH_SHORT).show();
    }
}
