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

package com.liferay.frontend.taglib.servlet.taglib;

import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolvedPackageNameUtil;
import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.servlet.taglib.aui.ScriptData;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PortalImpl;
import com.liferay.portal.util.PropsImpl;

import java.io.StringWriter;

import java.net.URL;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.mockito.Mockito;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockPageContext;

/**
 * @author Cristina González
 */
public class ComponentTagTest {

	@BeforeClass
	public static void setUpClass() {
		JSONFactoryUtil jsonFactoryUtil = new JSONFactoryUtil();

		jsonFactoryUtil.setJSONFactory(new JSONFactoryImpl());

		PortalClassLoaderUtil.setClassLoader(PortalImpl.class.getClassLoader());

		PortalUtil portalUtil = new PortalUtil();

		portalUtil.setPortal(new PortalImpl());

		PropsUtil.setProps(new PropsImpl());
	}

	@Test
	public void testDoEndTag() throws Exception {
		ComponentTag componentTag = new ComponentTag();

		HttpServletRequest httpServletRequest = _getHttpServletRequest();

		componentTag.setComponentId("componentId");

		componentTag.setContext(
			new HashMapBuilder().<String, Object>put(
				"name", "value"
			).build());

		componentTag.setModule("module");
		componentTag.setPageContext(
			new MockPageContext(_getServletContext(), httpServletRequest));

		componentTag.doEndTag();

		Document document = _toDocument(
			(ScriptData)httpServletRequest.getAttribute(
				WebKeys.AUI_SCRIPT_DATA));

		Elements elements = document.select("script[type='text/javascript']");

		Assert.assertEquals(1, elements.size());

		Element element = elements.get(0);

		Assert.assertEquals(_expectedResult(), element.html());
	}

	private String _expectedResult() throws Exception {
		Class<?> clazz = getClass();

		URL url = clazz.getResource("componentTag.txt");

		return new String(Files.readAllBytes(Paths.get(url.toURI())));
	}

	private HttpServletRequest _getHttpServletRequest() {
		MockHttpServletRequest mockHttpServletRequest =
			new MockHttpServletRequest();

		ThemeDisplay themeDisplay = new ThemeDisplay();

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		portletDisplay.setNamespace("namespace");

		LiferayPortletConfig liferayPortletConfig = Mockito.mock(
			LiferayPortletConfig.class);

		Mockito.when(
			liferayPortletConfig.getPortletId()
		).thenReturn(
			"portletId"
		);

		mockHttpServletRequest.setAttribute(
			JavaConstants.JAVAX_PORTLET_CONFIG, liferayPortletConfig);

		mockHttpServletRequest.setAttribute(
			WebKeys.THEME_DISPLAY, themeDisplay);

		return mockHttpServletRequest;
	}

	private ServletContext _getServletContext() {
		ServletContext servletContext = Mockito.mock(ServletContext.class);

		servletContext.setAttribute(
			NPMResolvedPackageNameUtil.class.getName(),
			"NPMResolvedPackageNameUtil");

		return servletContext;
	}

	private Document _toDocument(ScriptData scriptData) throws Exception {
		StringWriter stringWriter = new StringWriter();

		scriptData.writeTo(stringWriter);

		StringBuffer stringBuffer = stringWriter.getBuffer();

		return Jsoup.parse(stringBuffer.toString());
	}

}