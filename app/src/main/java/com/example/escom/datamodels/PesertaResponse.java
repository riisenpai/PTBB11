package com.example.escom.datamodels;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PesertaResponse{

	@SerializedName("room_id")
	private int roomId;

	@SerializedName("thesis_id")
	private int thesisId;

	@SerializedName("file_slide")
	private String fileSlide;

	@SerializedName("registered_at")
	private String registeredAt;

	@SerializedName("method")
	private int method;

	@SerializedName("file_report")
	private String fileReport;

	@SerializedName("recommendation")
	private Object recommendation;

	@SerializedName("description")
	private Object description;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("seminar_at")
	private String seminarAt;

	@SerializedName("file_journal")
	private String fileJournal;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("audiences")
	private List<AudiencesItem> audiences;

	@SerializedName("id")
	private int id;

	@SerializedName("file_attendance")
	private Object fileAttendance;

	@SerializedName("online_url")
	private Object onlineUrl;

	@SerializedName("status")
	private int status;

	public int getRoomId(){
		return roomId;
	}

	public int getThesisId(){
		return thesisId;
	}

	public String getFileSlide(){
		return fileSlide;
	}

	public String getRegisteredAt(){
		return registeredAt;
	}

	public int getMethod(){
		return method;
	}

	public String getFileReport(){
		return fileReport;
	}

	public Object getRecommendation(){
		return recommendation;
	}

	public Object getDescription(){
		return description;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getSeminarAt(){
		return seminarAt;
	}

	public String getFileJournal(){
		return fileJournal;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public List<AudiencesItem> getAudiences(){
		return audiences;
	}

	public int getId(){
		return id;
	}

	public Object getFileAttendance(){
		return fileAttendance;
	}

	public Object getOnlineUrl(){
		return onlineUrl;
	}

	public int getStatus(){
		return status;
	}
}