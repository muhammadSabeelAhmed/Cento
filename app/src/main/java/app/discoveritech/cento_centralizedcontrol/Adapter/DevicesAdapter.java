package app.discoveritech.cento_centralizedcontrol.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.polyak.iconswitch.IconSwitch;

import java.util.List;

import app.discoveritech.cento_centralizedcontrol.GeneralClasses.Global;
import app.discoveritech.cento_centralizedcontrol.Model.Devices;
import app.discoveritech.cento_centralizedcontrol.R;

public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.ViewHolder> {
    private List<Devices> devicesList;
    Context context;

    public DevicesAdapter(List<Devices> devices, Context context) {
        this.context = context;
        devicesList = devices;
    }

    @NonNull
    @Override
    public DevicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.devices_list_show, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DevicesAdapter.ViewHolder holder, int position) {
        if (Global.device_back_tag.equals("ControlFragment")) {
            holder.control_switch.setVisibility(View.VISIBLE);
            holder.device_status.setVisibility(View.GONE);
        } else {
            holder.control_switch.setVisibility(View.GONE);
            holder.device_status.setVisibility(View.VISIBLE);
        }
        String id = devicesList.get(position).getDevice_id();
        String name = devicesList.get(position).getName();
        String location = devicesList.get(position).getLocation();
        String status = devicesList.get(position).getStatus();
        String area = devicesList.get(position).getDevice_area();
        String conn = devicesList.get(position).getConn();

        holder.device_name.setText(name);
        holder.device_lcoation.setText(location);
        holder.device_area.setText(area);
        holder.device_status.setText(status);
        holder.device_id.setText(id);

        if (status.equals("OFF") || status.equals("Open") || status.equals("Null")) {
            holder.control_switch.setChecked(IconSwitch.Checked.LEFT);
            holder.device_status.setTextColor(Color.parseColor("#777777"));
            Drawable res = context.getResources().getDrawable(R.drawable.card_bg_gray);
            Drawable greyButton = context.getResources().getDrawable(R.drawable.grey_control);
            holder.device_control.setBackground(greyButton);
            holder.devices_card.setBackground(res);
        } else {
            holder.control_switch.setChecked(IconSwitch.Checked.RIGHT);
            Drawable greenButton = context.getResources().getDrawable(R.drawable.green_control);
            holder.device_control.setBackground(greenButton);
            holder.device_status.setTextColor(Color.parseColor("#50C100"));
        }
        if (conn.equals("Disconnected")) {
            Drawable res = context.getResources().getDrawable(R.drawable.card_bg_gray);
            holder.devices_card.setBackground(res);
            holder.device_conn.setTextColor(Color.parseColor("#777777"));
            holder.device_conn.setText(devicesList.get(position).getConn());
        } else {
            Drawable res = context.getResources().getDrawable(R.drawable.card_bg_green);
            holder.devices_card.setBackground(res);
        }


        holder.devices_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.itemSettings.add(id);
                Global.itemSettings.add(name);
                Global.itemSettings.add(location);
                Global.itemSettings.add(status);
                Global.itemSettings.add(area);
                Global.itemSettings.add(conn);
                Toast.makeText(context, "TODO!", Toast.LENGTH_SHORT).show();

                //    Global.mKProgressHUD.show();
                // Global.changeMainFragment(context, new ControlFragment(), "", "");
            }
        });
    }

    @Override
    public int getItemCount() {
        return devicesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView devices_card;
        LinearLayout view_changer;
        TextView device_name, device_status, device_id, device_conn, device_lcoation, device_area, device_control;
        IconSwitch control_switch;

        public ViewHolder(View v) {
            super(v);
            view_changer = v.findViewById(R.id.view_changer);
            devices_card = v.findViewById(R.id.devices_card);
            device_name = v.findViewById(R.id.device_name);
            device_status = v.findViewById(R.id.device_status);
            device_id = v.findViewById(R.id.device_id);
            device_conn = v.findViewById(R.id.device_conn);
            device_lcoation = v.findViewById(R.id.device_location);
            device_area = v.findViewById(R.id.device_area);
            device_control = v.findViewById(R.id.device_control);
            control_switch = v.findViewById(R.id.icon_switch);
        }
    }
}
