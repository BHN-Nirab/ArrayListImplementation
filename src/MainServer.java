
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

class eachClient extends Thread{

    Queue<Socket> listOfClient = new LinkedList<Socket>(); ;

    public eachClient(Socket client) throws IOException {

        super();
        listOfClient.add(client);
    }

    @Override
    public void run() {
        try {

            Socket tmp = listOfClient.poll();
            BufferedReader reader = new BufferedReader(new InputStreamReader(tmp.getInputStream()));

            String clientMsg = reader.readLine();

            if(clientMsg.equals("Ashraful"))
            {
                PrintStream out = new PrintStream(tmp.getOutputStream());
                out.println("10.100.101.116");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

public class MainServer {

    public static void main(String[] args) throws IOException {

        ServerSocket sc = new ServerSocket(8889);

        while(true)
        {
            System.out.println("Waiting for connection...");
            Socket client = sc.accept();
            System.out.println("Connected");
            Thread thread = new eachClient(client);
            thread.start();
        }

    }

}