import java.util.Scanner;

public class Puzzle {

	// Alikhan - Here are some of generic instance variables for the Puzzle class. Feel free to add, change, or delete anything as long as it makes sense for the requirements 

	private int puzzleId;
	private String puzzleDescription;
	private String puzzleAnswer;
	private String puzzleHint;
	private int attemptsAllowed;
	private boolean puzzleSolved;
	
	// Alikhan - Here is the constructor for Puzzle class. Feel free to add, change, or delete anything as long as it makes sense for the requirements 

	 public Puzzle(int puzzleId, String puzzleDescription, String puzzleAnswer, String puzzleHint, int attemptsAllowed) {
	        this.puzzleId = puzzleId;
	        this.puzzleDescription = puzzleDescription;
	        this.puzzleAnswer = puzzleAnswer;
	        this.puzzleHint = puzzleHint;
	        this.attemptsAllowed = attemptsAllowed;
	        this.puzzleSolved = false;
	    }
	 
		// Alikhan - Here is the getters and setters for Puzzle class. Feel free to add, change, or delete anything as long as it makes sense for the requirements 

	 public int getPuzzleId() {
		 return puzzleId;
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

	 public int getAttemptsAllowed() {
		 return attemptsAllowed;
		 }
	 
	 public boolean isPuzzleSolved() {
		 return puzzleSolved;
		 }

	 public void setPuzzleSolved(boolean puzzleSolved) {
		 this.puzzleSolved = puzzleSolved;
		 }

	    
	// Alikhan - Here are some of the methods we will need for the Puzzle class. After reading through the SRS document and reviewing the 
	// changed + unchanged features for Puzzle class.  We also need a method to hand reading the items txt file.
	        

	    public static void handlePuzzle() {	                                 
	        
	    }
}
