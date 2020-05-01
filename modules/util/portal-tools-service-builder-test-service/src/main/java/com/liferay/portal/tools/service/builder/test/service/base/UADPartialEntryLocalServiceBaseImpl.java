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

package com.liferay.portal.tools.service.builder.test.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.portal.tools.service.builder.test.model.UADPartialEntry;
import com.liferay.portal.tools.service.builder.test.service.UADPartialEntryLocalService;
import com.liferay.portal.tools.service.builder.test.service.persistence.UADPartialEntryPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the uad partial entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portal.tools.service.builder.test.service.impl.UADPartialEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portal.tools.service.builder.test.service.impl.UADPartialEntryLocalServiceImpl
 * @generated
 */
public abstract class UADPartialEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements IdentifiableOSGiService, UADPartialEntryLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>UADPartialEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.portal.tools.service.builder.test.service.UADPartialEntryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the uad partial entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param uadPartialEntry the uad partial entry
	 * @return the uad partial entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public UADPartialEntry addUADPartialEntry(UADPartialEntry uadPartialEntry) {
		uadPartialEntry.setNew(true);

		return uadPartialEntryPersistence.update(uadPartialEntry);
	}

	/**
	 * Creates a new uad partial entry with the primary key. Does not add the uad partial entry to the database.
	 *
	 * @param uadPartialEntryId the primary key for the new uad partial entry
	 * @return the new uad partial entry
	 */
	@Override
	@Transactional(enabled = false)
	public UADPartialEntry createUADPartialEntry(long uadPartialEntryId) {
		return uadPartialEntryPersistence.create(uadPartialEntryId);
	}

	/**
	 * Deletes the uad partial entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uadPartialEntryId the primary key of the uad partial entry
	 * @return the uad partial entry that was removed
	 * @throws PortalException if a uad partial entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public UADPartialEntry deleteUADPartialEntry(long uadPartialEntryId)
		throws PortalException {

		return uadPartialEntryPersistence.remove(uadPartialEntryId);
	}

	/**
	 * Deletes the uad partial entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uadPartialEntry the uad partial entry
	 * @return the uad partial entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public UADPartialEntry deleteUADPartialEntry(
		UADPartialEntry uadPartialEntry) {

		return uadPartialEntryPersistence.remove(uadPartialEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return uadPartialEntryPersistence.dslQuery(dslQuery);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			UADPartialEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return uadPartialEntryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.tools.service.builder.test.model.impl.UADPartialEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return uadPartialEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.tools.service.builder.test.model.impl.UADPartialEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return uadPartialEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return uadPartialEntryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return uadPartialEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public UADPartialEntry fetchUADPartialEntry(long uadPartialEntryId) {
		return uadPartialEntryPersistence.fetchByPrimaryKey(uadPartialEntryId);
	}

	/**
	 * Returns the uad partial entry with the primary key.
	 *
	 * @param uadPartialEntryId the primary key of the uad partial entry
	 * @return the uad partial entry
	 * @throws PortalException if a uad partial entry with the primary key could not be found
	 */
	@Override
	public UADPartialEntry getUADPartialEntry(long uadPartialEntryId)
		throws PortalException {

		return uadPartialEntryPersistence.findByPrimaryKey(uadPartialEntryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(uadPartialEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(UADPartialEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("uadPartialEntryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			uadPartialEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(UADPartialEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"uadPartialEntryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(uadPartialEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(UADPartialEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("uadPartialEntryId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return uadPartialEntryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return uadPartialEntryLocalService.deleteUADPartialEntry(
			(UADPartialEntry)persistedModel);
	}

	public BasePersistence<UADPartialEntry> getBasePersistence() {
		return uadPartialEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return uadPartialEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the uad partial entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.tools.service.builder.test.model.impl.UADPartialEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of uad partial entries
	 * @param end the upper bound of the range of uad partial entries (not inclusive)
	 * @return the range of uad partial entries
	 */
	@Override
	public List<UADPartialEntry> getUADPartialEntries(int start, int end) {
		return uadPartialEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of uad partial entries.
	 *
	 * @return the number of uad partial entries
	 */
	@Override
	public int getUADPartialEntriesCount() {
		return uadPartialEntryPersistence.countAll();
	}

	/**
	 * Updates the uad partial entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param uadPartialEntry the uad partial entry
	 * @return the uad partial entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public UADPartialEntry updateUADPartialEntry(
		UADPartialEntry uadPartialEntry) {

		return uadPartialEntryPersistence.update(uadPartialEntry);
	}

	/**
	 * Returns the uad partial entry local service.
	 *
	 * @return the uad partial entry local service
	 */
	public UADPartialEntryLocalService getUADPartialEntryLocalService() {
		return uadPartialEntryLocalService;
	}

	/**
	 * Sets the uad partial entry local service.
	 *
	 * @param uadPartialEntryLocalService the uad partial entry local service
	 */
	public void setUADPartialEntryLocalService(
		UADPartialEntryLocalService uadPartialEntryLocalService) {

		this.uadPartialEntryLocalService = uadPartialEntryLocalService;
	}

	/**
	 * Returns the uad partial entry persistence.
	 *
	 * @return the uad partial entry persistence
	 */
	public UADPartialEntryPersistence getUADPartialEntryPersistence() {
		return uadPartialEntryPersistence;
	}

	/**
	 * Sets the uad partial entry persistence.
	 *
	 * @param uadPartialEntryPersistence the uad partial entry persistence
	 */
	public void setUADPartialEntryPersistence(
		UADPartialEntryPersistence uadPartialEntryPersistence) {

		this.uadPartialEntryPersistence = uadPartialEntryPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"com.liferay.portal.tools.service.builder.test.model.UADPartialEntry",
			uadPartialEntryLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.portal.tools.service.builder.test.model.UADPartialEntry");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return UADPartialEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return UADPartialEntry.class;
	}

	protected String getModelClassName() {
		return UADPartialEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = uadPartialEntryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@BeanReference(type = UADPartialEntryLocalService.class)
	protected UADPartialEntryLocalService uadPartialEntryLocalService;

	@BeanReference(type = UADPartialEntryPersistence.class)
	protected UADPartialEntryPersistence uadPartialEntryPersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}