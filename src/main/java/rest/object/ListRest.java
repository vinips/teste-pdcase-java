package rest.object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author  Vinicius Pedro da Silveira
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListRest<T> {

	@JsonProperty("length")
	private Integer length;

	@JsonProperty("list")
	private List<T> list;

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
