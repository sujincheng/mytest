package com.xiaosu.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ����Դ������
 * @author NewBoy
 *
 */
public class DataSourceUtils {
	private static DataSource ds = new ComboPooledDataSource();

	/**
	 * ��ȡ���ӳ�
	 * @return
	 */
	public static DataSource getDataSource() {
		return ds;
	}

	/**
	 * ��ȡ����
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}