package com.xiaosu.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**`
 * 使用装饰者模式解码post与get乱码问题
 * @author ASUS
 *
 */
public class EncodeFilter implements Filter {
	
	//1.
	private String charset;
	
	//2.
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		charset=filterConfig.getInitParameter("charset");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//8.进行post编码
		request.setCharacterEncoding(charset);	//这里没有获得值原因之一,没有配置初始参数
		//9.创建争强类
		MyRequest myRequest=new MyRequest((HttpServletRequest) request);
		//9.放行
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
	}
	
	  /* 抽象角色  HttpServletRequest
		  真实角色  HttpServletRequestWrapper 需要增强的类
		  装饰角色  MyRequest 增强类，重写要增强的方法*/
	private class MyRequest extends HttpServletRequestWrapper{
		
		//4.抽象对象
		private HttpServletRequest request;
		
		public MyRequest(HttpServletRequest request) {
			super(request);
			//5.传入真是对象
			this.request=request;
		}
		
		//6.重写getParameter方法
		@Override
		public String getParameter(String name) {
			
			//获得值
			String value = request.getParameter(name);
			
			//排除
			if (value!=null && "GET".equals(request.getMethod())) {
				try {
					//解码
					value=new String(value.getBytes("iso-8859-1"),charset);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			return value;
		}
		
	}
	
}
