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

package com.liferay.mobile.device.rules.service;

import com.liferay.mobile.device.rules.model.MDRAction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.UnicodeProperties;

import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for MDRAction. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Edward C. Han
 * @see MDRActionServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface MDRActionService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.mobile.device.rules.service.impl.MDRActionServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the mdr action remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link MDRActionServiceUtil} if injection and service tracking are not available.
	 */
	public MDRAction addAction(
			long ruleGroupInstanceId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, String type,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException;

	public MDRAction addAction(
			long ruleGroupInstanceId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, String type,
			UnicodeProperties typeSettingsUnicodeProperties,
			ServiceContext serviceContext)
		throws PortalException;

	public void deleteAction(long actionId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MDRAction fetchAction(long actionId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MDRAction getAction(long actionId) throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public MDRAction updateAction(
			long actionId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, String type,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException;

	public MDRAction updateAction(
			long actionId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, String type,
			UnicodeProperties typeSettingsUnicodeProperties,
			ServiceContext serviceContext)
		throws PortalException;

}