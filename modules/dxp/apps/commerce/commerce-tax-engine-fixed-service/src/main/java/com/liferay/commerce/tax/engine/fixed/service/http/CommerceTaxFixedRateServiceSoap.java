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

package com.liferay.commerce.tax.engine.fixed.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.tax.engine.fixed.service.CommerceTaxFixedRateServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link CommerceTaxFixedRateServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRate}, that is translated to a
 * {@link com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceTaxFixedRateServiceHttp
 * @see com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateSoap
 * @see CommerceTaxFixedRateServiceUtil
 * @generated
 */
@ProviderType
public class CommerceTaxFixedRateServiceSoap {
	public static com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateSoap addCommerceTaxFixedRate(
		long commerceTaxMethodId, long cpTaxCategoryId, double rate,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRate returnValue =
				CommerceTaxFixedRateServiceUtil.addCommerceTaxFixedRate(commerceTaxMethodId,
					cpTaxCategoryId, rate, serviceContext);

			return com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteCommerceTaxFixedRate(long commerceTaxFixedRateId)
		throws RemoteException {
		try {
			CommerceTaxFixedRateServiceUtil.deleteCommerceTaxFixedRate(commerceTaxFixedRateId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateSoap fetchCommerceTaxFixedRate(
		long commerceTaxFixedRateId) throws RemoteException {
		try {
			com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRate returnValue =
				CommerceTaxFixedRateServiceUtil.fetchCommerceTaxFixedRate(commerceTaxFixedRateId);

			return com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateSoap fetchCommerceTaxFixedRate(
		long cpTaxCategoryId, long commerceTaxMethodId)
		throws RemoteException {
		try {
			com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRate returnValue =
				CommerceTaxFixedRateServiceUtil.fetchCommerceTaxFixedRate(cpTaxCategoryId,
					commerceTaxMethodId);

			return com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateSoap[] getCommerceTaxFixedRates(
		long groupId, long commerceTaxMethodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRate> orderByComparator)
		throws RemoteException {
		try {
			java.util.List<com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRate> returnValue =
				CommerceTaxFixedRateServiceUtil.getCommerceTaxFixedRates(groupId,
					commerceTaxMethodId, start, end, orderByComparator);

			return com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getCommerceTaxFixedRatesCount(long groupId,
		long commerceTaxMethodId) throws RemoteException {
		try {
			int returnValue = CommerceTaxFixedRateServiceUtil.getCommerceTaxFixedRatesCount(groupId,
					commerceTaxMethodId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateSoap updateCommerceTaxFixedRate(
		long commerceTaxFixedRateId, double rate) throws RemoteException {
		try {
			com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRate returnValue =
				CommerceTaxFixedRateServiceUtil.updateCommerceTaxFixedRate(commerceTaxFixedRateId,
					rate);

			return com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CommerceTaxFixedRateServiceSoap.class);
}