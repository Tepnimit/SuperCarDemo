public abstract class Vehicle implements MovableInt {   // Implement >> MovableInt
        private char color;         //Encapsulation ; Use private variables & providing access via public method
        private String chosencolor; // Use private because prevent another class to access it;
        private int wheel_number;
        private int seat; 
        
        public Vehicle() {
            System.out.println("HEY Vehicle class");
        }
        
        public String getColor(char color){
            switch(color)       //
            {
            case 'b' :
                chosencolor = "black";
                break;
            case 'w' :
                chosencolor = "white";
                break;
            default :
                System.out.println("Invalid color");
            }
            return chosencolor;
        }
        
        // Using abstract to control subclasss have to implement all abstract mothod
//        public abstract int startEngine();  
//        public abstract void stopEngine();
//        public abstract void increaseSpeed();
//        public abstract void decreaseSpeed();
//        public abstract void stopVehicle();
//		  public abstract void abc();
		
}
