/**
 * Copyright 2015 Stnts Inc.<br>
 * All rights reserved.<br>
 * (注意：本内容仅限于盛天公司内部传阅，禁止外泄以及用于其他的商业目的)<br>
 * Date: 2015年12月8日<br>
 * 文件名称: MessageSourceHelper.java<br>
 * 项目名称: web4j-validator<br>
 * 作者: Administrator<br>
 **/
package validatedemo.util;

import java.util.Locale;

import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * 类描述:资源文件读取类.
 **/
public class MessageSourceHelper {
    private ResourceBundleMessageSource messageSource;

    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        String msg = messageSource.getMessage(code, args, defaultMessage, locale);
        return msg != null ? msg.trim() : msg;
    }

    public String getMessage(String code, Object[] args) {
        return getMessage(code, args, null, Locale.CHINA);
    }

    public String getMessage(String code) {
        return getMessage(code, null, null, Locale.CHINA);
    }

    public void setMessageSource(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
