package com.sshmanager.ssh.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sshmanager.ssh.main.dao.CompanyDAO;
import com.sshmanager.ssh.main.dto.CompanyDTO;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyDAO companyDAO;
	
	public boolean checkDupCompanyName(String company_name) throws Exception {
		
		if(companyDAO.checkDupCompanyName(company_name) != 0) {
			// ��ü���� �ߺ��̸� false
			return false;
		}
		// ��ü���� �ߺ����� ������ true
		return true;
	}
	
	
	public void insertCompany(CompanyDTO dto) throws Exception {
		companyDAO.insertCompany(dto);
	}
}
