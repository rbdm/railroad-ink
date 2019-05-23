In addition to the features that are auto-graded, the graphical user interface
of our project implements the following features:

*(Remove those that are unimplemented)*

/**  I don't think we need to write this part because it can be auto-graded
 - Fix the isTilePlacementWellFormed() of the RailroadInk class (Task 1,2)
 - Fix the isBoardStringWellFormed() method of the RailroadInk class (Task 3)
 - Fix the areConnectedNeighbours() method of the RailroadInk class (Task 5)
 - Fix the isValidPlacementSequence() method of the RailroadInk class (Task 6)
 - Fix the generateDiceRoll() method of the RailroadInk class (Task 7)
 - Fix the getBasicScore() method of the RailroadInk class (Task 8)
 - Fix the generateMove() method of the RailroadInk class (Task 10)
 - Fix the getAdvancedScore() method of the RailroadInk class (Task 12)
 */

 - The game can be played by 1 human/computer player.(Task 9)
 - It also supports multiple human players and(or) AIs (user can select the difficulty of AI - Easy, Hard). (Addition)
 - Allow the player to choose tiles from a generated dice roll(Task 9)
 - The tiles would snap to the nearest position if valid, otherwise snap to home position and show warning message "Invalid tile placement." at bottom. (Task 9)
 - The game ends either after 7 rounds, or there are no more valid moves.(Task 9 + Addition)
 - Compute the total score for the completed game(Task 9 + Addition)
 - Implement a smarter AI with DFS, Greedy algorithm and softmax. (Task 13)

 * (Other additional features: )
 - In each turn, the player need to place all 4 tiles that generated from the dice roll, unless there are no more valid placements can be made.
 - The players can use special tiles at most once in one round and 3 times per game.
 - It implements a "Take Back" button that take back all the tiles just placed by the current player in current round.
 - It implements the stage of top 5 scores (store the best 5 score into a txt).
 - It implements a label that give some hints of illegal inputs (Easy for a new user to run).
 
 
 
