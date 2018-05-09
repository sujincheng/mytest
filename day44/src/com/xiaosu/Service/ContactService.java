package com.xiaosu.Service;

import java.util.List;

import com.xiaosu.dao.ContactDao;
import com.xiaosu.entity.Contact;

public class ContactService {
	
	private ContactDao contactDao = new ContactDao();
	
	//查询所有数据
	public List<Contact> fillAll(){
		return contactDao.fillAll();
	}
	
	//添加数据
	public int addContact(Contact contact){
		return contactDao.save(contact);
	}
	
	//通过id查一条记录
	public Contact findById(String id){
		return contactDao.findById(id);
	}
	
	//更新数据
	public int update(Contact contact){
		return contactDao.update(contact);
	}
	
	
}
