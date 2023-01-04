package com.example.escom.datamodels;

import com.google.gson.annotations.SerializedName;

public class ThesesItem{
	@SerializedName("student_name")
	private String studentName;

	@SerializedName("student_nim")
	private String studentNim;

	@SerializedName("student_id")
	private int studentId;

	@SerializedName("abstract")
	private Object jsonMemberAbstract;

	@SerializedName("title")
	private Object title;

	@SerializedName("start_at")
	private String startAt;

	@SerializedName("status")
	private int status;

	public String getStudentName(){
		return studentName;
	}

	public String getStudentNim(){
		return studentNim;
	}

	public int getStudentId(){
		return studentId;
	}

	public Object getJsonMemberAbstract(){
		return jsonMemberAbstract;
	}

	public Object getTitle(){
		return title;
	}

	public String getStartAt(){
		return startAt;
	}

	public int getStatus(){
		return status;
	}
}