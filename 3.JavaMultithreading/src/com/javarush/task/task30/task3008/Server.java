package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        int port = ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(port);) {
            System.out.println("сервер запущен");
            while (true){
                socket = serverSocket.accept();
               new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            socket.close();
        }
    }

    private static class Handler extends Thread{
        private Socket socket;
        public Handler (Socket socket){
            this.socket = socket;
        }
    }

}
