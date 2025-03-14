package in.ineuron.service;

import in.ineuron.bo.CustomerBO;
import in.ineuron.dao.ICustomerDAO;
import in.ineuron.dto.CustomerDTO;

public class CustomerMgmtSeviceImpl implements ICustomerMgmtService {

	private ICustomerDAO dao;
	
	public CustomerMgmtSeviceImpl(ICustomerDAO dao) {
		this.dao = dao;
		System.out.println("CustomerMgmtSeviceImpl :: 1 param constructor --->"+dao.getClass().getName());
	}

	@Override
	public String calcuteSimpleInterest(CustomerDTO dto) throws Exception {
		
		float intrAmount = (dto.getPamt() * dto.getRate() * dto.getTime())/100.0f;
		
		CustomerBO customerBo = new CustomerBO();
		customerBo.setCustomerName(dto.getCustomerName());
		customerBo.setCustomerAddress(dto.getCustomerAddress());
		customerBo.setPamt(dto.getPamt());
		customerBo.setRate(dto.getRate());
		customerBo.setTime(dto.getTime());
		customerBo.setIntrAmount(intrAmount);
											
		int count = dao.save(customerBo);
		
		return count==0?"customer registration failed" : "customer registration succesfull --->SimpleInterestAmount:: " + intrAmount;
	}
}
