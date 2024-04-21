import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Puzzle {

	// Alikhan - Here are some of generic instance variables for the Puzzle class. Feel free to add, change, or delete anything as long as it makes sense for the requirements 
	// Josiah - Added roomId, puzzleName, attempts, remainingAttempts, puzzleFailed, changed getter and setter methods

	private int puzzleId;
	private int puzzleRoomId;
	private String puzzleName;
	private String puzzleDescription;
	private String puzzleAnswer;
	private String puzzleHint;
	private int attempts;
	private int remainingAttempts;
	private boolean puzzleSolved = false;
	private boolean puzzleFailed = false;
	
	// Alikhan - Here is the constructor for Puzzle class. Feel free to add, change, or delete anything as long as it makes sense for the requirements

	public Puzzle(int puzzleId, int puzzleRoomId, String puzzleName, String puzzleDescription, String puzzleAnswer, String puzzleHint, int attempts) {
		this.puzzleId = puzzleId;
		this.puzzleRoomId = puzzleRoomId;
		this.puzzleName = puzzleName;
		this.puzzleDescription = puzzleDescription;
		this.puzzleAnswer = puzzleAnswer;
		this.puzzleHint = puzzleHint;
		this.attempts = attempts;
	}
	  public Puzzle(String puzzleName, String puzzleDescription, String puzzleAnswer, int puzzleRoomId, int attempts) {
	        this.puzzleName = puzzleName;
	        this.puzzleDescription = puzzleDescription;
	        this.puzzleAnswer = puzzleAnswer;
	        this.puzzleRoomId = puzzleRoomId;
	        this.attempts = attempts;
	    }


	// Alikhan - Here is the getters and setters for Puzzle class. Feel free to add, change, or delete anything as long as it makes sense for the requirements

	public int getPuzzleId() {
		return puzzleId;
	}

	public int getPuzzleRoomId() {
		return puzzleRoomId;
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
//	void startPuzzle() throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		remainingAttempts = attempts;
//
//		if (puzzleSolved) {
//			System.out.println("You have already successfully solved this puzzle.");
//		}
//		else {
//			while (!puzzleSolved) {
//				if(remainingAttempts <=0) {
//					System.out.println("You have no attempts left. Leave and re-enter room to try again.");
//					break;
//				}else if(puzzleFailed)
//				{
//					System.out.println("You have failed this puzzle.");
//					break;
//				}
//				else {
//					System.out.println(puzzleDescription);
//					String input = reader.readLine();
//					if(input.equalsIgnoreCase("hint"))
//					{
//						giveHint();
//					}else if(input.equalsIgnoreCase("quit"))
//					{
//						puzzleFailed = true;
//						break;
//					}
//					else //Add functionality to solve different type of puzzle.
//					{
//						solvePuzzle(input);
//					}
//				}
//			}
//		}
//	}
//
//	//Added Solve puzzle
//	void solvePuzzle(String a) {
//		if (a.equalsIgnoreCase(puzzleAnswer)) {
//			System.out.println("Correct Answer! You have solved the puzzle correctly!.");
//			puzzleSolved = true;
//		}
//		else
//		{
//			remainingAttempts--;
//			System.out.println("Incorrect answer. You have " + remainingAttempts + " attempts left");
//
//		}
//	}
//
//	//Josiah - added Solve Rng puzzle method
//	void solveRngPuzzle()
//	{
//
//	}
//
//	//Josiah - Added hive hint method
//	void giveHint()
//	{
//		System.out.println(puzzleHint);
//	}
	    



//	    public static Map<Integer, Puzzle> readPuzzles(String filename) throws IOException {
//	        Map<Integer, Puzzle> puzzles = new HashMap<>();
//	        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//	            String line;
//	            int puzzleId = 1;
//	            int currentRoom = 0;
//	            String description = null;
//	            String answer = null;
//	            String hint = null;
//
//	            while ((line = reader.readLine()) != null) {
//	                line = line.trim();
//	                if (line.startsWith("Room:")) {
//	                    currentRoom = Integer.parseInt(line.substring(line.indexOf(":") + 2));
//	                } else if (line.startsWith("Puzzle Name:")) {
//	                    // Not used
//	                } else if (line.startsWith("Description:")) {
//	                    description = line.substring(line.indexOf(":") + 2);
//	                } else if (line.startsWith("Answer:")) {
//	                    answer = line.substring(line.indexOf(":") + 2);
//	                } else if (line.startsWith("Hint:")) {
//	                    hint = line.substring(line.indexOf(":") + 2);
//	                } else if (line.startsWith("Attempts:")) {
//	                    int attempts = Integer.parseInt(line.substring(line.indexOf(":") + 2));
//	                    Puzzle puzzle = new Puzzle(puzzleId++, description, answer, hint, attempts);
//	                    puzzles.put(currentRoom, puzzle);
//	                    description = null;
//	                    answer = null;
//	                    hint = null;
//	                }
//	            }
//	        }
//	        return puzzles;
//	    }
//
//	    public static void handlePuzzle(Scanner scanner, int nextRoom, Map<Integer, Puzzle> puzzles) {
//	        Puzzle currentPuzzle = puzzles.get(nextRoom);
//	        System.out.println("You encounter a puzzle: " + currentPuzzle.getPuzzleDescription());
//
//	        int remainingAttempts = currentPuzzle.getAttempts();
//	        boolean hintProvided = false;
//
//	        while (remainingAttempts > 0 && !currentPuzzle.isPuzzleSolved()) {
//	            System.out.print("Enter your answer (Attempts left: " + remainingAttempts + "):");
//	            String answerInput = scanner.nextLine();
//
//	            if (answerInput.equalsIgnoreCase(currentPuzzle.getPuzzleAnswer())) {
//	                System.out.println("\nYou solved the puzzle correctly! \n");
//	                currentPuzzle.setPuzzleSolved(true);
//	                break;
//	            } else {
//	                remainingAttempts--;
//	                if (remainingAttempts > 0) {
//	                    System.out.println("\nThe answer you provided is wrong. Try again. (Attempts left: " + remainingAttempts + ")");
//	                    if (!hintProvided) {
//	                        System.out.println("Here's a hint: " + currentPuzzle.getPuzzleHint());
//	                        hintProvided = true;
//	                    }
//	                } else {
//	                    System.out.println("\nOut of attempts. You failed to solve the puzzle. \n");
//	                    currentPuzzle = puzzles.get(nextRoom);
//	                }
//	            }
//	        }
//	    }
}
