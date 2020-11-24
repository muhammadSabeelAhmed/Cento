package app.discoveritech.cento_centralizedcontrol.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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
        holder.device_name.setText(devicesList.get(position).getName());
        holder.device_lcoation.setText(devicesList.get(position).getLocation());

        if (devicesList.get(position).getStatus().equals("OFF") || devicesList.get(position).getStatus().equals("Unlocked") || devicesList.get(position).getStatus().equals("Unknown")) {
            holder.device_status.setTextColor(Color.parseColor("#C7041D"));
        } else {
            holder.device_status.setTextColor(Color.parseColor("#50C100"));
        }
        holder.device_status.setText(devicesList.get(position).getStatus());
        holder.device_update.setText(devicesList.get(position).getLastUpdate());
        holder.device_id.setText(devicesList.get(position).getDevice_id());
        if (devicesList.get(position).getConn().equals("Disconnected")) {
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
//                Global.mKProgressHUD.show();
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
        TextView device_name, device_status, device_update, device_id, device_conn, device_lcoation;

        public ViewHolder(View v) {
            super(v);
            view_changer = v.findViewById(R.id.view_changer);
            devices_card = v.findViewById(R.id.devices_card);
            device_name = v.findViewById(R.id.device_name);
            device_status = v.findViewById(R.id.device_status);
            device_update = v.findViewById(R.id.device_updated);
            device_id = v.findViewById(R.id.device_id);
            device_conn = v.findViewById(R.id.device_conn);
            device_lcoation = v.findViewById(R.id.device_location);
        }
    }
}
