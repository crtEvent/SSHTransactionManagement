package com.sshmanager.ssh.main.service;

import java.util.List;

import com.sshmanager.ssh.main.dto.InventoryItemDTO;

public interface InventoryService {
	
	/** ǰ���ڵ�(item_code) �ߺ� �˻� 
	 *  ǰ���ڵ尡 �ߺ��̸� false, �ߺ��� �ƴϸ� true */
	public boolean checkDupItemCode(String item_code) throws Exception;
	
	/** ��� ǰ�� ����Ʈ�� �ҷ����� �޼���
	 *  �Ű������� �Ѿ�� ��(company_idx)�� ������ where���� �˻� ���� �߰�(��ü�� �˻�)
	 *  �Ű������� ������ ��� ǰ�� ��ü �˻� */
	public List<InventoryItemDTO> getInventoryList() throws Exception;
	public List<InventoryItemDTO> getInventoryList(String company_idx) throws Exception;
}
