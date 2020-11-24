package app.discoveritech.cento_centralizedcontrol.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;

import app.discoveritech.cento_centralizedcontrol.Model.Devices;
import app.discoveritech.cento_centralizedcontrol.R;

public class ManageDevicesAdapter extends RecyclerView.Adapter<ManageDevicesAdapter.ViewHolder> {
    private List<Devices> devicesList;
    Context context;


    public ManageDevicesAdapter(List<Devices> devices, Context context) {
        this.context = context;
        devicesList = devices;
    }

    @NonNull
    @Override
    public ManageDevicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.manage_devices_list, parent, false);
        ManageDevicesAdapter.ViewHolder vh = new ManageDevicesAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ManageDevicesAdapter.ViewHolder holder, int position) {
        holder.device_name.setText(devicesList.get(position).getName());
        holder.device_update.setText(devicesList.get(position).getLastUpdate());
        holder.device_location.setText(devicesList.get(position).getLocation());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }

    @Override
    public int getItemCount() {
        return devicesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView device_name, device_update, device_location;
        LottieAnimationView view;

        public ViewHolder(View v) {
            super(v);
            device_name = v.findViewById(R.id.manage_dev_name);
            device_location = v.findViewById(R.id.manage_dev_location);
            view = v.findViewById(R.id.manage_dev_toggle);
            device_update = v.findViewById(R.id.manage_dev_updated);
        }
    }
}
