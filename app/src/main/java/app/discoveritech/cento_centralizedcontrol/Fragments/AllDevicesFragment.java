package app.discoveritech.cento_centralizedcontrol.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;

import app.discoveritech.cento_centralizedcontrol.Activities.DashboardActivity;
import app.discoveritech.cento_centralizedcontrol.Adapter.DevicesAdapter;
import app.discoveritech.cento_centralizedcontrol.GeneralClasses.Global;
import app.discoveritech.cento_centralizedcontrol.Model.Devices;
import app.discoveritech.cento_centralizedcontrol.R;

public class AllDevicesFragment extends Fragment {
    RecyclerView devices_recycler;
    DevicesAdapter devicesAdapter;
    ArrayList<Devices> devicesList = new ArrayList<>();
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_all_devices, container, false);
        Global.device_back_tag = "AllDevicesFragment";
        DashboardActivity.add_friend.setVisibility(View.GONE);
        DashboardActivity.txt_mainToolbar.setText("All Devices");
        init();
        return v;
    }

    private void init() {
        devicesList.clear();
        Global.devicesList.clear();
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "Null", "", "Bedroom - 1", "cento-001", "Disconnected","HSB1"));
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "HIGH", "", "Bedroom - 1", "cento-001", "Connected","HSB1"));
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "LOW", "", "TV Lounge", "cento-003", "Connected","HSB1"));
        Global.devicesList.add(new Devices("Door", "" + new Date(), "Closed", "", "Front Garage Door", "cento-005", "Connected","HSB1"));
        Global.devicesList.add(new Devices("Air Conditioner", "" + new Date(), "Null", "", "PEL 2-Ton Inverter", "cento-006", "Disconnected","HSB1"));
        Global.devicesList.add(new Devices("Speaker", "" + new Date(), "Vol 45", "", "Bluetooth Ceiling Stereo Speakers ", "cento-007", "Connected","HSB1"));
        Global.devicesList.add(new Devices("Fridge", "" + new Date(), "ON", "", "Kitchen", "cento-008", "Connected","HSB1"));
        Global.devicesList.add(new Devices("Television", "" + new Date(), "OFF", "", "TV Lounge", "cento-009", "Connected","HSB1")); devicesList.addAll(Global.devicesList);
        Global.devicesList.add(new Devices("Door", "" + new Date(), "Null", "", "Front Garage Door", "cento-005", "Disconnected","HSB1"));
        Global.devicesList.add(new Devices("Air Conditioner", "" + new Date(), "OFF", "", "PEL 2-Ton Inverter", "cento-006", "Connected","HSB1"));
        Global.devicesList.add(new Devices("Speaker", "" + new Date(), "Null", "", "Bluetooth Ceiling Stereo Speakers ", "cento-007", "Disconnected","HSB1"));
        Global.devicesList.add(new Devices("Television", "" + new Date(), "OFF", "", "TV Lounge 1", "cento-009", "Connected","HSB1")); devicesList.addAll(Global.devicesList);

        devicesList.addAll(Global.devicesList);

        devices_recycler = v.findViewById(R.id.schedule_recycler);
        devicesAdapter = new DevicesAdapter(devicesList, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        devices_recycler.setLayoutManager(mLayoutManager);
        devices_recycler.setItemAnimator(new DefaultItemAnimator());
        devices_recycler.setAdapter(devicesAdapter);
        devicesAdapter.notifyDataSetChanged();
    }
}