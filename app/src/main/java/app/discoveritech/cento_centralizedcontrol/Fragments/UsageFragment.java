package app.discoveritech.cento_centralizedcontrol.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;

import java.util.ArrayList;
import java.util.List;

import app.discoveritech.cento_centralizedcontrol.Activities.DashboardActivity;
import app.discoveritech.cento_centralizedcontrol.GeneralClasses.Global;
import app.discoveritech.cento_centralizedcontrol.R;

public class UsageFragment extends Fragment {
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Global.device_back_tag = "UsageFragment";
        DashboardActivity.txt_mainToolbar.setText("Social Ranking");
        DashboardActivity.add_friend.setVisibility(View.VISIBLE);
        v = inflater.inflate(R.layout.fragment_usage, container, false);
        init();
        return v;
    }

    private void init() {
        AnyChartView anyChartView = v.findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(v.findViewById(R.id.progress_bar));
        Cartesian cartesian = AnyChart.column();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Shahzad", 4));
        data.add(new ValueDataEntry("Sharjeel", 6));
        data.add(new ValueDataEntry("Anil", 7));
        data.add(new ValueDataEntry("Mudassir", 8));
        data.add(new ValueDataEntry("Maaz", 10));
        data.add(new ValueDataEntry("Sabeel", 11));
        data.add(new ValueDataEntry("Arsalan", 13));
        data.add(new ValueDataEntry("Ahmed", 16));
        data.add(new ValueDataEntry("Saad", 19));

        Column column = cartesian.column(data);
        column.color("#C7041D");
        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("{%Value}{groupsSeparator: } Devices");

        cartesian.animation(true);
        cartesian.title("Ranking by registered devices");

        cartesian.yScale().minimum(0d);

        cartesian.yAxis(0).labels().format("Devices {%Value}{groupsSeparator: }");

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);

        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title("Friends");
        cartesian.yAxis(0).title("Total Devices");

        anyChartView.setChart(cartesian);
    }
}