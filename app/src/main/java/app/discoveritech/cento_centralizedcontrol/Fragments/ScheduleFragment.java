package app.discoveritech.cento_centralizedcontrol.Fragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import app.discoveritech.cento_centralizedcontrol.Activities.DashboardActivity;
import app.discoveritech.cento_centralizedcontrol.GeneralClasses.Global;
import app.discoveritech.cento_centralizedcontrol.Model.Devices;
import app.discoveritech.cento_centralizedcontrol.R;

import static app.discoveritech.cento_centralizedcontrol.GeneralClasses.Global.categories;
import static app.discoveritech.cento_centralizedcontrol.GeneralClasses.Global.devicesList;

public class ScheduleFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    View v;
    ArrayList<String> devices = new ArrayList<>();
    Calendar now;
    TextView selected_date, end_date;
    TextView btn_schedule, btn_routine;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Global.device_back_tag = "ScheduleFragment";
        DashboardActivity.txt_mainToolbar.setText("Schedule Task");
        DashboardActivity.add_friend.setVisibility(View.GONE);
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_schedule, container, false);
        init();
        return v;
    }

    private void init() {
        now = Calendar.getInstance();
        Spinner spinner = (Spinner) v.findViewById(R.id.schedule_spinner);
        selected_date = v.findViewById(R.id.selected_date);
        end_date = v.findViewById(R.id.end_date);
        btn_schedule = v.findViewById(R.id.btn_schedule);
        btn_routine = v.findViewById(R.id.btn_routine);

        btn_schedule.setOnClickListener(this);
        btn_routine.setOnClickListener(this);
        selected_date.setOnClickListener(this);
        end_date.setOnClickListener(this);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        Global.devicesList.clear();
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "ON", "", "Bedroom - 1", "cento-001", "Connected"));
        Global.devicesList.add(new Devices("Bulb", "" + new Date(), "Unknown", "", "Bedroom - 1", "cento-002", "Disconnected"));
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "ON", "", "TV Lounge", "cento-003", "Connected"));
        Global.devicesList.add(new Devices("Television", "" + new Date(), "Unknown", "", "TV Lounge", "cento-004", "Disconnected"));
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "ON", "", "Drawing Room", "cento-005", "Connected"));
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "OFF", "", "Kitchen", "cento-006", "Connected"));
        Global.devicesList.add(new Devices("Bulb", "" + new Date(), "ON", "", "Kitchen", "cento-007", "Connected"));
        Global.devicesList.add(new Devices("Fridge", "" + new Date(), "ON", "", "Kitchen", "cento-008", "Connected"));
        Global.devicesList.add(new Devices("Gate Lock", "" + new Date(), "Locked", "", "Main Gate", "cento-009", "Connected"));
        Global.devicesList.add(new Devices("Gate Lock", "" + new Date(), "Unknown", "", "Stairs Gate", "cento-010", "Disconnected"));
        Global.devicesList.add(new Devices("Gate Lock", "" + new Date(), "Unlocked", "", "Roof Gate", "cento-011", "Connected"));
        Global.devicesList.add(new Devices("Gate Lock", "" + new Date(), "Unknown", "", "Drawing Room Gate", "cento-0012", "Disconnected"));
        Global.devicesList.add(new Devices("Gate Lock", "" + new Date(), "Unlocked", "", "Bedroom - 1 Gate", "cento-013", "Connected"));
        devices.clear();
        devices.add("Select Device");
        for (int i = 0; i <= devicesList.size() - 1; i++) {
            if (devicesList.get(i).getConn().equals("Connected")) {
                devices.add(devicesList.get(i).getName() + " | " + devicesList.get(i).getDevice_id());
            }
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simple_spinner_item, devices);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.selected_date:
                dateTimePicker(selected_date);
                break;
            case R.id.end_date:
                dateTimePicker(end_date);
                break;
            case R.id.btn_routine:
                Toast.makeText(getActivity(), "Routine task added successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_schedule:
                Toast.makeText(getActivity(), "Schedule task added successfully", Toast.LENGTH_SHORT).show();
        }
    }


    private void dateTimePicker(TextView textView) {
        final int year = now.get(Calendar.YEAR);
        final int month = now.get(Calendar.MONTH);
        final int day = now.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(final DatePicker view, final int year, final int month,
                                  final int dayOfMonth) {
                @SuppressLint("SimpleDateFormat")
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                now.set(year, month, dayOfMonth);
                String dateString = sdf.format(now.getTime());

                TimePickerDialog mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("TimeChecker", "Time");
                        String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
                        String minuteString = minute < 10 ? "0" + minute : "" + minute;
                        String time = hourString + ":" + minuteString;
                        textView.setText(dateString + ", " + time);
                    }
                }, now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        true);
                mTimePicker.show();
            }
        }, year, month, day).show(); // set date picker to current date
    }
}