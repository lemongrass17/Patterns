public class Main {

    public static void main(String[] args) {
        IParkingDataBaseHandler handler = ParkingDataBaseHandler.getInstance();
        handler.addParking("staro", "100","0", "300");
        System.out.println(handler.isContains("staro"));
        //handler.delParking("staro");
    }

}
