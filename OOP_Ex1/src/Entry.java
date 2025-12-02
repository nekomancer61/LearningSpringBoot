public class Entry {
    private static int count;
    private int ID;
    private int priority;
    private String note;
    public int getID () {
        return this.ID;
    }
    public void setID (int newID) {
        this.ID = newID;
    }
    public int getPriority(){
        return this.priority;
    }
    public void setPriority(int newPriority){
        this.priority = newPriority;
    }
    public String getNote(){
        return this.note;
    }
    public void setNote(String newNote){
        this.note = newNote;
    }
    public int getCount(){
        return Entry.count;
    }
    public void increaseCount(){
        Entry.count++;
    }

    public Entry(){
    }
    public Entry(int priority, String note){
        ID = Entry.count;
        increaseCount();
        this.note = note;
        this.priority = priority;
    }
    public String toString(){
        return "+ "+this.getNote();
    }

}
