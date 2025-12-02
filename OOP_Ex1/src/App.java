public class App {
    public static void main(String[] args) throws Exception {
        int delete = -1;
        int add = 1;
        Menu menu = new Menu();
        TodoList todoList = new TodoList();
        while (true){
            menu.displayOption();
            int choice = menu.getOptionInput();
            switch (choice) {
                case 1 : {
                    int priority = 0;
                    String note = "";
                    priority = menu.getPriorityInput();
                    note = menu.getNoteInput();
                    if (menu.getConfirmationInput(add) != true) continue;
                    Entry newEntry = new Entry(priority, note);
                    todoList.addEntry(newEntry);
                    break;
                }
                case 2 :{
                    int ID = menu.getIDInput();
                    if (menu.getConfirmationInput(delete)!=true) continue;
                    if (todoList.removeEntry(ID)!=true){
                        menu.displayFailedToDelete();;
                    }
                    menu.displaySuccessToDelete();
                    break;
                }

                case 3 : todoList.toString();
                case 4 : return;
                default : menu.displayOption();
            }
        }
    }



}
