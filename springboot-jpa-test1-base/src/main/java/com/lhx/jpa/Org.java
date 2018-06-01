package com.lhx.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Org {
	public void createMethod() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();// 开始事务
		manager.persist(new Object());
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

	// 立即加载
	public void getMethod() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("");
		EntityManager manager = factory.createEntityManager();
		Object object = manager.find(Object.class, 1);
		System.out.println(object);// 如果Object是null，没有异常打印null
		manager.close();
		factory.close();
	}

	// 延迟加载
	public void getMethod2() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("");
		EntityManager manager = factory.createEntityManager();
		// 延迟加载，不立即返回，返回一个代理对象，只有读取对象具体属性时，才返回具体对象
		Object object = manager.getReference(Object.class, 1);
		// 如果数据库没有object,在读取属性是出现异常
		// object.getName();
		manager.close();
		// 关闭后再读取有问题
		// object.getName();
		factory.close();
	}

	public void updateMethod() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();// 开始事务
		Object object = manager.find(Object.class, 1);
		// object,setName("测试");
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		// 四种 实体状态：new新建状态；
		// managed托管状态，能够被更新【托管状态，被事务管理】，放到jdbc批处理中，commit之后开始提交；游离状态【托管】；删除状态
	}

	public void updateMethod2() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();// 开始事务
		Object object = manager.find(Object.class, 1);
		manager.clear();// 把实体管理器中的所有实体变成游离状态，此时提交;不会被更新，需要做以下处理
		// object,setName("测试");
		manager.merge(object);// 把实体放入实体管理器中，再次提交可以被更新
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		// 四种 实体状态：new新建状态；
		// managed托管状态，能够被更新【托管状态，被事务管理】，放到jdbc批处理中，commit之后开始提交；游离状态【托管】；删除状态
	}

	public void deleteMethod() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();// 开始事务
		Object object = manager.find(Object.class, 1);
		manager.remove(object);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

	public void sqlQueryMethod() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("");
		EntityManager manager = factory.createEntityManager();
		// 面向对象查询语句
		// 位置参数
		Query query = manager.createQuery("selet o from Person o where o.id=?1");
		query.setParameter(1, 222);
		// 类型参数
		// Query query2 = manager.createQuery("selet o from Person o where o.id=:id");
		// query2.setParameter("id", 222);

		List resultList = query.getResultList();

		// 如果只有一个值
		// query.getSingleResult();
		manager.close();
		factory.close();
	}

	public void sqlDeleteMethod() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();// 开始事务
		// 面向对象查询语句
		// 位置参数
		Query query = manager.createQuery("delete from Person o where o.id=?1");
		query.setParameter(1, 222);
		query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

	public void sqlUpdateMethod() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();// 开始事务
		// 面向对象查询语句
		// 位置参数
		Query query = manager.createQuery("update Person 0 set o.name=:name where  o.id=:id");
		query.setParameter("name", "zahangsan");
		query.setParameter("id", 11);
		query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
