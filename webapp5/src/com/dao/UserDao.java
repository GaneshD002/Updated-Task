package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.config.HBUtils;
import com.model.User;

public class UserDao {

		private Session session = HBUtils.sf.openSession();
		private Transaction tx = session.beginTransaction();
		
		public int insertUser(User u1)
		{
			int check = (int) session.save(u1);
			tx.commit();
			session.close();
			return check;
		}

		public User getUserByEmail(String email) {
	        try {
	            // Create HQL query to retrieve user by email
	            String hql = "FROM User WHERE uemail = :email";
	            Query<User> query = session.createQuery(hql);
	            query.setParameter("email", email);
	            // Execute query and get the result
	            return query.uniqueResult();
	        } finally {
	            session.close();
	        }
	    }
}

