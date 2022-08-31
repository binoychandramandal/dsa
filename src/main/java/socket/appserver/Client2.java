package socket.appserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {
    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    // constructor to put ip address and port
    public Client2(String address, int port) {
        // establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {

        } catch (IOException i) {
            System.out.println("Server is not running!!!");
            System.exit(1);
        }

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
        while (!line.equals("bye")) {
            try {
                if(input==null){
                    return;
                }
                line = input.readLine();
                out.writeUTF(line);
            } catch (Exception i) {
                System.out.println(i.getCause());
                System.out.println(i);
            }
        }

        // close the connection
        try {
            input.close();
            out.close();
            socket.close();
        } catch (Exception i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Client2 client = new Client2("127.0.0.1", 8888);
    }
}
