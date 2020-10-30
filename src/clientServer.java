import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


class tmpServer extends Thread{

    Socket clientReq = null;

    public tmpServer()
    {
        super();
    }

    @Override
    public void run()
    {
        while (true)
        {
            try {

                ServerSocket sc = new ServerSocket(8889);
                clientReq = sc.accept();

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientReq.getInputStream()));

                System.out.println(reader.readLine());

                PrintStream out = new PrintStream(clientReq.getOutputStream());
                out.println("Hey, I am from server 123");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

public class clientServer {


    public static void main(String[] args) throws IOException, InterruptedException {

        Thread tmp = new tmpServer();
        tmp.start();

        String SERVER_IP = "localhost";
        int port = 5353;

        Socket server = new Socket(SERVER_IP, port);

        PrintStream out = new PrintStream(server.getOutputStream());
        out.println("Ashraful");

        BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
        String reqConnection = reader.readLine();

        Socket peerNetwork = new Socket(reqConnection, port);
        PrintStream out2 = new PrintStream(peerNetwork.getOutputStream());
        out2.println("Hey, I am from peer client!");

        BufferedReader reader2 = new BufferedReader(new InputStreamReader(peerNetwork.getInputStream()));
        String reqConnection2 = reader2.readLine();
        System.out.println(reqConnection2);

    }

}
