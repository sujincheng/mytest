package com.xiaosu.Service;

import java.util.List;

import com.xiaosu.dao.ContactDao;
import com.xiaosu.entity.Contact;

public class ContactService {
	
	private ContactDao contactDao = new ContactDao();
	
	//��ѯ��������
	public List<Contact> fillAll(){
		return contactDao.fillAll();
	}
	
	//�������
	public int addContact(Contact contact){
		return contactDao.save(contact);
	}
	
	//ͨ��id��һ����¼
	public Contact findById(String id){
		return contactDao.findById(id);
	}
	
	//��������
	public int update(Contact contact){
		return contactDao.update(contact);
	}
	
	
}
