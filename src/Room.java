import java.io.IOException;
import java.util.*;


public class Room {

    private static Monster currentMonster; // Add declaration for currentMonster
    private static int initialHealthLevel;
    private static int initialAttackLevel;
    private static Set<String> defeatedMonsters = new HashSet<>(); // Store defeated monsters

   

//
//    static void exploreRoom(int currentRoom, Scanner scanner) {
//        System.out.println("\nExploring the room...");
//        boolean foundItems = false;
//        for (Item item : items.values()) {
//            if (item.getItemRoomId() == currentRoom) {
//                System.out.println("You found an item: " + item.getItemName());
//                foundItems = true;
//            }
//        }
//        if (foundItems) {
//            System.out.println("Do you want to pick up any items? (Y/N)");
//            String pickUpInput = scanner.nextLine().toUpperCase();
//            if (pickUpInput.equals("Y")) {
//                System.out.println("Enter the name of the item you want to pick up: ");
//                String itemName = scanner.nextLine();
//                handlePickup(scanner, itemName, currentRoom);
//            }
//        } else {
//            System.out.println("You didn't find any items in this room.\n");
//        }
//    }
//
//    static void handlePickup(Scanner scanner, String itemName, int currentRoom) {
//        Item pickedItem = Item.pickupItem(itemName, items, Player.getPlayerInstance().getInventory(), currentRoom);
//        if (pickedItem != null) {
//            System.out.println("\n'" + itemName.toUpperCase() + "' has been picked up from the room and successfully added to the player inventory.\n");
//        } else {
//            System.out.println("\nItem '" + itemName.toUpperCase() + "' not found in the room or already picked up.\n");
//        }
//    }

//    public static void handleMovement(String userInput) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        int currentRoom = Player.getPlayerInstance().getCurrentRoom();
//        int nextRoom = connections.get(currentRoom).get(userInput);
//        Player.getPlayerInstance().setCurrentRoom(nextRoom);
//        incrementVisits(nextRoom);
//
//        // Check for monster interaction after moving to the next room
//        handleMonsterInteraction(nextRoom, scanner);
//
//        if (puzzles.containsKey(nextRoom) && !puzzles.get(nextRoom).isPuzzleSolved()) {
//            Puzzle.handlePuzzle(new Scanner(System.in), nextRoom, puzzles); // Pass the 'puzzles' map as the third argument
//        }
//    }

//    public static void handleMonsterInteraction(int currentRoom, Scanner scanner) throws IOException {
//        Iterator<Monster> iterator = Monster.readMonsters("monsters.txt").values().iterator();
//        while (iterator.hasNext()) {
//            Monster monster = iterator.next();
//            if (monster.getMonsterLocation() == currentRoom && !monster.isDefeated() && !defeatedMonsters.contains(monster.getMonsterName())) {
//                System.out.println("You encountered a " + monster.getMonsterName() + "!");
//                System.out.println("Commands:");
//                System.out.println("examine: Examines the monster and displays Description and Attack Damage.");
//                System.out.println("fight: Initiate a fight with the monster.");
//                System.out.println("ignore: Player ignores monster, and monster disappears.");
//                System.out.println("explore: Search the room for items or puzzles.\n");
//
//                initialHealthLevel = Player.getPlayerInstance().getCurrentHealth();
//                initialAttackLevel = Player.getPlayerInstance().getAttackPoints();
//
//                currentMonster = monster;
//
//                boolean continueCombat = true;
//                while (continueCombat) {
//                    System.out.print("Enter your command: ");
//                    String command = scanner.nextLine().toLowerCase();
//
//                    switch (command) {
//                        case "examine":
//                            System.out.println("Description: " + currentMonster.getMonsterDescription());
//                            System.out.println("Attack Damage: " + currentMonster.getMonsterAttackPoints());
//                            break;
//                        case "fight":
//                            initiateCombat(scanner);
//                            break;
//                        case "ignore":
//                            System.out.println("You ignore the " + currentMonster.getMonsterName() + ".\n");
//                            iterator.remove();
//                            defeatedMonsters.add(currentMonster.getMonsterName());
//                            currentMonster = null;
//                            return;
//                        case "explore":
//                            exploreRoom(currentRoom, scanner);
//                            break;
//                        case "leave fight":
//                            Player.getPlayerInstance().setCurrentHealth(initialHealthLevel);
//                            Player.getPlayerInstance().setAttackPoints(initialAttackLevel);
//                            System.out.println("Returning to the previous room.\n");
//                            continueCombat = false;
//                            break;
//                        default:
//                            System.out.println("Invalid command! Please try again. \n");
//                    }
//                }
//            }
//        }
//    }
//
//
//    private static void initiateCombat(Scanner scanner) throws IOException {
//        int playerHealth = Player.getPlayerInstance().getCurrentHealth();
//        System.out.println("Player's Health: " + playerHealth);
//
//        int monsterHealth = currentMonster.getMonsterHealthPoints();
//        System.out.println(currentMonster.getMonsterName() + "'s Health: " + monsterHealth);
//
//        while (playerHealth > 0 && monsterHealth > 0) {
//            System.out.println("Player's Turn:");
//            System.out.println("1. Attack");
//            System.out.println("2. Heal");
//            System.out.println("3. Inventory");
//            System.out.print("Choose your action: \n");
//            int action = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (action) {
//                case 1:
//                    int playerDamage = calculatePlayerDamage();
//                    monsterHealth -= playerDamage;
//                    System.out.println("Player deals " + playerDamage + " damage to " + currentMonster.getMonsterName() + ".");
//                    break;
//                case 2:
//                    Item.displayInventory(Player.getPlayerInstance().getInventory());
//                    System.out.println("Enter the name of the item you want to use for healing or 'cancel' to go back: ");
//                    String healItemName = scanner.nextLine();
//                    if (!healItemName.equalsIgnoreCase("cancel")) {
//                        Player.handleHeal(healItemName);
//                    }
//                    break;
//                case 3:
//                    Item.displayInventory(Player.getPlayerInstance().getInventory());
//                    System.out.println("Enter the name of the item you want to use or 'cancel' to go back: ");
//                    String itemName = scanner.nextLine();
//                    if (!itemName.equalsIgnoreCase("cancel")) {
//                        Item.equipUnequipItem(itemName);
//                    }
//                    break;
//                default:
//                    System.out.println("Invalid action! Please try again.");
//            }
//
//            if (monsterHealth <= 0) {
//                System.out.println("Player defeats " + currentMonster.getMonsterName() + "!");
//                currentMonster.setDefeated(true);
//                defeatedMonsters.add(currentMonster.getMonsterName());
//                System.out.println("Congratulations! You have defeated the monster. \n");
//                currentMonster = null;
//                break;
//            }
//            System.out.println("Monster's Turn:");
//            int monsterDamage = calculateMonsterDamage();
//            playerHealth -= monsterDamage;
//            System.out.println(currentMonster.getMonsterName() + " deals " + monsterDamage + " damage to the player.");
//
//            if (playerHealth <= 0) {
//                System.out.println("Player is defeated by " + currentMonster.getMonsterName() + "!");
//                handleGameOver(scanner);
//                return;
//            }
//            System.out.println("Player's Health: " + playerHealth);
//            System.out.println(currentMonster.getMonsterName() + "'s Health: " + monsterHealth);
//        }
//    }
//    private static int calculatePlayerDamage() {
//        int playerDamage = Player.getPlayerInstance().getAttackPoints();
//        Item equippedItem = Player.getPlayerInstance().getEquippedItem();
//        if (equippedItem != null) {
//            playerDamage += equippedItem.getItemAttackPoints();
//        }
//        return playerDamage;
//    }
//    private static int calculateMonsterDamage() {
//        int monsterDamage;
//        Random random = new Random();
//        int randomNumber = random.nextInt(10) + 1;
//        if (randomNumber < currentMonster.getThreshold()) {
//            monsterDamage = currentMonster.getMonsterAttackPoints() * 2;
//        } else {
//            monsterDamage = currentMonster.getMonsterAttackPoints();
//        }
//        return monsterDamage;
//    }
//
//  
//
//    public static void handleGameOver(Scanner scanner) throws IOException {
//        System.out.println("Game Over! You have two choices:");
//        System.out.println("1. Exit");
//        System.out.println("2. Start New Game");
//        System.out.print("Enter your choice (1/2): ");
//        int choice = scanner.nextInt();
//        scanner.nextLine();
//
//        switch (choice) {
//            case 1:
//                System.out.println("Exiting the game.");
//                System.exit(0);
//                break;
//            case 2:
//                System.out.println("Starting a new game. Enter leave fight command");
//                Room.initializeGame();
//                break;
//            default:
//                System.out.println("Invalid choice. Exiting the game.");
//                System.exit(0);
//        }
//    }
    protected int id;
    protected boolean is_visited;

    protected String name;
    protected String description;

    protected int N;
    protected int S;
    protected int E;
    protected int W;

    protected ArrayList<Item> Inventory = new ArrayList<>();

    protected Puzzle puzzle;
    boolean hasPuzzle;

    public Room(int id, String name, String description, int north_room, int south_room, int east_room, int west_room) {
        this.id = id;
        this.is_visited = false;
        this.name = name;
        this.description = description;
        this.N = north_room;
        this.S = south_room;
        this.E = east_room;
        this.W = west_room;
    }

    void setPuzzle(Puzzle p)
    {
        this.puzzle = p;
        hasPuzzle = true;
    }

    void disablePuzzle()
    {
        hasPuzzle = false;
    }
    public int getId() {
        return id;
    }

    public boolean isIs_visited() {
        return is_visited;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getN() {
        return N;
    }

    public int getS() {
        return S;
    }

    public int getE() {
        return E;
    }

    public int getW() {
        return W;
    }

    void setVisited()
    {
        is_visited = true;
    }

    Boolean CheckVisited()
    {
        return is_visited;
    }

    void addItem(Item item)
    {
        this.Inventory.add(item);
    }

    void RemoveItem(int i)
    {
        Inventory.remove(i);
    }

    void inspect()
    {
        for(Item i : Inventory)
        {
            System.out.println(i.toString());
        }
    }


    @Override
    public String toString() {
        return "Room{" +
                "id: " + id +
                ", is_visited: " + is_visited +
                ", Name: " + name +
                ", Description: '" + description + '\'' +
                ", N: " + N +
                ", S: " + S +
                ", E: " + E +
                ", W: " + W +
                '}';
    }
}
