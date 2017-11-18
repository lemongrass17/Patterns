public interface IUserDataBaseHandler {

    boolean isContains(String login);
    void addUser(String login, String password);
    void delUser(String login);

}
