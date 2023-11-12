package edu.poly.finalproject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.poly.finalproject.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity,Integer>{
	@Query("Select o From congviec o Where o.users.id = ?1")
	Page<TaskEntity> gettaskByUserId(Integer id,Pageable pageable);
	
	@Query("SELECT o from congviec o \r\n"
			+ "inner join duan d on d.id =o.duan.id \r\n"
			+ "INNER  join nguoidung n on n.id=o.users.id \r\n"
			+ "where o.duan.id=?1 and o.trangthai.idtrangthai=?2")
	List<TaskEntity> getTastByProject(Integer id,Integer idtt);
}
