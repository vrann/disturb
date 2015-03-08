package com.vrann.ServiceAgent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class PingAgent
{

    static int threadCounter = 0;

    public static void main(String[] args)
    {
        if (args.length < 1) {
            System.out.println("Usage: java -jar disturb.jar --ping|pong|yabaduka ");
            System.exit(10);
        }
        int portNumber = 1366;





            try {
                ServerSocket socket = new ServerSocket(portNumber);
                while (true) {
                    Socket clientSocket = socket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                    out.println("accepted");
                    out.println("Start by typing a greeting. Hu kouza " + args[0]);
                    ServeCustomer garcon = new ServeCustomer(args[0], in, out, clientSocket);
                    garcon.start();

                }
                //socket.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

    }
}

class ServeCustomer extends Thread
{
    public static final String PING = "ping";
    public static final String PONG = "pong";
    public static final String YABADUKA = "yabaduka";

    private String type;

    private BufferedReader inputReader;

    private PrintWriter outputReader;

    private Socket clientSocket;

    public ServeCustomer(String responseType, BufferedReader in, PrintWriter out, Socket socket)
    {
        type = responseType;
        inputReader = in;
        outputReader = out;
        clientSocket = socket;
    }

    public void run()
    {
        PingAgent.threadCounter++;
        outputReader.println("Zu hakarin #" + PingAgent.threadCounter);

        String inputLine;
        try {
            while ((inputLine = inputReader.readLine()) != null) {
                if (inputLine.equals("Bye.")) {
                    PingAgent.threadCounter--;
                    break;
                }

                if (type.equals(PONG))
                    outputReader.println(PONG);
                else if (type.equals(PING))
                    outputReader.println(PING);
                else if (type.equals(YABADUKA))
                    outputReader.println(YABADUKA);
            }
            clientSocket.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


