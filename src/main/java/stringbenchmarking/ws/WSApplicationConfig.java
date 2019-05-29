package stringbenchmarking.ws;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import stringbenchmarking.ws.resource.JHMStringenchmarkingExecuteResource;

@ApplicationPath("/")
public class WSApplicationConfig
	extends
	Application {

	private final Set<Class<?>> classes;

	public WSApplicationConfig() {
		HashSet<Class<?>> c = new HashSet<Class<?>>();
		c.add(JHMStringenchmarkingExecuteResource.class);
		classes = Collections.unmodifiableSet(c);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
}
