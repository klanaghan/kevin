package com.kevin.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@edu.umd.cs.findbugs.annotations.SuppressFBWarnings("RU_INVOKE_RUN")
public class MultiClientServer
{
    private ServerSocket serverSocket;

    public void start(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        while (true)
        {
            Socket socket = serverSocket.accept();
            SocketClientHandler handler = new SocketClientHandler(socket);
            handler.run();

            if( handler.shouldTerminate() == true)
            {
                stop();
            }
        }
    }

    public void stop()
    {
        try
        {
            serverSocket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }



    public static void main(String inArgs[]) throws IOException
    {
        MultiClientServer mEchoMultiServer = new MultiClientServer();
        mEchoMultiServer.start(5555);
    }
}
