
package ak.app.model.db;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"created",
		"modified",
		"name"
})
@Getter
@Setter
@Builder
@Embeddable
public class Common {
	@JsonProperty("created")
	public LocalDateTime created;
	@JsonProperty("modified")
	public LocalDateTime modified;
	@JsonProperty("name")
	public String name;

}
