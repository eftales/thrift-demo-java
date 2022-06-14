package server;

import org.apache.thrift.TException;
import thrift.ConService;
import thrift.DeviceMSGThrift;
import thrift.SafeParamThrift;

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
}

