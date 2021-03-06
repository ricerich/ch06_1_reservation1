package com.example.ch06_1_reservation;


import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
//    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
//    CalendarView calView;

    DatePicker dPicker;//새로 추가
    TimePicker tPicker;

    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

//    int selectYear, selectMonth, selectDay;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간 예약");

        // 버튼
//        btnStart = (Button) findViewById(R.id.btnStart);
//        btnEnd = (Button) findViewById(R.id.btnEnd);

        // 크로노미터
        chrono = (Chronometer) findViewById(R.id.chronometer1);

        // 라디오버튼 2개
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        // FrameLayout의 2개 위젯
        tPicker = (TimePicker) findViewById(R.id.timePicker1);
//        calView = (CalendarView) findViewById(R.id.calendarView1);
        dPicker = (DatePicker) findViewById(R.id.datePicker1);

        // 텍스트뷰 중에서 연,월,일,시,분 숫자
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        // 처음에는 2개를 안보이게 설정
        tPicker.setVisibility(View.INVISIBLE);
//        calView.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);
        rdoCal.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);



        rdoCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
//                calView.setVisibility(View.VISIBLE);
                dPicker.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
//                calView.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
            }
        });

//        // 타이머 설정
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                chrono.setBase(SystemClock.elapsedRealtime());
//                chrono.start();
//                chrono.setTextColor(Color.RED);
//            }
//        });

        chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);

                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);

            }
        });

        // 버튼을 클릭하면 날짜,시간을 가져온다.
//        btnEnd.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                chrono.stop();
//                chrono.setTextColor(Color.BLUE);
//
//                tvYear.setText(Integer.toString(selectYear));
//                tvMonth.setText(Integer.toString(selectMonth));
//                tvDay.setText(Integer.toString(selectDay));
//
//                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
//                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
//            }
//        });

        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                chrono.stop();
                chrono.setTextColor(Color.BLUE);

//                tvYear.setText(Integer.toString(selectYear));
//                tvMonth.setText(Integer.toString(selectMonth));
//                tvDay.setText(Integer.toString(selectDay));
                tvYear.setText(Integer.toString(dPicker.getYear()));
                tvMonth.setText(Integer.toString(dPicker.getMonth() +1));
                tvDay.setText(Integer.toString(dPicker.getDayOfMonth()));

                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));

                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);

                dPicker.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);

                return false;
            }
        });

//        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                selectYear =  year;
//                selectMonth = month + 1;
//                selectDay = dayOfMonth;
//            }
//        });

    }

}
