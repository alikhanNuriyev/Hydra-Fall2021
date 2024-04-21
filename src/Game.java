import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
public class Game {
    private ArrayList<Room> rooms_list = new ArrayList<>();

    private String filename;
    private ArrayList<Puzzle> puzzleArrayList = new ArrayList<>();
    private ArrayList<Item> itemArrayList = new ArrayList<>();
    private Room currentRoom;
    private Room prevRoom;
    private transient FileInputStream inputStream;
    private transient Scanner fileIn;

    void InitializeRooms(String filename) throws FileNotFoundException {

        Scanner r_scanner = new Scanner(new File(filename));
        r_scanner.useDelimiter("~|\n|,");

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
    public void populateItems(File file) throws FileNotFoundException {

        Scanner i_scanner = new Scanner(new File(filename));
        i_scanner.useDelimiter("~|\n|,");

            while (i_scanner.hasNext()) {
                int itemId = i_scanner.nextInt();
                String itemName = i_scanner.next();
                String itemType = i_scanner.next();
                String itemDescription = i_scanner.next();
                int itemRoomId = i_scanner.nextInt();
                int itemAttackPoints = i_scanner.nextInt();
                int itemHealthPoints = i_scanner.nextInt();
                int healingAmount = i_scanner.nextInt();

                this.itemArrayList.add(int itemId, String itemName, String itemType, String itemDescription, int itemRoom, int itemAttackPoints, int itemHealthPoints, double healingAmount)


        }
    }
        void InitializeMonster(String filename) throws FileNotFoundException {

            Scanner m_scanner = new Scanner(new File(filename));
            m_scanner.useDelimiter("~|\n|,");
            //Reads file
            while (m_scanner.hasNext()) {
                int monsterID = m_scanner.nextInt();
                String monsterName = m_scanner.next();
                String monsterDescription = m_scanner.next();
                int monsterHealthPoints = m_scanner.nextInt();
                int monsterAttackPoints = m_scanner.nextInt();
                String monsterLocation = m_scanner.next();


                Monster newMonster = new Monster(monsterID, monsterName, monsterDescription, monsterHealthPoints, monsterAttackPoints, monsterLocation) {


                }


            }}}


