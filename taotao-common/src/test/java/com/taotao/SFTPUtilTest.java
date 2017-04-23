package com.taotao;

import java.io.File;

import com.taotao.utils.SFTPUtil;
import org.junit.Test;

public class SFTPUtilTest {
//上传不设置保存文件名
   /* @Test
    public void upload1() {
        SFTPUtil sftp = new SFTPUtil();
        File local = new File("C:\\Users\\bypay\\Desktop\\CopyOnWriteArrayListDemo.java");
        sftp.setLocal(local);
        sftp.uploadFile();
    }
//上传并设置保存文件名
    @Test
    public void upload2() {
        SFTPUtil sftp = new SFTPUtil();
        File local = new File("C:\\Users\\bypay\\Desktop\\CopyOnWriteArrayListDemo.java");
        sftp.setLocal(local);
        sftp.setRemote("upload.txt");
        sftp.uploadFile();
    }
//上传并设置保存路径
    @Test
    public void upload3() {
        SFTPUtil sftp = new SFTPUtil();
        File local = new File("C:\\Users\\bypay\\Desktop\\CopyOnWriteArrayListDemo.java");
        sftp.setLocal(local);
        sftp.setRemote("upload.txt");
        sftp.setRemotePath("/home/test");
        sftp.uploadFile();
    }
//下载文件
    @Test
    public void down(){
        SFTPUtil sftp = new SFTPUtil();
        File local = new File("C:\\Users\\bypay\\Desktop\\download.java");
        sftp.setLocal(local);
        sftp.setRemote("upload.txt");
        sftp.setRemotePath("/home/test");
        sftp.download();
    }*/
}