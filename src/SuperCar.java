import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.ServerSocket;
import java.net.Socket;

import java.net.SocketTimeoutException;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class SuperCar extends Car {
    static int gpsport = 8080;   //fix Gps port value of Super Car
    public SuperCar() {
        System.out.println("HEY SuperCar class");
    }

    public int startEngine() g
	{              //Overriding; 
        int status = super.startEngine();   //use keyword super fn to access from parent class
        System.out.println("##### Start Engine of Super Car #####");
        if (status == 0) {  //Check Gear lever position from Parent class
            return 0 ;
        } else {
            System.out.println("Start Engine Completed in SuperCar Mothod");
//        Car car = new Car();
//        this.startGps();
            this.turnOnRadio();
            this.turnOnSuperCarGps(gpsport);
            return 1 ;
        }
    }
    
    public Vector scanRadio() { //need to return Vector because the parent class also return Vector
        System.out.println("##### Start Scanning Radio Function #####");
        Hashtable RadioChannels = new Hashtable();  // Use Hashtable to collect the keys of the collection 
        Enumeration RadioStations;
        String stationName;
        String[] names = {"WHTZ-FM","KIIS-FM","KAMP-FM","WXRK-FM","WQHT-FM","WKSC-FM",
                          "WBBM-FM","WXKS-FM","KHKS-FM","WIHT-FM"};
        Vector value = super.turnOnRadio();     //use the return value from Car.turnOnRadio class
        
        System.out.println("You have " + value.capacity() + " stations in the memory.");     //debug
        System.out.println("The first station is " + value.elementAt(0) + " MHz"); //debug
            
        for(int i=0; i < value.capacity(); i++){
            RadioChannels.put(names[i], value.elementAt(i));    //Match radioFreq from Car.turnOnRadio class to RadioStation names 
        }
        
        System.out.println("");
        RadioStations = RadioChannels.keys();   //Use keys for get Freq.
        while(RadioStations.hasMoreElements()){
            stationName = (String)RadioStations.nextElement();
            System.out.println(stationName + ": " + RadioChannels.get(stationName) + " MHz");
        }
        System.out.println("My favorite is: " + RadioChannels.get("WHTZ-FM") + " MHz"); //Key
        System.out.println("##### Test" + RadioChannels); //debug
        
        try{
            FileOutputStream fileOut = new FileOutputStream("radiostations.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);       //Serialization Object RadioChannels to file
            objOut.writeObject(RadioChannels);
            objOut.close();
            fileOut.close();
            System.out.println("Serialized data is saved in file radiostations.ser");
        } catch(IOException e){
            e.printStackTrace();
        }
        return value;
    }
    
    public Vector turnOnRadio() {
        System.out.println("##### Turn on radio of SuperCar #####");
        Hashtable scanRadioStations = null;
        FileInputStream fileIn = null;
        try{
            fileIn = new FileInputStream("radiostations.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);    //deserialization from file to Object
            scanRadioStations = (Hashtable)objIn.readObject();
            objIn.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {       //Be needed by readObject Method
            System.out.println("Class not found");
            c.printStackTrace();
        }
        System.out.println("Deserialization the Radio Stations from file radiostations.ser");
        System.out.println(scanRadioStations);      //debug
        System.out.println("My favorite is: " + scanRadioStations.get("WHTZ-FM") + " MHz"); //debug
        return null;
    }
    //Networking:
    public void turnOnSuperCarGps (int gpsport){    //Server     
        System.out.println("##### Turn on GPS #####");
         try{
            ServerSocket serverSocket = new ServerSocket(gpsport);  // get GPS port from static variable
            serverSocket.setSoTimeout(20000);       //call method to set socket TimeOut 
             
            System.out.println("Waiting for Mobile App Connection on port " + serverSocket.getLocalPort() + ".....");
            Socket server;      //Socket will provide communication between 2 computers
            server = serverSocket.accept(); //Wait until client connects to the server
            System.out.println("Welcome to Gps Mobile App: ");
            Gps gps = new Gps();
            gps.turnOnGps();
        } catch (SocketTimeoutException s) {
            System.out.println("Socket Timed Out!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}