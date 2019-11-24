
package ak.app.model.db;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"group",
		"name",
		"value"
})
@Getter
@Setter
@Builder
@Embeddable
public class Attribute {
	@Id
	public Integer id;
	@JsonProperty("group")
	public String group;
	@JsonProperty("name")
	public String name;
	@JsonProperty("value")
	public String value;

}
