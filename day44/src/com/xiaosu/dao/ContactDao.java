package com.xiaosu.dao;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xiaosu.entity.Contact;
import com.xiaosu.utils.DataSourceUtils;

public class ContactDao {
	
	private QueryRunner runner= new QueryRunner(DataSourceUtils.getDataSource());
	
	/*
	 * 查询所有联系人
	 * */
	public List<Contact> fillAll(){
		try {
			return runner.query("select * from contact", new BeanListHandler<Contact>(Contact.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 添加联系人
	 * */
	public int save(Contact contact){
		try {
			return runner.update("insert into Contact values(uuid(),?,?,?,?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 查询一个联系人
	 * */
	public Contact findById(String id){
		try {
			return runner.query("select * from Contact where name=?", new BeanHandler<Contact>(Contact.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 更新联系人
	 * */
	public int update(Contact contact){
		try {
			return runner.update("update Contact set name=?,set genter=?,set age=? , set jiguan=? set qq=? , set email=? where id=?",
					contact.getName(),contact.getGender(),contact.getAge(),contact.getJiguan(),
					contact.getQq(),contact.getEmail(),contact.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
