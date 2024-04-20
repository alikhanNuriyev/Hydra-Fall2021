import java.util.List;

public class Player {
    private int playerLevel;
    private int playerHealthPoints;
    private int playerAttackPoints;
    private int currency;
    private List<Item> playerInventory;
    private Room currentRoom;

    public Player(int playerLevel, int playerHealthPoints, int playerAttackPoints, int currency, List<Item> playerInventory, Room currentRoom) {
        this.playerLevel = playerLevel;
        this.playerHealthPoints = playerHealthPoints;
        this.playerAttackPoints = playerAttackPoints;
        this.currency = currency;
        this.playerInventory = playerInventory;
        this.currentRoom = currentRoom;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public int getPlayerHealthPoints() {
        return playerHealthPoints;
    }

    public int getPlayerAttackPoints() {
        return playerAttackPoints;
    }

    public int getCurrency() {
        return currency;
    }

    public List<Item> getPlayerInventory() {
        return playerInventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public void setPlayerHealthPoints(int playerHealthPoints) {
        this.playerHealthPoints = playerHealthPoints;
    }

    public void setPlayerAttackPoints(int playerAttackPoints) {
        this.playerAttackPoints = playerAttackPoints;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public void setPlayerInventory(List<Item> playerInventory) {
        this.playerInventory = playerInventory;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void restartLevel(){

    }

    public void saveGame(){

    }

    public void loadGame(){

    }

    public void accessMap(){

    }

    public void levelUp(){

    }

    public void pickupItem(){

    }

    public void equipItem(){

    }

    public void displayInventory(){

    }

    public void dropItem(){

    }
}
