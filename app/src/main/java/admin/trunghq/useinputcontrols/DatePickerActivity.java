package admin.trunghq.useinputcontrols;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatePickerActivity extends AppCompatActivity {
    Button btnChangeDate;
    Button btnChangeTime;
    TextView txtDate;
    TextView txtTime;
    Calendar cal;
    Date date;
    // Sự kiện khi click vào nút changedate
    View.OnClickListener showDatePicker = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
                //Sự kiện khi click vào nút Done trên Dialog
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    // Set text cho textView
                    txtDate.setText(day + "/" + (month + 1) + "/" + year);
                    //Lưu vết lại ngày mới cập nhật
                    cal.set(year, month, day);
                    date = cal.getTime();
                }
            };
            String s = txtDate.getText() + "";
            //Lấy ra chuỗi của textView Date
            String strArrtmp[] = s.split("/");
            int ngay = Integer.parseInt(strArrtmp[0]);
            int thang = Integer.parseInt(strArrtmp[1]) - 1;
            int nam = Integer.parseInt(strArrtmp[2]);
            //Hiển thị ra Dialog
            DatePickerDialog pic = new DatePickerDialog(
                    DatePickerActivity.this,
                    callback, nam, thang, ngay);
            pic.setTitle("Chọn ngày hoàn thành");
            pic.show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        SimpleDateFormat dft = null;
       /* txtTime = (TextView) findViewById(R.id.txtTime);
        btnChangeTime = (Button) findViewById(R.id.btnChangeTime);
        btnChangeTime.setOnClickListener(showTimePicker);
        //Định dạng giờ phút am/pm
        dft = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String strTime = dft.format(cal.getTime());
        //đưa lên giao diện
        txtTime.setText(strTime);
        //lấy giờ theo 24 để lập trình theo Tag
        dft = new SimpleDateFormat("HH:mm", Locale.getDefault());
        txtTime.setTag(dft.format(cal.getTime()));*/

        txtTime = (TextView) findViewById(R.id.txtTime);
        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
        btnChangeDate = (Button) findViewById(R.id.btnChangeDate);
        txtDate = (TextView) findViewById(R.id.txtDate);
        btnChangeDate.setOnClickListener(showDatePicker);

        //Set ngày giờ hiện tại khi mới chạy lần đầu
        cal = Calendar.getInstance();

        //Định dạng kiểu ngày / tháng /năm
        dft = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String strDate = dft.format(cal.getTime());
        //hiển thị lên giao diện
        txtDate.setText(strDate);
    }

    /**
     * Hàm hiển thị TimePickerDialog
     */
    public void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(DatePickerActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String s = hourOfDay + ":" + minute;
                int hourTam = hourOfDay;
                if (hourTam > 12)
                    hourTam = hourTam - 12;
                txtTime.setText
                        (hourTam + ":" + minute + (hourOfDay > 12 ? " PM" : " AM"));
                //lưu giờ thực vào tag
                txtTime.setTag(s);
            }
        }, hour, minute, true);
        timePickerDialog.setTitle("Chọn thời gian");
        timePickerDialog.show();
    }
}
