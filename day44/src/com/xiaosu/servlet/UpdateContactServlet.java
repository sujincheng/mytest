package com.xiaosu.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.xiaosu.Service.ContactService;
import com.xiaosu.entity.Contact;

public class UpdateContactServlet extends HttpServlet {
	
	private ContactService contactService = new ContactService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String, String[]> map = request.getParameterMap();
		
		Contact contact=new Contact();
		try {
			BeanUtils.populate(contact, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//调用业务层更新的方法
		//重定向到查询所有联系人页面
		contactService.update(contact);
		response.sendRedirect(request.getMethod()+"/list");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		super.doPost(request, response);
	}
}
