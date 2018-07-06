package com.kevin.socket;

import java.io.*;
import java.net.Socket;

public class SocketClient
{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException
    {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException
    {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection()
    {
        closeStream(in);
        closeStream(out);
        closeSocket(clientSocket);
    }
    private void closeSocket(Socket inClientSocket)
    {
        try
        {
            inClientSocket.close();
        }
        catch (IOException inE)
        {
            inE.printStackTrace();
        }
    }

    private void closeStream(Closeable inStream)
    {
        try
        {
            inStream.close();
        }
        catch (IOException inE)
        {
            inE.printStackTrace();
        }
    }
}