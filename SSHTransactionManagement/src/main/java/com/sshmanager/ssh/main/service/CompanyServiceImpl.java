package com.sshmanager.ssh.main.service;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sshmanager.ssh.main.dao.CompanyDAO;
import com.sshmanager.ssh.main.dao.InventoryDAO;
import com.sshmanager.ssh.main.dao.InventoryFileDAO;
import com.sshmanager.ssh.main.dao.PathDAO;
import com.sshmanager.ssh.main.dao.TransactionDAO;
import com.sshmanager.ssh.main.dto.CompanyDTO;
import com.sshmanager.ssh.main.dto.FileDTO;
import com.sshmanager.ssh.main.dto.InventoryItemDTO;
import com.sshmanager.ssh.main.dto.TransactionDTO;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired
	private TransactionDAO transactionDAO;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private InventoryDAO inventoryDAO;
	
	@Autowired
	private InventoryFileDAO inventoryFileDAO;
	
	@Autowired
	private PathDAO pathDAO;
	
	public CompanyDTO getCompany(String company_idx) throws Exception {
		return companyDAO.selectCompany(company_idx);
	}
	
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
	
	public boolean updateCompany(CompanyDTO dto) {
		
		try {
			
			if(dto.getCompany_name().equals("") || dto.getCompany_name() == null) {
				throw new Exception("company_name���� null�̰ų� ���ڿ��Դϴ�.");
			}
			
			// ���� ��ü ���� �ҷ�����
			CompanyDTO oldDto = companyDAO.selectCompany(dto.getCompany_idx());
			String oldName = oldDto.getCompany_name();
			
			// ��ü ���� update
			companyDAO.updateCompany(dto);
			
			// ��ü ������ ����
			renameCompnanyFolder(dto.getCompany_idx(), oldName, dto.getCompany_name());

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
			
		return true;
	}
	
	public void renameCompnanyFolder(String company_idx, String oldName, String newName) throws Exception {
		
		String file_root = pathDAO.selectFileRootPath();
		
		if(!oldName.equals(newName)) {
			// ��ü���� ����� ��쿡�� ������ ����
			File oldFile = new File(file_root+File.separator+oldName+"["+company_idx+"]");
			File newFile = new File(file_root+File.separator+newName+"["+company_idx+"]");
			
			if(!oldFile.exists()) {
				oldFile.mkdirs();
			}
			
			FileUtils.moveDirectory(oldFile, newFile);
		}
	}
	
	/* ��ü ���� - �ŷ� ����(ǰ��, �޸�, ����, ���� ǰ��)���� ��� ���� */
	@Transactional(rollbackFor = Exception.class)
	public void deleteCompany(String company_idx) throws Exception {
		
		// company_idx�� �ش��ϴ� �ŷ� list ����
		String transaction_idx;
		List<TransactionDTO> tList = transactionDAO.selectTransactionList(company_idx);
		 
		for(int i = 0; i < tList.size(); i++) {
			transaction_idx = tList.get(i).getTransaction_idx();
			transactionService.deleteTransaction(transaction_idx);

		}
		
		// company_idx�� �ش��ϴ� ��� ǰ�� list ����
		String item_idx;
		List<InventoryItemDTO> iList = inventoryService.getInventoryList(company_idx);
		
		for(int i = 0; i < iList.size(); i++) {
			item_idx = iList.get(i).getItem_idx();
			inventoryService.deleteInventoryItem(item_idx);
		}
		
		// company ����
		companyDAO.deleteCompany(company_idx);
		
	}
}
