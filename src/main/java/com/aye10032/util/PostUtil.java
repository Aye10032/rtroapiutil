package com.aye10032.util;

import com.aye10032.data.URL;
import com.aye10032.pojo.TransList;
import com.aye10032.pojo.VideoInfo;
import okhttp3.*;

import java.io.IOException;
import java.util.Date;

/**
 * @program: rtroapiutil
 * @className: PostUtil
 * @Description: Post请求相关封装
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/7/15 下午 3:43
 */
public class PostUtil {

    /**
     *
     * @param url 视频链接
     * @param needtrans 是否需要翻译
     * @param fromqq 消息来源
     * @param description 视频描述
     */
    public static void addVideo(String url, boolean needtrans, Long fromqq, String description) {
        addVideo(URL.default_host, url, needtrans, fromqq, description);
    }

    /**
     *
     * @param api_host API服务器地址加端口
     * @param url 视频链接
     * @param needtrans 是否需要翻译
     * @param fromqq 消息来源
     * @param description 视频描述
     */
    public static void addVideo(String api_host, String url, boolean needtrans, Long fromqq, String description) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Date date = new Date();

        MediaType mediaType = MediaType.parse("application/json");
        VideoInfo videoInfo = VideoInfo.builder()
                .id(null)
                .url(url)
                .hasdone(false)
                .needtrans(needtrans)
                .istrans(false)
                .fromqq(fromqq)
                .description(description)
                .time(date.getTime()).build();
//        System.out.println(videoInfo);

        RequestBody body = RequestBody.create(mediaType, JSONUtil.entity2json(videoInfo));

        Request request = new Request.Builder()
                .url("http://" + api_host + "/addVideo")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param videoInfo 视频信息实体类
     */
    public static void updateVideo(VideoInfo videoInfo) {
        updateVideo(URL.default_host, videoInfo);
    }

    /**
     *
     * @param api_host API服务器地址加端口
     * @param videoInfo 视频信息实体类
     */
    public static void updateVideo(String api_host, VideoInfo videoInfo) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create(mediaType, JSONUtil.entity2json(videoInfo));

        Request request = new Request.Builder()
                .url("http://" + api_host + "/updateVideo")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param fromid 对应的视频ID
     * @param fromqq 消息来源
     * @param msg 备注信息
     */
    public static void addTrans(Integer fromid, Long fromqq, String msg) {
        addTrans(URL.default_host, fromid, fromqq, msg);
    }

    /**
     *
     * @param api_host API服务器地址加端口
     * @param fromid 对应的视频ID
     * @param fromqq 消息来源
     * @param msg 备注信息
     */
    public static void addTrans(String api_host, Integer fromid, Long fromqq, String msg) {
        Date date = new Date();
        TransList transList = TransList.builder()
                .id(null)
                .fromid(fromid)
                .fromqq(fromqq)
                .msg(msg)
                .time(date.getTime()).build();

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, JSONUtil.entity2json(transList));

        Request request = new Request.Builder()
                .url("http://" + api_host + "/addTrans")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
