package reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileDestination implements Destination {

	@Override
	public void saveData(List<String> resultList, DestinationParams params) throws DestinationException {
		File file = new File(params.getDestination());
		if (! file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
//				log("Excepton Occured: " + e.toString());
			}
		}

		try {
			FileWriter fileWriter;
			fileWriter = new FileWriter(file.getAbsoluteFile(), false);

			// Writes text to a character-output stream
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			for (String s : resultList) {
				bufferWriter.write(s + "\n");
			}
			bufferWriter.close();

		} catch (IOException e) {
			throw new DestinationException("Got an error when saved the file");
		}
	}
}
