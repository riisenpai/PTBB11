package com.example.escom.datamodels;

import com.google.gson.annotations.SerializedName;

public class SupervisorsItem{

	@SerializedName("birthday")
	private String birthday;

	@SerializedName("address")
	private Object address;

	@SerializedName("gender")
	private int gender;

	@SerializedName("department_id")
	private int departmentId;

	@SerializedName("npwp")
	private Object npwp;

	@SerializedName("photo")
	private Object photo;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("association_type")
	private Object associationType;

	@SerializedName("religion")
	private int religion;

	@SerializedName("nik")
	private String nik;

	@SerializedName("marital_status")
	private int maritalStatus;

	@SerializedName("nip")
	private String nip;

	@SerializedName("karpeg")
	private Object karpeg;

	@SerializedName("birthplace")
	private String birthplace;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("phone")
	private String phone;

	@SerializedName("nidn")
	private String nidn;

	@SerializedName("name")
	private String name;

	@SerializedName("pivot")
	private Pivot pivot;

	@SerializedName("id")
	private int id;

	@SerializedName("status")
	private int status;

	public String getBirthday(){
		return birthday;
	}

	public Object getAddress(){
		return address;
	}

	public int getGender(){
		return gender;
	}

	public int getDepartmentId(){
		return departmentId;
	}

	public Object getNpwp(){
		return npwp;
	}

	public Object getPhoto(){
		return photo;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public Object getAssociationType(){
		return associationType;
	}

	public int getReligion(){
		return religion;
	}

	public String getNik(){
		return nik;
	}

	public int getMaritalStatus(){
		return maritalStatus;
	}

	public String getNip(){
		return nip;
	}

	public Object getKarpeg(){
		return karpeg;
	}

	public String getBirthplace(){
		return birthplace;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getPhone(){
		return phone;
	}

	public String getNidn(){
		return nidn;
	}

	public String getName(){
		return name;
	}

	public Pivot getPivot(){
		return pivot;
	}

	public int getId(){
		return id;
	}

	public int getStatus(){
		return status;
	}
}