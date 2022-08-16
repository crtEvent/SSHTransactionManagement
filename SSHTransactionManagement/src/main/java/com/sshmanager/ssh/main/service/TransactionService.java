package com.sshmanager.ssh.main.service;

import java.util.List;
import java.util.Map;

import com.sshmanager.ssh.main.dto.FileDTO;
import com.sshmanager.ssh.main.dto.ItemDTO;
import com.sshmanager.ssh.main.dto.TransactionDTO;

public interface TransactionService {
	
	/* �ŷ� ��� �ҷ����� */
	public List<TransactionDTO> getTransactionList(String company_name) throws Exception;
	
	/* �ŷ� ���� �ҷ����� */
	public TransactionDTO getTransaction(String transaction_idx) throws Exception;
	
	/* ������ ��� �ҷ����� */
	public List<ItemDTO> getItemList(String transaction_idx) throws Exception;
	
	/* ���� ��� �ҷ����� */
	public List<FileDTO> getFileList(String transaction_idx) throws Exception;
	
}
