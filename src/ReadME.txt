Spacebound Odyssey - Text-Based Adventure Game

Welcome to Spacebound Odyssey, a Java-based text adventure game set in the distant future of 2247. 
Embark on an epic journey aboard the starship "Odyssey," where you'll explore uncharted regions of the galaxy, confront challenges, and uncover the truth behind a mysterious distress signal.

How to Play
Installation: No installation required. Simply download the game files and run the Main.java file in your Java IDE.
Gameplay: Upon starting the game, you'll be introduced to the narrative and prompted with text-based commands to interact with the game world.
Navigation: Move between rooms using directional commands (N for North, E for East, S for South, W for West).
Monster: Engage in combat with monsters using the "attack" command.
Puzzle: Solve puzzles by interacting with them and submitting answers.
Item: Manage artifacts found throughout the game to enhance gameplay.
Progression: Track your progression, level up, and manage inventory.
Game Settings: Save your game progress and load saved games to continue gameplay later.

Commands: Use the following commands during gameplay:
N,S,E,W: This feature will allow players to move between rooms and within rooms.
Pickup + itemName: This feature will pickup a specific item in the current room.
Drop + itemName: This feature will drop a specific item in the current room.
Equip: This feature will equip an item from playe's inventory.
Consume: This feature will consume an item form player's inventory.
Level Up: This feature will allow player to level up their stats.
Stats: This feature will allow player to access their stats.
Detective Mode: This feature will display all items and puzzles in the current room.
Inventory: This feature will display all items in players inventory.
Map: This feature will allow the player to check the map.
Save: This allows player to save the game their currently on and save any progress, items, levels, and floors completed.
Load: This feature will allow so that the player, after saving a game, to easily load their game back with the correct amount of progress.
Pause/Resume : This feature will allow it so that the player will be able to pause the game and resume the game.
Restart: This feature will allow a restart to a level losing progress of the level they are currently on but not the entire game progress.


File Structure
Game.java: Main class to start the game.
Rooms.java: Class responsible for handling rooms, connections, descriptions, items, and puzzles.
Player.java: Class representing the player and their inventory.
Item.java: Class for handling items and their interactions.
Puzzle.java: Class for handling puzzles and their solutions.
Monster.java: Class for handling monster interactions and fights.
Connections.txt: Text file containing room connections.
Rooms.txt: Text file containing roomId, roomName, roomDescriptions, roomNavigation.
Items.txt: Text file containing itemName, itemDescription, itemRoom.
Puzzles.txt: Text file containing puzzleRoom, puzzleName, puzzleDescription, puzzleAnswer, puzzleHint, puzzleAttempts.
Monsters.txt: Text file containing monsterId, monsterName, monsterDescription, monsterHealthPoints, monsterAttackPoints, monsterRoom

1. Connections.txt
This text file defines the connections between different rooms in the game.
Each line represents a room and its connections in the following format: RoomNumber: Direction1: ConnectedRoom1 Direction2: ConnectedRoom2 ...
RoomNumber: The unique identifier for the room.
Direction: The direction leading to the connected room (e.g., N for North, S for South, E for East, W for West).
ConnectedRoom: The room number to which the direction leads.

2. Rooms.txt
This text file contains descriptions for each room in the game.
Each room description starts with the room number followed by the description text. An empty line separates each room's description.
Example:
1: Free Weights Room
As you step into the first room, the smell of the room leaves you thinking...
Is this worth it? The room is full of weight equipments that will increase your HP and ATTK.

3. Items.txt
This text file contains the details of items available in the game. Each line represents an item in the following format: ItemName, ItemDescription, RoomNumber
ItemName: The name of the item.
ItemDescription: Description of the item.
RoomNumber: The room number where the item is located.
Example:
Jump-rope, A sturdy jump-rope for cardio exercises., 1

4. Puzzles.txt
This text file defines puzzles encountered in certain rooms of the game.
Each puzzle entry contains the puzzle name, description, answer, hint, and the number of attempts allowed.
Example:
Room: 4
Puzzle Name: Puzzle1
Description: I speak without a mouth and hear without ears. I have no body, but I come alive with the wind.
Answer: Echo
Hint: Think about sounds in nature.
Attempts: 3
d adventure experience, challenging them to explore, strategize, and overcome obstacles as they embark on an epic journey through the cosmos.

5. Monsters.txt
This text file contains descriptions for monsters encountered in certain rooms of the game. 
Each monster entry includes the monster's name, description, attributes, and the room where it appears.
Example:
ID: 1
Name: Slimeoid Prime
Description: A mix of slime and alien stuff. Watch out for its acid!
Health Points: 200
Attack Points: 30
Location: R5
Each entry provides details about the appearance, abilities, and location of the monster within the game world. Players must strategize and utilize their combat skills to defeat these formidable foes as they progress through Spacebound Odyssey.






