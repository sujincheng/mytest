package com.xiaosu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.xiaosu.Service.ContactService;
import com.xiaosu.entity.Contact;

/**	添加联系人
 * @author ASUS
 *
 */
public class addContactServlet extends HttpServlet {
	
	private ContactService contactService = new ContactService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String, String[]> map = request.getParameterMap();
		
		//封装成JavaBean
		Contact contact=new Contact();
		try {
			BeanUtils.populate(contact, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(contact);
		//调用业务层
		contactService.addContact(contact);
		//重定向到显示所有联系人的页面，到Servlet中
		response.sendRedirect(request.getContextPath()+"/list");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
