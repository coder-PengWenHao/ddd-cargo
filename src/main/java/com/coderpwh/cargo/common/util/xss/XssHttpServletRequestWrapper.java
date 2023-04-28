package com.coderpwh.cargo.common.util.xss;

import cn.hutool.core.util.StrUtil;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

/**
 * @author coderpwh
 * @date 2023/4/28 11:32
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    HttpServletRequest orgRequest;
    private static final HTMLFilter htmlFilter = new HTMLFilter();

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.orgRequest = request;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (!"application/json".equalsIgnoreCase(super.getHeader("Content-Type"))) {
            return super.getInputStream();
        } else {
            String json = IOUtils.toString(super.getInputStream(), "utf-8");
            if (StrUtil.isBlank(json)) {
                return super.getInputStream();
            } else {
                json = this.xssEncode(json);
                final ByteArrayInputStream bis = new ByteArrayInputStream(json.getBytes("utf-8"));
                return new ServletInputStream() {
                    @Override
                    public boolean isFinished() {
                        return true;
                    }

                    @Override
                    public boolean isReady() {
                        return true;
                    }

                    @Override
                    public void setReadListener(ReadListener readListener) {
                    }

                    @Override
                    public int read() throws IOException {
                        return bis.read();
                    }
                };
            }
        }
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(this.xssEncode(name));
        if (StrUtil.isNotBlank(value)) {
            value = this.xssEncode(value);
        }

        return value;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] parameters = super.getParameterValues(name);
        if (parameters != null && parameters.length != 0) {
            for (int i = 0; i < parameters.length; ++i) {
                parameters[i] = this.xssEncode(parameters[i]);
            }

            return parameters;
        } else {
            return null;
        }
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> map = new LinkedHashMap();
        Map<String, String[]> parameters = super.getParameterMap();
        Iterator var3 = parameters.keySet().iterator();

        while (var3.hasNext()) {
            String key = (String) var3.next();
            String[] values = (String[]) parameters.get(key);

            for (int i = 0; i < values.length; ++i) {
                values[i] = this.xssEncode(values[i]);
            }

            map.put(key, values);
        }

        return map;
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(this.xssEncode(name));
        if (StrUtil.isNotBlank(value)) {
            value = this.xssEncode(value);
        }

        return value;
    }

    private String xssEncode(String input) {
        return input;
    }

    public HttpServletRequest getOrgRequest() {
        return this.orgRequest;
    }


    public static HttpServletRequest getOrgRequest(HttpServletRequest request) {
        return request instanceof XssHttpServletRequestWrapper ? ((XssHttpServletRequestWrapper) request).getOrgRequest() : request;
    }
}
