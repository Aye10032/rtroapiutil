package com.aye10032.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: rtroapiUtil
 * @className: TransList
 * @Description: 翻译信息实体类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/7/14 下午 6:27
 */
@Data
@NoArgsConstructor
public class TransList {

    private Integer id;
    private Integer fromid;
    private Long fromqq;
    private String msg;
    private Long time;

}
