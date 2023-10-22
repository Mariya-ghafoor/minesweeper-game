import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Create a JSON file and write into it
		
		
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of rows: ");
		int rowsUser = s.nextInt();
		
		System.out.println("Enter number of columns: ");
		int colsUser = s.nextInt();
		
		ConfigFile config = new ConfigFile(rowsUser, colsUser);
		
		int rows = (int)config.getGridRows();
		int cols = (int)config.getGridColumns();
		
		Minesweeper minesweeper = new Minesweeper(rows, cols);
		
		

	}
	
	

}
