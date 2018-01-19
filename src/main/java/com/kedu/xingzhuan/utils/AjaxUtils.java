package com.kedu.xingzhuan.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author：
 * @date  ： 2017年6月5日 上午09:55:48
 * @Desc  ：ajax工具类
 */
public class AjaxUtils {

	private static final String HEADER_ENCODING = "encoding";
	private static final String HEADER_NOCACHE = "no-cache";
	private static final String DEFAULT_ENCODING = "UTF-8";
	private static final boolean DEFAULT_NOCACHE = true;

	public static ObjectMapper mapper = JsonUtils.mapper;

	static {
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	}

	/**
	 * 直接输出内容的简便函数
	 */
	public static void render(HttpServletResponse response, final String contentType, final String content,
			final String... headers) {
		initResponseHeader(response, contentType, headers);
		PrintWriter write = null;
		try {
			write = response.getWriter();
			write.write(content);
			write.flush();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (write != null) {
				write.close();
			}
		}
	}

	/**
	 * 直接输出文本.
	 */
	public static void renderText(HttpServletResponse response, final String text, final String... headers) {
		render(response, CommonConstants.CONTENT_TYPE.TEXT_TYPE, text, headers);
	}

	/**
	 * 直接输出HTML.
	 * 
	 */
	public static void renderHtml(HttpServletResponse response, final String html, final String... headers) {
		render(response, CommonConstants.CONTENT_TYPE.HTML_TYPE, html, headers);
	}

	/**
	 * 直接输出XML.
	 * 
	 */
	public static void renderXml(HttpServletResponse response, final String xml, final String... headers) {
		render(response, CommonConstants.CONTENT_TYPE.XML_TYPE, xml, headers);
	}

	/**
	 * 直接输出JSON.
	 */
	public static void renderJson(HttpServletResponse response, final String jsonString, final String... headers) {
		render(response, CommonConstants.CONTENT_TYPE.JSON_TYPE, jsonString, headers);
	}

	/**
	 * 直接输出JSON,使用Jackson转换Java对象.
	 */
	public static void renderJson(HttpServletResponse response, final Object data, final String... headers) {
		initResponseHeader(response, CommonConstants.CONTENT_TYPE.JSON_TYPE, headers);
		try {
			mapper.writeValue(response.getWriter(), data);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * 直接输出支持跨域Mashup的JSONP.
	 */
	public static void renderJsonp(HttpServletResponse response, final String callbackName, final Object object,
			final String... headers) {
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(object);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}

		String result = new StringBuilder().append(callbackName).append("(").append(jsonString).append(");").toString();

		// 渲染Content-Type为javascript的返回内容,输出结果为javascript语句,
		render(response, CommonConstants.CONTENT_TYPE.JS_TYPE, result, headers);
	}

	/**
	 * 分析并设置contentType与headers.
	 */
	private static void initResponseHeader(HttpServletResponse response, final String contentType,
			final String... headers) {
		String encoding = DEFAULT_ENCODING;
		boolean noCache = DEFAULT_NOCACHE;
		for (String header : headers) {
			String headerName = StringUtils.substringBefore(header, ":");
			String headerValue = StringUtils.substringAfter(header, ":");

			if (StringUtils.equalsIgnoreCase(headerName, HEADER_ENCODING)) {
				encoding = headerValue;
			} else if (StringUtils.equalsIgnoreCase(headerName, HEADER_NOCACHE)) {
				noCache = Boolean.parseBoolean(headerValue);
			} else {
				throw new IllegalArgumentException(headerName + "不是一个合法的header类型");
			}
		}

		// 设置headers参数
		String fullContentType = contentType + ";charset=" + encoding;
		response.setContentType(fullContentType);
		if (noCache) {
			setDisableCacheHeader(response);
		}
	}

	/**
	 * 设置禁止客户端缓存的Header.
	 */
	public static void setDisableCacheHeader(HttpServletResponse response) {
		// Http 1.0 header
		response.setDateHeader("Expires", 1L);
		response.addHeader("Pragma", "no-cache");
		// Http 1.1 header
		response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
	}

	public static void renderJsonporJson(HttpServletResponse response, final String callbackName, final Object object,
			final String... headers) {
		if (callbackName != null && !callbackName.equals("")) {
			renderJsonp(response, callbackName, object, headers);
		} else {
			renderJson(response, object, headers);
		}
	}

	public static void renderJsonporJson2(HttpServletResponse response, final String callbackName, final String data,
			final String... headers) {
		if (callbackName != null && !callbackName.equals("")) {

			String result = callbackName + "(" + data + ")";
			renderText(response, result, headers);
		} else {
			renderJson(response, data, headers);
		}
	}
}
