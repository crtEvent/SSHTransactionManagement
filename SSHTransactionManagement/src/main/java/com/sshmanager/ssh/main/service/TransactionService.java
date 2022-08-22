package com.sshmanager.ssh.main.service;

import java.util.List;

import com.sshmanager.ssh.main.dto.FileDTO;
import com.sshmanager.ssh.main.dto.ItemDTO;
import com.sshmanager.ssh.main.dto.MemoDTO;
import com.sshmanager.ssh.main.dto.TransactionDTO;

import net.sf.json.JSONArray;

public interface TransactionService {
	
	/* �ŷ� ��� �ҷ����� */
	public List<TransactionDTO> getTransactionList(String company_name) throws Exception;
	
	/* �ŷ� ���� �ҷ����� */
	public TransactionDTO getTransaction(String transaction_idx) throws Exception;
	
	/* ������ ��� �ҷ����� */
	public List<ItemDTO> getItemList(String transaction_idx) throws Exception;
	
	/* �޸� ��� �ҷ����� */
	public List<MemoDTO> getMemoList(String transaction_idx) throws Exception;
	
	/* ������ ���� ��� �ҷ����� */
	public List<FileDTO> getQuoteFileList(String transaction_idx) throws Exception;
	
	/* ���ü� ���� ��� �ҷ����� */
	public List<FileDTO> getOrderFileList(String transaction_idx) throws Exception;
	
	/* �̹��� ���� ��� �ҷ����� */
	public List<FileDTO> getImageFileList(String transaction_idx) throws Exception;
	
	/* ��Ÿ ���� ��� �ҷ����� */
	public List<FileDTO> getOtherFileList(String transaction_idx) throws Exception;
	
	/* INSERT  - �ŷ� �Է� */
	public String insertTransaction(TransactionDTO dto) throws Exception;
	
	/* INSERT  - ������ �Է� */
	public boolean insertItem(ItemDTO dto);
	
	/* INSERT  - ������ ����Ʈ �Է� */
	public boolean insertItemList(String transaction_idx, JSONArray jsonArray);
	
	/* INSERT - �޸� �Է� */
	public boolean insertMemo(MemoDTO dto);
	
	/* INSERT  - �޸� ����Ʈ �Է� */
	public boolean insertMemoList(String transaction_idx, JSONArray jsonArray);
	
	/* INSERT - ������ ���� �Է� */
	public boolean insertQuoteFile(FileDTO dto);
	
	/* INSERT - ���ü� ���� �Է� */
	public boolean insertOrderFile(FileDTO dto);
	
	/* INSERT - �̹��� ���� �Է� */
	public boolean insertImageFile(FileDTO dto);
	
	/* INSERT - ��Ÿ���� �Է� */
	public boolean insertOtherFile(FileDTO dto);
	
	/* INSERT - ������+�޸� �Է� */
	public boolean insertTransactionDetails(String transaction_idx
			, JSONArray itemJsonArray, JSONArray memoJsonArray);
}
