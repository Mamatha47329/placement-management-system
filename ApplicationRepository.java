package com.pms.repository;

import com.pms.entity.Application;
import com.pms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByStudent(Student student);

}
