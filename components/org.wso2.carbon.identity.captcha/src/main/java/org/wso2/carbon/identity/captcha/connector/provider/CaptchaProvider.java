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

package org.wso2.carbon.identity.captcha.connector.provider;

import org.wso2.carbon.identity.captcha.exception.CaptchaException;
import org.wso2.carbon.identity.captcha.util.CaptchaConfigs;
import org.wso2.carbon.identity.captcha.util.CaptchaConstants;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Captcha Provider interface.
 */
public interface CaptchaProvider {

    String getName();

    int getPriority();

    CaptchaConfigs getCaptchaProperties();

    void setCaptchaParamsForPreValidation(ServletRequest servletRequest, ServletResponse servletResponse,
                                          CaptchaConstants.Flow flow) throws CaptchaException;

    void setCaptchaParamsForPostValidation(ServletRequest servletRequest, ServletResponse servletResponse,
                                          CaptchaConstants.Flow flow) throws CaptchaException;

    boolean verifyCaptcha(ServletRequest servletRequest, ServletResponse servletResponse) throws CaptchaException;

    void addPostValidationData(ServletRequest servletRequest);
}
