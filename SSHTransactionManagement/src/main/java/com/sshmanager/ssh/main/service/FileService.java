package com.sshmanager.ssh.main.service;

import com.sshmanager.ssh.main.domain.FileType;
import com.sshmanager.ssh.main.dto.FileDTO;

public interface FileService {
	
	/* ���� �ҷ����� */
	public FileDTO getFile(String file_idx) throws Exception;

}
