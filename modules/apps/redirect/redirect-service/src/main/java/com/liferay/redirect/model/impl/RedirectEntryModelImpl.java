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

package com.liferay.redirect.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.redirect.model.RedirectEntry;
import com.liferay.redirect.model.RedirectEntryModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the RedirectEntry service. Represents a row in the &quot;RedirectEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>RedirectEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RedirectEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RedirectEntryImpl
 * @generated
 */
public class RedirectEntryModelImpl
	extends BaseModelImpl<RedirectEntry> implements RedirectEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a redirect entry model instance should use the <code>RedirectEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "RedirectEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"redirectEntryId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"destinationURL", Types.VARCHAR},
		{"sourceURL", Types.VARCHAR}, {"temporary", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("redirectEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("destinationURL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sourceURL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("temporary", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table RedirectEntry (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,redirectEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,destinationURL VARCHAR(75) null,sourceURL VARCHAR(75) null,temporary BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table RedirectEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY redirectEntry.redirectEntryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY RedirectEntry.redirectEntryId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long REDIRECTENTRYID_COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public RedirectEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _redirectEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRedirectEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _redirectEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RedirectEntry.class;
	}

	@Override
	public String getModelClassName() {
		return RedirectEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<RedirectEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<RedirectEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RedirectEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((RedirectEntry)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<RedirectEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<RedirectEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(RedirectEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<RedirectEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<RedirectEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, RedirectEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			RedirectEntry.class.getClassLoader(), RedirectEntry.class,
			ModelWrapper.class);

		try {
			Constructor<RedirectEntry> constructor =
				(Constructor<RedirectEntry>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<RedirectEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<RedirectEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<RedirectEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<RedirectEntry, Object>>();
		Map<String, BiConsumer<RedirectEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<RedirectEntry, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", RedirectEntry::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<RedirectEntry, Long>)RedirectEntry::setMvccVersion);
		attributeGetterFunctions.put("uuid", RedirectEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<RedirectEntry, String>)RedirectEntry::setUuid);
		attributeGetterFunctions.put(
			"redirectEntryId", RedirectEntry::getRedirectEntryId);
		attributeSetterBiConsumers.put(
			"redirectEntryId",
			(BiConsumer<RedirectEntry, Long>)RedirectEntry::setRedirectEntryId);
		attributeGetterFunctions.put("groupId", RedirectEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<RedirectEntry, Long>)RedirectEntry::setGroupId);
		attributeGetterFunctions.put("companyId", RedirectEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<RedirectEntry, Long>)RedirectEntry::setCompanyId);
		attributeGetterFunctions.put("userId", RedirectEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<RedirectEntry, Long>)RedirectEntry::setUserId);
		attributeGetterFunctions.put("userName", RedirectEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<RedirectEntry, String>)RedirectEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", RedirectEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<RedirectEntry, Date>)RedirectEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", RedirectEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<RedirectEntry, Date>)RedirectEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"destinationURL", RedirectEntry::getDestinationURL);
		attributeSetterBiConsumers.put(
			"destinationURL",
			(BiConsumer<RedirectEntry, String>)
				RedirectEntry::setDestinationURL);
		attributeGetterFunctions.put("sourceURL", RedirectEntry::getSourceURL);
		attributeSetterBiConsumers.put(
			"sourceURL",
			(BiConsumer<RedirectEntry, String>)RedirectEntry::setSourceURL);
		attributeGetterFunctions.put("temporary", RedirectEntry::getTemporary);
		attributeSetterBiConsumers.put(
			"temporary",
			(BiConsumer<RedirectEntry, Boolean>)RedirectEntry::setTemporary);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
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
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getRedirectEntryId() {
		return _redirectEntryId;
	}

	@Override
	public void setRedirectEntryId(long redirectEntryId) {
		_redirectEntryId = redirectEntryId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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
		catch (PortalException portalException) {
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
	public String getDestinationURL() {
		if (_destinationURL == null) {
			return "";
		}
		else {
			return _destinationURL;
		}
	}

	@Override
	public void setDestinationURL(String destinationURL) {
		_destinationURL = destinationURL;
	}

	@Override
	public String getSourceURL() {
		if (_sourceURL == null) {
			return "";
		}
		else {
			return _sourceURL;
		}
	}

	@Override
	public void setSourceURL(String sourceURL) {
		_sourceURL = sourceURL;
	}

	@Override
	public boolean getTemporary() {
		return _temporary;
	}

	@Override
	public boolean isTemporary() {
		return _temporary;
	}

	@Override
	public void setTemporary(boolean temporary) {
		_temporary = temporary;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(RedirectEntry.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), RedirectEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RedirectEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, RedirectEntry>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RedirectEntryImpl redirectEntryImpl = new RedirectEntryImpl();

		redirectEntryImpl.setMvccVersion(getMvccVersion());
		redirectEntryImpl.setUuid(getUuid());
		redirectEntryImpl.setRedirectEntryId(getRedirectEntryId());
		redirectEntryImpl.setGroupId(getGroupId());
		redirectEntryImpl.setCompanyId(getCompanyId());
		redirectEntryImpl.setUserId(getUserId());
		redirectEntryImpl.setUserName(getUserName());
		redirectEntryImpl.setCreateDate(getCreateDate());
		redirectEntryImpl.setModifiedDate(getModifiedDate());
		redirectEntryImpl.setDestinationURL(getDestinationURL());
		redirectEntryImpl.setSourceURL(getSourceURL());
		redirectEntryImpl.setTemporary(isTemporary());

		redirectEntryImpl.resetOriginalValues();

		return redirectEntryImpl;
	}

	@Override
	public int compareTo(RedirectEntry redirectEntry) {
		long primaryKey = redirectEntry.getPrimaryKey();

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

		if (!(obj instanceof RedirectEntry)) {
			return false;
		}

		RedirectEntry redirectEntry = (RedirectEntry)obj;

		long primaryKey = redirectEntry.getPrimaryKey();

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
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		RedirectEntryModelImpl redirectEntryModelImpl = this;

		redirectEntryModelImpl._originalUuid = redirectEntryModelImpl._uuid;

		redirectEntryModelImpl._originalGroupId =
			redirectEntryModelImpl._groupId;

		redirectEntryModelImpl._setOriginalGroupId = false;

		redirectEntryModelImpl._originalCompanyId =
			redirectEntryModelImpl._companyId;

		redirectEntryModelImpl._setOriginalCompanyId = false;

		redirectEntryModelImpl._setModifiedDate = false;

		redirectEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<RedirectEntry> toCacheModel() {
		RedirectEntryCacheModel redirectEntryCacheModel =
			new RedirectEntryCacheModel();

		redirectEntryCacheModel.mvccVersion = getMvccVersion();

		redirectEntryCacheModel.uuid = getUuid();

		String uuid = redirectEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			redirectEntryCacheModel.uuid = null;
		}

		redirectEntryCacheModel.redirectEntryId = getRedirectEntryId();

		redirectEntryCacheModel.groupId = getGroupId();

		redirectEntryCacheModel.companyId = getCompanyId();

		redirectEntryCacheModel.userId = getUserId();

		redirectEntryCacheModel.userName = getUserName();

		String userName = redirectEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			redirectEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			redirectEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			redirectEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			redirectEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			redirectEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		redirectEntryCacheModel.destinationURL = getDestinationURL();

		String destinationURL = redirectEntryCacheModel.destinationURL;

		if ((destinationURL != null) && (destinationURL.length() == 0)) {
			redirectEntryCacheModel.destinationURL = null;
		}

		redirectEntryCacheModel.sourceURL = getSourceURL();

		String sourceURL = redirectEntryCacheModel.sourceURL;

		if ((sourceURL != null) && (sourceURL.length() == 0)) {
			redirectEntryCacheModel.sourceURL = null;
		}

		redirectEntryCacheModel.temporary = isTemporary();

		return redirectEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<RedirectEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<RedirectEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RedirectEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((RedirectEntry)this));
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
		Map<String, Function<RedirectEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<RedirectEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RedirectEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((RedirectEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, RedirectEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _redirectEntryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _destinationURL;
	private String _sourceURL;
	private boolean _temporary;
	private long _columnBitmask;
	private RedirectEntry _escapedModel;

}