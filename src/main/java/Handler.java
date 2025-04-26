import java.util.*;

public class Handler extends User{
    private List<Agent> agents; // agents assigned under handler

    public Handler() {
        super();
        this.agents = new ArrayList<>();
    }

    public Handler(int id, String name, String password, Ranks rank) {
        super(id, name, password, rank);
        this.agents = new ArrayList<>();
    }

    public void addAgent(Agent agent) {
        agents.add(agent);
    }
}
