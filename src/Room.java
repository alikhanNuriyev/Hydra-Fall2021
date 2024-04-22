import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Room {
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

    private Monster monster;
    boolean hasMonster;

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

    void setMonster(Monster m)
    {
        this.monster = m;
        hasMonster = true;
    }

    void viewMonster()
    {
        System.out.println("You spy a " + monster.getMonsterName() + ", "+ monster.getMonsterDescription());
    }

    Monster getMonster()
    {
        return monster;
    }


    void viewPuzzle()
    {
        System.out.println("There is a " + puzzle.getPuzzleName() + " puzzle in this room.");
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
