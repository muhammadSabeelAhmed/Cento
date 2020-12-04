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
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "ON", "", "Bedroom - 1", "cento-001", "Connected","F12"));
        Global.devicesList.add(new Devices("Bulb", "" + new Date(), "Null", "", "Bedroom - 1", "cento-002", "Disconnected","F12"));
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "ON", "", "TV Lounge", "cento-003", "Connected","F12"));
        Global.devicesList.add(new Devices("Television", "" + new Date(), "Null", "", "TV Lounge", "cento-004", "Disconnected","G1"));
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "ON", "", "Drawing Room", "cento-005", "Connected","S11"));
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "OFF", "", "Kitchen", "cento-006", "Connected","S12"));
        Global.devicesList.add(new Devices("Bulb", "" + new Date(), "ON", "", "Kitchen", "cento-007", "Connected","F12"));
        Global.devicesList.add(new Devices("Fridge", "" + new Date(), "ON", "", "Kitchen", "cento-008", "Connected","F12"));
        Global.devicesList.add(new Devices("Gate Lock", "" + new Date(), "Closed", "", "Main Gate", "cento-009", "Connected","M1"));
        Global.devicesList.add(new Devices("Gate Lock", "" + new Date(), "Null", "", "Stairs Gate", "cento-010", "Disconnected","M2"));
        Global.devicesList.add(new Devices("Gate Lock", "" + new Date(), "Open", "", "Roof Gate", "cento-011", "Connected","ML"));
        Global.devicesList.add(new Devices("Gate Lock", "" + new Date(), "Null", "", "Drawing Room Gate", "cento-0012", "Disconnected","M3"));
        Global.devicesList.add(new Devices("Gate Lock", "" + new Date(), "Open", "", "Bedroom - 1 Gate", "cento-013", "Connected","F12"));
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