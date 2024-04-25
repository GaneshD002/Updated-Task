package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.config.HBUtils;
import com.model.Employee;

public class EmployeeDao {

		private Session session = HBUtils.sf.openSession();
		private Transaction tx = session.beginTransaction();
		
		public int insertEmployee(Employee e1)
		{
			int check = (int) session.save(e1);
			tx.commit();
			session.close();
			return check;
		}
		
		public int deleteEmployeeByEid(int eid)
		{
			int check = session.createQuery("delete from Employee where eid=:a")
					.setParameter("a", eid)
					.executeUpdate();
			tx.commit();
			session.close();
			return check;
		}
		
		public Employee findByEid(int eid)
		{
			return session.get(Employee.class, eid);
		}
		
		public void updateEmployee(Employee e)
		{
			session.saveOrUpdate(e);
			tx.commit();
			session.close();
		}
}
