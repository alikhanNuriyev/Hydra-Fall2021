import java.util.ArrayList;
import java.util.List;

public class Player {
    private int playerLevel;
    private int playerHealthPoints;
    private int playerCurrentHealth;
    private int playerAttackPoints;
    private int currency;
    private ArrayList<Item> playerInventory = new ArrayList<>();
    private Room currentRoom;
    private Monster engagedMonster;
    private Item weaponSlot;
    private Item armorSlot;

    public Player(int playerLevel, int playerHealthPoints, int playerAttackPoints, int currency, Room currentRoom) {
        this.playerLevel = playerLevel;
        this.playerHealthPoints = playerHealthPoints;
        this.playerAttackPoints = playerAttackPoints;
        this.currency = currency;
        this.playerInventory = playerInventory;
        this.currentRoom = currentRoom;
        this.playerCurrentHealth = playerHealthPoints;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public int getPlayerHealthPoints() {
        return playerHealthPoints;
    }

    public int getPlayerCurrentHealth() { return playerCurrentHealth; }

    public int getPlayerAttackPoints() {
        return playerAttackPoints;
    }

    public int getCurrency() {
        return currency;
    }

    void setEngagedMonster(Monster m) { engagedMonster = m; }

    Monster getEngagedMonster(){ return engagedMonster; }

    void defeatMonster()
    {
        levelUp();
        engagedMonster = null;
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

    public void playerTakeDamage(int damage)
    {
        playerCurrentHealth -= damage;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public void setPlayerInventory(ArrayList<Item> playerInventory) {
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
        playerLevel ++;
        playerHealthPoints +=5;
        playerCurrentHealth += 5;
        playerAttackPoints += 5;
    }

    public void pickupItem(){

    }

    public void equipItem(){

    }

    public void displayInventory(){

    }

    public void dropItem(){

    }

    void Setlocation(Room location)
    {
        this.currentRoom = location;
    }

    int CheckNorth()
    {
        return currentRoom.getN();
    }

    int CheckSouth()
    {
        return currentRoom.getS();
    }

    int CheckEast() {  return currentRoom.getE(); }

    int CheckWest()
    {
        return currentRoom.getW();
    }

    void showInventory()
    {
        if(playerInventory.size() == 0)
            System.out.println("Your Inventory is empty.");
        else {
            for (Item i : playerInventory) {
                System.out.println(i.toString());
            }
        }
    }

    void addItem(Item i) {
        playerInventory.add(i);
    }


    void RemoveItem(int i)
    {
        playerInventory.remove(i);
    }

    void showCurrentLocationInventory()
    {
        if(currentRoom.Inventory.size() == 0)
            System.out.println("Room is empty of items.");
        else {
            for(Item i : currentRoom.Inventory)
            {
                System.out.println(i.toString());
            }
        }
    }

    void showCurrentLocationMonsters()
    {
        if(!currentRoom.hasMonster)
            System.out.println("Room is empty of monsters.");
        else {
            currentRoom.viewMonster();
        }
    }


    void pickUp(String target_name)
    {
        boolean foundItem = false;
        for(Item i : currentRoom.Inventory)
        {
            if(i.getItemName().equalsIgnoreCase(target_name))
            {
                addItem(currentRoom.Inventory.get(currentRoom.Inventory.indexOf(i)));
                System.out.println("You picked up " + i.getItemName() + ".");
                currentRoom.RemoveItem(currentRoom.Inventory.indexOf(i));
                foundItem = true;
                break;
            }
        }
        if(!foundItem)
            System.out.println("Item was not found in room");
    }

    void Drop(String target_name)
    {
        boolean foundItem = false;
        for (Item i : playerInventory) {
            if (i.getItemName().equalsIgnoreCase(target_name)) {
                currentRoom.addItem(playerInventory.get(playerInventory.indexOf(i)));
                System.out.println("You dropped " + i.getItemName() + ".");
                RemoveItem(playerInventory.indexOf(i));
                foundItem = true;
                break;
            }
        }
        if(!foundItem)
            System.out.println("Item was not found in inventory");
    }

    void Inpsect(String target_name)
    {
        boolean foundItem = false;
        for (Item i : playerInventory) {
            if (i.getItemName().equalsIgnoreCase(target_name)) {
                System.out.println("You examine the " + i.getItemName() + ". It's description is: " + i.getDescription());
                foundItem = true;
                break;
            }
        }
        if(!foundItem)
            System.out.println("Item was not found in inventory");
    }

    void Consume(String target_name)
    {
        boolean foundItem = false;
        for (Item i : playerInventory) {
            if (i.getItemName().equalsIgnoreCase(target_name)) {
                System.out.println("Item found");
                if(i.getItemType().equalsIgnoreCase("C"))
                {
                    System.out.println("You consumed the " + i.getItemName() + "!");
                    playerAttackPoints += i.getItemAttackPoints();
                    playerHealthPoints += i.getItemHealthPoints();
                    playerCurrentHealth += (1 * i.getHealingAmount() * playerHealthPoints);
                    if(playerCurrentHealth > playerHealthPoints)
                    {
                        playerCurrentHealth = playerHealthPoints;
                    }
                    System.out.println("You restored " + playerHealthPoints / 2 + " health points by consuming " + i.getItemName());
                    System.out.println("Your stats are now: Health: " + playerCurrentHealth + "/" + playerHealthPoints  + " Attack: "+ playerAttackPoints);
                    playerInventory.remove(i);
                }

                foundItem = true;
                break;
            }
        }
        if(!foundItem)
            System.out.println("Item was not found in inventory");
    }

    void Equip(String target_name)
    {
        boolean foundItem = false;
        for (Item i : playerInventory) {
            if (i.getItemName().equalsIgnoreCase(target_name)) {
                System.out.println("Item found");
                if(i.getItemType().equalsIgnoreCase("W") || i.getItemType().equalsIgnoreCase("A"))
                {
                    System.out.println("You equipped the " + i.getItemName() + ".");
                    playerAttackPoints += i.getItemAttackPoints();
                    playerHealthPoints += i.getItemHealthPoints();
                    playerCurrentHealth += (1 * i.getHealingAmount() * playerHealthPoints);
                    if(playerCurrentHealth > playerHealthPoints)
                    {
                        playerCurrentHealth = playerHealthPoints;
                    }
                    System.out.println("Your stats are now: Health: " + playerCurrentHealth + "/" + playerHealthPoints  + " Attack: "+ playerAttackPoints);
                    playerInventory.remove(i);
                }

                foundItem = true;
                break;
            }
        }
        if(!foundItem)
            System.out.println("Item was not found in inventory");
    }

    void showStats()
    {
        System.out.println("Your Current Stats: " + " Level: " + playerLevel + " Health: " + getPlayerCurrentHealth() + "/" + getPlayerHealthPoints() + " Attack: " + playerAttackPoints);
    }


}
