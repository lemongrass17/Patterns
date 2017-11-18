import java.io.PrintWriter;
import java.util.ArrayList;

public class UserDataBaseHandler extends DefaultDataBaseHandler implements IUserDataBaseHandler {

    private static UserDataBaseHandler handler;
    private ArrayList<User> users = new ArrayList<>();

    private UserDataBaseHandler() {
        super("C://Users//Богдан//Desktop//Java//Parking", "UserDataBase.base");
    }

    public static UserDataBaseHandler getInstance() {
        if (handler == null) {
            handler = new UserDataBaseHandler();
        }
        return handler;
    }

    private User fromString(String line){
        String [] usr = line.split(";", 3);
        for (int i = 0; i < usr.length; i++){
            usr[i].trim();
        }
        return new User(usr[0], usr[1], Integer.parseInt(usr[2]));
    }

    private void rewriteFile(){
        flushFile();
        for (int i = 0; i < users.size(); i++){
            addUser(users.get(i));
        }
    }

    public boolean isContainLogPass(String login, String password){
        users.clear();
        getAllRecords();

        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getLogin().equals(login) && users.get(i).getHash().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isContains(User user) {
        return isEnable(user.toString());
    }

    @Override
    public void addUser(User user) {
        add(user.toString());
    }

    @Override
    public void delUser(User user) {
        del(user.toString());
    }

    @Override
    public void incSum(User user, int sum) {
        users.clear();
        getAllRecords();

        for (int i = 0; i < users.size(); i++){
            if (users.get(i).equals(user)){
                users.get(i).setMoney(users.get(i).getMoney() + sum);
                break;
            }
        }
        rewriteFile();
    }

    @Override
    public void decSum(User user, int sum) {
        users.clear();
        getAllRecords();

        for (int i = 0; i < users.size(); i++){
            if (users.get(i).equals(user)){
                users.get(i).setMoney(users.get(i).getMoney() - sum);
                break;
            }
        }
        rewriteFile();
    }

    @Override
    protected void sendDiff(String line) {
        users.add(fromString(line));
    }
}
