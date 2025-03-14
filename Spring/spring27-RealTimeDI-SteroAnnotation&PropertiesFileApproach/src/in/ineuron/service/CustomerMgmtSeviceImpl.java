package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CustomerBO;
import in.ineuron.dao.ICustomerDAO;
import in.ineuron.dto.CustomerDTO;

@Service(value="service")
public class CustomerMgmtSeviceImpl implements ICustomerMgmtService {

	static {
		System.out.println("CustomerMgmtSeviceImpl.class file is loading...");
	}
	
	public CustomerMgmtSeviceImpl() {
		System.out.println("CustomerMgmtSeviceImpl :: zero param constructor");
	}
	
	@Autowired
	private ICustomerDAO dao;

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
