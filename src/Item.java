import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Item {
	// Alikhan - Here are some of generic instance variables for the Item class. Feel free to add, change, or delete anything as long as it makes sense for the requirements 

    private int itemId;
    private String itemName;
    private String itemDescription;
    private int itemRoom;
    private int itemAttackPoints;
    private int itemHealthPoints;
    private boolean equipped;

	// Alikhan - Here is the constructor for Item class. Feel free to add, change, or delete anything as long as it makes sense for the requirements 

    public Item(int itemId, String itemName, String itemDescription, int itemRoom, int itemAttackPoints, int itemHealthPoints) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemRoom = itemRoom;
        this.itemAttackPoints = itemAttackPoints;
        this.itemHealthPoints = itemHealthPoints;
    }
    
	// Alikhan - Here is the getters and setters for Item class. Feel free to add, change, or delete anything as long as it makes sense for the requirements 

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {

        return itemDescription;
    }

    public int getItemRoom() {
        return itemRoom;
    }

    public int getItemAttackPoints() {
        return itemAttackPoints;
    }

    public int getItemHealthPoints() {
        return itemHealthPoints;
    }
    
    public boolean isEquipped() {
        return equipped;
    }
    
    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }
    
    public void setItemRoom(int itemRoom) {
        this.itemRoom = itemRoom;
    }

    
// Alikhan - Here are some of the methods we will need for the Item class. After reading through the SRS document and reviewing the 
// changed + unchanged features for Item class. Below, I included generic methods that will be useful for the Item class. You can change any method,
// delete, or add new methods if it is required to do so. We also need a method to hand reading the items txt file.
    
    
    public static Item pickupItem() {
		return null;
     
    }
  
    public static void unequipItem() {

    } public static void equipItem() {

    }

    public static void inspectItem() {

    }
    public static void dropItem() {
      
    }

    public static void displayInventory() {
       
    }
}