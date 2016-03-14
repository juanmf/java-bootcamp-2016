package user;

/**
 * @author Cadrian Represents a user of the system.
 */
public class User {

    private static int nextId = 0;
    private String name;
    private String passwd;
    private int id;

    public User(String name, String passwd) {
        this.setId(nextId);
        nextId++;
        this.setName(name);
        this.setPasswd(passwd);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void update(User user) {
        setName(user.getName());
        setPasswd(user.getName());
    }

}
