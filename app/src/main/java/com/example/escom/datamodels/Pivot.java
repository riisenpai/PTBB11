package com.example.escom.datamodels;

import com.google.gson.annotations.SerializedName;

public class Pivot{

	@SerializedName("thesis_id")
	private int thesisId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("position")
	private int position;

	@SerializedName("lecturer_id")
	private int lecturerId;

	@SerializedName("created_by")
	private int createdBy;

	@SerializedName("status")
	private int status;

	public int getThesisId(){
		return thesisId;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public int getPosition(){
		return position;
	}

	public int getLecturerId(){
		return lecturerId;
	}

	public int getCreatedBy(){
		return createdBy;
	}

	public int getStatus(){
		return status;
	}
}