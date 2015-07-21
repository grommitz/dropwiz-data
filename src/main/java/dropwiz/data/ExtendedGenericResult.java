package dropwiz.data;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExtendedGenericResult extends GenericResult<Dog> {

	public ExtendedGenericResult() {
		super();
	}
	
	public ExtendedGenericResult(List<Dog> results, int total) {
		super(results, total);
	}

	@Override
	@XmlElement
	public List<Dog> getResults() {
		return results;
	}
	
	@Override
	@XmlElement
	public int getTotal() {
		return super.getTotal();
	}
	
	@XmlElement
	public int getNothing() {
		return 0;
	}
	
}
