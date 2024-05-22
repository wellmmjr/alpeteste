package org.example.data.dto.v1.model;

import java.io.Serializable;
import java.util.Objects;

public class UploadFileResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private long size;
	
	public UploadFileResponseDTO() {
		
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public UploadFileResponseDTO(String fileName, String fileDownloadUri, String fileType, long size) {
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fileDownloadUri, fileName, fileType, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UploadFileResponseDTO other = (UploadFileResponseDTO) obj;
		return Objects.equals(fileDownloadUri, other.fileDownloadUri) && Objects.equals(fileName, other.fileName)
				&& Objects.equals(fileType, other.fileType) && size == other.size;
	}

	
}
