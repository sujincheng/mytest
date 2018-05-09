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
 * ʹ��װ����ģʽ����post��get��������
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
		//8.����post����
		request.setCharacterEncoding(charset);	//����û�л��ֵԭ��֮һ,û�����ó�ʼ����
		//9.������ǿ��
		MyRequest myRequest=new MyRequest((HttpServletRequest) request);
		//9.����
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
	}
	
	  /* �����ɫ  HttpServletRequest
		  ��ʵ��ɫ  HttpServletRequestWrapper ��Ҫ��ǿ����
		  װ�ν�ɫ  MyRequest ��ǿ�࣬��дҪ��ǿ�ķ���*/
	private class MyRequest extends HttpServletRequestWrapper{
		
		//4.�������
		private HttpServletRequest request;
		
		public MyRequest(HttpServletRequest request) {
			super(request);
			//5.�������Ƕ���
			this.request=request;
		}
		
		//6.��дgetParameter����
		@Override
		public String getParameter(String name) {
			
			//���ֵ
			String value = request.getParameter(name);
			
			//�ų�
			if (value!=null && "GET".equals(request.getMethod())) {
				try {
					//����
					value=new String(value.getBytes("iso-8859-1"),charset);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			return value;
		}
		
	}
	
}
