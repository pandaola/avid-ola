package ak.app.model.db;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Builder
@Entity
public class MyFile {
	@Id
	private Integer id;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Asset> assets;
}
