package in.ineuron.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.mysql.cj.x.protobuf.MysqlxCrud.Projection;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp2 {

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
			
			Criterion cond1 = Restrictions.ge("price", 10000);
			Criterion cond2 = Restrictions.le("price", 45000);
			
			criteria.add(cond1);
			criteria.add(cond2); // HQL =>select pname,qty from in.ineuron.model.Product where price>=10000 and price<=25000 
			
			Order order = Order.asc("pname");
			criteria.addOrder(order); 
			
			// HQL => select pname,qty from in.ineuron.model.Product where price>=10000 and price<=25000 orderby asc(pname)
			
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
