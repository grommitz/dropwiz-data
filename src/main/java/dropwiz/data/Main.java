package dropwiz.data;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class Main extends Application<Config> {

	public static void main(String[] args) throws Exception {
		new Main().run(args);
	}
	
	@Override
	public void run(Config config, Environment env) throws Exception {
		env.jersey().register(new Resource());
	}

	
}
