package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    //服务器IP
    private static final String ip = "127.0.0.1";
    //服务器端口号
    private static final int port = 8099;
    //数据最大长度
    private static final int bleng = 1024;

    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("我：");
            String msg = sc.nextLine();

            //发送信息
            DatagramPacket datagramPacket = new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),
                    port
            );
            client.send(datagramPacket);

            //接收服务器返回的信息
            DatagramPacket serPacket = new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            client.receive(serPacket);
            //接收服务器端返回的信息
            String serMsg = new String(serPacket.getData());
            System.out.println("对方" + serMsg);
        }
    }
}
