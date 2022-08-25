package com.sshmanager.ssh.main.domain;

public enum FileType {
	
	QUOTE("quote","������"), ORDER("order","�۾����ü�"), IMAGE("image","����"), OTHER("other","��Ÿ");
	
	private final String file_type;
	private final String folder_name;
	
	FileType(String file_type, String folder_name) {
		this.file_type = file_type;
		this.folder_name = folder_name;
	}

	public String getFile_type() {
		return file_type;
	}

	public String getFolder_name() {
		return folder_name;
	}
	
}
