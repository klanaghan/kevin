package com.kevin.socket;

import java.io.*;
import java.net.Socket;

public class SocketClientHandler extends Thread
{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private boolean terminate = true;

    public boolean shouldTerminate()
    {
        return terminate;
    }


    public SocketClientHandler(Socket socket)
    {
        this.clientSocket = socket;
    }

    public void run()
    {
        try
        {
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null)
            {
                if ("bye".equals(inputLine))
                {
                    out.println("bye");
                    terminate = true;
                    break;
                }
                out.println(inputLine);
            }
        }
        catch (IOException inE)
        {
            inE.printStackTrace();
        }

        finally
        {

            closeStream(in);
            closeStream(out);
            closeSocket(clientSocket);
        }
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