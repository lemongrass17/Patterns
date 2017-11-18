import java.util.ArrayList;

public class UserDataBaseHandler extends DefaultDataBaseHandler implements IUserDataBaseHandler {

    private static UserDataBaseHandler handler;
    private HashMD5 hashFunc;

    private UserDataBaseHandler() {
        super("C://Users//Богдан//Desktop//Java//Parking", "UserDataBase.base");
        hashFunc = new HashMD5();
    }

    public static UserDataBaseHandler getInstance() {
        if (handler == null) {
            handler = new UserDataBaseHandler();
        }
        return handler;
    }

    @Override
    protected String getSubString(String str) {
        String [] subStrings = str.split(";");
        subStrings[0] = subStrings[0].trim();
        return subStrings[0];
    }

    @Override
    protected void diffDel(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            String[] usr = arrayList.get(i).split(";", 2);
            usr[0] = usr[0].trim();
            usr[1] = usr[1].trim();

            addUser(usr[0], usr[1]);
        }
    }

    @Override
    public boolean isContains(String login) {
        return isEnable(login);
    }

    @Override
    public void addUser(String login, String password) {
        String line = login + "; " + hashFunc.hash(password);
        add(line);
    }

    @Override
    public void delUser(String login) {
        del(login);
    }
}
