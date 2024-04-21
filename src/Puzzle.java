import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Puzzle {

	// Alikhan - Here are some of generic instance variables for the Puzzle class. Feel free to add, change, or delete anything as long as it makes sense for the requirements 
	// Josiah - Added roomId, puzzleName, attempts, remainingAttempts, puzzleFailed, changed getter and setter methods

	private int puzzleId;
	private int roomId;
	private String puzzleName;
	private String puzzleDescription;
	private String puzzleAnswer;
	private String puzzleHint;
	private int attempts;
	private int remainingAttempts;
	private boolean puzzleSolved = false;
	private boolean puzzleFailed = false;
	
	// Alikhan - Here is the constructor for Puzzle class. Feel free to add, change, or delete anything as long as it makes sense for the requirements

	public Puzzle(int puzzleId, int roomId, String puzzleName, String puzzleDescription, String puzzleAnswer, String puzzleHint, int attempts) {
		this.puzzleId = puzzleId;
		this.roomId = roomId;
		this.puzzleName = puzzleName;
		this.puzzleDescription = puzzleDescription;
		this.puzzleAnswer = puzzleAnswer;
		this.puzzleHint = puzzleHint;
		this.attempts = attempts;
	}


	// Alikhan - Here is the getters and setters for Puzzle class. Feel free to add, change, or delete anything as long as it makes sense for the requirements

	public int getPuzzleId() {
		return puzzleId;
	}

	public int getRoomId() {
		return roomId;
	}

	public String getPuzzleName() {
		return puzzleName;
	}

	public String getPuzzleDescription() {
		return puzzleDescription;
	}

	public String getPuzzleAnswer() {
		return puzzleAnswer;
	}

	public String getPuzzleHint() {
		return puzzleHint;
	}

	public int getAttempts() {
		return attempts;
	}

	public int getRemainingAttempts() {
		return remainingAttempts;
	}

	public boolean isPuzzleSolved() {
		return puzzleSolved;
	}

	public boolean isPuzzleFailed() {
		return puzzleFailed;
	}

	public void setPuzzleSolved(boolean puzzleSolved) {
		this.puzzleSolved = puzzleSolved;
	}

	public void setPuzzleFailed(boolean puzzleFailed) {
		this.puzzleFailed = puzzleFailed;
	}

	// Alikhan - Here are some of the methods we will need for the Puzzle class. After reading through the SRS document and reviewing the
	// changed + unchanged features for Puzzle class.  We also need a method to hand reading the items txt file.
	//

	    public static void handlePuzzle() {	                                 
	        
	    }

	//Josiah - Added startPuzzle and solve
	void startPuzzle() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		remainingAttempts = attempts;

		if (puzzleSolved) {
			System.out.println("You have already successfully solved this puzzle.");
		}
		else {
			while (!puzzleSolved) {
				if(remainingAttempts <=0) {
					System.out.println("You have no attempts left. Leave and re-enter room to try again.");
					break;
				}else if(puzzleFailed)
				{
					System.out.println("You have failed this puzzle.");
					break;
				}
				else {
					System.out.println(puzzleDescription);
					String input = reader.readLine();
					if(input.equalsIgnoreCase("hint"))
					{
						giveHint();
					}else if(input.equalsIgnoreCase("quit"))
					{
						puzzleFailed = true;
						break;
					}
					else //Add functionality to solve different type of puzzle.
					{
						solvePuzzle(input);
					}
				}
			}
		}
	}

	//Added Solve puzzle
	void solvePuzzle(String a) {
		if (a.equalsIgnoreCase(puzzleAnswer)) {
			System.out.println("Correct Answer! You have solved the puzzle correctly!.");
			puzzleSolved = true;
		}
		else
		{
			remainingAttempts--;
			System.out.println("Incorrect answer. You have " + remainingAttempts + " attempts left");

		}
	}

	//Josiah - added Solve Rng puzzle method
	void solveRngPuzzle()
	{

	}

	//Josiah - Added hive hint method
	void giveHint()
	{
		System.out.println(puzzleHint);
	}
}
