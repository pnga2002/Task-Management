package edu.poly.finalproject.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity(name = "congviec")
public class TaskEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int idcv;
	
	

	@Column(name= "ten")
	private String ten;

	@Column(name= "mota")
	private String mota;

	@Column(name= "ngaybatdau")
	private Date ngaybatdau;

	@Column(name= "ngayketthuc")
	private Date ngayketthuc;
	
	@ManyToOne
	@JoinColumn(name="maduan")
	private ProjectEntity duan;

	@ManyToOne
	@JoinColumn(name="matrangthai")
	private StatusEntity trangthai;

	@ManyToOne
	@JoinColumn(name="manguoidung")
	private UserEntity users;
	
	public int getIdcv() {
		return idcv;
	}

	public void setIdcv(int idcv) {
		this.idcv = idcv;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Date getNgaybatdau() {
		return ngaybatdau;
	}

	public void setNgaybatdau(Date ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}

	public Date getNgayketthuc() {
		return ngayketthuc;
	}

	public void setNgayketthuc(Date ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}

	public ProjectEntity getDuan() {
		return duan;
	}

	public void setDuan(ProjectEntity duan) {
		this.duan = duan;
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
