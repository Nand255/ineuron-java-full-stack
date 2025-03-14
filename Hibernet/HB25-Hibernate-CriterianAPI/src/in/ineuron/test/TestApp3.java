package in.ineuron.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.mysql.cj.x.protobuf.MysqlxCrud.Projection;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp3 {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			
			Criteria criteria = session.createCriteria(Product.class); // HQL=>from in.ineuron.model.Product
			
			ProjectionList list = Projections.projectionList();
			list.add(Projections.property("pname"));
			list.add(Projections.property("qty"));
			
			criteria.setProjection(list); // select pname,qty from in.ineuron.model.Product
			
			Criterion cond1 = Restrictions.between("price", 10000, 45000);
			Criterion cond2 = Restrictions.in("pname", "fossil", "titan", "casio", "hmt");
			Criterion cond3 = Restrictions.ilike("pname", "f%");
			
			LogicalExpression finalCondition = Restrictions.or(Restrictions.and(cond1,cond2),cond3);
			
			criteria.add(finalCondition);
			
			Order order = Order.asc("pname");
			criteria.addOrder(order); 
		
			
			List<Object[]> products = criteria.list();
			System.out.println("pname\tqty");
			products.forEach(row->{
				for(Object obj : row) {
					System.out.print(obj+"\t");
				}
				System.out.println();
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
