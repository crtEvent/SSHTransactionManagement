package com.sshmanager.ssh.user.service;

import java.util.List;

import com.sshmanager.ssh.user.dto.UserDTO;

public interface UserService {
	
	/* ���޵� id�� ���� ������ �����ϴ��� Ȯ�� */
	public boolean checkUserExist(String user_id) throws Exception;
	
	/* id, password�� ��ġ�ϴ� �������� �ҷ����� */
	public UserDTO getUser(String user_id, String user_password) throws Exception;
	
	/* ���� ����Ʈ �ҷ����� */
	public List<UserDTO> getUserList() throws Exception;
	
	/* ���� ��� */
	public void insertUser(UserDTO dto) throws Exception;
	
	/* ���� ���� */
	public void updateUser(UserDTO dto) throws Exception;
	
	/* ���� ���� */
	public void deleteUser(String user_idx) throws Exception;
}
