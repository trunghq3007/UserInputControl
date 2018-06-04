package admin.trunghq.useinputcontrols;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * The type Content activity.
 */
public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
    }

    /**
     * Btn seek bar on click.
     *
     * @param view the view
     */
    public void btnSeekBarOnClick(View view) {
        // start SeekBarActivity
        startActivity(new SeekbarActivity());
    }

    public void btnCheckBoxOnClick(View view) {
        startActivity(new CheckBox());
    }

    public void btnToogleOnClick(View view) {
    }

    public void btnSpinnerOnClick(View view) {
    }

    public void btnSwitchOnclick(View view) {
    }

    private void startActivity(AppCompatActivity appCompatActivity) {
        // start activity
        Intent intent = new Intent(ContentActivity.this, appCompatActivity.getClass());
        startActivity(intent);
    }
}
