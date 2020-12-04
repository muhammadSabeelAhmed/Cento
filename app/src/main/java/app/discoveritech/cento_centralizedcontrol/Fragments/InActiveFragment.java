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

public class InActiveFragment extends Fragment {
    View v;
    RecyclerView devices_recycler;
    DevicesAdapter devicesAdapter;
    ArrayList<Devices> devicesList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Global.device_back_tag = "InActiveFragment";
        DashboardActivity.add_friend.setVisibility(View.GONE);
        DashboardActivity.txt_mainToolbar.setText("In-Active Devices");
        v = inflater.inflate(R.layout.fragment_in_active, container, false);
        init();
        return v;
    }


    private void init() {
        devicesList.clear();
        Global.devicesList.clear();
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "Null", "", "Bedroom - 1", "cento-001", "Disconnected","HSB1"));
        Global.devicesList.add(new Devices("Air Conditioner", "" + new Date(), "Null", "", "PEL 2-Ton Inverter", "cento-006", "Disconnected","HSB1"));
        Global.devicesList.add(new Devices("Door", "" + new Date(), "Null", "", "Front Garage Door", "cento-005", "Disconnected","HSB1"));
        Global.devicesList.add(new Devices("Speaker", "" + new Date(), "Null", "", "Bluetooth Ceiling Stereo Speakers ", "cento-007", "Disconnected","HSB1"));
        devicesList.addAll(Global.devicesList);

        devicesList.addAll(Global.devicesList);

        devices_recycler = v.findViewById(R.id.inactive_recycler);
        devicesAdapter = new DevicesAdapter(devicesList, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        devices_recycler.setLayoutManager(mLayoutManager);
        devices_recycler.setItemAnimator(new DefaultItemAnimator());
        devices_recycler.setAdapter(devicesAdapter);
        devicesAdapter.notifyDataSetChanged();
    }
}