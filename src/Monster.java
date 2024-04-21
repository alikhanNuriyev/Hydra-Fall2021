import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;

public class Monster {
    private int monsterID;
    private String monsterName;
    private String monsterDescription;
    private int monsterHealthPoints;
    private int monsterAttackPoints;
    private int monsterLocation;
    private int threshold;
    private boolean defeated;

    public Monster(int monsterID, String monsterName, String monsterDescription, int monsterHealthPoints, int monsterAttackPoints, int monsterLocation) {
        this.monsterID = monsterID;
        this.monsterName = monsterName;
        this.monsterDescription = monsterDescription;
        this.monsterHealthPoints = monsterHealthPoints;
        this.monsterAttackPoints = monsterAttackPoints;
        this.monsterLocation = monsterLocation;
    }
    public Monster(String monsterName, String monsterDescription, int monsterAttackPoints, int threshold, int monsterLocation, int monsterHealthPoints) {
        this.monsterName = monsterName;
        this.monsterDescription = monsterDescription;
        this.monsterAttackPoints = monsterAttackPoints;
        this.threshold = threshold;
        this.monsterLocation = monsterLocation;
        this.monsterHealthPoints = monsterHealthPoints;
        this.defeated = false;
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

    public int getMonsterLocation() {
        return monsterLocation;
    }

    public void setMonsterLocation(int monsterLocation) {
        this.monsterLocation = monsterLocation;
    }

    public String getMonsterDescription() {
        return monsterDescription;
    }

    public void setMonsterDescription(String monsterDescription) {
        this.monsterDescription = monsterDescription;
    }

    public void monsterCombat(){

    }
	public int getThreshold() {
		return threshold;
	}
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	public boolean isDefeated() {
		return defeated;
	}
	public void setDefeated(boolean defeated) {
		this.defeated = defeated;
	}

    public static Map<Integer, Monster> readMonsters(String filename) throws IOException {
        Map<Integer, Monster> monsters = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int monsterId = 1;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.trim().split(",");
            String monsterName = parts[0];
            String description = parts[1];
            int attackDamage = Integer.parseInt(parts[2]);
            int threshold = Integer.parseInt(parts[3]);
            int roomNumber = Integer.parseInt(parts[4]);
            int health = Integer.parseInt(parts[5]);
            Monster monster = new Monster(monsterName, description, attackDamage, threshold, roomNumber, health);
            monsters.put(monsterId++, monster);
        }
        reader.close();
        return monsters;
    }
	
}
