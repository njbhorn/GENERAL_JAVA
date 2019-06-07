package json;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Location {

	private Map<String, String> locations = new HashMap<>();
	private String fileName;

	public Location(String fileName) throws IOException {
		this.fileName = fileName;
		this.getDataFromFile();
	}

	public String getFileName() {
		return fileName;
	}

	public Map<String, String> getLocations() {
		return locations;
	}

	private void getDataFromFile() throws IOException {
		FileInputStream fis = new FileInputStream(this.fileName);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null) {
			String[] info = line.split(",");
			locations.put(info[0], info[1]);
		}
		// System.out.println(locations);

		br.close();
		isr.close();
		fis.close();
	}

	public void refreshLocationCache() throws IOException {
		this.getDataFromFile();
	}

}
