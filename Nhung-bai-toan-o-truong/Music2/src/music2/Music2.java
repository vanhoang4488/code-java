/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music2;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.media.DataSink;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Processor;
import javax.media.ProcessorModel;
import javax.media.format.AudioFormat;
import javax.media.protocol.DataSource;
import javax.media.protocol.FileTypeDescriptor;
import javax.swing.JFileChooser;
import javazoom.jl.converter.Converter;
import javazoom.jl.player.Player;

public class Music2 extends Application {
    public static ChayNhac music;
     private javax.media.Player audioPlayer = null;
    public static Thread thread1;
    public static Thread thread2;
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
//                thread1 = new Thread(new Runnable(){
//                    @Override
//                    public void run() {
//                        music.stop();
//                    }
//                    
//                });
                
                thread2 = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        music.a();
                    }
                    
                });
                
//                thread1.start();
//                try {
//                    thread1.join(1);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
                thread2.start();
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void play() {
        audioPlayer.start(); // start playing
    }
    public void stop() {
        audioPlayer.stop();  //stop playing
        audioPlayer.close();
    }
    public static void main(String[] args){
        //launch(args);
        try {
//            JFileChooser fc = new JFileChooser();
//            fc.showOpenDialog(null);
//            File file = fc.getSelectedFile();
//            File file2 = new File("C:\\Users\\Nguyen Van Hoang\\Documents\\a font (online-audio-converter.com).wav");
//            Converter convert = new Converter();
//            convert.convert(file.getName(), file2.getName());
//            System.out.println(file.getPath());
//            System.out.println(file2.getPath());
            
            MediaLocator locator = new MediaLocator("file://C:\\Users\\Nguyen Van Hoang\\Documents\\a font.wav");
            DataSource data = Manager.createDataSource(locator);
            FileTypeDescriptor outputFile = new FileTypeDescriptor(FileTypeDescriptor.WAVE);
            AudioFormat[] aFormat = new AudioFormat[1];
            aFormat[0] = new AudioFormat(AudioFormat.LINEAR);
            ProcessorModel pro = new ProcessorModel(data, aFormat, outputFile);
            Processor process = Manager.createRealizedProcessor(pro);
            DataSource ra = process.getDataOutput();
            MediaLocator outLocator = new MediaLocator("file://C:\\Users\\Nguyen Van Hoang\\Downloads\\a font.wav");
            DataSink sink = Manager.createDataSink(ra, outLocator);
            sink.open();
            sink.start();
            process.start();
            Thread.sleep(10000000);
            sink.stop();
            process.stop();
            process.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
