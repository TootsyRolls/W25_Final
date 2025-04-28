import java.util.*;

public class Handler extends User{
    private List<Mission> allMissions;
    private List<Agent> agents; // agents assigned under handler

    public Handler() {
        super();
        this.agents = new ArrayList<>();
    }

    public Handler(int id, String name, String password, Ranks rank) {
        super(id, name, password, rank);
        this.agents = new ArrayList<>();
    }

    /**
     * This method adds agents to a handler
     * @param agent
     */
    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    /**
     * This method adds missions to a list containing all existing missions
     * @param mission
     */
    public void addMission(Mission mission) {
        allMissions.add(mission);
    }

    /**
     * This method shows list of all existing missions and their statuses
     * @param allMissions
     * @return A list of all existing missions and their statuses
     */
    @Override
    public List<String> viewDatabase(List<Mission> allMissions) {
        List<String> allMissionsList = new ArrayList<>();
        for (Mission m : allMissions) {
            allMissionsList.add(m.getName() + " : " + m.getStatus());
        }
        return allMissionsList;
    }
}
