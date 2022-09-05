package org.example.server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.example.thrift.ConService;


/**
 * Created by huyanshi on 2019/03/28.
 */
public class Server {


    private void startServer() {
        ConService.Processor processor = new ConService.Processor<ConService.Iface>(new ConServiceImpl());
        try {
            TServerTransport transport = new TServerSocket(2022);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
            tArgs.processor(processor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            tArgs.transportFactory(new TTransportFactory());
            tArgs.minWorkerThreads(10);
            tArgs.maxWorkerThreads(20);
            TServer server = new TThreadPoolServer(tArgs);
            System.out.println("Server started.");
            server.serve();
        } catch (Exception e) {
            System.out.println("thrift服务启动失败");
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
    }
}
