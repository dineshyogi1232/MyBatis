package com.mybatis.util;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserUtils {

	private static SqlSessionFactory sqlSessionFactory;

	UserUtils() {
		System.out.println("Constructor");
	}

	static {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("/resource/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			System.out.println("Connection failed..." + e);
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}