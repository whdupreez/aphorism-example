/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.example;

import com.willydupreez.aphorism.app.Application;
import com.willydupreez.aphorism.daemon.ApplicationEnvironment;
import com.willydupreez.aphorism.server.Server;
import com.willydupreez.aphorism.server.ServerProperties;
import com.willydupreez.aphorism.server.undertow.UndertowServer;

/**
 *
 * @author Willy du Preez
 *
 */
public class ExampleApplication implements Application {

	private ServerProperties properties;
	private Server appServer;

	@Override
	public void onStart(ApplicationEnvironment context) {
		System.out.println("onStart");

		properties = new ServerProperties();
		properties.setBindAddress("localhost");
		properties.setBindPort(8080);

		appServer = new UndertowServer();
		appServer.init(properties);
		appServer.start();
	}

	@Override
	public void onStop() {
		System.out.println("onStop");
		appServer.stop();
	}

}
