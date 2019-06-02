package sources;

import java.util.List;

public interface Source {

	List<String> readData(SourceParams params);

}
