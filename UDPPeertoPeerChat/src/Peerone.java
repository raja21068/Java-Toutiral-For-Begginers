
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salman
 */
public class Peerone extends Thread {
    ChatMainFrame f;

  DatagramSocket socket;
  Peerone(DatagramSocket socket,ChatMainFrame f){ 
  this.socket=socket;
  this.f=f;
   }
   
       public void run(){ 
         
          do{
              try{
            // user name recive     
            byte UserName[]=new byte[20];
            DatagramPacket packusername=new DatagramPacket(UserName,0,UserName.length); 
            socket.receive(packusername);
            String s0=new String(packusername.getData(),0,packusername.getLength());
           // data size recive
             byte datasize[]=new byte[20];
            DatagramPacket packsize=new DatagramPacket(datasize,0,datasize.length);
            socket.receive(packsize);
            String s1=new String(packsize.getData(),0,packsize.getLength());
            int size=Integer.parseInt(s1);
            //data recive
            byte data[]=new byte[size];
            DatagramPacket pack=new DatagramPacket(data,0,data.length);
            
            socket.receive(pack);
            String s2=new String(pack.getData(),0,pack.getLength());
            System.out.println(s0+":"+s2);
            f.Area.append(s0+":"+s2+"\n");
            }catch(Exception e){}
              }while(true);
     
   }
      


}