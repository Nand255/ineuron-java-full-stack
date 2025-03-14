package in.ineuron.test;

import in.ineuron.Dao.InsurancePolicyDao;
import in.ineuron.Dao.InsurancePolicyDaoImpl;

public class InsertApp {

	public static void main(String[] args) {
		
		InsurancePolicyDao daoImpl = new InsurancePolicyDaoImpl();
		String result = daoImpl.tranferPolicies(15);
		System.out.println(result);
		
	}
}
