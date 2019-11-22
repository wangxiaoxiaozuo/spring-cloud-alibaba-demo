package com.weblogic.demo.repository.mysql;

import com.weblogic.demo.dto.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobInfoRepository extends JpaRepository<JobInfo, Integer> {

}
