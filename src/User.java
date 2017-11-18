public class User {

    private String login;
    private String hash;
    private int money;

    public User(){
        login = "";
        hash = "";
        money = 0;
    }

    public User(String login, String hash, int money){
        this.login = login;
        this.hash = hash;
        this.money = money;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getLogin(){
        return login;
    }

    public void setHash(String hash){
        this.hash = hash;
    }

    public String getHash(){
        return hash;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public int getMoney(){
        return money;
    }

    @Override
    public String toString() {
        return getLogin() + "; " + getHash() + "; " + Integer.toString(getMoney());
    }
}
