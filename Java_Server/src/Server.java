import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by s213391244 on 10/13/2015.
 */
public class Server {

    public static void main(String[] args) {
        new Server();
    }

    protected HashMap<String, ClientConnection> connections;
    protected Lock connectionLock = new ReentrantLock();

    public Server(){
        connections = new HashMap<String, ClientConnection>();
        try{
            System.out.println("Server Started!");
            ServerSocket serverSocket = new ServerSocket(5051);

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("New Connection!");

                ClientConnection connection = new ClientConnection(this,socket);
                connection.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addPlayer(String handle, ClientConnection connection) {
        connectionLock.lock();
        try {
            connections.put(handle, connection);
            System.out.println("New Player " + handle + " connected!");
        } catch (Exception e) {
            System.out.println("Connection Failed");
        } finally {
            connectionLock.lock();
        }
    }

    public void removePlayer(String handle) {
        connectionLock.lock();
        try {
            connections.remove(handle);
            System.out.println("Player " + handle + " left...");

        } catch (Exception e) {
            System.out.println("Unable to remove connection...");

        } finally {
            connectionLock.unlock();
        }
    }

    public void findGame(String handle, ClientConnection connection){

    }



}
