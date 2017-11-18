public class SignUpCommand implements Command{

    private UserDataBaseHandler handler;
    private HashMD5 hashMD5 = new HashMD5();
    private String login;
    private String passwordHash;

    public SignUpCommand(String login, String password){
        handler = UserDataBaseHandler.getInstance();
        this.login = login;
        this.passwordHash = hashMD5.hash(password);
    }

    @Override
    public boolean execute() {
        if (!handler.isContainLogPass(login, passwordHash)){
            handler.addUser(new User(login, passwordHash, 0));
            return true;
        }
        return false;
    }
}
