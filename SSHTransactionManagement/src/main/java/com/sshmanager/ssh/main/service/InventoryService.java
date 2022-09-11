package com.sshmanager.ssh.main.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sshmanager.ssh.main.dto.InventoryItemDTO;

import net.sf.json.JSONArray;

public interface InventoryService {
	
	/** ǰ���ڵ�(item_code) �ߺ� �˻� 
	 *  ǰ���ڵ尡 �ߺ��̸� false, �ߺ��� �ƴϸ� true */
	public boolean checkDupItemCode(String item_code) throws Exception;
	
	/* ǰ���ڵ�(item_code)�� ���ǰ�� ���� �������� */
	public InventoryItemDTO getInventoryItemByCode(String item_code) throws Exception;
	
	/** ��� ǰ�� ���� �� ���� ����Ʈ�� �ҷ����� �޼���.
	 *  item_dx�� �ش��ϴ� ��� ǰ�� ���� �� ���� ����Ʈ�� �ҷ��´�.
	 * */
	public List<Object> getInventory(String item_idx) throws Exception;
	
	/** ��� ǰ�� ����Ʈ�� �ҷ����� �޼���
	 *  �Ű������� �Ѿ�� ��(company_idx)�� ������ where���� �˻� ���� �߰�(��ü�� �˻�)
	 *  �Ű������� ������ ��� ǰ�� ��ü �˻� */
	public List<InventoryItemDTO> getInventoryList() throws Exception;
	public List<InventoryItemDTO> getInventoryList(String company_idx) throws Exception;
	
	/* [INSERT] ��� ǰ�� ��� */
	public String insertInventroyItem(InventoryItemDTO dto) throws Exception;
	
	/* [INSERT] ��� ǰ�� ���� ���� */
	public void insertinventoryFiles(String company_idx, String item_idx
			, MultipartHttpServletRequest multipartRequest) throws Exception;
	
	/* [UPDATE] ��� ǰ�� ���� */
	public String updateInventroyItem(InventoryItemDTO dto) throws Exception;
	
	/* [INSERT/DELETE] ��� ǰ�� ���� ���� */
	public void updateinventoryFiles(String old_company_idx, String new_company_idx, String item_idx
			, MultipartHttpServletRequest multipartRequest, JSONArray existingFilejsonArray) throws Exception;
}
