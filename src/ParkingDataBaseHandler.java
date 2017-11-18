import java.util.ArrayList;

public class ParkingDataBaseHandler extends DefaultDataBaseHandler implements IParkingDataBaseHandler {

    private static ParkingDataBaseHandler handler;

    private ParkingDataBaseHandler(){
        super("C://Users//Богдан//Desktop//Java//Parking", "ParkingDataBase.base");
    }

    public static ParkingDataBaseHandler getInstance(){
        if (handler == null){
            handler = new ParkingDataBaseHandler();
        }
        return handler;
    }

    private String getStringByAddress(String address){
        return getStringOnSubstring(address);
    }

    @Override
    public boolean isContains(String address) {
        return isEnable(address);
    }

    @Override
    protected String getSubString(String str) {
        String [] subStrings = str.split(";");
        subStrings[0].trim();
        return subStrings[0];
    }

    @Override
    protected void diffDel(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            String[] park = arrayList.get(i).split(";", 4);
            park[0].trim();
            park[1].trim();
            park[2].trim();
            park[3].trim();

            addParking(park[0], park[1], park[2], park[3]);
        }
    }

    @Override
    public boolean isFree(String address) {
        String []substrings = getStringByAddress(address).split(";", 4);

        if (Integer.parseInt(substrings[1]) - Integer.parseInt(substrings[2]) != 0){
            return true;
        }
        return false;
    }

    @Override
    public void addParking(String address, String numbOfParkPlaces, String numbOfOccupPlaces, String price) {
        String line = address + "; " + numbOfParkPlaces + "; " + numbOfOccupPlaces + "; " + price;
        add(line);
    }

    @Override
    public void delParking(String address) {
        del(address);
    }

    @Override
    public void incNumbOfOccup(String address) {

    }

    @Override
    public void decNumbOfOccup(String address) {

    }
}
