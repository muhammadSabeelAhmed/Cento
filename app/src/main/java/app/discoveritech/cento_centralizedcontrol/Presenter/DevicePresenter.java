package app.discoveritech.cento_centralizedcontrol.Presenter;

import app.discoveritech.cento_centralizedcontrol.View.IDevicesView;

public class DevicePresenter implements IDevicePresenter {
    IDevicesView devicesView;

    DevicePresenter(IDevicesView devicesView) {
        this.devicesView = devicesView;
    }

    @Override
    public void onDevices() {

    }
}
