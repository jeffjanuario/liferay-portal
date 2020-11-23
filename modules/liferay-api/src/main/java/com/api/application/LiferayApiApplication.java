package com.api.application;

import com.api.ApiApplication;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author JEFF JANUARIO
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/api",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Api.Rest" }, service = Application.class)

public class LiferayApiApplication extends Application {
	private Set<Object> singletons = new HashSet<>();

	public LiferayApiApplication() {
		singletons.add(ApiApplication.class);
	}

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}
}


