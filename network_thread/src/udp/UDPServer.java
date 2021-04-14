package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    //端口号
    private static final int port = 8099;

    //数据的最大值
    private static final int bleng = 1024;

    public static void main(String[] args) throws IOException {
        //启动一个UDP服务器端
        DatagramSocket socket = new DatagramSocket();
        System.out.println("服务器已启动");
        while(true) {
            //初始化数据包
            DatagramPacket clientPacket = new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            //等待客户端的连接
            socket.receive(clientPacket);

            //接收到客户端的信息
            String msg = new String(clientPacket.getData());
            System.out.println("接收到客户端信息：" + msg);

            //给客户端回应
            String serMsg = "我收到了";

            DatagramPacket serPacket = new DatagramPacket(
                    serMsg.getBytes(),
                    serMsg.getBytes().length,
                    clientPacket.getAddress(),//地址
                    clientPacket.getPort() //端口号
            );

            socket.send(serPacket);
        }

    }
    
}
