package com.aye10032.util;

import com.aye10032.data.ResultCode;
import com.aye10032.data.ResultVO;
import com.aye10032.pojo.VideoInfo;

/**
 * @program: rtroapiutil
 * @className: UpdateUtil
 * @Description: 更新信息相关工具
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/7/17 上午 10:04
 */
public class UpdateUtil {

    public static String updateVideoDone(Integer id, boolean flag){
        ResultVO<VideoInfo> result = GetUtil.getVideo(id);
        if (result.getCode() == ResultCode.FAILED.getCode()){
            return "视频不存在";
        }
        VideoInfo videoInfo = result.getData();
        videoInfo.setHasdone(flag);

        PostUtil.updateVideo(videoInfo);

        return "success";
    }

    public static String updateVideoNeedTrans(Integer id, boolean flag){
        ResultVO<VideoInfo> result = GetUtil.getVideo(id);
        if (result.getCode() == ResultCode.FAILED.getCode()){
            return "视频不存在";
        }
        VideoInfo videoInfo = result.getData();
        videoInfo.setNeedtrans(flag);

        PostUtil.updateVideo(videoInfo);

        return "success";
    }

    public static String updateVideoIsTrans(Integer id, boolean flag){
        ResultVO<VideoInfo> result = GetUtil.getVideo(id);
        if (result.getCode() == ResultCode.FAILED.getCode()){
            return "视频不存在";
        }
        VideoInfo videoInfo = result.getData();
        videoInfo.setIstrans(flag);

        PostUtil.updateVideo(videoInfo);
        return "success";
    }

}
