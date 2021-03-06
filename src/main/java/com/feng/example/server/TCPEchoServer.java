package com.feng.example.server;


import java.net.*; // for Socket, ServerSocket, and InetAddress
import java.io.*; // for IOException and Input/OutputStream

/**
 * Created by tianfengluyao on 2017/10/31.
 */
public class TCPEchoServer {

    private static final int BUFSIZE = 32; // Size of receive buffer

    private static final int servPort = 7; //设置端口号

    public static void main(String[] args) throws IOException {

        // Create a server socket to accept client connection requests
        ServerSocket servSock = new ServerSocket(servPort);

        int recvMsgSize; // Size of received message
        byte[] receiveBuf = new byte[BUFSIZE]; // Receive buffer

        while (true) { // Run forever, accepting and servicing connections
            Socket clntSock = servSock.accept(); // Get client connection
            SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
            System.out.println("Handling client at " + clientAddress);

            InputStream in = clntSock.getInputStream();
            OutputStream out = clntSock.getOutputStream();

            // Receive until client closes connection, indicated by -1 return
            while ((recvMsgSize = in.read(receiveBuf)) != -1) {
                out.write(receiveBuf, 0, recvMsgSize);
            }
            clntSock.close(); // Close the socket. We are done with this client!
        }
    }
}