package com.neuron.etl.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.Notecard;
import com.neuron.etl.model.master.Resp;
import com.neuron.etl.model.master.Test;
import com.neuron.etl.model.master.User;
import com.neuron.etl.service.master.SysSonService;
import com.neuron.etl.service.master.impl.SysUserServiceImpl;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @Author: FengJie
 * #Description: test
 * #Date: 2021/5/8 16:33
 */

public class test {
    @Autowired
    static SysSonService sysSonService;
    @Autowired
    static SysUserServiceImpl sysUserService;
    public static void main(String[] args) {
        String spaht=publicData.FILE_ALL+publicData.HEAD.substring(publicData.HEAD.lastIndexOf("/image/"));
        System.out.println(spaht);
        spaht=spaht.replace("/","\\");
        System.out.println(spaht);
        System.out.println(Inti.GetLastPath(publicData.HEAD));
    }

    public static Resp<String> putFilefileOutputStream(MultipartFile file, String... s){
        if(file==null){
            return null;
        }
        if(file.isEmpty()){
            return Resp.fail("400","文件为空");
        }
        StringBuffer stringBuffer=new StringBuffer();
        for (String s1 : s) {
            stringBuffer.append(s1+"\\");
        }
        String filepath="C:\\file\\img\\"+stringBuffer;
        String OrgainFile=file.getOriginalFilename();
        String fileName=Ramdnum.getTOken()+"."+OrgainFile.substring(OrgainFile.lastIndexOf(".")+1);

        File file1=new File(filepath+fileName);
        if(!file1.getParentFile().exists()){
            file1.getParentFile().mkdirs();
        }
        try {
            InputStream inputStream=file.getInputStream();
            FileOutputStream fileOutputStream=new FileOutputStream(file1);
            int b=0;
            while ((b=inputStream.read())!=-1){
                fileOutputStream.write(b);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            inputStream.close();

        }catch (IOException e) {
            e.printStackTrace();
            return Resp.fail("500","上传失败");
        }
        String sp="http://47.101.198.228"+"/image/"+stringBuffer+fileName;
        sp=sp.replace("\\","/");
        return Resp.success(sp,"上传成功");
//        String sp="http://localhost"+"/image/"+stringBuffer+fileName;
//        sp=sp.replace("\\","/");
////        http:\\localhost\image\1620646833485\1625035079956.png
//        return Resp.success(sp,"上传成功");
//        System.out.println("ok"+filepath+fileName);
//        return Resp.success("http://"+GetIp.getip()+"/image/"+fileName,"上传成功");
    }

    public static Resp<String> putFilefileOutputStreamArr(MultipartFile file, String... s){
        if(file==null){
            return null;
        }
        if(file.isEmpty()){
            return Resp.fail("400","文件为空");
        }
        StringBuffer stringBuffer=new StringBuffer();
        for (String s1 : s) {
            stringBuffer.append(s1+"\\");
        }
        String filepath="C:\\file\\img\\"+stringBuffer;
        String OrgainFile=file.getOriginalFilename();
        String fileName=Ramdnum.getTOken()+"."+OrgainFile.substring(OrgainFile.lastIndexOf(".")+1);

        File file1=new File(filepath+fileName);
        if(!file1.getParentFile().exists()){
            file1.getParentFile().mkdirs();
        }
        try {
            InputStream inputStream=file.getInputStream();
            FileOutputStream fileOutputStream=new FileOutputStream(file1);
            byte[] b=new byte[1024*200];
            int k;
            while ((k=inputStream.read(b))!=-1){
                fileOutputStream.write(b);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            inputStream.close();

        }catch (IOException e) {
            e.printStackTrace();
            return Resp.fail("500","上传失败");
        }
        String sp="http://47.101.198.228"+"/image/"+stringBuffer+fileName;
        sp=sp.replace("\\","/");
        return Resp.success(sp,"上传成功");

    }


    public static Resp<String> putFileBuff(MultipartFile file, String... s){
        if(file==null){
            return null;
        }
        if(file.isEmpty()){
            return Resp.fail("400","文件为空");
        }
        StringBuffer stringBuffer=new StringBuffer();
        for (String s1 : s) {
            stringBuffer.append(s1+"\\");
        }
        String filepath="C:\\file\\img\\"+stringBuffer;
        String OrgainFile=file.getOriginalFilename();
        String fileName=Ramdnum.getTOken()+"."+OrgainFile.substring(OrgainFile.lastIndexOf(".")+1);

        File file1=new File(filepath+fileName);
        if(!file1.getParentFile().exists()){
            file1.getParentFile().mkdirs();
        }
        try {
            InputStream inputStream=file.getInputStream();
            BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(file1));
            int a=0;
            byte[] bytes=new byte[1024*200];
            while ((a=bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes);
            }
            bufferedInputStream.close();
            bufferedOutputStream.close();
            inputStream.close();

        }catch (IOException e) {
            e.printStackTrace();
            return Resp.fail("500","上传失败");
        }
        String sp="http://47.101.198.228"+"/image/"+stringBuffer+fileName;
        sp=sp.replace("\\","/");
        return Resp.success(sp,"上传成功");
    }


}
