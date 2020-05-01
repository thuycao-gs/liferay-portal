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

package com.liferay.batch.engine.service.base;

import com.liferay.batch.engine.model.BatchEngineExportTask;
import com.liferay.batch.engine.model.BatchEngineExportTaskContentBlobModel;
import com.liferay.batch.engine.service.BatchEngineExportTaskLocalService;
import com.liferay.batch.engine.service.persistence.BatchEngineExportTaskPersistence;
import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.io.AutoDeleteFileInputStream;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.db.DBType;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.File;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.InputStream;
import java.io.Serializable;

import java.sql.Blob;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the batch engine export task local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.batch.engine.service.impl.BatchEngineExportTaskLocalServiceImpl}.
 * </p>
 *
 * @author Shuyang Zhou
 * @see com.liferay.batch.engine.service.impl.BatchEngineExportTaskLocalServiceImpl
 * @generated
 */
public abstract class BatchEngineExportTaskLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, BatchEngineExportTaskLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>BatchEngineExportTaskLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.batch.engine.service.BatchEngineExportTaskLocalServiceUtil</code>.
	 */

	/**
	 * Adds the batch engine export task to the database. Also notifies the appropriate model listeners.
	 *
	 * @param batchEngineExportTask the batch engine export task
	 * @return the batch engine export task that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public BatchEngineExportTask addBatchEngineExportTask(
		BatchEngineExportTask batchEngineExportTask) {

		batchEngineExportTask.setNew(true);

		return batchEngineExportTaskPersistence.update(batchEngineExportTask);
	}

	/**
	 * Creates a new batch engine export task with the primary key. Does not add the batch engine export task to the database.
	 *
	 * @param batchEngineExportTaskId the primary key for the new batch engine export task
	 * @return the new batch engine export task
	 */
	@Override
	@Transactional(enabled = false)
	public BatchEngineExportTask createBatchEngineExportTask(
		long batchEngineExportTaskId) {

		return batchEngineExportTaskPersistence.create(batchEngineExportTaskId);
	}

	/**
	 * Deletes the batch engine export task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param batchEngineExportTaskId the primary key of the batch engine export task
	 * @return the batch engine export task that was removed
	 * @throws PortalException if a batch engine export task with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public BatchEngineExportTask deleteBatchEngineExportTask(
			long batchEngineExportTaskId)
		throws PortalException {

		return batchEngineExportTaskPersistence.remove(batchEngineExportTaskId);
	}

	/**
	 * Deletes the batch engine export task from the database. Also notifies the appropriate model listeners.
	 *
	 * @param batchEngineExportTask the batch engine export task
	 * @return the batch engine export task that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public BatchEngineExportTask deleteBatchEngineExportTask(
		BatchEngineExportTask batchEngineExportTask) {

		return batchEngineExportTaskPersistence.remove(batchEngineExportTask);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return batchEngineExportTaskPersistence.dslQuery(dslQuery);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			BatchEngineExportTask.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return batchEngineExportTaskPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.batch.engine.model.impl.BatchEngineExportTaskModelImpl</code>.
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

		return batchEngineExportTaskPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.batch.engine.model.impl.BatchEngineExportTaskModelImpl</code>.
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

		return batchEngineExportTaskPersistence.findWithDynamicQuery(
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
		return batchEngineExportTaskPersistence.countWithDynamicQuery(
			dynamicQuery);
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

		return batchEngineExportTaskPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public BatchEngineExportTask fetchBatchEngineExportTask(
		long batchEngineExportTaskId) {

		return batchEngineExportTaskPersistence.fetchByPrimaryKey(
			batchEngineExportTaskId);
	}

	/**
	 * Returns the batch engine export task with the matching UUID and company.
	 *
	 * @param uuid the batch engine export task's UUID
	 * @param companyId the primary key of the company
	 * @return the matching batch engine export task, or <code>null</code> if a matching batch engine export task could not be found
	 */
	@Override
	public BatchEngineExportTask fetchBatchEngineExportTaskByUuidAndCompanyId(
		String uuid, long companyId) {

		return batchEngineExportTaskPersistence.fetchByUuid_C_First(
			uuid, companyId, null);
	}

	/**
	 * Returns the batch engine export task with the primary key.
	 *
	 * @param batchEngineExportTaskId the primary key of the batch engine export task
	 * @return the batch engine export task
	 * @throws PortalException if a batch engine export task with the primary key could not be found
	 */
	@Override
	public BatchEngineExportTask getBatchEngineExportTask(
			long batchEngineExportTaskId)
		throws PortalException {

		return batchEngineExportTaskPersistence.findByPrimaryKey(
			batchEngineExportTaskId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			batchEngineExportTaskLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(BatchEngineExportTask.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"batchEngineExportTaskId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			batchEngineExportTaskLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			BatchEngineExportTask.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"batchEngineExportTaskId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			batchEngineExportTaskLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(BatchEngineExportTask.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"batchEngineExportTaskId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<BatchEngineExportTask>() {

				@Override
				public void performAction(
						BatchEngineExportTask batchEngineExportTask)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, batchEngineExportTask);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					BatchEngineExportTask.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return batchEngineExportTaskPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return batchEngineExportTaskLocalService.deleteBatchEngineExportTask(
			(BatchEngineExportTask)persistedModel);
	}

	public BasePersistence<BatchEngineExportTask> getBasePersistence() {
		return batchEngineExportTaskPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return batchEngineExportTaskPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the batch engine export task with the matching UUID and company.
	 *
	 * @param uuid the batch engine export task's UUID
	 * @param companyId the primary key of the company
	 * @return the matching batch engine export task
	 * @throws PortalException if a matching batch engine export task could not be found
	 */
	@Override
	public BatchEngineExportTask getBatchEngineExportTaskByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return batchEngineExportTaskPersistence.findByUuid_C_First(
			uuid, companyId, null);
	}

	/**
	 * Returns a range of all the batch engine export tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.batch.engine.model.impl.BatchEngineExportTaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of batch engine export tasks
	 * @param end the upper bound of the range of batch engine export tasks (not inclusive)
	 * @return the range of batch engine export tasks
	 */
	@Override
	public List<BatchEngineExportTask> getBatchEngineExportTasks(
		int start, int end) {

		return batchEngineExportTaskPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of batch engine export tasks.
	 *
	 * @return the number of batch engine export tasks
	 */
	@Override
	public int getBatchEngineExportTasksCount() {
		return batchEngineExportTaskPersistence.countAll();
	}

	/**
	 * Updates the batch engine export task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param batchEngineExportTask the batch engine export task
	 * @return the batch engine export task that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public BatchEngineExportTask updateBatchEngineExportTask(
		BatchEngineExportTask batchEngineExportTask) {

		return batchEngineExportTaskPersistence.update(batchEngineExportTask);
	}

	@Override
	public BatchEngineExportTaskContentBlobModel getContentBlobModel(
		Serializable primaryKey) {

		Session session = null;

		try {
			session = batchEngineExportTaskPersistence.openSession();

			return (BatchEngineExportTaskContentBlobModel)session.get(
				BatchEngineExportTaskContentBlobModel.class, primaryKey);
		}
		catch (Exception exception) {
			throw batchEngineExportTaskPersistence.processException(exception);
		}
		finally {
			batchEngineExportTaskPersistence.closeSession(session);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public InputStream openContentInputStream(long batchEngineExportTaskId) {
		try {
			BatchEngineExportTaskContentBlobModel
				BatchEngineExportTaskContentBlobModel = getContentBlobModel(
					batchEngineExportTaskId);

			Blob blob = BatchEngineExportTaskContentBlobModel.getContentBlob();

			if (blob == null) {
				return _EMPTY_INPUT_STREAM;
			}

			InputStream inputStream = blob.getBinaryStream();

			if (_useTempFile) {
				inputStream = new AutoDeleteFileInputStream(
					_file.createTempFile(inputStream));
			}

			return inputStream;
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Activate
	protected void activate() {
		DB db = DBManagerUtil.getDB();

		if ((db.getDBType() != DBType.DB2) &&
			(db.getDBType() != DBType.MYSQL) &&
			(db.getDBType() != DBType.MARIADB) &&
			(db.getDBType() != DBType.SYBASE)) {

			_useTempFile = true;
		}
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			BatchEngineExportTaskLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		batchEngineExportTaskLocalService =
			(BatchEngineExportTaskLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return BatchEngineExportTaskLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return BatchEngineExportTask.class;
	}

	protected String getModelClassName() {
		return BatchEngineExportTask.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				batchEngineExportTaskPersistence.getDataSource();

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

	protected BatchEngineExportTaskLocalService
		batchEngineExportTaskLocalService;

	@Reference
	protected BatchEngineExportTaskPersistence batchEngineExportTaskPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected File _file;

	private static final InputStream _EMPTY_INPUT_STREAM =
		new UnsyncByteArrayInputStream(new byte[0]);

	private boolean _useTempFile;

}