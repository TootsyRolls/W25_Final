import java.util.*;

public abstract class User {
    private int id;
    private String name;
    private String password;
    private Ranks rank;

    public abstract List<String> viewDatabase(List<Mission> missions);

    public enum Ranks {
        LIEUTENANT,
        CAPTAIN,
        MAJOR,
        COLONEL
    }

    public User() {
        this.id = 0;
        this.name = "Jan Kowalski";
        this.password = "0356";
        this.rank = Ranks.LIEUTENANT;
    }

    public User(int id, String name, String password, Ranks rank) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.rank = rank;
    }

    public abstract List<String> viewDatabase();

    public abstract String viewStats();

    // Comparable here add later


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Ranks getRank() {
        return rank;
    }

    public void setRank(Ranks rank) {
        this.rank = rank;
    }
}
