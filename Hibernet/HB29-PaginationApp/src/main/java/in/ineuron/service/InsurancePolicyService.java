package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.InsurancePolicyDTO;

public interface InsurancePolicyService {
	public Long fetchPageCount(int pageSize);
	public List<InsurancePolicyDTO> fetchPageData(int pageSize, int pageNo);
}
