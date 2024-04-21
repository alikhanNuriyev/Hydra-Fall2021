import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Item {
	// Alikhan - Here are some of generic instance variables for the Item class. Feel free to add, change, or delete anything as long as it makes sense for the requirements 
    // Josiah - Added healing Amount, item type
    private int itemId;
    private String itemName;
    private String itemType;
    private String itemDescription;
    private int itemRoomId;
    private int itemAttackPoints;
    private int itemHealthPoints;
    private boolean equipped;
    private int originalRoom;

	// Alikhan - Here is the constructor for Item class. Feel free to add, change, or delete anything as long as it makes sense for the requirements 
    // Josiah - Modified constructure to include type and healing amount
    public Item(int itemId, String itemName, String itemDescription, int itemRoomId, int itemAttackPoints, int itemHealthPoints) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemRoomId = itemRoomId;
        this.originalRoom = itemRoomId;
        this.itemAttackPoints = itemAttackPoints;
        this.itemHealthPoints = itemHealthPoints;
    }
    Item(int itemId, String name, String desc)
    {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }


    
	// Alikhan - Here is the getters and setters for Item class. Feel free to add, change, or delete anything as long as it makes sense for the requirements 

    public int getItemId() {
        return itemId;
        }

    public String getItemName() {
        return itemName;
        }

    public String getItemType() {
    	return itemType; 
    	}
    
    public String getItemDescription() {
        return itemDescription;
        }

    public int getItemRoomId() {
        return itemRoomId;
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
    
    void setItemRoomId(int itemRoomId) {
        this.itemRoomId = itemRoomId;
    }
  
    public static Map<Integer, Item> readItems(String filename) throws IOException {
        Map<Integer, Item> items = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int itemId = 1;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.trim().split(",");
            String itemName = parts[0];
            String itemDescription = parts[1];
            int itemRoom = Integer.parseInt(parts[2]);
            int attackPoints = Integer.parseInt(parts[3]);
            int hp = Integer.parseInt(parts[4]);
            Item item = new Item(itemId++, itemName, itemDescription, itemRoom, attackPoints, hp);
            items.put(item.getItemId(), item);
        }
        reader.close();
        return items;
    }

    public static Item pickupItem(String itemName, Map<Integer, Item> items, List<Item> playerInventory, int currentRoom) {
        for (Item item : new ArrayList<>(items.values())) {
            if (item.getItemName().equalsIgnoreCase(itemName) && item.getItemRoomId() == currentRoom) {
                playerInventory.add(item);
                return items.remove(item.getItemId());
            }
        }
        return null;
    }
//    static void handlePickup(Scanner scanner, String itemName, int currentRoom) {
//        Player.getPlayerInstance();
//        Item pickedItem = Item.pickupItem(itemName, items, Player.getInventory(), currentRoom);
//        if (pickedItem != null) {
//            System.out.println("\n'" + itemName.toUpperCase() + "' has been picked up from the room and successfully added to the player inventory.\n");
//        } else {
//            System.out.println("\nItem '" + itemName.toUpperCase() + "' not found in the room or already picked up.\n");
//        }
//    }

//    static void handleEquip(String itemName) {
//        Player player = Player.getPlayerInstance();
//        Item itemToEquip = null;
//        for (Item item : player.getInventory()) {
//            if (item.getItemName().equalsIgnoreCase(itemName)) {
//                itemToEquip = item;
//                break;
//            }
//        }
//        if (itemToEquip != null) {
//            System.out.println("You equipped: " + itemToEquip.getItemName());
//            System.out.println("Item Attack Level: " + itemToEquip.getItemAttackPoints());
//            Player.updateAttackPoints(itemToEquip.getItemAttackPoints());
//            System.out.println("Player Attack Level: " + Player.getPlayerInstance().getAttackPoints() + "\n");
//
//        } else {
//            System.out.println("Item '" + itemName + "' not found in the player inventory.\n");
//        }
//    }
//
//    static void handleUnequip(String itemName) {
//        Player player = Player.getPlayerInstance();
//        Item itemToUnequip = null;
//        for (Item item : player.getInventory()) {
//            if (item.getItemName().equalsIgnoreCase(itemName)) {
//                itemToUnequip = item;
//                break;
//            }
//        }
//        if (itemToUnequip != null) {
//            System.out.println("You unequipped: " + itemToUnequip.getItemName());
//            Player.resetAttackPoints();
//            System.out.println("Player Attack Level: " + Player.getPlayerInstance().getAttackPoints() + "\n");
//        } else {
//            System.out.println("Item '" + itemName + "' not found in the player inventory.\n");
//        }
//    }
//
//    public static void equipUnequipItem(String itemName) {
//        if (itemName.startsWith("UNEQUIP ")) {
//            String itemToUnequipName = itemName.substring(8);
//            handleUnequip(itemToUnequipName);
//        } else {
//            handleEquip(itemName);
//        }
//    }

    public static void inspectItem(String itemName, List<Item> playerInventory) {
        for (Item item : playerInventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                System.out.println("\n" + item.getItemDescription() + "\n");
                return;
            }
        }
        System.out.println("\n" + "Item '" + itemName + "' not found in the player inventory." + "\n");
    }
    public static void dropItem(String itemName, Map<Integer, Item> items, List<Item> playerInventory, int currentRoom) {
        Iterator<Item> iterator = playerInventory.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                iterator.remove();
                item.setItemRoomId(currentRoom);
                items.put(item.getItemId(), item);
                System.out.println("\n" + itemName + " has been dropped successfully from the player inventory. " + itemName + " can only be picked up from room " + currentRoom + "\n");
                System.out.println("Item's new room: " + item.getItemRoomId() + "\n");
                return;
            }
        }
        System.out.println("\n" + "Item '" + itemName + "' not found in the player inventory." + "\n");
    }

    public static void displayInventory(List<Item> playerInventory) {
        if (playerInventory.isEmpty()) {
            System.out.println("\n" + "You didn’t pick up any items yet.");
            System.out.println("-----------" + "\n");
        } else {
            System.out.println("\n" + "Your inventory:");
            for (Item item : playerInventory) {
                System.out.println("- " + item.getItemName());
            }
            System.out.println("-----------" + "\n");
        }
    }
    @Override
    public String toString() {
        return itemName + ", " +
                itemDescription;
    }
}