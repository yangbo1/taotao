package com.taotao.controller;

import com.taotao.utils.FtpUtil;
import com.taotao.utils.SFTPUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by 杨波 on 2017/3/15.
 */
public class FTPTest {
    /**不行*/
    @Test
    public void testFtpClient() throws Exception {
        //创建一个FtpClient对象
        FTPClient ftpClient = new FTPClient();
        //创建连接
        ftpClient.connect("192.168.203.128",22);
        //登陆服务器
        ftpClient.login("yangbo","134679");
        //上传本地文件
        FileInputStream inputStream = new FileInputStream(new File("D:\\images\\b64543a98226cffca90bcfecbd014a90f603ea4f.jpg"));
        //设置上传的路径
        ftpClient.changeWorkingDirectory("/usr/local/nginx/html/images");
        //修改上传文件的格式
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //第一个参数：服务器端文档名
        //第二个参数：上传文档的inputStream
        ftpClient.storeFile("1.jpg", inputStream);
        //关闭连接
        ftpClient.logout();
    }
    /**不行*/
    @Test
    public void testFtpUtil() throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("D:\\images\\b64543a98226cffca90bcfecbd014a90f603ea4f.jpg"));
        FtpUtil.uploadFile("192.168.203.128",22,"yangbo","134679","/usr/local/nginx/html/images","/2017/03/15","1.jpg",inputStream);
    }
    /**可以*/
    @Test
    public void testSFTPUtil() {
        SFTPUtil sftp = new SFTPUtil();
        File local = new File("D:\\images\\b64543a98226cffca90bcfecbd014a90f603ea4f.jpg");
        sftp.setLocal(local);
        sftp.setRemote("1.jpg");
        sftp.setRemotePath("/usr/local/nginx/html/images");
        sftp.uploadFile();
    }
}
