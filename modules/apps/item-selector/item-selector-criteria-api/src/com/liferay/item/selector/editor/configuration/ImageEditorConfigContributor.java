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

package com.liferay.item.selector.editor.configuration;

import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLBuilder;

import java.util.Map;

import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(service = EditorConfigContributor.class)
public class ImageEditorConfigContributor extends BaseEditorConfigContributor {

	@Override
	public void populateConfigJSONObject(
		JSONObject jsonObject, Map<String, Object> inputEditorTaglibAttributes,
		ThemeDisplay themeDisplay, PortletURLBuilder portletURLBuilder) {

		PortletURL itemSelectorURL = getItemSelectorPortletURL(
			inputEditorTaglibAttributes, portletURLBuilder,
				new ImageItemSelectorCriterion());

		if (itemSelectorURL != null) {
			jsonObject.put(
				"filebrowserImageBrowseLinkUrl", itemSelectorURL.toString());
			jsonObject.put(
				"filebrowserImageBrowseUrl", itemSelectorURL.toString());
		}
	}

	@Reference(unbind = "-")
	public void setItemSelector(ItemSelector itemSelector) {
		_itemSelector = itemSelector;
	}

	protected ItemSelector getItemSelector() {
		return _itemSelector;
	}

	private ItemSelector _itemSelector;

}