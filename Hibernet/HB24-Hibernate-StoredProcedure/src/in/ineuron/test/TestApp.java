package in.ineuron.test;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_PRODUCT_BY_NAME`()
BEGIN
		select pid,pname,price,qty from product where pname IN (name1,name2);
END
*/

public class TestApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			String product1 = "omegha";
			String product2 = "titan";
			
			//creating a procedure call object
			ProcedureCall procedureCall = session.createStoredProcedureCall("P_GET_PRODUCT_BY_NAME",Product.class);
			
			//binding input parameter value for procedure call object
			procedureCall.registerParameter(1, String.class, ParameterMode.IN).bindValue(product1);
			procedureCall.registerParameter(2, String.class, ParameterMode.IN).bindValue(product2);
			
			//Executing the stored procedure to get the result
			List<Product> products = procedureCall.getResultList();
			
			// processing the result
			products.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
