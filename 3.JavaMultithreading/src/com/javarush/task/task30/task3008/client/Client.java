package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread{

    }
    protected String getServerAddress() throws IOException {
        ConsoleHelper.writeMessage("Введите адрес сервера.");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера.");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() throws IOException {
        ConsoleHelper.writeMessage("Введите имя клиента.");
        return ConsoleHelper.readString();
    }
    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage(e.getMessage());
            clientConnected = false;
        }
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this){
            try {
                this.wait();
                if (clientConnected){
                    ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’.");
                }else {ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");}
                while (clientConnected){
                    String textMessage = ConsoleHelper.readString();
                    if (textMessage == "exit"){break;}
                    if (shouldSendTextFromConsole()){
                        sendTextMessage(textMessage);
                    }
                }
            } catch (InterruptedException e) {
                    ConsoleHelper.writeMessage(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
    Client client = new Client();
    client.run();
    }
}
