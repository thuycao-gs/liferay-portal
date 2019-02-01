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

package com.liferay.portal.workflow.kaleo.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.petra.string.StringBundler;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinitionVersion;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinitionVersionModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the KaleoDefinitionVersion service. Represents a row in the &quot;KaleoDefinitionVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link KaleoDefinitionVersionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoDefinitionVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoDefinitionVersionImpl
 * @see KaleoDefinitionVersion
 * @see KaleoDefinitionVersionModel
 * @generated
 */
@ProviderType
public class KaleoDefinitionVersionModelImpl extends BaseModelImpl<KaleoDefinitionVersion>
	implements KaleoDefinitionVersionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo definition version model instance should use the {@link KaleoDefinitionVersion} interface instead.
	 */
	public static final String TABLE_NAME = "KaleoDefinitionVersion";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mvccVersion", Types.BIGINT },
			{ "kaleoDefinitionVersionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "title", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "content", Types.CLOB },
			{ "version", Types.VARCHAR },
			{ "startKaleoNodeId", Types.BIGINT },
			{ "status", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("kaleoDefinitionVersionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("content", Types.CLOB);
		TABLE_COLUMNS_MAP.put("version", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("startKaleoNodeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table KaleoDefinitionVersion (mvccVersion LONG default 0 not null,kaleoDefinitionVersionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(200) null,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,createDate DATE null,modifiedDate DATE null,name VARCHAR(200) null,title STRING null,description STRING null,content TEXT null,version VARCHAR(75) null,startKaleoNodeId LONG,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table KaleoDefinitionVersion";
	public static final String ORDER_BY_JPQL = " ORDER BY kaleoDefinitionVersion.kaleoDefinitionVersionId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY KaleoDefinitionVersion.kaleoDefinitionVersionId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoDefinitionVersion"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoDefinitionVersion"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.workflow.kaleo.model.KaleoDefinitionVersion"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long NAME_COLUMN_BITMASK = 2L;
	public static final long VERSION_COLUMN_BITMASK = 4L;
	public static final long KALEODEFINITIONVERSIONID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.portal.workflow.kaleo.model.KaleoDefinitionVersion"));

	public KaleoDefinitionVersionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _kaleoDefinitionVersionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setKaleoDefinitionVersionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kaleoDefinitionVersionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return KaleoDefinitionVersion.class;
	}

	@Override
	public String getModelClassName() {
		return KaleoDefinitionVersion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<KaleoDefinitionVersion, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<KaleoDefinitionVersion, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<KaleoDefinitionVersion, Object> attributeGetterFunction = entry.getValue();

			attributes.put(attributeName,
				attributeGetterFunction.apply((KaleoDefinitionVersion)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<KaleoDefinitionVersion, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<KaleoDefinitionVersion, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((KaleoDefinitionVersion)this,
					entry.getValue());
			}
		}
	}

	public Map<String, Function<KaleoDefinitionVersion, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<KaleoDefinitionVersion, Object>> getAttributeSetterBiConsumers() {
		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<KaleoDefinitionVersion, Object>> _attributeGetterFunctions;
	private static final Map<String, BiConsumer<KaleoDefinitionVersion, Object>> _attributeSetterBiConsumers;

	static {
		Map<String, Function<KaleoDefinitionVersion, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<KaleoDefinitionVersion, Object>>();
		Map<String, BiConsumer<KaleoDefinitionVersion, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<KaleoDefinitionVersion, ?>>();


		attributeGetterFunctions.put("mvccVersion", KaleoDefinitionVersion::getMvccVersion);
		attributeSetterBiConsumers.put("mvccVersion", (BiConsumer<KaleoDefinitionVersion, Long>)KaleoDefinitionVersion::setMvccVersion);
		attributeGetterFunctions.put("kaleoDefinitionVersionId", KaleoDefinitionVersion::getKaleoDefinitionVersionId);
		attributeSetterBiConsumers.put("kaleoDefinitionVersionId", (BiConsumer<KaleoDefinitionVersion, Long>)KaleoDefinitionVersion::setKaleoDefinitionVersionId);
		attributeGetterFunctions.put("groupId", KaleoDefinitionVersion::getGroupId);
		attributeSetterBiConsumers.put("groupId", (BiConsumer<KaleoDefinitionVersion, Long>)KaleoDefinitionVersion::setGroupId);
		attributeGetterFunctions.put("companyId", KaleoDefinitionVersion::getCompanyId);
		attributeSetterBiConsumers.put("companyId", (BiConsumer<KaleoDefinitionVersion, Long>)KaleoDefinitionVersion::setCompanyId);
		attributeGetterFunctions.put("userId", KaleoDefinitionVersion::getUserId);
		attributeSetterBiConsumers.put("userId", (BiConsumer<KaleoDefinitionVersion, Long>)KaleoDefinitionVersion::setUserId);
		attributeGetterFunctions.put("userName", KaleoDefinitionVersion::getUserName);
		attributeSetterBiConsumers.put("userName", (BiConsumer<KaleoDefinitionVersion, String>)KaleoDefinitionVersion::setUserName);
		attributeGetterFunctions.put("statusByUserId", KaleoDefinitionVersion::getStatusByUserId);
		attributeSetterBiConsumers.put("statusByUserId", (BiConsumer<KaleoDefinitionVersion, Long>)KaleoDefinitionVersion::setStatusByUserId);
		attributeGetterFunctions.put("statusByUserName", KaleoDefinitionVersion::getStatusByUserName);
		attributeSetterBiConsumers.put("statusByUserName", (BiConsumer<KaleoDefinitionVersion, String>)KaleoDefinitionVersion::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", KaleoDefinitionVersion::getStatusDate);
		attributeSetterBiConsumers.put("statusDate", (BiConsumer<KaleoDefinitionVersion, Date>)KaleoDefinitionVersion::setStatusDate);
		attributeGetterFunctions.put("createDate", KaleoDefinitionVersion::getCreateDate);
		attributeSetterBiConsumers.put("createDate", (BiConsumer<KaleoDefinitionVersion, Date>)KaleoDefinitionVersion::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", KaleoDefinitionVersion::getModifiedDate);
		attributeSetterBiConsumers.put("modifiedDate", (BiConsumer<KaleoDefinitionVersion, Date>)KaleoDefinitionVersion::setModifiedDate);
		attributeGetterFunctions.put("name", KaleoDefinitionVersion::getName);
		attributeSetterBiConsumers.put("name", (BiConsumer<KaleoDefinitionVersion, String>)KaleoDefinitionVersion::setName);
		attributeGetterFunctions.put("title", KaleoDefinitionVersion::getTitle);
		attributeSetterBiConsumers.put("title", (BiConsumer<KaleoDefinitionVersion, String>)KaleoDefinitionVersion::setTitle);
		attributeGetterFunctions.put("description", KaleoDefinitionVersion::getDescription);
		attributeSetterBiConsumers.put("description", (BiConsumer<KaleoDefinitionVersion, String>)KaleoDefinitionVersion::setDescription);
		attributeGetterFunctions.put("content", KaleoDefinitionVersion::getContent);
		attributeSetterBiConsumers.put("content", (BiConsumer<KaleoDefinitionVersion, String>)KaleoDefinitionVersion::setContent);
		attributeGetterFunctions.put("version", KaleoDefinitionVersion::getVersion);
		attributeSetterBiConsumers.put("version", (BiConsumer<KaleoDefinitionVersion, String>)KaleoDefinitionVersion::setVersion);
		attributeGetterFunctions.put("startKaleoNodeId", KaleoDefinitionVersion::getStartKaleoNodeId);
		attributeSetterBiConsumers.put("startKaleoNodeId", (BiConsumer<KaleoDefinitionVersion, Long>)KaleoDefinitionVersion::setStartKaleoNodeId);
		attributeGetterFunctions.put("status", KaleoDefinitionVersion::getStatus);
		attributeSetterBiConsumers.put("status", (BiConsumer<KaleoDefinitionVersion, Integer>)KaleoDefinitionVersion::setStatus);


		_attributeGetterFunctions = Collections.unmodifiableMap(attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap((Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public long getKaleoDefinitionVersionId() {
		return _kaleoDefinitionVersionId;
	}

	@Override
	public void setKaleoDefinitionVersionId(long kaleoDefinitionVersionId) {
		_kaleoDefinitionVersionId = kaleoDefinitionVersionId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public String getTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId);
	}

	@Override
	public String getTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId, useDefault);
	}

	@Override
	public String getTitle(String languageId) {
		return LocalizationUtil.getLocalization(getTitle(), languageId);
	}

	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getTitle(), languageId,
			useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return _titleCurrentLanguageId;
	}

	@JSON
	@Override
	public String getTitleCurrentValue() {
		Locale locale = getLocale(_titleCurrentLanguageId);

		return getTitle(locale);
	}

	@Override
	public Map<Locale, String> getTitleMap() {
		return LocalizationUtil.getLocalizationMap(getTitle());
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public void setTitle(String title, Locale locale) {
		setTitle(title, locale, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setTitle(String title, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(title)) {
			setTitle(LocalizationUtil.updateLocalization(getTitle(), "Title",
					title, languageId, defaultLanguageId));
		}
		else {
			setTitle(LocalizationUtil.removeLocalization(getTitle(), "Title",
					languageId));
		}
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		_titleCurrentLanguageId = languageId;
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap) {
		setTitleMap(titleMap, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale) {
		if (titleMap == null) {
			return;
		}

		setTitle(LocalizationUtil.updateLocalization(titleMap, getTitle(),
				"Title", LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public String getContent() {
		if (_content == null) {
			return "";
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@Override
	public String getVersion() {
		if (_version == null) {
			return "";
		}
		else {
			return _version;
		}
	}

	@Override
	public void setVersion(String version) {
		_columnBitmask |= VERSION_COLUMN_BITMASK;

		if (_originalVersion == null) {
			_originalVersion = _version;
		}

		_version = version;
	}

	public String getOriginalVersion() {
		return GetterUtil.getString(_originalVersion);
	}

	@Override
	public long getStartKaleoNodeId() {
		return _startKaleoNodeId;
	}

	@Override
	public void setStartKaleoNodeId(long startKaleoNodeId) {
		_startKaleoNodeId = startKaleoNodeId;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			KaleoDefinitionVersion.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> titleMap = getTitleMap();

		for (Map.Entry<Locale, String> entry : titleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getTitle();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(KaleoDefinitionVersion.class.getName(),
				getPrimaryKey(), defaultLocale, availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String title = getTitle(defaultLocale);

		if (Validator.isNull(title)) {
			setTitle(getTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setTitle(getTitle(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public KaleoDefinitionVersion toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (KaleoDefinitionVersion)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		KaleoDefinitionVersionImpl kaleoDefinitionVersionImpl = new KaleoDefinitionVersionImpl();

		kaleoDefinitionVersionImpl.setMvccVersion(getMvccVersion());
		kaleoDefinitionVersionImpl.setKaleoDefinitionVersionId(getKaleoDefinitionVersionId());
		kaleoDefinitionVersionImpl.setGroupId(getGroupId());
		kaleoDefinitionVersionImpl.setCompanyId(getCompanyId());
		kaleoDefinitionVersionImpl.setUserId(getUserId());
		kaleoDefinitionVersionImpl.setUserName(getUserName());
		kaleoDefinitionVersionImpl.setStatusByUserId(getStatusByUserId());
		kaleoDefinitionVersionImpl.setStatusByUserName(getStatusByUserName());
		kaleoDefinitionVersionImpl.setStatusDate(getStatusDate());
		kaleoDefinitionVersionImpl.setCreateDate(getCreateDate());
		kaleoDefinitionVersionImpl.setModifiedDate(getModifiedDate());
		kaleoDefinitionVersionImpl.setName(getName());
		kaleoDefinitionVersionImpl.setTitle(getTitle());
		kaleoDefinitionVersionImpl.setDescription(getDescription());
		kaleoDefinitionVersionImpl.setContent(getContent());
		kaleoDefinitionVersionImpl.setVersion(getVersion());
		kaleoDefinitionVersionImpl.setStartKaleoNodeId(getStartKaleoNodeId());
		kaleoDefinitionVersionImpl.setStatus(getStatus());

		kaleoDefinitionVersionImpl.resetOriginalValues();

		return kaleoDefinitionVersionImpl;
	}

	@Override
	public int compareTo(KaleoDefinitionVersion kaleoDefinitionVersion) {
		long primaryKey = kaleoDefinitionVersion.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KaleoDefinitionVersion)) {
			return false;
		}

		KaleoDefinitionVersion kaleoDefinitionVersion = (KaleoDefinitionVersion)obj;

		long primaryKey = kaleoDefinitionVersion.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		KaleoDefinitionVersionModelImpl kaleoDefinitionVersionModelImpl = this;

		kaleoDefinitionVersionModelImpl._originalCompanyId = kaleoDefinitionVersionModelImpl._companyId;

		kaleoDefinitionVersionModelImpl._setOriginalCompanyId = false;

		kaleoDefinitionVersionModelImpl._setModifiedDate = false;

		kaleoDefinitionVersionModelImpl._originalName = kaleoDefinitionVersionModelImpl._name;

		kaleoDefinitionVersionModelImpl._originalVersion = kaleoDefinitionVersionModelImpl._version;

		kaleoDefinitionVersionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<KaleoDefinitionVersion> toCacheModel() {
		KaleoDefinitionVersionCacheModel kaleoDefinitionVersionCacheModel = new KaleoDefinitionVersionCacheModel();

		kaleoDefinitionVersionCacheModel.mvccVersion = getMvccVersion();

		kaleoDefinitionVersionCacheModel.kaleoDefinitionVersionId = getKaleoDefinitionVersionId();

		kaleoDefinitionVersionCacheModel.groupId = getGroupId();

		kaleoDefinitionVersionCacheModel.companyId = getCompanyId();

		kaleoDefinitionVersionCacheModel.userId = getUserId();

		kaleoDefinitionVersionCacheModel.userName = getUserName();

		String userName = kaleoDefinitionVersionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kaleoDefinitionVersionCacheModel.userName = null;
		}

		kaleoDefinitionVersionCacheModel.statusByUserId = getStatusByUserId();

		kaleoDefinitionVersionCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = kaleoDefinitionVersionCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			kaleoDefinitionVersionCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			kaleoDefinitionVersionCacheModel.statusDate = statusDate.getTime();
		}
		else {
			kaleoDefinitionVersionCacheModel.statusDate = Long.MIN_VALUE;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kaleoDefinitionVersionCacheModel.createDate = createDate.getTime();
		}
		else {
			kaleoDefinitionVersionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kaleoDefinitionVersionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kaleoDefinitionVersionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kaleoDefinitionVersionCacheModel.name = getName();

		String name = kaleoDefinitionVersionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			kaleoDefinitionVersionCacheModel.name = null;
		}

		kaleoDefinitionVersionCacheModel.title = getTitle();

		String title = kaleoDefinitionVersionCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			kaleoDefinitionVersionCacheModel.title = null;
		}

		kaleoDefinitionVersionCacheModel.description = getDescription();

		String description = kaleoDefinitionVersionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			kaleoDefinitionVersionCacheModel.description = null;
		}

		kaleoDefinitionVersionCacheModel.content = getContent();

		String content = kaleoDefinitionVersionCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			kaleoDefinitionVersionCacheModel.content = null;
		}

		kaleoDefinitionVersionCacheModel.version = getVersion();

		String version = kaleoDefinitionVersionCacheModel.version;

		if ((version != null) && (version.length() == 0)) {
			kaleoDefinitionVersionCacheModel.version = null;
		}

		kaleoDefinitionVersionCacheModel.startKaleoNodeId = getStartKaleoNodeId();

		kaleoDefinitionVersionCacheModel.status = getStatus();

		return kaleoDefinitionVersionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<KaleoDefinitionVersion, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((4 * attributeGetterFunctions.size()) +
				2);

		sb.append("{");

		for (Map.Entry<String, Function<KaleoDefinitionVersion, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<KaleoDefinitionVersion, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply(
					(KaleoDefinitionVersion)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<KaleoDefinitionVersion, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler((5 * attributeGetterFunctions.size()) +
				4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<KaleoDefinitionVersion, Object>> entry : attributeGetterFunctions.entrySet()) {
			String attributeName = entry.getKey();
			Function<KaleoDefinitionVersion, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply(
					(KaleoDefinitionVersion)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = KaleoDefinitionVersion.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			KaleoDefinitionVersion.class, ModelWrapper.class
		};
	private long _mvccVersion;
	private long _kaleoDefinitionVersionId;
	private long _groupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _originalName;
	private String _title;
	private String _titleCurrentLanguageId;
	private String _description;
	private String _content;
	private String _version;
	private String _originalVersion;
	private long _startKaleoNodeId;
	private int _status;
	private long _columnBitmask;
	private KaleoDefinitionVersion _escapedModel;
}