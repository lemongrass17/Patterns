public class Parking {

    private String address;
    private int numOfOcccupPlaces;
    private int numOfPlaces;
    private int price;

    public Parking(){
        address = "";
        numOfOcccupPlaces = 0;
        numOfPlaces = 0;
        price = 0;
    }

    public Parking(String address, int numOfOcccupPlaces, int numOfPlaces, int price){
        this.address = address;
        this.numOfOcccupPlaces = numOfOcccupPlaces;
        this.numOfPlaces = numOfPlaces;
        this.price = price;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setNumOfOcccupPlaces(int numOfOcccupPlaces){
        this.numOfOcccupPlaces = numOfOcccupPlaces;
    }

    public int getNumOfOcccupPlaces(){
        return numOfOcccupPlaces;
    }

    public void setNumOfPlaces(int num){
        this.numOfPlaces = numOfPlaces;
    }

    public int getNumOfPlaces(){
        return numOfPlaces;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public String toString(){
        return getAddress() + "; " + Integer.toString(getNumOfOcccupPlaces()) + "; " + Integer.toString(getNumOfPlaces()) + "; " + Integer.toString(getPrice());
    }
}
