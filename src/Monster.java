public class Monster {
    private int monsterID;
    private String monsterName;
    private int monsterHealthPoints;
    private int monsterAttackPoints;
    private String monsterLocation;

    public Monster(int monsterID, String monsterName, int monsterHealthPoints, int monsterAttackPoints, String monsterLocation) {
        this.monsterID = monsterID;
        this.monsterName = monsterName;
        this.monsterHealthPoints = monsterHealthPoints;
        this.monsterAttackPoints = monsterAttackPoints;
        this.monsterLocation = monsterLocation;
    }

    public int getMonsterID() {
        return monsterID;
    }

    public void setMonsterID(int monsterID) {
        this.monsterID = monsterID;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMonsterHealthPoints() {
        return monsterHealthPoints;
    }

    public void setMonsterHealthPoints(int monsterHealthPoints) {
        this.monsterHealthPoints = monsterHealthPoints;
    }

    public int getMonsterAttackPoints() {
        return monsterAttackPoints;
    }

    public void setMonsterAttackPoints(int monsterAttackPoints) {
        this.monsterAttackPoints = monsterAttackPoints;
    }

    public String getMonsterLocation() {
        return monsterLocation;
    }

    public void setMonsterLocation(String monsterLocation) {
        this.monsterLocation = monsterLocation;
    }
}
