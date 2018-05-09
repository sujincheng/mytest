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

/**	�����ϵ��
 * @author ASUS
 *
 */
public class addContactServlet extends HttpServlet {
	
	private ContactService contactService = new ContactService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String, String[]> map = request.getParameterMap();
		
		//��װ��JavaBean
		Contact contact=new Contact();
		try {
			BeanUtils.populate(contact, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(contact);
		//����ҵ���
		contactService.addContact(contact);
		//�ض�����ʾ������ϵ�˵�ҳ�棬��Servlet��
		response.sendRedirect(request.getContextPath()+"/list");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
