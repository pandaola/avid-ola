package ak.app.model.db;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Builder
public class MyFileWithPath {
	@Id
	private String path;
	private MyFile myFile;
}
