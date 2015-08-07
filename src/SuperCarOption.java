import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;

public class SuperCarOption {
    SuperCar supercar = new SuperCar();
    Car car = new Car();
    public SuperCarOption() throws IOException {
        InputStream inputSt = new FileInputStream("optionMenu.txt");     //File I/O Stream: Streams from Text File
        while ( inputSt.available() > 0){
            System.out.print((char)inputSt.read()); //When InputSt is read, available will be -1
        }
        inputSt.close();

        InputStreamReader input = new InputStreamReader(System.in);   //from Input
        char option = (char)input.read();   // Standarn Streams
        switch (option) {       // Switch Decision Making
// l : Select Car Color
        case ('l') : case ('L') :
            System.out.println("Obtion = " + option);   //debug
            String color = supercar.getColor('w');
            System.out.println("Your Super car's color is " + color);
            break;
// e : Start Car Engine
        case 'e' : case ('E') :
            int status = supercar.startEngine(); //Overriding
            if (status == 0){
                System.exit(0);
            }
            break;
// r : Turn on Radio
        case 'r' : case ('R') :
            supercar.turnOnRadio();
            break;
// c : Scan Radio
        case 'c' : case ('C') :
            supercar.scanRadio();
            break;
// g : Turn on Gps
        case 'g' : case ('G') :
            int gpsport = 0;
            supercar.turnOnSuperCarGps(gpsport);
            break;
// s : Increase Car Speed
        case 's' : case ('S') :
            supercar.increaseSpeed();
            break;
// t : Stop Car Engine
        case 't' : case ('T') :
            supercar.stopEngine();
            break;
// q : Quit
        case 'q' : case ('Q') :
            System.out.println("Bye!");
            break;
        default :
            System.out.println("Invalid Option: " + option);
            System.out.println("Do Nothing");
            break;
        }
    }
}
