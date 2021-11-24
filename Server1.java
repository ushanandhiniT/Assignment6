package Assignmnt6;
import java.io.*;
import java.net.*;

class Server implements Runnable{
    private static ServerSocket MyService = null;
    private  DataInputStream input = null;
    private  PrintStream  output = null;
    private  String line;
    private static Socket serviceSocket = null;
    public static void main(String[] args) throws IOException {
        try{
            MyService = new ServerSocket(4444);
            if(args.length > 0){
                MyService = new ServerSocket(Integer.parseInt(args[0]));
            }
        }
        catch( IOException e){
            System.out.println("Couldn't linputten to port " + (args.length > 0 ? Integer.parseInt(args[0]) : 4444));
        }

        System.out.println("The server started. To stop it press <CTRL><C>.");
        while(true){
            try {
                serviceSocket = MyService.accept();
                new Thread(new Server()).start();
                System.out.println("CREATED");
            }
            catch (IOException e) {
                System.out.println("can't accept");
            }
        }

    }

    public void run(){
        try {
            input = new DataInputStream(serviceSocket.getInputStream());
            output = new PrintStream(serviceSocket.getOutputStream());
            while (true) {
                line = input.readLine();
                System.out.println("from client:" + line+"\n");
                output.println("From server: " + line+"\n");

            }

        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

}

