package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import in.ineuron.dao.InsurancePolicyDao;
import in.ineuron.dao.InsurancePolicyDaoImpl;
import in.ineuron.dto.InsurancePolicyDTO;
import in.ineuron.model.InsurancePolicy;

public class InsurancePolicyServiceImpl implements InsurancePolicyService {
	
	InsurancePolicyDao dao;
	
	public InsurancePolicyServiceImpl() {
		dao = new InsurancePolicyDaoImpl();
	}
	
	
	@Override
	public Long fetchPageCount(int pageSize) {
		Long totalRecords = dao.getTotalRecordsCount();
		Long pagesCont = totalRecords/pageSize;
		if (totalRecords%pageSize != 0) {
			pagesCont++;
		}
		return pagesCont;
	}

	@Override
	public List<InsurancePolicyDTO> fetchPageData(int pageSize, int pageNo) {
		int startPos = 0;
		startPos = (pageNo * pageSize) - pageSize;
		
		List<InsurancePolicyDTO> list = new ArrayList<InsurancePolicyDTO>();
		List<InsurancePolicy> entities = dao.getPageData(pageSize, startPos);
		
		entities.forEach(entity->{
			InsurancePolicyDTO dto = new InsurancePolicyDTO();
			dto.setPid(entity.getPid());
			dto.setPname(entity.getPname());
			dto.setCompny(entity.getCompny());
			dto.setPtype(entity.getPtype());
			dto.setTenure(entity.getTenure());
			list.add(dto);
		});
		
		return list;
	}

}
