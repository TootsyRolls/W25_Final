import java.util.*;

public class Agent extends User {
    private List<Mission> missions;
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

    /**
     * This method shows list of all the missions and their statuses belonging to an agent
     * @param missions
     * @return A list of all missions and their statuses belonging to an agent
     */
    @Override
    public List<String> viewDatabase(List<Mission> missions) {
        List<String> agentMissionsList = new ArrayList<>();
        for (Mission m : missions) {
            agentMissionsList.add(m.getName() + " : " + m.getStatus());
        }
        return agentMissionsList;
    }

    @Override
    public String viewStats() {
        return "";
    }


    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
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
