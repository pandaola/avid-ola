
package ak.app.model.db;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"attributes",
		"base",
		"media-items",
		"common",
		"mobId"
})

@Builder
@Entity
public class Asset {
	@Id
	@GeneratedValue
	public Integer id;
	@JsonProperty("attributes")
	@ElementCollection(targetClass = Attribute.class)
	public List<Attribute> attributes;
	@JsonProperty("media-items")
	@ElementCollection(targetClass = MediaItem.class)
	public List<MediaItem> mediaItems;
	@JsonProperty("common")
	public Common common;
	@JsonProperty("mobId")
	public String mobId;
	@JsonProperty("base")
	public Base base;


}
