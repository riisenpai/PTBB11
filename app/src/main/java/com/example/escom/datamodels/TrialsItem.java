package com.example.escom.datamodels;

import com.google.gson.annotations.SerializedName;

public class TrialsItem{

	@SerializedName("room_id")
	private Object roomId;

	@SerializedName("end_at")
	private Object endAt;

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

	@SerializedName("description")
	private Object description;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("thesis_rubric_id")
	private int thesisRubricId;

	@SerializedName("start_at")
	private Object startAt;

	@SerializedName("file_journal")
	private String fileJournal;

	@SerializedName("score")
	private Object score;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("grade")
	private Object grade;

	@SerializedName("trial_at")
	private Object trialAt;

	@SerializedName("id")
	private int id;

	@SerializedName("online_url")
	private Object onlineUrl;

	@SerializedName("status")
	private int status;

	public Object getRoomId(){
		return roomId;
	}

	public Object getEndAt(){
		return endAt;
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

	public Object getDescription(){
		return description;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getThesisRubricId(){
		return thesisRubricId;
	}

	public Object getStartAt(){
		return startAt;
	}

	public String getFileJournal(){
		return fileJournal;
	}

	public Object getScore(){
		return score;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public Object getGrade(){
		return grade;
	}

	public Object getTrialAt(){
		return trialAt;
	}

	public int getId(){
		return id;
	}

	public Object getOnlineUrl(){
		return onlineUrl;
	}

	public int getStatus(){
		return status;
	}
}