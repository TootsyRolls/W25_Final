public class Mission {
    private int id;
    private String name;
    private String location;
    private int difficulty; // Compare using ints later
    private Status status;

    public enum Status {
        ACTIVE,
        COMPLETED,
        CANCELLED
    }

    public enum Difficulty { // String with int value
        EASY(1),
        MEDIUM(2),
        HARD(3);

        private final int difficultyLevel; // int value

        Difficulty(int difficultyLevel) { // constructor initialize int value
            this.difficultyLevel = difficultyLevel;
        }

        public int getDifficultyLevel() { // get int value for use
            return difficultyLevel;
        }
    }

    public Mission() {
        this.id = 0;
        this.name = "";
        this.location = "";
        this.difficulty = Difficulty.EASY.getDifficultyLevel();
        this.status = status;
    }

    public Mission(int id, String name, String location, Difficulty difficulty, Status status) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.difficulty = difficulty.getDifficultyLevel();
        this.status = status;
    }

    // add methods

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
