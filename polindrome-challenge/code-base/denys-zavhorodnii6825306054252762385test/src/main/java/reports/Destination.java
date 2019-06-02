package reports;

import java.util.List;
import java.util.Set;

public interface Destination {

	void saveData(List<String> resultList, DestinationParams params) throws DestinationException;

}
