package com.sshmanager.ssh.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sshmanager.ssh.main.dto.InventoryItemDTO;
import com.sshmanager.ssh.main.service.InventoryService;

@Controller
@RequestMapping("/inventory")
public class InventoryManagementController {
	
	@Autowired
	InventoryService inventoryService;
	
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
	
	/* ��� ����Ʈ �ҷ����� (jsGrid) */
	@RequestMapping("/inventory-item-list")
	@ResponseBody
	public List<InventoryItemDTO> getInventoryItemList() throws Exception {
		return inventoryService.getInventoryList();
	}
	
	
}
