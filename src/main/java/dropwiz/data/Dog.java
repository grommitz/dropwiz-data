package dropwiz.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dog {

	private final String name;
	private final String breed;

	public Dog() {
		// default ctor required
		this.name = null;
		this.breed = null;
	}
	
	public Dog(String name, String breed) {
		this.name = name;
		this.breed = breed;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	@XmlElement
	public String getBreed() {
		return breed;
	}
}
