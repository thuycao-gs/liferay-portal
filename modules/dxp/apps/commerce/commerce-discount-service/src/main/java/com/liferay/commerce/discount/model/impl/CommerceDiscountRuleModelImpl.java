/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.commerce.discount.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.discount.model.CommerceDiscountRule;
import com.liferay.commerce.discount.model.CommerceDiscountRuleModel;
import com.liferay.commerce.discount.model.CommerceDiscountRuleSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CommerceDiscountRule service. Represents a row in the &quot;CommerceDiscountRule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CommerceDiscountRuleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceDiscountRuleImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CommerceDiscountRuleImpl
 * @see CommerceDiscountRule
 * @see CommerceDiscountRuleModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CommerceDiscountRuleModelImpl extends BaseModelImpl<CommerceDiscountRule>
	implements CommerceDiscountRuleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce discount rule model instance should use the {@link CommerceDiscountRule} interface instead.
	 */
	public static final String TABLE_NAME = "CommerceDiscountRule";
	public static final Object[][] TABLE_COLUMNS = {
			{ "commerceDiscountRuleId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "commerceDiscountId", Types.BIGINT },
			{ "type_", Types.VARCHAR },
			{ "typeSettings", Types.CLOB }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("commerceDiscountRuleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceDiscountId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("typeSettings", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE = "create table CommerceDiscountRule (commerceDiscountRuleId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceDiscountId LONG,type_ VARCHAR(75) null,typeSettings TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table CommerceDiscountRule";
	public static final String ORDER_BY_JPQL = " ORDER BY commerceDiscountRule.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CommerceDiscountRule.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.discount.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.discount.model.CommerceDiscountRule"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.discount.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.discount.model.CommerceDiscountRule"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.discount.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.discount.model.CommerceDiscountRule"),
			true);
	public static final long COMMERCEDISCOUNTID_COLUMN_BITMASK = 1L;
	public static final long CREATEDATE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceDiscountRule toModel(
		CommerceDiscountRuleSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommerceDiscountRule model = new CommerceDiscountRuleImpl();

		model.setCommerceDiscountRuleId(soapModel.getCommerceDiscountRuleId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommerceDiscountId(soapModel.getCommerceDiscountId());
		model.setType(soapModel.getType());
		model.setTypeSettings(soapModel.getTypeSettings());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceDiscountRule> toModels(
		CommerceDiscountRuleSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CommerceDiscountRule> models = new ArrayList<CommerceDiscountRule>(soapModels.length);

		for (CommerceDiscountRuleSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.discount.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.discount.model.CommerceDiscountRule"));

	public CommerceDiscountRuleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceDiscountRuleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceDiscountRuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceDiscountRuleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceDiscountRule.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceDiscountRule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commerceDiscountRuleId", getCommerceDiscountRuleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("commerceDiscountId", getCommerceDiscountId());
		attributes.put("type", getType());
		attributes.put("typeSettings", getTypeSettings());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commerceDiscountRuleId = (Long)attributes.get(
				"commerceDiscountRuleId");

		if (commerceDiscountRuleId != null) {
			setCommerceDiscountRuleId(commerceDiscountRuleId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long commerceDiscountId = (Long)attributes.get("commerceDiscountId");

		if (commerceDiscountId != null) {
			setCommerceDiscountId(commerceDiscountId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}
	}

	@JSON
	@Override
	public long getCommerceDiscountRuleId() {
		return _commerceDiscountRuleId;
	}

	@Override
	public void setCommerceDiscountRuleId(long commerceDiscountRuleId) {
		_commerceDiscountRuleId = commerceDiscountRuleId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
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

	@JSON
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

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
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

	@JSON
	@Override
	public long getCommerceDiscountId() {
		return _commerceDiscountId;
	}

	@Override
	public void setCommerceDiscountId(long commerceDiscountId) {
		_columnBitmask |= COMMERCEDISCOUNTID_COLUMN_BITMASK;

		if (!_setOriginalCommerceDiscountId) {
			_setOriginalCommerceDiscountId = true;

			_originalCommerceDiscountId = _commerceDiscountId;
		}

		_commerceDiscountId = commerceDiscountId;
	}

	public long getOriginalCommerceDiscountId() {
		return _originalCommerceDiscountId;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_type = type;
	}

	@JSON
	@Override
	public String getTypeSettings() {
		if (_typeSettings == null) {
			return "";
		}
		else {
			return _typeSettings;
		}
	}

	@Override
	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CommerceDiscountRule.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceDiscountRule toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CommerceDiscountRule)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommerceDiscountRuleImpl commerceDiscountRuleImpl = new CommerceDiscountRuleImpl();

		commerceDiscountRuleImpl.setCommerceDiscountRuleId(getCommerceDiscountRuleId());
		commerceDiscountRuleImpl.setGroupId(getGroupId());
		commerceDiscountRuleImpl.setCompanyId(getCompanyId());
		commerceDiscountRuleImpl.setUserId(getUserId());
		commerceDiscountRuleImpl.setUserName(getUserName());
		commerceDiscountRuleImpl.setCreateDate(getCreateDate());
		commerceDiscountRuleImpl.setModifiedDate(getModifiedDate());
		commerceDiscountRuleImpl.setCommerceDiscountId(getCommerceDiscountId());
		commerceDiscountRuleImpl.setType(getType());
		commerceDiscountRuleImpl.setTypeSettings(getTypeSettings());

		commerceDiscountRuleImpl.resetOriginalValues();

		return commerceDiscountRuleImpl;
	}

	@Override
	public int compareTo(CommerceDiscountRule commerceDiscountRule) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				commerceDiscountRule.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommerceDiscountRule)) {
			return false;
		}

		CommerceDiscountRule commerceDiscountRule = (CommerceDiscountRule)obj;

		long primaryKey = commerceDiscountRule.getPrimaryKey();

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
		CommerceDiscountRuleModelImpl commerceDiscountRuleModelImpl = this;

		commerceDiscountRuleModelImpl._setModifiedDate = false;

		commerceDiscountRuleModelImpl._originalCommerceDiscountId = commerceDiscountRuleModelImpl._commerceDiscountId;

		commerceDiscountRuleModelImpl._setOriginalCommerceDiscountId = false;

		commerceDiscountRuleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceDiscountRule> toCacheModel() {
		CommerceDiscountRuleCacheModel commerceDiscountRuleCacheModel = new CommerceDiscountRuleCacheModel();

		commerceDiscountRuleCacheModel.commerceDiscountRuleId = getCommerceDiscountRuleId();

		commerceDiscountRuleCacheModel.groupId = getGroupId();

		commerceDiscountRuleCacheModel.companyId = getCompanyId();

		commerceDiscountRuleCacheModel.userId = getUserId();

		commerceDiscountRuleCacheModel.userName = getUserName();

		String userName = commerceDiscountRuleCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceDiscountRuleCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceDiscountRuleCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceDiscountRuleCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceDiscountRuleCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commerceDiscountRuleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceDiscountRuleCacheModel.commerceDiscountId = getCommerceDiscountId();

		commerceDiscountRuleCacheModel.type = getType();

		String type = commerceDiscountRuleCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			commerceDiscountRuleCacheModel.type = null;
		}

		commerceDiscountRuleCacheModel.typeSettings = getTypeSettings();

		String typeSettings = commerceDiscountRuleCacheModel.typeSettings;

		if ((typeSettings != null) && (typeSettings.length() == 0)) {
			commerceDiscountRuleCacheModel.typeSettings = null;
		}

		return commerceDiscountRuleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{commerceDiscountRuleId=");
		sb.append(getCommerceDiscountRuleId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", commerceDiscountId=");
		sb.append(getCommerceDiscountId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", typeSettings=");
		sb.append(getTypeSettings());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.commerce.discount.model.CommerceDiscountRule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>commerceDiscountRuleId</column-name><column-value><![CDATA[");
		sb.append(getCommerceDiscountRuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commerceDiscountId</column-name><column-value><![CDATA[");
		sb.append(getCommerceDiscountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeSettings</column-name><column-value><![CDATA[");
		sb.append(getTypeSettings());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CommerceDiscountRule.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CommerceDiscountRule.class, ModelWrapper.class
		};
	private long _commerceDiscountRuleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceDiscountId;
	private long _originalCommerceDiscountId;
	private boolean _setOriginalCommerceDiscountId;
	private String _type;
	private String _typeSettings;
	private long _columnBitmask;
	private CommerceDiscountRule _escapedModel;
}