package app.discoveritech.cento_centralizedcontrol.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.discoveritech.cento_centralizedcontrol.Activities.DashboardActivity;
import app.discoveritech.cento_centralizedcontrol.GeneralClasses.Global;
import app.discoveritech.cento_centralizedcontrol.R;

public class SubscriptionFragment extends Fragment {
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Global.device_back_tag = "SubscriptionFragment";
        DashboardActivity.txt_mainToolbar.setText("Offers & Subscriptions");
        DashboardActivity.add_friend.setVisibility(View.GONE);
        v = inflater.inflate(R.layout.fragment_subscription, container, false);
        return v;
    }
}