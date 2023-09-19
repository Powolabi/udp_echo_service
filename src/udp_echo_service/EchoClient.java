package udp_echo_service;
import java.net.*;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Syntax: EchoClient <serverIP> <serverPort>");
            return;
        }

        int serverPort = Integer.parseInt(args[1]);
        String serverIp = args[0];

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 'date' or 'time': ");
            String request = scanner.nextLine();

            byte[] sendData = request.getBytes();
            InetAddress serverAddress = InetAddress.getByName(serverIp);

            // Create & send the request packet to the server
            DatagramSocket socket = new DatagramSocket();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            socket.send(sendPacket);

            // Receive & process server reply
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server response: " + response);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

