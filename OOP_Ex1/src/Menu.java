import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public Menu(){}
    public void displayOption(){
        System.out.println("=====To do=====");
        System.out.println("1. Add an Entry");
        System.out.println("2. Remove an Entry");
        System.out.println("3. Display Entry");
        System.out.println("4. Exit");
    }
    public int getOptionInput(){
        
        int choice = 0;
        while (true){
            System.out.print("Your choice: ");
            try {
                choice = Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.println("1, 2, 3 or 4.");
            }
            if (choice<=4 && choice >=1) break;
            System.out.println("1, 2, 3 or 4.");
        }
        
        return choice;
    }
    public int getPriorityInput(){
        Scanner sc = new Scanner(System.in);
        int priority = -1;
        while (true){
            System.out.print("Please give me the priority: ");
            String input = sc.next();
            try {
                priority = Integer.parseInt(input);
            } catch (Exception e){
                System.out.println("An interger number please.");
            }
            if (priority>=0) break;
        }
        return priority;
    }

    public String getNoteInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Note: ");
        String note = sc.nextLine();
        return note;
    }

    public boolean getConfirmationInput(int type){
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (type == -1){
                System.out.println("Do you want to delete this entry? (Y/n)");
            }
            else {
                System.out.println("Do you want to add this entry? (Y/n)");
            }
            
            String input = sc.nextLine().toLowerCase();
            if (input.equals("y" )) {
                return true;
            }
            if (input.equals("n" )) {
                return false;
            }
        }
                
    }
    public int getIDInput(){
        int ID = -1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Please input the ID you want to delete: ");
            try {
                ID = Integer.parseInt(sc.nextLine());
            }
            catch (Exception e) {
                System.out.println("An integer please.");
            }
            if (ID >= 0) break;
        }
        return ID;
    }
    public void displayFailedToDelete(){
        System.out.println("Delete failed. ID doesnt exist!");
    }
    public void displaySuccessToDelete(){
        System.out.println("Delete successful.");
    }
}
