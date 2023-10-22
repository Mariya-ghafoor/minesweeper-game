import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ConfigFile {
	private long gridRows;
	private long gridColumns;
	
	public ConfigFile(long rows, long cols) {
		
		//create and write to file
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("gridRows", rows);
		jsonObject.put("gridColumns", cols);
		
		try {
			FileWriter file = new FileWriter("./config/config.json");
			file.write(jsonObject.toJSONString());
			file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	
		
		//Read from file and save values in class properties of rows and cols
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("./config/config.json"));
			JSONObject jsonOb = (JSONObject) obj;
			
			long gridRows = (long) jsonOb.get("gridRows");
			long gridCols = (long) jsonOb.get("gridColumns");
			
			this.setGridRows(gridRows);
			this.setGridColumns(gridCols);
		
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public long getGridRows() {
		return gridRows;
	}

	public void setGridRows(long gridRows) {
		this.gridRows = gridRows;
	}

	public long getGridColumns() {
		return gridColumns;
	}

	public void setGridColumns(long gridColumns) {
		this.gridColumns = gridColumns;
	}


	
	
	

}
