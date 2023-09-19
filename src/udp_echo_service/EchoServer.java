package udp_echo_service;

import java.net.*;
import java.time.LocalDateTime;
import java.util.Arrays;

public class EchoServer {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;

        try {
            serverSocket = new DatagramSocket(3000);

            while (true) {
                DatagramPacket clientRequest = new DatagramPacket(new byte[1024], 1024);
                serverSocket.receive(clientRequest);
                byte[] content = Arrays.copyOf(clientRequest.getData(), clientRequest.getLength());
                String request = new String(content).trim(); // Convert the received data to a string and trim it

                InetAddress clientIP = clientRequest.getAddress();
                int clientPort = clientRequest.getPort();

                String response = processRequest(request);
                byte[] responseData = response.getBytes();

                DatagramPacket serverReply = new DatagramPacket(responseData, responseData.length, clientIP, clientPort);
                serverSocket.send(serverReply);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        }
    }

    private static String processRequest(String request) {
        if (request.equalsIgnoreCase("date")) {
            LocalDateTime now = LocalDateTime.now();
            return now.toLocalDate().toString();
        } else if (request.equalsIgnoreCase("time")) {
            LocalDateTime now = LocalDateTime.now();
            return now.toLocalTime().toString();
        } else {
            return "invalid request";
        }
    }
}
