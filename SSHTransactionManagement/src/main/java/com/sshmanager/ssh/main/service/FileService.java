package com.sshmanager.ssh.main.service;

import java.util.List;

import com.sshmanager.ssh.main.domain.FileType;
import com.sshmanager.ssh.main.dto.FileDTO;

public interface FileService {
	
	/* ���� �ҷ����� */
	public FileDTO getFile(String file_idx) throws Exception;
	
	/* �ش� �⵵�� �̹��� ���� ����Ʈ �ҷ����� */
	public List<FileDTO> getFileByFileType(String company_idx, FileType file_type
			, String year) throws Exception;
}
