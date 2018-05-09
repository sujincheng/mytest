package com.xiaosu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaosu.Service.ContactService;
import com.xiaosu.entity.Contact;

/**	 
 * 	通过id查询联系人
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
		
		//将籍贯信息放入数组中
		String [] jgs={"广东","湖南","广西", "江西"};
		request.setAttribute("jgs", jgs);
		
		//转发到更新页面显示
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}
	
}
