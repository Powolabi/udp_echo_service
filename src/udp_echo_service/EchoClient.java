package udp_echo_service;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class EchoClient {
    public static void main(string[] args) throws Exception{
        if(args.length != 2){
            System.out.println("Syntax: EchoClient <serverIP> <serverPort>");
            return;
        }
    }

    InetAddress serverIP = InetAddress,getByName(args[0]);
    int serverPort = Interger.parseInt(args[1]);

    Scanner keyboard = new Scanner(System.in);
    String message = Keyboard.nextLine();



    //create & send  the request packet to server
    DatagramSocket socket = new DatagramSocket();
    DatgramPacket request = new DatagramPacket(message.getBytes(), message.getBytes().length,
            serverIP,
            serverPort
    );
    socket.send(request);

    //receive & process server reply

    DatagramPacket reply = new DatagramPacket(new Byte[1024], 1024);
    socket.recieve(reply);
    byte[] serverMessage = reply.getData();
    System.out.println(new String(serverMessage));
    socket.close();
}
