import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {

    protected ArrayList<Room> rooms_list = new ArrayList<>();
    protected String filename;

    Map()
    {

    }

    void Initialize(String filename) throws FileNotFoundException {

        Scanner r_scanner = new Scanner(new File(filename));
        r_scanner.useDelimiter("~|\n");

        while (r_scanner.hasNext()) {
            int id = r_scanner.nextInt();
            String name = r_scanner.next();
            String description = r_scanner.next();
            int north = r_scanner.nextInt();
            int south = r_scanner.nextInt();
            int east = r_scanner.nextInt();
            int west = r_scanner.nextInt();

            Room newRoom = new Room(id, name, description, north, south, east, west);
            rooms_list.add(newRoom);

        }
        r_scanner.close();
    }

    protected ArrayList<Item> itemList = new ArrayList<>();
    void InitializeItems(String filename) throws FileNotFoundException {

        Scanner i_scanner = new Scanner(new File(filename));
        i_scanner.useDelimiter("~|\n|");

        while (i_scanner.hasNext())
        {
            int id = Integer.parseInt(i_scanner.nextLine());
            int roomId = Integer.parseInt(i_scanner.nextLine());
            String name = i_scanner.nextLine();
            String type = i_scanner.nextLine();
            String desc = i_scanner.nextLine();
            int atk = Integer.parseInt(i_scanner.nextLine());
            int health = Integer.parseInt(i_scanner.nextLine());
            float heal = Integer.parseInt(i_scanner.nextLine());
            itemList.add(new Item(id, roomId, name, type, desc, atk, health, heal));
        }
        loadRoomInventory();
        i_scanner.close();
    }
    void loadRoomInventory() {
        for (Room i : rooms_list) {
            for(Item j : itemList)
            {
                if(j.getItemRoom() == i.getId())
                {
                    i.addItem(j);
                }
            }

        }
    }

    protected ArrayList<Puzzle> puzzleList = new ArrayList<>();

    void InitializePuzzles(String filename) throws FileNotFoundException {

        Scanner i_scanner = new Scanner(new File(filename));
        i_scanner.useDelimiter("~|\n|");

        while (i_scanner.hasNext())
        {
            int id = Integer.parseInt(i_scanner.nextLine());
            int roomId = Integer.parseInt(i_scanner.nextLine());
            String name = i_scanner.nextLine();
            String desc = i_scanner.nextLine();
            String solution = i_scanner.nextLine();
            String hint = i_scanner.nextLine();
            puzzleList.add(new Puzzle(id, roomId, name, desc, solution, hint, 3));
        }
        loadRoomPuzzles();
        i_scanner.close();

    }

    void loadRoomPuzzles() {
        for (Room r : rooms_list) {
            for(Puzzle p : puzzleList)
            {
                if(p.getRoomId() == r.getId())
                {
                    r.setPuzzle(p);
                }
            }

        }
    }
    public ArrayList<Room> getRooms() {
        return rooms_list;
    }

    void listRooms()
    {
        for(Room i : rooms_list)
        {
            System.out.println(i);
        }
    }


}
