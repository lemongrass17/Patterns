import java.util.ArrayList;

public class ParkingDataBaseHandler extends DefaultDataBaseHandler implements IParkingDataBaseHandler {

    private static ParkingDataBaseHandler handler;
    private ArrayList<Parking> parkings = new ArrayList<>();

    private ParkingDataBaseHandler(){
        super("C://Users//Богдан//Desktop//Java//Parking", "ParkingDataBase.base");
    }

    public static ParkingDataBaseHandler getInstance(){
        if (handler == null){
            handler = new ParkingDataBaseHandler();
        }
        return handler;
    }

    private Parking fromString(String line){
        String [] park = line.split(";", 4);
        for (int i = 0; i < park.length; i++){
            park[i].trim();
        }
        return new Parking(park[0], Integer.parseInt(park[1]), Integer.parseInt(park[2]), Integer.parseInt(park[3]));
    }

    private void rewriteFile(){
        flushFile();
        for (int i = 0; i < parkings.size(); i++){
            addParking(parkings.get(i));
        }
    }

    @Override
    public boolean isContains(Parking parking) {
        return isEnable(parking.toString());
    }

    @Override
    public void addParking(Parking parking) {
        add(parking.toString());
    }

    @Override
    public void delParking(Parking parking) {
        del(parking.toString());
    }

    @Override
    public void incNumbOfOccup(Parking parking) {
        parkings.clear();
        getAllRecords();

        for (int i = 0; i < parkings.size(); i++){
            if (parkings.get(i).equals(parking)){
                parkings.get(i).setNumOfOcccupPlaces(parkings.get(i).getNumOfOcccupPlaces() + 1);
                break;
            }
        }
        rewriteFile();
    }

    @Override
    public void decNumbOfOccup(Parking parking) {
        parkings.clear();
        getAllRecords();

        for (int i = 0; i < parkings.size(); i++){
            if (parkings.get(i).equals(parking)){
                parkings.get(i).setNumOfOcccupPlaces(parkings.get(i).getNumOfOcccupPlaces() - 1);
                break;
            }
        }
        rewriteFile();
    }

    @Override
    protected void sendDiff(String line) {
        parkings.add(fromString(line));
    }
}
