package com.weblogic.demo.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @program mall
 * @description:
 * @author: wangjian
 * @create: 2019/11/21 15:50:46
 */
@Data
@Entity(name = "job_info")
@ToString
@Accessors(chain = true)
public class JobInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String companyName;

    private String companyAddr;

    private String companyInfo;

    private String jobName;

    private String jobAddr;

    private String jobInfo;

    private String salary;

    private String url;

    private LocalDateTime time;

}
