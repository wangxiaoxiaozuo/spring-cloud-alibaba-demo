package com.weblogic.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |  映射到ElasticSearch实体类              |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/25 09:10:12
 */
@Document(indexName = "jobinfo", type = "job")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EsJobInfo {

    @Id
    private Integer id;

    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String companyName;

    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String companyAddr;

    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String companyInfo;

    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String jobName;

    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String jobAddr;

    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String jobInfo;

    private String salary;

    private String url;

    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private LocalDateTime time;
}
