package edu.poly.finalproject.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "trangthai")
public class StatusEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtrangthai;
	
	@Column(name = "ten")
	private String ten;

	@OneToMany(mappedBy = "trangthai")
	private List<ProjectEntity> duan;
	
	@OneToMany(mappedBy = "trangthai")
	private List<TaskEntity> congviec;
	
	public int getIdtrangthai() {
		return idtrangthai;
	}

	public void setIdtrangthai(int idtrangthai) {
		this.idtrangthai = idtrangthai;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
	
	
}
