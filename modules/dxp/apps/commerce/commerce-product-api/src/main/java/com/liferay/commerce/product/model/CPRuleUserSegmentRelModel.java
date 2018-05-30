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

package com.liferay.commerce.product.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CPRuleUserSegmentRel service. Represents a row in the &quot;CPRuleUserSegmentRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.commerce.product.model.impl.CPRuleUserSegmentRelModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.commerce.product.model.impl.CPRuleUserSegmentRelImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CPRuleUserSegmentRel
 * @see com.liferay.commerce.product.model.impl.CPRuleUserSegmentRelImpl
 * @see com.liferay.commerce.product.model.impl.CPRuleUserSegmentRelModelImpl
 * @generated
 */
@ProviderType
public interface CPRuleUserSegmentRelModel extends BaseModel<CPRuleUserSegmentRel>,
	GroupedModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cp rule user segment rel model instance should use the {@link CPRuleUserSegmentRel} interface instead.
	 */

	/**
	 * Returns the primary key of this cp rule user segment rel.
	 *
	 * @return the primary key of this cp rule user segment rel
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cp rule user segment rel.
	 *
	 * @param primaryKey the primary key of this cp rule user segment rel
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the cp rule user segment rel ID of this cp rule user segment rel.
	 *
	 * @return the cp rule user segment rel ID of this cp rule user segment rel
	 */
	public long getCPRuleUserSegmentRelId();

	/**
	 * Sets the cp rule user segment rel ID of this cp rule user segment rel.
	 *
	 * @param CPRuleUserSegmentRelId the cp rule user segment rel ID of this cp rule user segment rel
	 */
	public void setCPRuleUserSegmentRelId(long CPRuleUserSegmentRelId);

	/**
	 * Returns the group ID of this cp rule user segment rel.
	 *
	 * @return the group ID of this cp rule user segment rel
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this cp rule user segment rel.
	 *
	 * @param groupId the group ID of this cp rule user segment rel
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this cp rule user segment rel.
	 *
	 * @return the company ID of this cp rule user segment rel
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this cp rule user segment rel.
	 *
	 * @param companyId the company ID of this cp rule user segment rel
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this cp rule user segment rel.
	 *
	 * @return the user ID of this cp rule user segment rel
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this cp rule user segment rel.
	 *
	 * @param userId the user ID of this cp rule user segment rel
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this cp rule user segment rel.
	 *
	 * @return the user uuid of this cp rule user segment rel
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this cp rule user segment rel.
	 *
	 * @param userUuid the user uuid of this cp rule user segment rel
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this cp rule user segment rel.
	 *
	 * @return the user name of this cp rule user segment rel
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this cp rule user segment rel.
	 *
	 * @param userName the user name of this cp rule user segment rel
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this cp rule user segment rel.
	 *
	 * @return the create date of this cp rule user segment rel
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this cp rule user segment rel.
	 *
	 * @param createDate the create date of this cp rule user segment rel
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this cp rule user segment rel.
	 *
	 * @return the modified date of this cp rule user segment rel
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this cp rule user segment rel.
	 *
	 * @param modifiedDate the modified date of this cp rule user segment rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the cp rule ID of this cp rule user segment rel.
	 *
	 * @return the cp rule ID of this cp rule user segment rel
	 */
	public long getCPRuleId();

	/**
	 * Sets the cp rule ID of this cp rule user segment rel.
	 *
	 * @param CPRuleId the cp rule ID of this cp rule user segment rel
	 */
	public void setCPRuleId(long CPRuleId);

	/**
	 * Returns the commerce user segment entry ID of this cp rule user segment rel.
	 *
	 * @return the commerce user segment entry ID of this cp rule user segment rel
	 */
	public long getCommerceUserSegmentEntryId();

	/**
	 * Sets the commerce user segment entry ID of this cp rule user segment rel.
	 *
	 * @param commerceUserSegmentEntryId the commerce user segment entry ID of this cp rule user segment rel
	 */
	public void setCommerceUserSegmentEntryId(long commerceUserSegmentEntryId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(CPRuleUserSegmentRel cpRuleUserSegmentRel);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CPRuleUserSegmentRel> toCacheModel();

	@Override
	public CPRuleUserSegmentRel toEscapedModel();

	@Override
	public CPRuleUserSegmentRel toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}