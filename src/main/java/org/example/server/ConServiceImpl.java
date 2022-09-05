package org.example.server;

import org.apache.thrift.TException;
import org.example.thrift.ConService;
import org.example.thrift.DeviceMSGThrift;
import org.example.thrift.SafeParamThrift;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by pfliu on 2019/03/28.
 */
public class ConServiceImpl implements ConService.Iface {


    @Override
    public Map<String, DeviceMSGThrift> getTopo() throws TException {
        Map<String, DeviceMSGThrift> topo = new HashMap<>();
        String macStr = "11:22:33:44:55:66";
        DeviceMSGThrift deviceMSG = new DeviceMSGThrift();
        deviceMSG.type = 1;
        topo.put(macStr,deviceMSG);
        return topo;
    }

    @Override
    public Map<String, SafeParamThrift> getSafeParam() throws TException {
        return null;
    }

    @Override
    public byte getCMode() throws TException {
        return 0;
    }

    @Override
    public byte setCMode(byte mode) throws TException {
        return 0;
    }

    @Override
    public byte fetchFlowData() throws TException {
        return 0;
    }

    @Override
    public byte fetchNetEvent() throws TException {
        return 0;
    }

    @Override
    public byte setRandNumLoopDelay(int delay) throws TException {
        return 0;
    }

    @Override
    public byte setRandNumDelay(byte delay) throws TException {
        return 0;
    }

    @Override
    public byte addMACAuthDevice(String mac, String colonyID) throws TException {
        return 0;
    }

    @Override
    public byte addPEAPAuthDevice(String mac, String colonyID, String userName, String password) throws TException {
        return 0;
    }
}

