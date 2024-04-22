import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Game {
    public static void main(String[] args) throws IOException {

        Map map = new Map();
        map.Initialize("src//Rooms.txt");
        //map.listRooms();
        map.InitializeItems("src//Items.txt");
        map.InitializePuzzles("src//Puzzles.txt");
        map.InitializeMonsters("src//Monsters.txt");
        //map.listMonsters();
        Player Player = new Player(1, 50, 25, 0, map.getRooms().get(0));

        showMap();
        StartGame(Player, map.getRooms());


    }

    public static void StartGame(Player Player, ArrayList<Room> Map) throws IOException {
        Scanner input = new Scanner(System.in);
        String target = "";

        System.out.print("Current location: " + Player.getCurrentRoom().getName() + "RoomId: " + Player.getCurrentRoom().getId());
        System.out.println();
        System.out.println(Player.getCurrentRoom().getDescription());
        System.out.print("\nWhich direction do you want to travel? (N, S, E, W) ");

        while(true) {
            String direction = input.next();

            //Inspect
            if(direction.equalsIgnoreCase("P"))
            {
                System.out.print("\nWhat item do you want to inspect? ");
                input.nextLine();
                target = input.nextLine();

                Player.Inpsect(target);
                System.out.print("\nWhich direction do you want to travel? (N, S, E, W) ");
                continue;
            }

            //consume
            if(direction.equalsIgnoreCase("consume"))
            {
                System.out.print("\nWhat item do you want to consume? ");
                input.nextLine();
                target = input.nextLine();

                Player.Consume(target);
                System.out.print("\nWhich direction do you want to travel? (N, S, E, W) ");
                continue;
            }

            //equip
            if(direction.equalsIgnoreCase("equip"))
            {
                System.out.print("\nWhat item do you want to equip? ");
                input.nextLine();
                target = input.nextLine();

                Player.Equip(target);
                System.out.print("\nWhich direction do you want to travel? (N, S, E, W) ");
                continue;
            }



            //Access Inventory
            if(direction.equalsIgnoreCase("I"))
            {
                System.out.println("These are the Items in your inventory:");
                Player.showInventory();
                System.out.print("\nWhich direction do you want to travel? (N, S, E, W) ");
                continue;
            }




            //Grab Item
            if(direction.equalsIgnoreCase("pick")||direction.equalsIgnoreCase("pickup"))
            {
                System.out.print("\nWhat item do you want to pickup? ");
                input.nextLine();
                target = input.nextLine();

                Player.pickUp(target);
                System.out.print("\nWhich direction do you want to travel? (N, S, E, W) ");
                continue;
            }

            //Drop Item
            if(direction.equalsIgnoreCase("D")||direction.equalsIgnoreCase("drop"))
            {
                System.out.print("\nWhat item do you want to drop? ");
                direction = input.next();

                Player.Drop(direction);
                System.out.print("\nWhich direction do you want to travel? (N, S, E, W) ");
                continue;
            }

            //Search Room
            if(direction.equalsIgnoreCase("detective")||direction.equalsIgnoreCase("detect"))
            {
                System.out.println("These are the visible items in this room:");
                Player.showCurrentLocationInventory();
                Player.getCurrentRoom().viewPuzzle();
                Player.showCurrentLocationMonsters();
                System.out.print("\nWhich direction do you want to travel? (N, S, E, W) ");
                continue;
            }

            //Show Stats
            if(direction.equalsIgnoreCase("stats")||direction.equalsIgnoreCase("stat"))
            {
                Player.showStats();
                System.out.print("\nWhich direction do you want to travel? (N, S, E, W) ");
                continue;
            }

            //Show Map
            if(direction.equalsIgnoreCase("map")||direction.equalsIgnoreCase("m"))
            {
                showMap();
                System.out.print("\nWhich direction do you want to travel? (N, S, E, W) ");
                continue;
            }

            //Equip Item

            //Directional Navigation
            if (direction.equalsIgnoreCase("N")) {
                if(Player.CheckNorth() == 0)
                { System.out.println("You cannot move in that direction.");}

                else if (Player.CheckNorth() != 0) {
                    Player.Setlocation(Map.get(Player.CheckNorth()-1));
                }

            }

            else if (direction.equalsIgnoreCase("S")) {
                if(Player.CheckSouth() == 0)
                { System.out.println("You cannot move in that direction.");}

                else if (Player.CheckSouth() != 0) {
                    Player.Setlocation(Map.get(Player.CheckSouth()-1));
                }

            }

            else if (direction.equalsIgnoreCase("E")) {
                if(Player.CheckEast() == 0)
                { System.out.println("You cannot move in that direction.");}

                else if (Player.CheckEast() != 0) {
                    Player.Setlocation(Map.get(Player.CheckEast()-1));
                }

            }

            else if (direction.equalsIgnoreCase("W")) {
                if(Player.CheckWest() == 0)
                { System.out.println("You cannot move in that direction.");}

                else if (Player.CheckWest() != 0) {
                    Player.Setlocation(Map.get(Player.CheckWest()-1));
                }

            }
            else if(direction.equalsIgnoreCase("exit"))
            {
                System.out.println("Exiting Game");
                System.out.println("Thank you for playing.");
                break;
            }

                        else {
                System.out.println("Invalid Input");
            }


            System.out.print("Current location: " + Player.getCurrentRoom().getName() + "RoomId: " + Player.getCurrentRoom().getId());
            if(Player.getCurrentRoom().CheckVisited()){ System.out.print(" (Visited)");}
            System.out.println();
            System.out.println(Player.getCurrentRoom().getDescription());

            if(Player.getCurrentRoom().hasPuzzle)
            {
                Player.getCurrentRoom().puzzle.startPuzzle();
            }

            if(Player.getCurrentRoom().hasMonster)
            {
                Player.setEngagedMonster(Player.getCurrentRoom().getMonster());
                initiateCombat(input, Player, Player.getEngagedMonster());
            }

            System.out.print("\nWhich direction do you want to travel? (N, S, E, W) ");
            Map.get(Player.getCurrentRoom().getId() -1).setVisited();
        }

        input.close();
    }

    //Combat
    private static void initiateCombat(Scanner scanner, Player player, Monster monster) throws IOException {
        //int playerHealth = Player.getPlayerInstance().getCurrentHealth();
        System.out.println("WARNING a hostile " + monster.getMonsterName() + " approaches!");
        System.out.println("Player's Health: " + player.getPlayerCurrentHealth());
        player.setEngagedMonster(monster);


        int monsterHealth = player.getEngagedMonster().getMonsterHealthPoints();
        System.out.println(player.getEngagedMonster().getMonsterName() + "'s Health: " + monsterHealth);

        while (player.getPlayerCurrentHealth() > 0 && monsterHealth > 0) {
            System.out.println("Player's Turn:");
            System.out.print("Your action, type 'attack' to deal damage. \n");
            String action = scanner.next();
            scanner.nextLine();

            if (action.equalsIgnoreCase("attack")){
                //int playerDamage = calculatePlayerDamage();
                player.getEngagedMonster().modHealth(player.getPlayerAttackPoints());
                System.out.println("Player deals " + player.getPlayerAttackPoints() + " damage to " + player.getEngagedMonster().getMonsterName() + ".");
            }else
            {
                System.out.println("Invalid Input.");
                continue;
            }

            if (player.getEngagedMonster().getMonsterHealthPoints() <= 0) {
                System.out.println("Player defeats " + player.getEngagedMonster().getMonsterName() + "!");
                player.getEngagedMonster().setDefeated(true);
                player.defeatMonster();
                System.out.println("Congratulations! You have defeated the monster. \n");
                System.out.println("You leveled up! Your stats have increased!");
                break;
            }

            System.out.println("Monster's Turn:");
            int monsterDamage = player.getEngagedMonster().getMonsterAttackPoints();
            player.playerTakeDamage(monsterDamage);
            System.out.println(player.getEngagedMonster().getMonsterName() + " deals " + monsterDamage + " damage to the player.");

            if (player.getPlayerCurrentHealth() <= 0) {
                System.out.println("Player is defeated by " + player.getEngagedMonster().getMonsterName() + "!");
                handleGameOver(scanner);
                return;
            }
            System.out.println("Player's Health: " + player.getPlayerCurrentHealth());
            System.out.println(player.getEngagedMonster().getMonsterName() + "'s Health: " + player.getEngagedMonster().getMonsterHealthPoints());
        }
    }

    private static void showMap() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src//Utilities.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void handleGameOver(Scanner scanner) throws IOException {
        System.out.println("Game Over! You have two choices:");
        System.out.println("1. Exit");
        System.out.println("2. Start New Game");
        System.out.print("Enter your choice (1/2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Exiting the game.");
                System.exit(0);
                break;
                case 2:
                System.out.println("Starting a new game. Enter leave fight command");
                Map map = new Map();
                map.Initialize("src//Rooms.txt");
                map.InitializeItems("src//Items.txt");
                map.InitializePuzzles("src//Puzzles.txt");
                map.InitializeMonsters("src//Monsters.txt");
                Player player = new Player(1, 50, 25, 0, map.getRooms().get(0));
                StartGame(player, map.getRooms());
                break;
                default:
            System.out.println("Invalid choice. Exiting the game.");
            System.exit(0);
        }
    }
}


