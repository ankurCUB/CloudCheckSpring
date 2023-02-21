package com.example.cloudcheckspring.project;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;

    public Server(int port) throws IOException {
        try {
            serverSocket = new ServerSocket(port,200000);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public void startServer() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(this, socket);
            serverThread.start();
        }
    }

    public String processClientRequest(String request){
        return "";
    }

    public void disconnectServer() throws IOException {
        serverSocket.close();
    }

    public static void main() throws IOException {
        Server server = new Server(5001);
        server.startServer();
    }
}
