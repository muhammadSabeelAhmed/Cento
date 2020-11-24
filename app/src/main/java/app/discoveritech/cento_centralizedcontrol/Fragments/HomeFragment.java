package app.discoveritech.cento_centralizedcontrol.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import app.discoveritech.cento_centralizedcontrol.Activities.DashboardActivity;
import app.discoveritech.cento_centralizedcontrol.GeneralClasses.Global;
import app.discoveritech.cento_centralizedcontrol.R;

import static app.discoveritech.cento_centralizedcontrol.Activities.DashboardActivity.txt_mainToolbar;

public class HomeFragment extends Fragment implements View.OnClickListener {
    CardView schedules, membership, devices, socials, support, active_devices;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_home, container, false);
        DashboardActivity.add_friend.setVisibility(View.GONE);
        init();
        return v;
    }

    private void init() {
        schedules = v.findViewById(R.id.btn_schedules);
        membership = v.findViewById(R.id.btn_membership);
        devices = v.findViewById(R.id.btn_devices);
        socials = v.findViewById(R.id.btn_social);
        support = v.findViewById(R.id.btn_support);
        active_devices = v.findViewById(R.id.btn_activeDevices);

        schedules.setOnClickListener(this);
        membership.setOnClickListener(this);
        devices.setOnClickListener(this);
        socials.setOnClickListener(this);
        support.setOnClickListener(this);
        active_devices.setOnClickListener(this);

        Global.device_back_tag = "HomeFragment";
        txt_mainToolbar.setText("Dashboard");

        if (Global.mKProgressHUD.isShowing()) {
            Global.mKProgressHUD.dismiss();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_devices:
                Global.changeMainFragment(getActivity(), new DevicesFragment(), "", "");
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.btn_schedules:
                Global.changeMainFragment(getActivity(), new ScheduleFragment(), "", "");
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.btn_membership:
                Global.changeMainFragment(getActivity(), new SubscriptionFragment(), "", "");
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.btn_social:
                Global.changeMainFragment(getActivity(), new UsageFragment(), "", "");
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.btn_support:
                Global.changeMainFragment(getActivity(), new TechSupportFragment(), "", "");
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.btn_activeDevices:
                Global.changeMainFragment(getActivity(), new ActiveFragment(), "", "");
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
        }
    }
}