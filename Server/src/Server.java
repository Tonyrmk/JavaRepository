

import modules.Phone;

import java.io.*;
import java.net.ServerSocket;


public class Server {
    public static void main(String[] args) {
       try( ServerSocket server =new ServerSocket(8000))    {
           System.out.println("Server started");

           while (true){
               Phone phone  = new Phone(server);
                   new Thread(()->{
                       String request = phone.readLine();
                       System.out.println("Request: "+request);
                       String response ="hello from server "+ request.length();
                       System.out.println("Response: "+ response);
                       try {
                           Thread.sleep(4000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       phone.writeLine(response);
                       try {
                           phone.close();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }).start();

                   }
               }
       catch (IOException e){
           throw new RuntimeException(e);
       }

    }
}
