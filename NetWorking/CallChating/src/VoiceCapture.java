/**
 *
 * @author Jay Kumar
 */
import javax.sound.sampled.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class VoiceCapture extends Thread {
     AudioFormat audioFormat;
    TargetDataLine line;
    DataLine.Info info;
    File file;
    
    VoiceCapture(File f){
        try{
        audioFormat = getAudioFormat();
        info = new DataLine.Info(TargetDataLine.class, audioFormat);
        line = (TargetDataLine)AudioSystem.getLine(info);
        file = f;
        }catch(Exception e){ e.printStackTrace(); }
    }
   
    
    AudioFormat getAudioFormat(){
        final float sampleRate = 8000.0f;//8000,11025,16000,22050,44100
        final int sampleSize = 16;
        final int channel = 1; // 1 for mono // 2 for stero
        final boolean signed = true;
        final boolean bigEndian = true;
        return new AudioFormat(sampleRate, sampleSize , channel , signed ,bigEndian);
    }
    public void stopCapture(){
          line.stop();
          line.close();
          stop();
    }
    
    public void run(){
       try{
        AudioFileFormat.Type fileFormat = AudioFileFormat.Type.AU;
        
        file.createNewFile();
        
        line.open(audioFormat);
        line.start();
        AudioSystem.write(new AudioInputStream(line), fileFormat, file);
       }catch(Exception e){e.printStackTrace();}
    }
    public static void main(String arg[]){
        
        
        
        
    }
}
