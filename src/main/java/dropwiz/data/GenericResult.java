package dropwiz.data;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GenericResult<T> {

	protected final List<T> results;
	private final int total;
	
	public GenericResult() {
		this.results = null;
		this.total = -1;
	}
	
	public GenericResult(List<T> results, int total) {
		this.results = results;
		this.total = total;
	}

	@XmlElementWrapper(name="results")
//	@XmlElementRef
	@XmlElement
	public List<T> getResults() {
		return results;
	}
	
	@XmlElement
	public int getTotal() {
		return total;
	}
	
}
