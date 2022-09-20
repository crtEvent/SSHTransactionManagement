package com.sshmanager.ssh.user.service;

import com.sshmanager.ssh.user.dto.UserDTO;

public interface UserService {
	
	/* ���޵� id�� ���� ������ �����ϴ��� Ȯ�� */
	public boolean checkUserExist(String user_id) throws Exception;
	
	/* id, password�� ��ġ�ϴ� �������� �ҷ����� */
	public UserDTO getUser(String user_id, String user_password) throws Exception;

}
