package com.sshmanager.ssh.main.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sshmanager.ssh.main.dao.PathDAO;
import com.sshmanager.ssh.user.dto.UserDTO;
import com.sshmanager.ssh.user.service.UserService;

@Controller
@RequestMapping("/setting")
public class SettingController {

	@Autowired
	PathDAO pathDAO;
	
	@Autowired
	UserService userService;

	/* ���� �������� �̵� */
	@PostMapping("/main")
	public String getMain() throws Exception {
		return "redirect:/setting/main-result";
	}

	/* ���� �������� �̵� - ��� */
	@GetMapping("/main-result")
	public String getMainResult(Model model) throws Exception {

		model.addAttribute("root_path", pathDAO.selectFileRootPath());
		model.addAttribute("userList", userService.getUserList());

		return "/main/setting";
	}

	/* DB ��� */
	@RequestMapping("/backup-db")
	@ResponseBody
	public boolean backupDB() throws Exception {

		try {
			// ��¥ ������ yyyyMMddHHmmss�� ��¥ ���
	        Calendar calendar = Calendar.getInstance();
	        Date date = calendar.getTime();
	        String dateTime = (new SimpleDateFormat("yyyyMMddHHmmss").format(date));
			
			String path = pathDAO.selectFileRootPath()+File.separator+"backup"+File.separator+dateTime+"ssh_db.sql";
			File file = new File(pathDAO.selectFileRootPath()+File.separator+"backup");
			file.mkdirs();
			
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("cmd /c mysqldump --user=ssh --password=1234 ssh_db > "+path);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;

	}
	
	/* ��������� ��� ���� */
	@RequestMapping("/update-path")
	@ResponseBody
	public boolean updateRootPath(String path) throws Exception {
		
		pathDAO.updateFileRootPath(path);
		
		return true;
	}
	
	/* ���̵� �ߺ� üũ */
	@RequestMapping("/check-user-exist")
	@ResponseBody
	public boolean checkUserExist(String user_id) throws Exception {
		return userService.checkUserExist(user_id);
	}
	
	/* ���� ��� */
	@RequestMapping("/insert-user")
	@ResponseBody
	public void insertUser(UserDTO dto) throws Exception {
		userService.insertUser(dto);
	}
	
	/* ���� ���� */
	@RequestMapping("/update-user")
	@ResponseBody
	public void updateUser(UserDTO dto) throws Exception {
		userService.updateUser(dto);
	}
	
	/* ���� ���� */
	@RequestMapping("/delete-user")
	@ResponseBody
	public void deleteUser(String user_idx) throws Exception {
		userService.deleteUser(user_idx);
	}
	
	/* ������ ��й�ȣ Ȯ�� */
	@RequestMapping("/check-admin-password")
	@ResponseBody
	public boolean checkAdminPassword(String admin_password) throws Exception {
		// ������ ��й�ȣ�� ��ġ���� ������ false ��ȯ
		if(userService.getUser("admin", admin_password) == null) {
			return false;
		}
		return true;
	}
}
