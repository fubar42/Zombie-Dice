import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by s213391244 on 10/15/2015.
 */
public class ClientConnection extends Thread{

    public ClientConnection(Server server, Socket socket){
        this.server = server;
        this.socket = socket;
    }
    // reference to server object connected to
    private Server server;

    // the communication channels through which the server and THIS client communicate
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private Lock outLock = new ReentrantLock();
    private String userHandle;

    // stream : (COMMAND, SCORE, RANK)
    //Message
    //commands from server to client
    private static final String START_COMMAND = "#START";
    private static final String ROLL_COMMAND = "#ROLL";
    private static final String WAIT_COMMAND = "#WAIT";
    private static final String END_COMMAND = "#END";

    //stream : (COMMAND, DICE("runner_shotgun_brain"))
    //commands from client to server
    private static final String JOIN_REQUEST = "#JOIN";
    private static final String CREATE_COMMAND = "#CREATE";
    private static final String EVALUATE_COMMAND = "#EVALUATE";
    private static final String QUIT_COMMAND = "#QUIT";

    public void sendStartCommand(String score, String rank){
        outLock.lock();
        try{
            out.writeUTF(START_COMMAND);
            out.writeUTF(score);
            out.writeUTF(rank);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            outLock.unlock();
        }
    }

    public void sendRollCommand(String score, String rank){
        outLock.lock();
        try{
            out.writeUTF(ROLL_COMMAND);
            out.writeUTF(score);
            out.writeUTF(rank);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            outLock.unlock();
        }
    }

    public void sendWaitCommand(String score, String rank){
        outLock.lock();
        try{
            out.writeUTF(WAIT_COMMAND);
            out.writeUTF(score);
            out.writeUTF(rank);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            outLock.unlock();
        }
    }

    public void sendEndCommand(String score, String rank){
        outLock.lock();
        try{
            out.writeUTF(END_COMMAND);
            out.writeUTF(score);
            out.writeUTF(rank);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            outLock.unlock();
        }
    }


    @Override
    public void run(){
        try{
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            userHandle = in.readUTF().trim();
            server.addPlayer(userHandle, this);
            String command = "";

            while(!command.equals(QUIT_COMMAND)){
                command = in.readUTF();

                switch (command){
                    case JOIN_REQUEST:
                        //server.findGame(
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
