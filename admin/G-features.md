In addition to the features that are auto-graded, the graphical user interface
of our project implements the following features:
*(Remove those that are unimplemented)*

 - The game can be played by human and/or AI player.
 - For AI type players, the user can set the difficulty (Easy or Hard).
 - The game also supports multiple human players and/or AIs. It should support any natural number but we just set it between 1 to 4 player.
 - Allow the player to choose tiles from a generated dice roll. On the same round, all players have the same dice roll.
 - The tiles are separated into special and regular tile, all draggable and rotatable with right click
 - The players can use special tiles at most once in one round and 3 times per game, 
   and each special tiles can only be used once (follows the rules of the original board game)
 - In each turn, the player need to place all 4 tiles that generated from the dice roll, unless there are no more valid placements that can be made.
 - After dragged, if it is on the board the tiles would snap to the nearest square, otherwise snap to home position and shows relevant warning message at bottom.
 - The game ends after 7 rounds
 - Compute the total score (basic + bonus scoring) for every player after game ends
 - Implement a smarter AI with DFS, Greedy algorithm and softmax. (Task 13)
 - It implements a "Take Back" button that can take back all the tiles just placed by the current player in the current round.
 - High Score menu, displays list of 5 human players with top scores (store the best 5 score into a txt).
 - It implements a user-friendly warning label (below the board) that displays what is happening on the board such as invalid placement, 
   special tiles turn & game limit reached, please click next turn because there are no more move available, etc. (Makes it easy for a new user to run).
 
 
 
