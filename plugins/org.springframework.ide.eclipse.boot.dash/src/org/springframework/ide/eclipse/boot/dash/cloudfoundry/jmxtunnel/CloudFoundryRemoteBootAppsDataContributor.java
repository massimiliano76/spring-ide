/*******************************************************************************
 * Copyright (c) 2015, 2016 Pivotal Software, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pivotal Software, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.boot.dash.cloudfoundry.jmxtunnel;

import org.springframework.ide.eclipse.boot.dash.di.SimpleDIContext;
import org.springframework.ide.eclipse.boot.dash.model.BootDashViewModel;
import org.springframework.ide.eclipse.boot.dash.remoteapps.RemoteBootAppsDataHolder;
import org.springframework.ide.eclipse.boot.dash.remoteapps.RemoteBootAppsDataHolder.RemoteAppData;
import org.springsource.ide.eclipse.commons.livexp.core.ObservableSet;

public class CloudFoundryRemoteBootAppsDataContributor implements RemoteBootAppsDataHolder.Contributor {

	private SimpleDIContext context;

	public CloudFoundryRemoteBootAppsDataContributor(SimpleDIContext context) {
		this.context = context;
	}

	@Override
	public ObservableSet<RemoteAppData> getRemoteApps() {
		return context.getBean(BootDashViewModel.class).getJmxSshTunnelManager().getUrls();
	}

}
