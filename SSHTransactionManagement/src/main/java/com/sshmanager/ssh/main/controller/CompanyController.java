package com.sshmanager.ssh.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sshmanager.ssh.main.dto.CompanyDTO;
import com.sshmanager.ssh.main.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	/* ��ü ��� */
	@PostMapping("/insert")
	public String insert(CompanyDTO dto, HttpServletRequest request) throws Exception {
		
		companyService.insertCompany(dto);
		
		// ���� ������ URL
		String referer = request.getHeader("Referer");
		
		return "redirect:"+referer;
	}
	
	/* ��ü�� �ߺ�üũ */
	@RequestMapping("/check-company-name")
	@ResponseBody
	public boolean checkCompanyName(String company_name) throws Exception {
		
		// ��ü���� �ߺ��̸� false, ��ü���� �ߺ����� ������ true
		return companyService.checkDupCompanyName(company_name)? true:false;
	}
}
