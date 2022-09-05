package org.example.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.*;
import org.example.thrift.ConService;


/**
 * Created by huyanshi on 2019/03/28.
 */
public class Client {
    private static final String SERVER_IP = "192.168.26.143";
    private static final int SERVER_PORT = 2022;//Thrift server listening port

    private void startClient() {
        TTransport transport = null;
        try {
            transport = new TSocket(SERVER_IP,SERVER_PORT);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            ConService.Client client = new ConService.Client(protocol);
            transport.open();
            System.out.println(client.getTopo());
            System.out.println(client.setCMode((byte) 1));
            System.out.println(client.fetchFlowData());
            System.out.println(client.fetchNetEvent());
            System.out.println(client.addMACAuthDevice("0x112233445566","0x000001")); // 现在必须是 0x112233445566 这种格式，之后会更改为 11:22:33:11:22:33
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.startClient();
    }

}
