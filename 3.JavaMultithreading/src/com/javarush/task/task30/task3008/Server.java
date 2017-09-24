package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            System.out.println("сервер запущен");
            while (true) {
                socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();
                if (answer.getType() == MessageType.USER_NAME) {
                    if (!answer.getData().isEmpty()) {
                        if (!connectionMap.containsKey(answer.getData())) {
                            connectionMap.put(answer.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return answer.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            Message mes;
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()){
                if (entry.getKey()!= userName){
                    mes = new Message(MessageType.USER_ADDED, entry.getKey());
                    connection.send(mes);
                }
            }
        }
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{

            while (true){
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT){
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                }
                else {
                    ConsoleHelper.writeMessage("Error");
                }
            }
        }
    }
        public static void sendBroadcastMessage(Message message) {
                try {
                    for (Connection connection : connectionMap.values()) {
                        connection.send(message);
                    }
                } catch (IOException e) {
                    e.getMessage();
                    ConsoleHelper.writeMessage("Error");
                }
        }
}