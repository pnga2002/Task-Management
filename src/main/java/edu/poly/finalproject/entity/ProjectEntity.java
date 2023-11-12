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

@Entity(name="duan")
public class ProjectEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name= "tenduan")
	private String tenduan;
	
	@Column(name= "mota")
	private String mota;
	
	@Column(name= "ngaybatdau")
	private String ngaybatdau;

	@Column(name= "ngayketthuc")
	private String ngayketthuc;
	
	@ManyToOne
	@JoinColumn(name="matrangthai")
	private StatusEntity trangthai;
	
	@ManyToOne
	@JoinColumn(name="maquanly")
	private UserEntity users;
	
	@OneToMany(mappedBy = "duan")
	private List<TaskEntity> congviec;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenduan() {
		return tenduan;
	}

	public void setTenduan(String tenduan) {
		this.tenduan = tenduan;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getNgaybatdau() {
		return ngaybatdau;
	}

	public void setNgaybatdau(String ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}

	public String getNgayketthuc() {
		return ngayketthuc;
	}

	public void setNgayketthuc(String ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}

	public StatusEntity getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(StatusEntity trangthai) {
		this.trangthai = trangthai;
	}

	public UserEntity getUsers() {
		return users;
	}

	public void setUsers(UserEntity users) {
		this.users = users;
	}
}
