package admin.trunghq.useinputcontrols;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Content2Activity extends AppCompatActivity {


    ProgressDialog progressDoalog;
    Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressDoalog.incrementProgressBy(1);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content2);
    }

    public void btnDialogProgressClick(View view) {
        progressDoalog = new ProgressDialog(this);

        progressDoalog.setMax(100);
        //  progressDoalog.setProgress();
        progressDoalog.setMessage("Its loading....");
        progressDoalog.setCancelable(false);
        progressDoalog.setTitle("ProgressDialog bar example");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDoalog.show();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (progressDoalog.getProgress() <= progressDoalog
                            .getMax()) {
                        Thread.sleep(200);
                        handle.sendMessage(handle.obtainMessage());
                        if (progressDoalog.getProgress() == progressDoalog
                                .getMax()) {
                            progressDoalog.dismiss();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void showDatePickerActivity(View view) {
        startActivity(new DatePickerActivity());
    }

    private void startActivity(AppCompatActivity appCompatActivity) {
        // start activity
        Intent intent = new Intent(Content2Activity.this, appCompatActivity.getClass());
        startActivity(intent);
    }
}
