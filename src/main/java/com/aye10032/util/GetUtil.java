package com.aye10032.util;

import com.aye10032.data.ResultCode;
import com.aye10032.data.ResultVO;
import com.aye10032.data.URL;
import com.aye10032.pojo.TransList;
import com.aye10032.pojo.VideoInfo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @program: rtroapiutil
 * @className: GetUtil
 * @Description: GET请求封装
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/7/15 下午 4:44
 */
public class GetUtil {

    public static ResultVO<List<VideoInfo>> getAllVideo() {
        return getAllVideo(URL.default_host);
    }

    public static ResultVO<List<VideoInfo>> getAllVideo(String api_host) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://" + api_host + "/getAllVideo")
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();

            String body = Objects.requireNonNull(response.body()).string();

            return JSONUtil.json2entityList(body, VideoInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultVO<List<VideoInfo>>(ResultCode.ERROR, null);
    }

    public static ResultVO<List<VideoInfo>> getTODOVideo() {
        return getTODOVideo(URL.default_host);
    }

    public static ResultVO<List<VideoInfo>> getTODOVideo(String api_host) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://" + api_host + "/getTODOVideo")
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();

            String body = Objects.requireNonNull(response.body()).string();

            return JSONUtil.json2entityList(body, VideoInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultVO<List<VideoInfo>>(ResultCode.ERROR, null);
    }

    public static ResultVO<List<VideoInfo>> getNeedTransVideo() {
        return getNeedTransVideo(URL.default_host);
    }

    public static ResultVO<List<VideoInfo>> getNeedTransVideo(String api_host) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://" + api_host + "/getNeedTransVideo")
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();

            String body = Objects.requireNonNull(response.body()).string();

            return JSONUtil.json2entityList(body, VideoInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultVO<List<VideoInfo>>(ResultCode.ERROR, null);
    }

    public static ResultVO<VideoInfo> getVideo(Integer id) {
        return getVideo(id, URL.default_host);
    }

    public static ResultVO<VideoInfo> getVideo(Integer id, String api_host) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://" + api_host + "/getVideo?id=" + id)
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();

            String body = Objects.requireNonNull(response.body()).string();

            return JSONUtil.json2entity(body, VideoInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultVO<VideoInfo>(ResultCode.ERROR, null);
    }

    public static ResultVO<List<TransList>> getTransByVideoID(Integer id) {
        return getTransByVideoID(id, URL.default_host);
    }

    public static ResultVO<List<TransList>> getTransByVideoID(Integer id, String api_host) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("http://" + api_host + "/getTransByVideoID?id=" + id)
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();

            String body = Objects.requireNonNull(response.body()).string();

            return JSONUtil.json2entityList(body, TransList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultVO<List<TransList>>(ResultCode.ERROR, null);
    }

}
