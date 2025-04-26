import java.util.*;

public class Agent extends User {
    private List<String> missions;
    private int missionCompleted;
    private int missionAssigned;

    public Agent() {
        super();
        this.missions = new ArrayList<>();
        this.missionCompleted = 0;
        this.missionAssigned = 0;
    }

    public Agent(int id, String name, String password, Ranks rank) {
        super(id, name, password, rank);
        this.missions = new ArrayList<>();
        this.missionCompleted = 0;
        this.missionAssigned = 0;
    }

    // add methods

    public List<String> getMissions() {
        return missions;
    }

    public void setMissions(List<String> missions) {
        this.missions = missions;
    }

    public int getMissionCompleted() {
        return missionCompleted;
    }

    public void setMissionCompleted(int missionCompleted) {
        this.missionCompleted = missionCompleted;
    }

    public int getMissionAssigned() {
        return missionAssigned;
    }

    public void setMissionAssigned(int missionAssigned) {
        this.missionAssigned = missionAssigned;
    }
}
