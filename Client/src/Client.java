



import modules.Phone;

import java.io.*;


public class Client {
    public static void main(String[] args) {
       try ( Phone phone = new Phone("127.0.0.1" ,8000))
              {
           System.out.println("Client connected");
           String request = "Some request to server";
          phone.writeLine(request);
           System.out.println("Request: "+request);

           String response =phone.readLine();
           System.out.println("Response: "+response);

       }
       catch (IOException r){}

    }
}
