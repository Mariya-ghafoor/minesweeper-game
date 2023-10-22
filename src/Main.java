import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("----------------- WELCOME-------------");
		System.out.println("-------------------- TO --------------");
		System.out.println("-------------- MINESWEEPER -----------");

		boolean condition = true;
		while(condition) {
			try {
				Scanner s = new Scanner(System.in);
				System.out.println("Enter number of rows: ");
				int rowsUser = s.nextInt();
				
				if(rowsUser <10 || rowsUser>50) {
					throw new Exception();
				}
				
				System.out.println("Enter number of columns: ");
				int colsUser = s.nextInt();
				
				if(colsUser<10 || colsUser>50  ) {
					throw new Exception();
				}
				
				
				//Create a JSON file and write into it
				ConfigFile config = new ConfigFile(rowsUser, colsUser);
				
				int rows = (int)config.getGridRows();
				int cols = (int)config.getGridColumns();
				
				Minesweeper minesweeper = new Minesweeper(rows, cols);
				condition = false;
				
				
			
				
				
			}
			
			catch(Exception e) {
				System.out.println("Please enter valid numbers between 10 and 50. Fractions are not allowed.");
			}
			
		}
		
		
		
		
		
		
		

	}
	
	

}
