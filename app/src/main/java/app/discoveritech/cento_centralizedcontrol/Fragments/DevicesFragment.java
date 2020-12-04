package app.discoveritech.cento_centralizedcontrol.Fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import app.discoveritech.cento_centralizedcontrol.Activities.DashboardActivity;
import app.discoveritech.cento_centralizedcontrol.GeneralClasses.Global;
import app.discoveritech.cento_centralizedcontrol.R;

public class DevicesFragment extends Fragment implements View.OnClickListener {
    View v;
    CardView add_devices, all_devices, control_devices, remove_devices;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Global.device_back_tag = "DevicesFragment";
        DashboardActivity.txt_mainToolbar.setText("Devices");
        DashboardActivity.add_friend.setVisibility(View.GONE);
        v = inflater.inflate(R.layout.fragment_devices, container, false);
        init();
        return v;
    }

    private void init() {
        add_devices = v.findViewById(R.id.btn_addDevices);
        all_devices = v.findViewById(R.id.btn_allDevices);
        control_devices = v.findViewById(R.id.btn_controlDevices);
        remove_devices = v.findViewById(R.id.btn_removeDevices);

        add_devices.setOnClickListener(this);
        all_devices.setOnClickListener(this);
        control_devices.setOnClickListener(this);
        remove_devices.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_addDevices:
                Global.changeMainFragment(getActivity(), new AddDeviceFragment(), "", "");
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.btn_controlDevices:
                Global.changeMainFragment(getActivity(), new ControlFragment(), "", "");
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.btn_allDevices:
                Global.changeMainFragment(getActivity(), new AllDevicesFragment(), "", "");
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.btn_removeDevices:
                Global.changeMainFragment(getActivity(), new InActiveFragment(), "", "");
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
        }
    }
}