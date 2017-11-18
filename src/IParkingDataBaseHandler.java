public interface IParkingDataBaseHandler {

    boolean isContains(String address);
    boolean isFree(String address);
    void addParking(String address, String numbOfParkPlaces, String numbOfOccupPlaces, String price);
    void delParking(String address);
    void incNumbOfOccup(String address);
    void decNumbOfOccup(String address);
}
