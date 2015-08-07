import java.io.IOException;
import java.net.Socket;

public class MobileApp {    //Client
    public static void main(String[] args) throws IOException{
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);   // Need 2 parameters when caliing this Application
        
        System.out.println(serverName + " " + port);
        Socket mobileApp = new Socket(serverName, port);    //creates a socket on its end of the communication and attempts 
        System.out.println("Connected to " + mobileApp.getRemoteSocketAddress());   //to connect the socket to a server
        mobileApp.close();
    }
}
