package com.aye10032.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: rtroapiUtil
 * @className: Video
 * @Description: 视频实体类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/4/22 下午 1:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoInfo {

    private Integer id;
    private String url;
    private boolean hasdone;
    private boolean needtrans;
    private boolean istrans;
    private Long fromqq;
    private String description;
    private Long time;

}
