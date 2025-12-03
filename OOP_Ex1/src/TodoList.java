public class TodoList {
    private Entry[] list; 
    private static int length;

    public TodoList(){
        TodoList.length=0;
        list = new Entry[0];
    }
    public void display(){
        for (Entry entry : list) {
            System.out.println(entry.toString());
        }
    }
    public void showTodoList(){
        sortList();
        for (Entry entry : list) {
            System.out.println(entry.toString());
        }
    }
    public void sortList(){
        for (int i = 0; i < list.length-1; i++) {
            Entry maxPriorityEntry = list[i];
            for (int j = i+1; j < list.length; j++) {
                if (list[j].getPriority()>=maxPriorityEntry.getPriority()){
                    Entry tempEntry = maxPriorityEntry;
                    list[i] = list[j];
                    list[j] = tempEntry;
                }
            }
        }
    }
    public boolean removeEntry(int ID){
        
        if (checkIfExist(ID) != true) return false;

        TodoList.length--;
        Entry[] newList = new Entry[TodoList.length];
        
        int index = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].getID() == ID) continue;
            newList[index] = list[i];
            index++;
        }
        list= newList;
        return true;
    }

    public boolean addEntry(Entry entry) {
        if (checkIfExist(entry.getID())) {
            return false;
        }
        TodoList.length++;
        Entry[] newList = new Entry[TodoList.length];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        newList[list.length] = entry;
        list = newList;
        return true;
    }

    private boolean checkIfExist(int ID){
        boolean IdExist = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i].getID() == ID) IdExist = true;
        }
        return IdExist;
    }

    public Entry getEntryById(int ID) {
        if (checkIfExist(ID) == false) return null;
        else {
            for (int i = 0;i<list.length;i++){
                if (list[i].getID() == ID) return list[i];
            }
        }
        return null;
    }

}
