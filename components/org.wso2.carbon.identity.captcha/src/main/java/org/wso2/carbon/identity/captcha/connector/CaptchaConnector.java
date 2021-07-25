/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.captcha.connector;

import org.wso2.carbon.identity.captcha.exception.CaptchaException;
import org.wso2.carbon.identity.governance.IdentityGovernanceService;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Captcha Connector.
 */
public interface CaptchaConnector {

    void init(IdentityGovernanceService identityGovernanceService);

    int getPriority();

    boolean canHandle(ServletRequest servletRequest, ServletResponse servletResponse) throws CaptchaException;

    @Deprecated
    CaptchaPreValidationResponse preValidate(ServletRequest servletRequest, ServletResponse servletResponse) throws
            CaptchaException;

    default CaptchaPreValidationResponse preValidate(ServletRequest servletRequest, ServletResponse servletResponse, CaptchaProvider captchaProvider) throws
            CaptchaException {
        return null;
    }

    @Deprecated
    CaptchaPostValidationResponse postValidate(ServletRequest servletRequest, ServletResponse servletResponse) throws
            CaptchaException;

    default CaptchaPostValidationResponse postValidate(ServletRequest servletRequest, ServletResponse servletResponse, CaptchaProvider captchaProvider) throws
            CaptchaException{
        return null;
    }

    @Deprecated
    boolean verifyCaptcha(ServletRequest servletRequest, ServletResponse servletResponse) throws CaptchaException;

    default boolean verifyCaptcha(ServletRequest servletRequest, ServletResponse servletResponse, CaptchaProvider captchaProvider) throws CaptchaException{
        return false;
    }

}
