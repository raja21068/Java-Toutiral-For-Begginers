
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class PeeroneSendingThread extends Thread{
    DatagramSocket socket;
    InetAddress adress;
    ChatMainFrame f;
    String name;
    String ip;
    PeeroneSendingThread(String ip,String name,ChatMainFrame f){
    this.name=name; 
    this.ip=ip;
    this.f=f;
    try{
    adress=InetAddress.getByName(this.ip);
    socket=new DatagramSocket();
    }catch(Exception e){}
    }
    
 public void run(){   
    try{
    
    String s=f.messageBox.getText().trim();
    f.messageBox.setText("");  
    f.Area.append(name+":"+s);  
    f.Area.append("\n");
    byte data[]=s.getBytes();
    int i=data.length;
    String size=""+i;
    byte dataSize[]=size.getBytes();
    byte username[]=name.getBytes();
    DatagramPacket packusername=new DatagramPacket(username,0,username.length,adress,8090);
    DatagramPacket packsize=new DatagramPacket(dataSize,0,dataSize.length,adress,8090);
    DatagramPacket pack=new DatagramPacket(data,0,data.length,adress,8090);
    socket.send(packusername);
    socket.send(packsize);
    socket.send(pack);
    if (s.length()>0){  
}  
    f.messageBox.requestFocusInWindow(); 
    }catch(Exception e){}  
    
 } 
    
}