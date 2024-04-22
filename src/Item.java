import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Item {
	// Alikhan - Here are some of generic instance variables for the Item class. Feel free to add, change, or delete anything as long as it makes sense for the requirements 
    // Josiah - Added healing Amount, item type
    private int itemId;
    private String itemName;
    private String itemType;

    @Override
    public String toString() {
        return itemName + ", " +
                itemDescription + ' ';
    }

    private String itemDescription;
    private int itemRoomId;
    private int itemAttackPoints;
    private int itemHealthPoints;
    private double healingAmount;
    private boolean equipped;

	// Alikhan - Here is the constructor for Item class. Feel free to add, change, or delete anything as long as it makes sense for the requirements 
    // Josiah - Modified constructure to include type and healing amount
    public Item(int itemId, int itemRoom, String itemName, String itemType, String itemDescription, int itemAttackPoints, int itemHealthPoints, double healingAmount) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemDescription = itemDescription;
        this.itemRoomId = itemRoom;
        this.itemAttackPoints = itemAttackPoints;
        this.itemHealthPoints = itemHealthPoints;
        this.healingAmount = healingAmount;

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
        return itemRoomId;
    }

    public String getItemType() {return itemType; }

    public int getItemAttackPoints() {
        return itemAttackPoints;
    }

    public int getItemHealthPoints() {
        return itemHealthPoints;
    }

    public double getHealingAmount(){ return healingAmount; }
    
    public boolean isEquipped() {
        return equipped;
    }
    

    
// Alikhan - Here are some of the methods we will need for the Item class. After reading through the SRS document and reviewing the 
// changed + unchanged features for Item class. Below, I included generic methods that will be useful for the Item class. You can change any method,
// delete, or add new methods if it is required to do so. We also need a method to hand reading the items txt file.
    
    // Josiah added getDescription, and set equipped Method

    String getDescription() {
        return itemDescription;
    }

    void setEquipped() {
        equipped = true;
    }


}