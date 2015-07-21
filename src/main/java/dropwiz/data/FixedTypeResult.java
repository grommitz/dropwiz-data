package dropwiz.data;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FixedTypeResult  {

	private final List<Dog> results;
	private final int total;
	
	public FixedTypeResult() {
		// default ctor required
		results = null;
		total = 0;
	}
	
	public FixedTypeResult(List<Dog> results, int total) {
		this.results = results;
		this.total = total;
	}

	@XmlElementWrapper(name="results")
	@XmlElementRef
	public List<Dog> getResults() {
		return results;
	}
	
	@XmlElement
	public int getTotal() {
		return total;
	}
	
}
