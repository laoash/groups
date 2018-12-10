package com.gdpi.groups.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UpLoadUtil {
    //允许上传视屏的格式
    private static final String[] VIDEO_TYPE = new String[]{"mp4", "", ""};
    // 允许上传图片的格式
    private static final String[] IMAGE_TYPE = new String[]{"bmp", "jpg", "jpeg", "gif", "png"};


    /**
     * 传入文件后缀判断是什么类型，然后找到对应的老路径
     *
     * @param suffixName 文件后缀名
     * @param oldPaths   老地址
     * @return 返回就路径
     */
    private static String getOldPath(String suffixName, String[] oldPaths) {
        String rePath = "";
        //先判断是不是image
        for (String type : IMAGE_TYPE) {
            if (suffixName.equals(type)) {
                //来到这里说明是image
                //看看有没老路径
                for (String oldPath : oldPaths) {
                    if (oldPath.split("/")[0].equals("images")) {
                        //返回正确的对应老路径
                        return oldPath;
                    }
                }
                //来到这里说明没有老路径
                return "images/null";
            }
        }

        //判断是不是video
        for (String type : VIDEO_TYPE) {
            if (suffixName.equals(type)) {
                //来到这里说明是video
                //看看有没老路径
                for (String oldPath : oldPaths) {
                    if (oldPath.split("/")[0].equals("videos")) {
                        //返回正确的对应老路径
                        return oldPath;
                    }
                }
                //来到这里说明没有老路径
                return "videos/null";
            }
        }
        rePath = "typeException";
        return rePath;
    }

    /**
     * 上传图片，顺带处理老图片
     *
     * @param file     上传的文件
     * @param request  获取地址用
     * @param oldPaths 老路径
     * @return 新路径
     * @throws IOException io异常
     */
    public static String upOneFile(MultipartFile file, HttpServletRequest request, String[] oldPaths) throws IOException {
        // 保存数据库的路径
        String sqlPath = null;
        //生成uuid作为文件名称
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //获得文件类型（可以判断如果不是图片，禁止上传）
        String contentType = file.getContentType();
        //获得文件后缀名
        String suffixName = contentType.substring(contentType.indexOf("/") + 1);

        String oldPath = getOldPath(suffixName, oldPaths);

        String path = request.getSession().getServletContext().getRealPath("/") + "/WEB-INF/" + oldPath.split("/")[0];
        //得到文件名
        String filename = uuid + "." + suffixName;
        //生成文件路径
        File dir = new File(path, filename);
        if (!dir.exists()) {
            //如果文件路径不存在新建一个
            dir.mkdirs();
        }
        //判断是不是要删除老图片
        if (!oldPath.split("/")[1].equals("null")) {
            deleOldFile(request, oldPath);
        }
        //  MultipartFile自带的解析方法
        file.transferTo(dir);
        //拼接路径
        sqlPath = oldPath.split("/")[0] + "/" + filename;
        return sqlPath;
    }

    /**
     * 删除老文件
     *
     * @param request 获取地址用的
     * @param oldPath 老的路径
     */
    public static void deleOldFile(HttpServletRequest request, String oldPath) {
        String pathBase = request.getSession().getServletContext().getRealPath("/") + "/WEB-INF/";
        StringBuffer oldFilePath = new StringBuffer();
        String delePath = oldFilePath.append(String.valueOf(pathBase)).append(String.valueOf(oldPath)).toString();
        File deleFile = new File(delePath);
        if (deleFile.exists()) {
            deleFile.delete();
        }
    }

}
