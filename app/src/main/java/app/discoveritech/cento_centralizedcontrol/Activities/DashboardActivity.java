package app.discoveritech.cento_centralizedcontrol.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.zagori.bottomnavbar.BottomNavBar;

import app.discoveritech.cento_centralizedcontrol.Fragments.AccountFragment;
import app.discoveritech.cento_centralizedcontrol.Fragments.AddDeviceFragment;
import app.discoveritech.cento_centralizedcontrol.Fragments.HomeFragment;
import app.discoveritech.cento_centralizedcontrol.GeneralClasses.Global;
import app.discoveritech.cento_centralizedcontrol.R;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    public static TextView txt_mainToolbar;
    public static ImageView add_friend;
    private BottomNavBar.OnBottomNavigationListener mOnBottomNavItemSelectedListener;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        fm = getSupportFragmentManager();
        init();
    }

    private void init() {
        Global.mKProgressHUD = KProgressHUD.create(DashboardActivity.this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setDimAmount(0.7f).setAnimationSpeed(2).setLabel("Please Wait").setCancellable(true);

        Global.changeMainFragment(DashboardActivity.this, new HomeFragment(), "", "");
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        bottomNavSettings();

        BottomNavBar bottomNavView = findViewById(R.id.bottom_nav_view);
        bottomNavView.setBottomNavigationListener(mOnBottomNavItemSelectedListener);
        txt_mainToolbar = findViewById(R.id.main_toolbar_txt);
        add_friend = findViewById(R.id.add_friend);
        add_friend.setVisibility(View.GONE);
    }

    private void bottomNavSettings() {
        mOnBottomNavItemSelectedListener =
                new BottomNavBar.OnBottomNavigationListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_home:
                                fm.popBackStack();
                                fm.popBackStack();
                                Global.changeMainFragment(DashboardActivity.this, new HomeFragment(), "", "");
                                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                return true;
                            case R.id.navigation_add:
                                Global.changeMainFragment(DashboardActivity.this, new AddDeviceFragment(), "", "");
                                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                return true;
                            case R.id.navigation_profile:
                                Global.changeMainFragment(DashboardActivity.this, new AccountFragment(), "", "");
                                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                return true;
                        }
                        return false;
                    }
                };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    @Override
    public void onBackPressed() {
        if (!Global.device_back_tag.equals("HomeFragment")) {
            DashboardActivity.txt_mainToolbar.setText("Dashboard");
            Global.device_back_tag = "HomeFragment";
            fm.popBackStack();
        } else {
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}