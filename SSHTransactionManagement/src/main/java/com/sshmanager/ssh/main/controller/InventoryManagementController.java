package com.sshmanager.ssh.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sshmanager.ssh.main.dto.CompanyDTO;
import com.sshmanager.ssh.main.dto.InventoryItemDTO;
import com.sshmanager.ssh.main.service.CompanyService;
import com.sshmanager.ssh.main.service.InventoryService;

@Controller
@RequestMapping("/inventory")
public class InventoryManagementController {
	
	@Autowired
	InventoryService inventoryService;
	
	@Autowired
	CompanyService companyService;
	
	/* ��� ���� ������ */
	@PostMapping("/inventory-management")
	public String getInventoryManagement() throws Exception {
		
		return "redirect:/inventory/inventory-management-result";
	}
	
	/* ��� ���� ������ - ��� */
	@GetMapping("/inventory-management-result")
	public String getInventoryManagementResult() throws Exception {
		
		return "/main/inventory_management";
	}
	
	/* ��� ����Ʈ �ҷ����� (jsGrid) - �Ű�����(company_idx)�� ���� ���*/
	/* ��ü�� ��� ����Ʈ �ҷ����� (jsGrid) - �Ű�����(company_idx)�� �ִ� ��� */
	@RequestMapping("/inventory-item-list")
	@ResponseBody
	public List<InventoryItemDTO> getInventoryItemList(String company_idx) throws Exception {
		
		if(company_idx.equals("") || company_idx.equals("undefined")) company_idx = null;
		
		return inventoryService.getInventoryList(company_idx);
	}
	
	/* ��ü�� ��� ����Ʈ ���� */
	@PostMapping("/inventory-list-by-company")
	public String getInventoryListByCompany(RedirectAttributes ridirectAttr, String company_idx) throws Exception {
		
		ridirectAttr.addAttribute("company_idx", company_idx);
		
		return "redirect:/inventory/inventory-list-by-company-result";
	}
	
	/* ��ü�� ��� ����Ʈ ���� - ��� */
	@GetMapping("/inventory-list-by-company-result")
	public String getInventoryListByCompanyResult(Model model, String company_idx) throws Exception {
		
		model.addAttribute("inventoryList", inventoryService.getInventoryList(company_idx));
		
		return "/main/inventory_list";
	}
	
	/* ������ �ڵ� �ߺ� �˻� */
	@RequestMapping("/check-code")
	@ResponseBody
	public boolean checkItemCode(String item_code) throws Exception {
		System.out.println("checkItemCode: "+inventoryService.checkDupItemCode(item_code));
		// item_code�� �ߺ��̸� false, �ߺ��� �ƴϸ� true
		return inventoryService.checkDupItemCode(item_code);
	}
	
	/* ��ü�� �ҷ����� */
	@RequestMapping(value="/get-company-name", produces = "application/text; charset=utf8")
	@ResponseBody
	public String getCompanyName(String company_idx) throws Exception {
		
		CompanyDTO dto = companyService.getCompany(company_idx);
		
		if(dto == null) {
			return null;
		}
		
		return dto.getCompany_name();
	}
	
	/* ��� ǰ�� ��� */
	@RequestMapping("/insert-inventory-item")
	@ResponseBody
	public boolean insertInventory(InventoryItemDTO dto) throws Exception {
		
		inventoryService.insertInventroyItem(dto);
		
		return true;
	}
	
}
