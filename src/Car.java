import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Vector;

public class Car extends Vehicle {
    private Transmission trans;
    private char gearLeverPosition;
    
    public Car() {
        System.out.println("HEY Car class");
        
//        trans = new Transmission();
//        System.out.print("What is your current Gear Lever Position? > ");
//        InputStreamReader input = null;
//        try{
//            input = new InputStreamReader(System.in);
//            char i = (char)input.read();
//            gearLeverPosition = trans.setShiftGear(i);
//            System.out.println(i);
//        }catch(IOException e){
//            e.getStackTrace();
//        }
//        
//        gearLeverPosition = trans.getShiftGear();
//        System.out.println("The Gear Lever Position is " + Character.toUpperCase(gearLeverPosition));
    }
    
    public int startEngine(){
        System.out.println("##### Start Engine of Car #####");
        trans = new Transmission(); // call Transmission Method
        System.out.println("Current Gear Position = " + trans.getShiftGear());
        System.out.print("What is your current Gear Lever Position? : ");
        //InputStream need exception Handling either throws or try/catch
        InputStreamReader input = null;
        try{
            input = new InputStreamReader(System.in);   //Standard Streams: Standard Input
            char i = (char)input.read();
            gearLeverPosition = trans.setShiftGear(i);  //setShiftGear
        }catch(IOException e){
            e.getStackTrace();
        }
        
        gearLeverPosition = trans.getShiftGear();   //getShiftGear
        System.out.println("The Current Gear Lever Position is " + Character.toUpperCase(gearLeverPosition)); //Basic Char Type
        
        if ( gearLeverPosition == 'P'|| gearLeverPosition == 'p' ){
            System.out.println("Start Engine Completed in Car Mothod");
            return 1 ; 
        }else{
            System.out.println("------- WARNING!! Please shift gear to P position\n------- Try Again!!");
            return 0 ;
        }
    }
    
    public void stopEngine(){
        System.out.println("Stop Engine Completed ");
    }
    public void increaseSpeed(){
        System.out.println("Speed Up ");
    }
    public void decreaseSpeed()`{
        System.out.println("Speed Down ");
    }
    public void stopVehicle(){
        System.out.println("Put the break !! ");
    }
    
    public Vector turnOnRadio() { // Vector and Enumeration
        System.out.println("Turn on Radio");
        
        Enumeration radioStations;  
        Vector RadioFreq = new Vector();    //very useful if we don't know the size
            RadioFreq.add(100.0);
            RadioFreq.add(102.7);
            RadioFreq.add(97.1);
            RadioFreq.add(92.3);
            RadioFreq.add(97.0);
            RadioFreq.add(103.5);
            RadioFreq.add(96.0);
            RadioFreq.add(108.0);
            RadioFreq.add(106.1);
            RadioFreq.add(99.5);
        radioStations = RadioFreq.elements();   //returns enumeration of the components 
        System.out.print("Scanning Radio Stations ..... " );
        while (radioStations.hasMoreElements()){
            System.out.print(radioStations.nextElement() + " ");    // then enumerate the elements in a collectionof object
        }
        System.out.println();
        return RadioFreq;
    }

}

