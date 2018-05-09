package com.xiaosu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaosu.Service.ContactService;
import com.xiaosu.entity.Contact;

/**	 
 * 	ͨ��id��ѯ��ϵ��
 * @author ASUS
 *
 */
public class QueryContactServlet extends HttpServlet {
	
	private ContactService contactService= new ContactService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		Contact contact = contactService.findById(id);
		
		request.setAttribute("contact", contact);
		System.out.println(contact);
		
		//��������Ϣ����������
		String [] jgs={"�㶫","����","����", "����"};
		request.setAttribute("jgs", jgs);
		
		//ת��������ҳ����ʾ
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}
	
}
