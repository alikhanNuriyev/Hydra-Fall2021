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
    private boolean defeated;

    public Monster(int monsterID, String monsterName, String monsterDescription, int monsterHealthPoints, int monsterAttackPoints, int monsterLocation, String drop) {
        this.monsterID = monsterID;
        this.monsterName = monsterName;
        this.monsterDescription = monsterDescription;
        this.monsterHealthPoints = monsterHealthPoints;
        this.monsterAttackPoints = monsterAttackPoints;
        this.monsterLocation = monsterLocation;
    }
    public Monster(String monsterName, String monsterDescription, int monsterAttackPoints, int monsterLocation, int monsterHealthPoints, String drop) {
        this.monsterName = monsterName;
        this.monsterDescription = monsterDescription;
        this.monsterAttackPoints = monsterAttackPoints;
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

    void modHealth(int amount)
    {
        this.monsterHealthPoints -= amount;
    }
	public boolean isDefeated() {
		return defeated;
	}
	public void setDefeated(boolean defeated) {
		this.defeated = defeated;
	}

}
