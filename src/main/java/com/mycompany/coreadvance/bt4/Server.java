/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coreadvance.bt4;

/**
 *
 * @author maytinh
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket server;
    private static int port = 9876;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        server = new ServerSocket(port);

        while (true) {
            System.out.println("Waiting for client request...");
            Socket socket = server.accept();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Received message: " + message);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Hi Client " + message);

            ois.close();
            oos.close();
            socket.close();

            if (message.equalsIgnoreCase("exit")) {
                break;
            }
        }

        System.out.println("Shutting down Socket server!");
        server.close();
    }
}
