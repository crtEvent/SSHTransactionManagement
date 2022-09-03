package com.sshmanager.ssh.main.service;

import com.sshmanager.ssh.main.dto.CompanyDTO;

public interface CompanyService {
	
	/* ��ü ���� �ҷ����� */
	public CompanyDTO getCompany(String company_idx) throws Exception;
	
	/* ��ü�� �ߺ� üũ */
	public boolean checkDupCompanyName(String company_name) throws Exception;
	
	/* ��ü ��� */
	public void insertCompany(CompanyDTO dto) throws Exception;
	
	/* ��ü ���� ���� */
	public boolean updateCompany(CompanyDTO dto) throws Exception;
}
