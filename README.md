# thrif-demo-java

编译&运行客户端
```bash
mvn clean package assembly:single
java -jar target/thrift-demo-1.0-SNAPSHOT-jar-with-dependencies.jar
```

输出：
```text
{11:22:33:44:55:66=DeviceMSGThrift(type:1, state:0, authTime:0, dhcpTime:0, ip:null, colonyID:null, swCapability:0, forwardCapability:0, portNum:0, peers:null, portCapability:null, portState:null, portRate:null, key:null)}
```


请在 IDEA 里面启动服务端 🤦‍♀️
