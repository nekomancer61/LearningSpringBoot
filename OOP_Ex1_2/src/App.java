public class App {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        Car[] carList = new Car[10];
        Counter[] counterList = new Counter[10];
        Road road = new Road(0, 0);
        while (true) {
            menu.displayOptions();
            int option = menu.getOptionInput();
            switch (option) {
                case 1:
                    carList = menu.getCarsInput();
                    break;
                case 2:
                    road = menu.getRoadInput();
                    break;
                case 3:
                    for (int i = 0; i < carList.length; i++) {
                        counterList[i] = new Counter(0);
                        carList[i].go(road, 0, counterList[i]);
                    }
                    break;
                case 4:
                    menu.showResult();

                    for (int i = 0; i < carList.length - 1; i++) {
                        int fastestCarIndex = i;
                        for (int j = i + 1; j < carList.length; j++) {
                            if (counterList[i].getCount() > counterList[j].getCount()) {
                                fastestCarIndex = j;
                            }
                        }
                        menu.showCar(i, carList[fastestCarIndex], counterList[fastestCarIndex]);
                    }

                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }
}
