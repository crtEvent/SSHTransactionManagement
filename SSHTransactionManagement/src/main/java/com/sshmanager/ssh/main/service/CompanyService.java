package com.sshmanager.ssh.main.service;

import com.sshmanager.ssh.main.dto.CompanyDTO;

public interface CompanyService {
	
	/* ��ü�� �ߺ� üũ */
	public boolean checkDupCompanyName(String company_name) throws Exception;
	
	/* ��ü ��� */
	public void insertCompany(CompanyDTO dto) throws Exception;
	
}
