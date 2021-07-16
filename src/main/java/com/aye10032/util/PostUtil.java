package com.aye10032.util;

import com.aye10032.data.URL;
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

    public static void addVideo(String url, boolean needtrans, Long fromqq, String description) {
        addVideo(URL.default_host, url, needtrans, fromqq, description);
    }

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
        System.out.println(videoInfo);

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

    public static void updateVideo(VideoInfo videoInfo) {
        updateVideo(URL.default_host, videoInfo);
    }

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

}
