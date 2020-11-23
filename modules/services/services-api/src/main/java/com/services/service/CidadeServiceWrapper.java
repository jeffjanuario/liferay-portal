/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.services.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CidadeService}.
 *
 * @author Brian Wing Shun Chan
 * @see CidadeService
 * @generated
 */
public class CidadeServiceWrapper
	implements CidadeService, ServiceWrapper<CidadeService> {

	public CidadeServiceWrapper(CidadeService cidadeService) {
		_cidadeService = cidadeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cidadeService.getOSGiServiceIdentifier();
	}

	@Override
	public CidadeService getWrappedService() {
		return _cidadeService;
	}

	@Override
	public void setWrappedService(CidadeService cidadeService) {
		_cidadeService = cidadeService;
	}

	private CidadeService _cidadeService;

}