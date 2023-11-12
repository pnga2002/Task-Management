package edu.poly.finalproject.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="nguoidung")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name= "email")
	private String email;
	
	@Column(name="matkhau")
	private String matkhau;
	
	@Column(name="fullname")
	private String fullname;

	@Column(name="diachi")
	private String diachi;

	public List<ProjectEntity> getDuan() {
		return duan;
	}

	public void setDuan(List<ProjectEntity> duan) {
		this.duan = duan;
	}

	@Column(name="sodienthoai")
	private String sodienthoai;
	
	@ManyToOne
	@JoinColumn(name="id_loaithanhvien")
	private RoleEntity role;
	
	@OneToMany(mappedBy = "users")
	private List<ProjectEntity> duan;

	@OneToMany(mappedBy = "users")
	private List<TaskEntity> congviec;
	
	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
}
