package com.kevin.socket;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


/**
 * Created by kevinlanaghan on 11/20/17.
 */
public class EchoServerTest2
{

    @Test
    public void givenClient1WhenServerRespondsThenCorrect() throws IOException
    {
        SocketClient client1 = new SocketClient();
        client1.startConnection("127.0.0.1", 5555);
        String msg1 = client1.sendMessage("hello");
        String msg2 = client1.sendMessage("world");
        String terminate = client1.sendMessage("bye");

        assertEquals(msg1, "hello");
        assertEquals(msg2, "world");
        assertEquals(terminate, "null");
    }

    @Test
    public void givenClient2WhenServerRespondsThenCorrect() throws IOException
    {
        SocketClient client2 = new SocketClient();
        client2.startConnection("127.0.0.1", 5555);
        String msg1 = client2.sendMessage("hello");
        String msg2 = client2.sendMessage("world");
        String terminate = client2.sendMessage(".");

        assertEquals(msg1, "hello");
        assertEquals(msg2, "world");
        assertEquals(terminate, "bye");
    }

}
