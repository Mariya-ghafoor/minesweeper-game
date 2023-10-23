# Minesweeper
- The classic Minesweeper built on Java complete with GUI and ability to customise mine size.

# Demo

# Purpose
- The purpose of the project was to improve upon the understanding of Java classes and data structures by building the classic Minesweeper game.

# Approach
- The project was approached in a way so as to keep it simple while also achieving the objectives of the game. 

# Features
- The program allows the user to customise the number of rows and columns for the grid.
- The dimensions are saved in a config.json file which is then read by the program to access the dimensions to build the grid.
- The GUI provides an easy way to interact with the game.
- When a tile in the grid is clicked it either shows a mine or shows the number of mines surrounding it.
- Where no mines are present around the tile, a cascading function is initiliazed which open all the tiles around the first clicked tile until it finds a mine.

# Future Goals
- Make the replay game button functional