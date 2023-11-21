import java.util.ArrayList;
import java.util.List;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

class UserManagement {
    private List<User> users;

    public UserManagement() {
        this.users = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public boolean authenticateUser(String username, String password) {
        return users.stream()
                .anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));
    }

    public List<User> getUsers() {
        return users;
    }
}

class Module {
    private String moduleName;

    public Module(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleName() {
        return moduleName;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleName='" + moduleName + '\'' +
                '}';
    }
}

class CourseManager {
    private List<Module> modules;

    public CourseManager() {
        this.modules = new ArrayList<>();
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() {
        return modules;
    }
}

public class TechSeniorsProject {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        CourseManager courseManager = new CourseManager();

        User newUser = new User("john_doe", "password123");
        userManagement.registerUser(newUser);

        boolean isAuthenticated = userManagement.authenticateUser("john_doe", "password123");
        System.out.println("User Authentication Result: " + isAuthenticated);

        Module newModule = new Module("Introduction to Java");
        courseManager.addModule(newModule);

        System.out.println("Registered Users: " + userManagement.getUsers());
        System.out.println("Available Modules: " + courseManager.getModules());
    }
}
