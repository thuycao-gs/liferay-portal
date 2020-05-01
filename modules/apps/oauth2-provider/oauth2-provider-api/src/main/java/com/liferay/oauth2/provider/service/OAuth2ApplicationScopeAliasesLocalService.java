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

package com.liferay.oauth2.provider.service;

import com.liferay.oauth2.provider.model.OAuth2ApplicationScopeAliases;
import com.liferay.oauth2.provider.util.builder.OAuth2ScopeBuilder;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.function.Consumer;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for OAuth2ApplicationScopeAliases. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see OAuth2ApplicationScopeAliasesLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface OAuth2ApplicationScopeAliasesLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OAuth2ApplicationScopeAliasesLocalServiceUtil} to access the o auth2 application scope aliases local service. Add custom service methods to <code>com.liferay.oauth2.provider.service.impl.OAuth2ApplicationScopeAliasesLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public OAuth2ApplicationScopeAliases addOAuth2ApplicationScopeAliases(
			long companyId, long userId, String userName,
			long oAuth2ApplicationId,
			Consumer<OAuth2ScopeBuilder> builderConsumer)
		throws PortalException;

	public OAuth2ApplicationScopeAliases addOAuth2ApplicationScopeAliases(
			long companyId, long userId, String userName,
			long oAuth2ApplicationId, List<String> scopeAliasesList)
		throws PortalException;

	/**
	 * Adds the o auth2 application scope aliases to the database. Also notifies the appropriate model listeners.
	 *
	 * @param oAuth2ApplicationScopeAliases the o auth2 application scope aliases
	 * @return the o auth2 application scope aliases that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public OAuth2ApplicationScopeAliases addOAuth2ApplicationScopeAliases(
		OAuth2ApplicationScopeAliases oAuth2ApplicationScopeAliases);

	/**
	 * Creates a new o auth2 application scope aliases with the primary key. Does not add the o auth2 application scope aliases to the database.
	 *
	 * @param oAuth2ApplicationScopeAliasesId the primary key for the new o auth2 application scope aliases
	 * @return the new o auth2 application scope aliases
	 */
	@Transactional(enabled = false)
	public OAuth2ApplicationScopeAliases createOAuth2ApplicationScopeAliases(
		long oAuth2ApplicationScopeAliasesId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the o auth2 application scope aliases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oAuth2ApplicationScopeAliasesId the primary key of the o auth2 application scope aliases
	 * @return the o auth2 application scope aliases that was removed
	 * @throws PortalException if a o auth2 application scope aliases with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public OAuth2ApplicationScopeAliases deleteOAuth2ApplicationScopeAliases(
			long oAuth2ApplicationScopeAliasesId)
		throws PortalException;

	/**
	 * Deletes the o auth2 application scope aliases from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oAuth2ApplicationScopeAliases the o auth2 application scope aliases
	 * @return the o auth2 application scope aliases that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public OAuth2ApplicationScopeAliases deleteOAuth2ApplicationScopeAliases(
		OAuth2ApplicationScopeAliases oAuth2ApplicationScopeAliases);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.oauth2.provider.model.impl.OAuth2ApplicationScopeAliasesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.oauth2.provider.model.impl.OAuth2ApplicationScopeAliasesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OAuth2ApplicationScopeAliases fetchOAuth2ApplicationScopeAliases(
		long oAuth2ApplicationScopeAliasesId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OAuth2ApplicationScopeAliases fetchOAuth2ApplicationScopeAliases(
		long oAuth2ApplicationId, List<String> scopeAliasesList);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the o auth2 application scope aliases with the primary key.
	 *
	 * @param oAuth2ApplicationScopeAliasesId the primary key of the o auth2 application scope aliases
	 * @return the o auth2 application scope aliases
	 * @throws PortalException if a o auth2 application scope aliases with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OAuth2ApplicationScopeAliases getOAuth2ApplicationScopeAliases(
			long oAuth2ApplicationScopeAliasesId)
		throws PortalException;

	/**
	 * Returns a range of all the o auth2 application scope aliaseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.oauth2.provider.model.impl.OAuth2ApplicationScopeAliasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of o auth2 application scope aliaseses
	 * @param end the upper bound of the range of o auth2 application scope aliaseses (not inclusive)
	 * @return the range of o auth2 application scope aliaseses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OAuth2ApplicationScopeAliases>
		getOAuth2ApplicationScopeAliaseses(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OAuth2ApplicationScopeAliases>
		getOAuth2ApplicationScopeAliaseses(
			long oAuth2ApplicationId, int start, int end,
			OrderByComparator<OAuth2ApplicationScopeAliases> orderByComparator);

	/**
	 * Returns the number of o auth2 application scope aliaseses.
	 *
	 * @return the number of o auth2 application scope aliaseses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOAuth2ApplicationScopeAliasesesCount();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<String> getScopeAliasesList(
		long oAuth2ApplicationScopeAliasesId);

	/**
	 * Updates the o auth2 application scope aliases in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param oAuth2ApplicationScopeAliases the o auth2 application scope aliases
	 * @return the o auth2 application scope aliases that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public OAuth2ApplicationScopeAliases updateOAuth2ApplicationScopeAliases(
		OAuth2ApplicationScopeAliases oAuth2ApplicationScopeAliases);

}