package sources;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSource implements Source{

	public List<String> readData(SourceParams params) {
		List<String> resultList = new ArrayList<String>();
		File file = new File(params.getSource());
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (sc.hasNextLine()) resultList.add(sc.nextLine());
		return resultList;
	}
}
