package dtcc.itn262;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CityImporter {
	private CityImporter() {
	}
	public static void loadAndDisplay() {
		HashMap<String, LongitudeLatitude> cityMap = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/dtcc/itn262/worldcities.csv"))) {
			String line;

			// Skip the first line (header)
			br.readLine();

			int count = 0;
			while ((line = br.readLine()) != null && count < 10000) {
				// Split by commas, but trim double quotes from each element
				String[] data = line.split(",");
				String cityName = data[1].replace("\"", ""); // Use city_ascii for standard key
				double latitude = Double.parseDouble(data[2].replace("\"", "")); // Clean quotes from latitude
				double longitude = Double.parseDouble(data[3].replace("\"", "")); // Clean quotes from longitude

				LongitudeLatitude location = new LongitudeLatitude(latitude, longitude);
				cityMap.put(cityName, location);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Number of collisions during import: " + cityMap.getCollisions());
		cityMap.displayHashTable(); // Optional: display hash table contents

	}


}
