package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(7777);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    try {
                        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                        while (true) {
                            String input = objectInputStream.readUTF();
                            String result = process(input, objectOutputStream);
                            if (result.equals("")) continue;
                            else if (result.equals("end")) break;
                            objectOutputStream.writeUTF(result);
                            objectOutputStream.flush();
                        }
                        objectOutputStream.close();
                        socket.close();
                        serverSocket.close();
                    } catch (Exception e) {
                        try {
                            socket.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String process(String input, ObjectOutputStream objectOutputStream) throws Exception {
        String[] split;
        if (input.startsWith("register")) {
            split = input.split(" ");
            return String.valueOf(ServerController.register(split[1], split[2], split[3]));
        } else if (input.startsWith("login")) {
            split = input.split(" ");
            ServerController.login(split[1], split[2], objectOutputStream);
            return "";
        } else if (input.startsWith("buy card")) {
            split = input.split(" ");
            return String.valueOf(ServerController.buyCard(split[2], split[3]));
        } else if (input.startsWith("logout")) {
            split = input.split(" ");
            return String.valueOf(ServerController.logout(split[1]));
        } else if (input.startsWith("scoreboard")) {
            ServerController.scoreboard(objectOutputStream);
            return "";
        } else if (input.startsWith("duel")) {
            ServerController.duelMenu(objectOutputStream);
            return "";
        }
        return "";
    }

}
