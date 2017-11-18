public interface IParkingDataBaseHandler {

    boolean isContains(Parking parking);
    void addParking(Parking parking);
    void delParking(Parking parking);
    void incNumbOfOccup(Parking parking);
    void decNumbOfOccup(Parking parking);
}
