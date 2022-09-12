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

@Controller
@RequestMapping("/setting")
public class SettingController {

	@Autowired
	PathDAO pathDAO;

	/* ���� �������� �̵� */
	@PostMapping("/main")
	public String getMain() throws Exception {
		return "redirect:/setting/main-result";
	}

	/* ���� �������� �̵� - ��� */
	@GetMapping("/main-result")
	public String getMainResult(Model model) throws Exception {

		model.addAttribute("root_path", pathDAO.selectFileRootPath());

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
			System.out.println(path);
			
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("cmd /c mysqldump --user=ssh --password=1234 ssh_db > "+path);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;

	}
	
	/* DB ��� */
	@RequestMapping("/update-path")
	@ResponseBody
	public boolean updateRootPath(String path) throws Exception {
		
		pathDAO.updateFileRootPath(path);
		
		return true;
	}
}
