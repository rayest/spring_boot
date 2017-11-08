package com.rayeston.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.util.UUID;

/**
 * Created by lirui on 2017/9/28.
 */
public class Crawler {
    private static final String baidu = "http://v.youku.com/v_show/id_XODAxMjE2MDMy.html";
    private static final String a = "a";
    private static final String id = "g-productshow";

    private static Elements getByUrl(String url) throws IOException {
        Document document = Jsoup.connect(url)
                //.data("query", "Java")
                //.userAgent("头部")
                //.cookie("auth", "token")
                //.timeout(3000)
                //.post()
                .get();
        Elements content = document.getElementsByClass(id);
        Elements images = content.select("img[src$=.jpg]");
        for (Element image : images) {
            String imageUrl = image.attr("src");
            System.out.println(imageUrl);
            saveImages(imageUrl);
        }
        return images;
    }

    private static void saveImages(String imageUrl) throws IOException {
        int id = UUID.randomUUID().hashCode();
        File dest = new File("src/images/" + id + ".png");
        FileOutputStream fos = new FileOutputStream(dest);
        URL temp = new URL(imageUrl);
        InputStream is = temp.openStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int length;
        byte[] bytes = new byte[1024 * 20];
        while ((length = bis.read(bytes, 0, bytes.length)) != -1) {
            fos.write(bytes, 0, length);
        }
        bos.close();
        fos.close();
        bis.close();
        is.close();
    }

    public static void main(String[] args) throws IOException {
        Elements element = getByUrl(baidu);
        System.out.println(element);
    }

}
