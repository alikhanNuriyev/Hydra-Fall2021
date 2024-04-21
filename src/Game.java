import java.io.IOException;
import java.util.*;
public class Game {
    public static void main(String[] args) throws IOException {

        Map map = new Map();
        map.Initialize("src//Rooms.txt");
        //map.InitializeItems("src//items.txt");
        //map.InitializePuzzles("src//puzzles.txt");
        Player Player1 = new Player(1, 50, 25, 0, map.getRooms().get(0));

        //map.listRooms();

        //StartGame(Player1, map.getRooms());


    }
    /*
    public static void StartGame(Player Player, ArrayList<Room> Map) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.print("Current location: " + Player.getCurrentRoom().getName());
        System.out.println();
        System.out.println(Player.getCurrentRoom().getDescription());
        System.out.print("\nWhich direction do you want to travel? (N, S, E, W) ");

        while(true) {
            String direction = input.next();

            //Inspect
            if(direction.equalsIgnoreCase("P"))
            {
                System.out.print("\nWhat item do you want to inspect? ");
                direction = input.next();

                Player.Inpsect(direction);
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
            if(direction.equalsIgnoreCase("G")||direction.equalsIgnoreCase("grab"))
            {
                System.out.print("\nWhat item do you want to grab? ");
                direction = input.next();

                Player.pickUp(direction);
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
            if(direction.equalsIgnoreCase("l")||direction.equalsIgnoreCase("look"))
            {
                System.out.println("These are the visible items in this room:");
                Player.showCurrentLocationInventory();
                System.out.print("\nWhich direction do you want to travel? (N, S, E, W) ");
                continue;
            }

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


            System.out.print("Current location: " + Player.getCurrentRoom().getName());
            if(Player.getCurrentRoom().CheckVisited()){ System.out.print(" (Visited)");}
            System.out.println();
            System.out.println(Player.getCurrentRoom().getDescription());

            if(Player.getCurrentRoom().hasPuzzle)
            {
                Player.getCurrentRoom().puzzle.startPuzzle();
            }

            System.out.print("\nWhich direction do you want to travel? (N, S, E, W) ");
            Map.get(Player.getCurrentRoom().getId() -1).setVisited();
        }

        input.close();
    }
    */

}