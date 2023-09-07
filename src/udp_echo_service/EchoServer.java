package udp_echo_service;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class EchoServer {
    public static void main(String[] args) {
        DatagramSocket serverSocket = new DatagramSocket(port:3000);
        DatagramPacket clientRequest = new DatagramPacket(new byte[1024], length:1024);
        serverSocket.recieve(clientRequest);
        byte[] content = clientRequest.getData();
        System.out.println(new String(content));


        InetAddress clientIP = clientRequest.getAddress();
        DatagramPacket serverReply = new DatagramPacket(content, content.length, clientIP, clientPort);
        serverSocket.send(serverReply);
        serverSocket.close();

    }catch(socketException e){
        e.printStackTrace();

    }catch(IOException e){
        e.printStackTrace();
    }
}
