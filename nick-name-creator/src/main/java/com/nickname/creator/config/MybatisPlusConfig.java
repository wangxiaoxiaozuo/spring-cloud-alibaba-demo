package com.nickname.creator.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * | MyBatis-Plus 配置文件 配置Mapper扫描路径 |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/26 14:30:30
 */
@Configuration
@MapperScan("com.nickname.creator.mapper")
public class MybatisPlusConfig {


}
