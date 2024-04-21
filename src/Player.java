import java.util.List;
import java.util.ArrayList;

public class Player {
//	protected Room current_location;
//    protected ArrayList<Item> Inventory = new ArrayList<>();
//    Player(Room StartLocation)
//    {
//        current_location = StartLocation;
//    }
//    
//    private int playerLevel;
//    private int playerHealthPoints;
//    private static int playerAttackPoints;
//    private int currency;
//    private static Player playerInstance;
//    private static List<Item> inventory;
//    private int currentRoom;
//    static int maxHealth ;
//    private static final int MAX_HEALTH = 100; // Maximum health limit for the player
//    static final int DEFAULT_ATTACK_POINTS = 5;
//   
//    public Player(int playerLevel, int playerHealthPoints, int playerAttackPoints, List<Item> inventory, int currentRoom) {
//        this.playerLevel = playerLevel;
//        this.playerHealthPoints = playerHealthPoints;
//        this.playerAttackPoints = playerAttackPoints;
//        this.inventory = new ArrayList<>();
//        this.currentRoom = currentRoom;
//    }
//    public Player(int startingRoom, int currentHealth) {
//        this.currentRoom = startingRoom;
//        this.inventory = new ArrayList<>();
//        Player.maxHealth = 100;
//        this.playerHealthPoints = currentHealth;
//        this.playerAttackPoints = DEFAULT_ATTACK_POINTS;
//    }
//
//    public int getPlayerLevel() {
//        return playerLevel;
//    }
//
//    public int getPlayerHealthPoints() {
//        return playerHealthPoints;
//    }
//
//    public int getPlayerAttackPoints() {
//        return playerAttackPoints;
//    }
//
//    public int getCurrency() {
//        return currency;
//    }
//
//    public int getCurrentRoom() {
//        return currentRoom;
//    }
//
//    public void setPlayerLevel(int playerLevel) {
//        this.playerLevel = playerLevel;
//    }
//
//    public void setPlayerHealthPoints(int playerHealthPoints) {
//        this.playerHealthPoints = playerHealthPoints;
//    }
//
//    public void setPlayerAttackPoints(int playerAttackPoints) {
//        this.playerAttackPoints = playerAttackPoints;
//    }
//
//    public void setCurrency(int currency) {
//        this.currency = currency;
//    }
//
//
//    public void restartLevel(){
//
//    }
//
//    public void saveGame(){
//
//    }
//
//    public void loadGame(){
//
//    }
//
//    public void accessMap(){
//
//    }
//
//    public void levelUp(){
//
//    }
//
//    public void pickupItem(){
//
//    }
//
//    public void equipItem(){
//
//    }
//
//    public void displayInventory(){
//
//    }
//
//    public void dropItem(){
//
//    }
//  
//
//    public static List<Item> getInventory() {
//        return inventory;
//    }
//    
//    public static int getMaxHealth() {
//        return MAX_HEALTH;
//    }
//
//    public static Player getPlayerInstance() {
//        if (playerInstance == null) {
//            playerInstance = new Player(1, 50);
//        }
//        return playerInstance;
//    }
//
//    public int getAttackPoints() {
//        return playerAttackPoints;
//    }
//
//    public int getCurrentHealth() {
//        return playerHealthPoints;
//    }
//    public Item getEquippedItem() {
//        for (Item item : inventory) {
//            if (item.isEquipped()) {
//                return item;
//            }
//        }
//        return null;
//    }
//    public void setCurrentRoom(int roomNumber) {
//        this.currentRoom = roomNumber;
//    }
//    public void setCurrentHealth(int currentHealth) {
//        this.playerHealthPoints = currentHealth;
//    }
//
//    public void heal(int amount, String itemName) {
//        int previousHealth = playerHealthPoints;
//        playerHealthPoints += amount;
//        if (playerHealthPoints > maxHealth) {
//        	playerHealthPoints = maxHealth;
//        }
//        int healedAmount = playerHealthPoints - previousHealth;
//        if (healedAmount > 0) {
//            System.out.println("You healed with: " + itemName.toLowerCase());
//            System.out.println("Item Heal Level: " + healedAmount);
//            System.out.println("Player Previous Health Level: " + previousHealth);
//            System.out.println("Player Current Health Level: " + playerHealthPoints);
//
//        } else {
//            System.out.println("You are already at full health. Current Health: " + playerHealthPoints);
//        }
//    }
//
//    static void handleHeal(String itemName) {
//        Player player = getPlayerInstance();
//        Item itemToHeal = null;
//        for (Item item : Player.getInventory()) {
//            if (item.getItemName().equalsIgnoreCase(itemName) && item.getItemHealthPoints() > 0) {
//                itemToHeal = item;
//                break;
//            }
//        }
//        if (itemToHeal != null) {
//            player.heal(itemToHeal.getItemHealthPoints(), itemName);
//            Player.getInventory().remove(itemToHeal);
//        } else {
//            System.out.println("Item '" + itemName + "' cannot be used for healing.\n");
//        }
//    }
//
//    public static void updateAttackPoints(int points) {
//        playerAttackPoints += points;
//    }
//    public static void resetAttackPoints() {
//    	playerAttackPoints = DEFAULT_ATTACK_POINTS;
//    }
//    public int getHealth() {
//        return playerHealthPoints;
//    }
//    public void setAttackPoints(int attackPoints) {
//        this.playerAttackPoints = attackPoints;
//    }
//    
//    int CheckNorth()
//    {
//        return current_location.getN();
//    }
//
//    int CheckSouth()
//    {
//        return current_location.getS();
//    }
//
//    int CheckEast()
//    {
//        return current_location.getE();
//    }
//
//    int CheckWest()
//    {
//        return current_location.getW();
//    }
//    public Room Getlocation()
//    {
//        return current_location;
//    }
	    protected Room current_location;

	    protected ArrayList<Item> Inventory = new ArrayList<>();

	    Player(Room StartLocation)
	    {
	        current_location = StartLocation;
	    }

	    int CheckNorth()
	    {
	        return current_location.getN();
	    }

	    int CheckSouth()
	    {
	        return current_location.getS();
	    }

	    int CheckEast()
	    {
	        return current_location.getE();
	    }

	    int CheckWest()
	    {
	        return current_location.getW();
	    }
	    public Room Getlocation()
	    {
	        return current_location;
	    }

	    void showInventory()
	    {
	        if(Inventory.size() == 0)
	            System.out.println("Your Inventory is empty.");
	        else {
	            for (Item i : Inventory) {
	                System.out.println(i.toString());
	            }
	        }
	    }




	    void addItem(Item i) {
	        Inventory.add(i);
	    }


	    void RemoveItem(int i)
	    {
	        Inventory.remove(i);
	    }

	    void showCurrentLocationInventory()
	    {
	        if(current_location.Inventory.size() == 0)
	            System.out.println("Room is empty of items.");
	        else {
	            for(Item i : current_location.Inventory)
	            {
	                System.out.println(i.toString());
	            }
	        }
	    }


	    void pickUp(String target_name)
	    {
	        boolean foundItem = false;
	        for(Item i : current_location.Inventory)
	        {
	            if(i.getItemName().equalsIgnoreCase(target_name))
	            {
	                addItem(current_location.Inventory.get(current_location.Inventory.indexOf(i)));
	                System.out.println("You picked up " + i.getItemName() + ".");
	                current_location.RemoveItem(current_location.Inventory.indexOf(i));
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
	        for (Item i : Inventory) {
	            if (i.getItemName().equalsIgnoreCase(target_name)) {
	                current_location.addItem(Inventory.get(Inventory.indexOf(i)));
	                System.out.println("You dropped " + i.getItemName() + ".");
	                RemoveItem(Inventory.indexOf(i));
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
	        for (Item i : Inventory) {
	            if (i.getItemName().equalsIgnoreCase(target_name)) {
	                System.out.println("You examine the " + i.getItemName() + ". It's description is: " + i.getDescription());
	                foundItem = true;
	                break;
	            }
	        }
	        if(!foundItem)
	            System.out.println("Item was not found in inventory");
	    }




	    void Setlocation(Room location)
	    {
	        this.current_location = location;
	    }

}
