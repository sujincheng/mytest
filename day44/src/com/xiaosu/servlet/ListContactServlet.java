package com.xiaosu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaosu.Service.ContactService;
import com.xiaosu.entity.Contact;

/**	��ʾ������ϵ��
 * @author ASUS
 *
 */
public class ListContactServlet extends HttpServlet {
	
	private ContactService contactService = new ContactService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Contact> contacts = contactService.fillAll();
		
		request.setAttribute("contacts", contacts);
		//Ϊ�����ظ�����,��ɾ��ʹ���ض���,��ʹ��ת��:
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
