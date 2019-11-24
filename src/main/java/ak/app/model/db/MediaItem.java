
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
		"essenceType",
		"track",
		"start",
		"length",
		"mobId",
		"online",
		"type"
})
@Getter
@Setter
@Builder
@Embeddable
public class MediaItem {

	@JsonProperty("essenceType")
	public String essenceType;
	@JsonProperty("track")
	public String track;
	@JsonProperty("start")
	public String start;
	@JsonProperty("length")
	public String length;
	@JsonProperty("mobId")
	public String mobId;
	@JsonProperty("online")
	public String online;
	@JsonProperty("type")
	public String type;

}
