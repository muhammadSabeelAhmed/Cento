package app.discoveritech.cento_centralizedcontrol.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.shashank.sony.fancytoastlib.FancyToast;

import app.discoveritech.cento_centralizedcontrol.Activities.DashboardActivity;
import app.discoveritech.cento_centralizedcontrol.GeneralClasses.Global;
import app.discoveritech.cento_centralizedcontrol.R;

import static app.discoveritech.cento_centralizedcontrol.GeneralClasses.Global.categories;

public class AddDeviceFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    TextView btn_addDevice;
    View v;
    CardView btn_addConnect;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Global.device_back_tag = "AddDeviceFragment";
        DashboardActivity.txt_mainToolbar.setText("Add Device");
        DashboardActivity.add_friend.setVisibility(View.GONE);
        v = inflater.inflate(R.layout.fragment_add_device, container, false);
        initSpinner();
        init();
        return v;
    }

    private void init() {

        btn_addDevice = v.findViewById(R.id.txt_addDevice);
        btn_addDevice.setOnClickListener(this);

        btn_addConnect = v.findViewById(R.id.btn_Addconnect);
        btn_addConnect.setOnClickListener(this);
    }

    private void initSpinner() {
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        categories.clear();
        // Spinner Drop down elements
        categories.add("Device Category");
        categories.add("Fan");
        categories.add("Lights");
        categories.add("Air Conditioner");
/*
        categories.add("Room Cooler");
*/
        categories.add("Gate Lock");
        categories.add("Television");
        categories.add("Smart Phone");
/*        categories.add("Fridge/Freezer");
        categories.add("Microwave Own");
        categories.add("Desktop Computer");
        categories.add("Laptop");
        categories.add("Smart Watch");
        categories.add("Vehicle");*/

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_addDevice:
                Toast.makeText(getActivity(),"Device added successfully",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_Addconnect:
                Global.changeMainFragment(getActivity(), new ConnectionFragment(), "", "");
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
        }
    }
}