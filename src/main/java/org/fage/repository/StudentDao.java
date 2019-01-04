package org.fage.repository;

import javax.transaction.Transactional;
import org.fage.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentDao extends JpaRepository<Student,String> {

    @Query("update Student set name=?1 where id=?2")
    @Modifying
    @Transactional
    int updateNameById(String name,String id);
}