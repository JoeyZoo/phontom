package com.zj.baseservice.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutdoorException extends RuntimeException {
    private String msg;
    private Integer code;
}
