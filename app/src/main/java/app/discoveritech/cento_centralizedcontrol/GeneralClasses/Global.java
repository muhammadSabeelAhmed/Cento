package app.discoveritech.cento_centralizedcontrol.GeneralClasses;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import app.discoveritech.cento_centralizedcontrol.Model.Devices;
import app.discoveritech.cento_centralizedcontrol.R;

public class Global {
    public static String device_back_tag = "";
    public static KProgressHUD mKProgressHUD;
    public static ArrayList<Devices> devicesList = new ArrayList<>();
    public static List<String> categories = new ArrayList<String>();
    public static List<String> devices = new ArrayList<String>();
    public static ArrayList<String> itemSettings = new ArrayList<>();

    public static void changeMainFragment(Context context, Fragment fragment, String key, String value) {
        if (!key.isEmpty()) {
            Bundle i = new Bundle();
            i.putString(key, value);
            fragment.setArguments(i);
        }
        FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fadein,
                R.anim.fadeout);
        transaction.replace(R.id.main_frame, fragment);
        transaction.addToBackStack(device_back_tag);
        transaction.commit();
    }
}
