public class Car {
    private String name;
    private int maxSpeed;
    private int currentSpeed; 
    private int meter;
    
    public Car(String name, int maxSpeed, int meter) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.meter = meter;
    }
    public void go(Road road, int currentSpeed,Counter counter ){
        // if car go through the road length then break the recursive
        if (road.getLength()<=0){
            return;
        }
        // if the the car hasnt reach the finish then recall this function with
        // road length =  old road length - current speed
        // current speed >= max speed ? max speed : current speed + meter
        // counter count ++
        counter.setCount(counter.getCount()+1);
        setCurrentSpeed(this.currentSpeed + this.meter > this.maxSpeed ? this.maxSpeed : this.currentSpeed + this.meter);
        go(new Road(road.getLength() - this.currentSpeed,road.getType()), this.currentSpeed, 
            counter);
    }
    public boolean isFinish(Road road){
        boolean isFinish = true;
        return isFinish;
    }
    public void scanInfo(){
        System.out.println(this.name+" | "+ this.currentSpeed +" | ");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public int getCurrentSpeed() {
        return currentSpeed;
    }
    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    public int getMeter() {
        return meter;
    }
    public void setMeter(int meter) {
        this.meter = meter;
    }
    
}
