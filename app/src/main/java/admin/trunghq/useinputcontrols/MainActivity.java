package admin.trunghq.useinputcontrols;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    EditText edtUserName;
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.editPassword);
    }


    public void btnSignInClick(View view) {
        if (edtUserName.getText().toString().trim().equals("imic") && edtPassword.getText().toString().trim().equals("123456")) {
            Intent intent = new Intent(MainActivity.this, ContentActivity.class);
            startActivity(intent);
            // finish MainActivity
            finish();
        } else {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(this);
            }
            builder.setTitle("Access Denied")
                    .setCancelable(false)
                    .setMessage("Đăng nhập thất bại. Vui lòng đăng nhập lại")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }
                    })
                    /*.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })*/
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }
}
