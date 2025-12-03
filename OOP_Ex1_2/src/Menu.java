import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public Menu(){

    }
    public void displayOptions(){
        System.out.println("=====Racing Car=====");
        System.out.println("1. Register cars");
        System.out.println("2. Prepare race tracks");
        System.out.println("3. Start the race");
        System.out.println("4. Top 3 result");
        System.out.println("5. Exit");
        System.out.println("====================");
        System.out.println("Your choice");
    }
    public int getOptionInput(){
        int choice = 0;
        while (true){
            System.out.print("Your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("1, 2, 3, 4 or 5.");
            }
            if (choice<=4 && choice >=1) break;
            System.out.println("1, 2, 3, 4 or 5.");
        }
        
        return choice;
    }
    

    public Car[] getCarsInput(){
        int carsNumber = getNumberOfCarInput();
        Car[] carList = new Car[carsNumber];
        for (int i = 0; i < carsNumber; i++) {
            System.out.println("Input detail for car number "+ i+":");
            carList[i] = getCarDetail();
        }
        return carList;
        
    }
    private Car getCarDetail() {
        System.out.println("Enter car name: ");
        String carName = sc.nextLine();
        int maxSpeed = 0;
        int meter = 0;
        while (true) {
            
            try{
                System.out.println("Enter its max speed: ");
                maxSpeed = Integer.parseInt(sc.nextLine());
                System.out.println("Enter its accelaration: ");
                meter = Integer.parseInt(sc.nextLine());;
            }
            catch (Exception e){
                System.out.println("Please enter positive integer number.");
            }
            if (maxSpeed>0 && meter>0) break;
        }
        Car newCar = new Car(carName, maxSpeed, meter);
        return newCar;
    }
    private int getNumberOfCarInput(){
        int carsNumber = 0;
        while (true) {
            System.out.print("Input the number of cars you want to add:");
            try {
                carsNumber = Integer.parseInt(sc.nextLine());
            }
            catch (Exception e){
                System.out.println("Please input an integer number from 1-10.");
            }
            if (carsNumber >=1 && carsNumber <= 10) break;
        }
        return carsNumber;
    }

    public Road getRoadInput(){
        System.out.println("Please enter road detail");
        int length = 0;
        int type = 0;
        while (true) {
            try {
                System.out.println("Please enter the length of the road:");
                length = Integer.parseInt(sc.nextLine());
                System.out.println("Please enter the type of the road:");
                type = Integer.parseInt(sc.nextLine());
            }
            catch (Exception e) {
                System.out.println("Integer please.");
            }
            if (length >0 && type > 0) break;
        }
        Road newRoad = new Road(length, type);
        return newRoad;
    }
    public void showCar(int top, Car car, Counter counter) {
        System.out.print("| "+top+" | ");
        car.scanInfo();
        System.out.println(counter.getCount()+" |");
    }
    public void showResult(){
        System.out.println("=================================");
        System.out.println("|  STT  | Name  | Speed | Count |");
        System.out.println("=================================");
    }
}
