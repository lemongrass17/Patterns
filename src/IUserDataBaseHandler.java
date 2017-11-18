public interface IUserDataBaseHandler {

    boolean isContains(User user);
    void addUser(User user);
    void delUser(User user);
    void incSum(User user, int sum);
    void decSum(User user, int sum);

}
