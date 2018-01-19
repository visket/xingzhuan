package com.kedu.xingzhuan.framework.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.kedu.xingzhuan.utils.CommonConstants;


public class EncodingFilter extends OncePerRequestFilter {

	private String encoding;

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		super.doFilter(request, response, filterChain);
		
		//System.out.println("=============中文处理===================");
		// 设置请求响应字符编码
		/*HttpServletRequest req = request;
		//String tempencode = request.getCharacterEncoding();
		String tempmethod = request.getMethod();
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		if(CommonConstants.ENCODE.GET.equals(tempmethod)){
			// 传递给目标servlet或jsp的实际上时包装器对象的引用，而不是原始的HttpServletRequest对象
			req = new GetHttpServletRequestWrapper(request, encoding);
		}
		filterChain.doFilter(req, response);*/
	}

	class GetHttpServletRequestWrapper extends HttpServletRequestWrapper {
		private String charset = CommonConstants.ENCODE.UTF_8;

		public GetHttpServletRequestWrapper(HttpServletRequest request) {
			super(request);
		}

		/**
		 * 获得被装饰对象的引用和采用的字符编码
		 * @param request
		 * @param charset
		 */
		public GetHttpServletRequestWrapper(HttpServletRequest request, String charset) {
			super(request);
			this.charset = charset;
		}

		/**
		 * 获取单个参数也复写
		 */
		public String getParameter(String name) {
			String value = super.getParameter(name);
			try {
				if (value != null) {
					value = new String(value.getBytes(CommonConstants.ENCODE.ISO_8859_1), charset);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return value;
		}

		/*
		 * Spring MVC方法参数自动注入调用的是这个方法 {@link RequestParamMethodArgumentResolver}
		 */
		public String[] getParameterValues(String name) {
			String[] values = super.getParameterValues(name);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					try {
						values[i] = new String(values[i].getBytes(CommonConstants.ENCODE.ISO_8859_1), charset);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
			return values;
		}
	}
}
