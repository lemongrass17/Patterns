public class SignInCommand implements Command {

    private UserDataBaseHandler handler;
    private HashMD5 hashMD5 = new HashMD5();
    private String login;
    private String passwordHash;

    public SignInCommand(String login, String password){
        handler = UserDataBaseHandler.getInstance();
        this.login = login;
        this.passwordHash = hashMD5.hash(password);
    }

    @Override
    public boolean execute() {
        return handler.isContainLogPass(login, passwordHash);
    }
}
