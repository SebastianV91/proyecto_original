/**
 * 
 */
package com.curso.ecommerce.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.curso.ecommerce.resource.UserResource;

/**
 * @author raidentrance
 *
 */
@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(UserResource.class);
	}
}
