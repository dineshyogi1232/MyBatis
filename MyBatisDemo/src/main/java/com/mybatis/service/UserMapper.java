package com.mybatis.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.mybatis.model.User;
import com.mybatis.util.UserUtils;
import java.util.Collections;

@Repository
public class UserMapper {

	SqlSession session;

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		try {
			session = UserUtils.getSqlSessionFactory().openSession();
			return session.selectList("getAllUsers");
		} catch (Exception e) {
			System.err.println("Exception occured" + e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return Collections.emptyList();
	}

	public User getUserByID(int id) {
		try {
			session = UserUtils.getSqlSessionFactory().openSession();
			return (User) session.selectOne("getUserByID", id);
		} catch (Exception e) {
			System.err.println("In catch block" + e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	public void saveUser(User user) {
		try {
			session = UserUtils.getSqlSessionFactory().openSession();
			session.insert("insertUser", user);
			session.commit();
		} catch (Exception e) {
			System.err.println("User not saved ,Exception occured" + e);
			if (session != null) {
				session.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateUser(User user) {
		try {
			session = UserUtils.getSqlSessionFactory().openSession();
			session.update("updateUser", user);
			session.commit();
		} catch (Exception e) {
			System.err.println("User not updated ,Exception occured" + e);
			if (session != null) {
				session.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public int deleteUser(int id) {
		try {
			session = UserUtils.getSqlSessionFactory().openSession();
			session.delete("deleteUser", id);
			session.commit();
			return id;
		} catch (Exception e) {
			System.err.println("User not deleted ,Exception occured" + e);
			if (session != null) {
				session.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return 0;
	}

}