import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import java.awt.event.*;

public class Minesweeper {
	private static final long serialVersionUID = 1L;

	private class MineTile extends JButton {
		private static final long serialVersionUID = 1L;
		int r;
		int c;
		
		
		public MineTile(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	
	
	int tileSize = 70;
	int rows = 10;
	int cols = 10;
	int boardWidth = tileSize * rows;
	int boardHeight = tileSize * cols;
	
	

	
	JFrame frame = new JFrame("Minesweeper");
	JLabel textLabel = new JLabel();
	JPanel textPanel = new JPanel();
	JPanel boardPanel = new JPanel();
	JButton playAgainButton = new JButton();
	
	MineTile[][] board = new MineTile[rows][cols];
	
	
	
	
	public Minesweeper() {
		
		//Create a grid
		Grid myGrid = new Grid(this.rows, this.cols);
		ArrayList<ArrayList<String>> grid = myGrid.getGrid();
		int countBombs = myGrid.getCountOfBombs();
		
		System.out.println("Grid created:");
		myGrid.printGrid(grid);
		
		
		frame.setSize(boardWidth,boardHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		textLabel.setFont(new Font("Arial", Font.BOLD, 25));
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setText("Minesweeper");
		textLabel.setOpaque(true);
		
		playAgainButton.setFont(new Font("Arial", Font.BOLD, 25));
		playAgainButton.setHorizontalAlignment(JLabel.CENTER);
		playAgainButton.setText("Minesweeper");
		playAgainButton.setEnabled(false);
		
		textPanel.setLayout(new BorderLayout());
		textPanel.add(textLabel);
		frame.add(textPanel, BorderLayout.NORTH);
		frame.add(playAgainButton, BorderLayout.NORTH);
		
		boardPanel.setLayout(new GridLayout(rows, cols));
		//boardPanel.setBackground(Color.green);
		frame.add(boardPanel);
		
		

		
//		Filling grid with tiles
		for(int r=0; r < rows; r++) {
			for(int c=0; c < cols; c++) {
				//System.out.println("row= "+r+" col= "+c);
				MineTile tile = new MineTile(r,c);
				board[r][c] = tile;
				tile.setFocusable(false);
				tile.setMargin(new Insets(0,0,0,0));
				tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
				
				tile.addMouseListener(new MouseAdapter(){
		
					@Override
					public void mousePressed(MouseEvent e) {
						
						if(tile.getText()=="") {
							//System.out.println("Empty tile clicked at row= "+tile.r+" and col= "+tile.c);
							tile.setEnabled(false);
							String valueInGrid = grid.get(tile.r).get(tile.c);
							if(valueInGrid == "💣") {
								tile.setText("💣");
								revealGrid();
								playAgainButton.setText("Game Over! Play Again?");
								playAgainButton.setEnabled(true);
								}
							
							else {
								if (valueInGrid.equals("0")) {
									System.out.println("Found 0. Going to reveal func");
									revealTilesAround(tile.r,tile.c);
									tile.setText(valueInGrid);	
									
								}
								else {
									tile.setText(valueInGrid);
									
								};
								checkIfWon();
							}
							
							
							
						
							}
					
						}
					
		//check if game is won by counting how many buttons are still hidden and comparing with bombs present
		private void checkIfWon() {
			int count = 0;
			for(int r=0; r<rows; r++) {
				for(int c=0; c<cols; c++) {
					MineTile tile = board[r][c];
					if(tile.isEnabled()==true) count++;	
				}
			}
			System.out.println("Bombs= "+countBombs+" Empty= "+count);
			if (count == countBombs ) {
				playAgainButton.setText("You won! Play Again?");
				playAgainButton.setEnabled(true);
				//textLabel.setText("You won!");
				revealGrid();
				};
		}

		//when a bomb is clicked-- reveal all--game over			
		private void revealGrid() {
			System.out.println("i m revealing grid");
			
			for(int r=0; r<rows; r++) {
				for(int c=0; c<cols; c++) {
					MineTile tile = board[r][c];
					String valueInGrid = grid.get(r).get(c);
					if (valueInGrid.equals("💣")) {
						tile.setBackground(Color.RED);
						tile.setOpaque(true);
						}
					tile.setText(valueInGrid);
					tile.setEnabled(false);		
				}
				}
			}
		
		//....
		
		//check for empty tiles around--reveal if no bombs
		private void revealTilesAround(int row, int col) {
			int start_row; //start checking from previous row;
			int end_row; //stop checking at next row
			
			int start_col;
			int end_col;
			
			if(row - 1 < 0) start_row = row; //if previous row is less than 0 then don't check it
			else start_row = row - 1;
			
			if(row + 1 >= rows) end_row = row; //if next row is greater than max no. of rows then don't check it
			else end_row = row + 1;
			
			if(col - 1 < 0) start_col = col;
			else start_col = col - 1;
			
			if(col + 1 >= cols) end_col = col;
			else end_col = col + 1;
			
			for(int i = start_row; i <= end_row; i++) {
				for(int j = start_col; j <= end_col; j++) {
					//ystem.out.println("Checking tile at row="+i+"and col"+j);
					MineTile tile = board[i][j];
					String valueInGrid = grid.get(i).get(j);
					tile.setText(valueInGrid);
					
					//check tiles around this tile
					if(valueInGrid.equals("0") && tile.isEnabled()==true) {
						tile.setEnabled(false); //disable this tile after revealing so it does not go into infinite loop
						revealTilesAround(i,j);
						};
					tile.setEnabled(false); //disable the revealed tiles
					
					}
				}	
		}
		
		//......
	
		
		//.........
				}
				);	
				boardPanel.add(tile);	
			
			}
		}
		
		//..........
		
		
		frame.setVisible(true);
	}
}
