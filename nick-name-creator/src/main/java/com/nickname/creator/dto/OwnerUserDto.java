package com.nickname.creator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/27 14:21:00
 */
@Data
@AllArgsConstructor
public class OwnerUserDto {

    private Long userId;

    private String nickName;

}
