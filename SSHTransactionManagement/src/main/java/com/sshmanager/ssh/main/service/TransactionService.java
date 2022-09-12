package com.sshmanager.ssh.main.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sshmanager.ssh.main.dto.FileDTO;
import com.sshmanager.ssh.main.dto.ItemDTO;
import com.sshmanager.ssh.main.dto.MemoDTO;
import com.sshmanager.ssh.main.dto.TotalPriceDTO;
import com.sshmanager.ssh.main.dto.TransactionDTO;

import net.sf.json.JSONArray;

public interface TransactionService {
	
	/* �ŷ� ��� �ҷ����� */
	public List<TransactionDTO> getTransactionList(String company_name) throws Exception;
	
	/* �ŷ� ���� �ҷ����� */
	public TransactionDTO getTransaction(String transaction_idx) throws Exception;
	
	/* �ŷ� ���� - �� ���� ���� �ҷ����� */
	public TotalPriceDTO getTotalPrice(String transaction_idx) throws Exception;
	
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
	
	/* INSERT - ���Ͼ��ε� */
	public void insesrtTransactionFiles(String date, String company_idx, String transaction_idx
			, MultipartHttpServletRequest multipartRequest) throws Exception;
	
	/* �ߺ��� ������ �̸��� ����*/
	public String replaceDuplicateFileName(String path, String storedFileName);
	
	/* ���ϸ� �տ� ��¥ �ٿ��ִ� �޼��� */
	public String prependDateToFileName(String fileName, String date);
	
	/* UPDATE - �ŷ� ���� */
	public void updateTransaction(TransactionDTO transactionDTO) throws Exception;
	
	/* UPDATE - ������+�޸� ���� */
	public boolean updateTransactionDetails(String transaction_idx
			, JSONArray itemJsonArray, JSONArray memoJsonArray);
	
	/* UPDATE - ���� ���� */
	public void updateTransactionFiles(String date, String company_idx, String transaction_idx
			, MultipartHttpServletRequest multipartRequest, JSONArray existingFilejsonArray) throws Exception;
	
	/* �ŷ� ���� ���� - transaction_idx�� �ش��ϴ� item, memo, file ��� ���� */
	public void deleteTransaction(String transaction_idx) throws Exception;
}
