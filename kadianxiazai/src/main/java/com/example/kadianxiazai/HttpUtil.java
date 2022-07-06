package com.example.kadianxiazai;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

    public static HttpURLConnection getConnection(String fileUrl, int start, int end) throws IOException {
        URL url = new URL(fileUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(10 * 1000);
        conn.setRequestMethod("GET");

        if (start >= 0 && end > 0) {

            ///设置请求部分资源   Range表示随机位置   重点1

            conn.setRequestProperty("Range", "bytes=" + start + "-" + end); //设置当前线程从start开始  到 end结束
        }

        conn.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
        conn.setRequestProperty("Accept-Language", "zh-CN");
        conn.setRequestProperty("Referer", fileUrl);
        conn.setRequestProperty("Charset", "UTF-8");
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
        conn.setRequestProperty("Connection", "Keep-Alive");
        conn.setRequestProperty("Accept-Encoding", "identity");
        return conn;
    }
}
