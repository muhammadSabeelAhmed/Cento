package app.discoveritech.cento_centralizedcontrol.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.discoveritech.cento_centralizedcontrol.Activities.DashboardActivity;
import app.discoveritech.cento_centralizedcontrol.GeneralClasses.Global;
import app.discoveritech.cento_centralizedcontrol.R;

public class ConnectionFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Global.device_back_tag = "ConnectionFragment";
        DashboardActivity.txt_mainToolbar.setText("Device Connection Settings");
        DashboardActivity.add_friend.setVisibility(View.GONE);
        return inflater.inflate(R.layout.fragment_connection, container, false);
    }
}
