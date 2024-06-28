/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coreadvance.bt4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static String serverAddress = "127.0.0.1";
    private static int serverPort = 9876;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(serverAddress, serverPort);
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.print("Enter message for server (type 'exit' to quit): ");
                String message = scanner.nextLine();
                oos.writeObject(message);

                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }

                String response;
                try {
                    response = (String) ois.readObject();
                    System.out.println("Server response: " + response);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}



