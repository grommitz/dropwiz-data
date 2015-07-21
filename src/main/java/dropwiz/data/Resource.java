package dropwiz.data;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.Lists;

/**
 * Testing XML serialization.
 * JSON works perfectly in all cases but XML doesn't work in case 2.
 * @author MCharlesworth
 *
 */
@Path("results")
public class Resource {

	/**
	 * Works when the generic type is simple such as String
	 * @return
	 */
	@GET
	@Path("v1")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public GenericResult<String> get() {
		return new GenericResult<String>(Lists.newArrayList("Lorem ipsum","One flew over..."), 22);
	}
	
	/**
	 * Fails when the generic type is custom object
	 * @return
	 */
	@GET
	@Path("v2")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public GenericResult<Dog> get2() {
		return new GenericResult<Dog>(dogs(), 31);
	}
	
	/**
	 * Works when the contained type is fixed. This seems the best thing to do, but we have to create
	 * a fixed type version for every type we need to return. There must be a better way...
	 * @return
	 */
	@GET
	@Path("v3")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public FixedTypeResult get3() {
		return new FixedTypeResult(dogs(), 31);
	}
	
	/**
	 * Works when we extend the generic version with a fixed type but we seem to get 2 copies everything
	 * if we override the getters. But we have to have at least 1 @XmlElement in the pojo it appears.
	 * @return
	 */
	@GET
	@Path("v4")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ExtendedGenericResult get4() {
		return new ExtendedGenericResult(dogs(), 31);
	}
	
	private List<Dog> dogs() {
		return Lists.newArrayList(new Dog("Fido", "Beagle"), new Dog("Rover", "Dalmatian"));
	}
}
