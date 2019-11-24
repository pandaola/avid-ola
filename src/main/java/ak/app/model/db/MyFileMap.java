package ak.app.model.db;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class MyFileMap {
	private HashMap<String, MyFile> filesMap;
}
