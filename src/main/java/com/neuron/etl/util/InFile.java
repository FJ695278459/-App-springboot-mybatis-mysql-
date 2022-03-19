package com.neuron.etl.util;

import com.alibaba.fastjson.JSONObject;
import com.neuron.etl.model.master.Resp;
import lombok.Data;
import lombok.ToString;
import net.coobird.thumbnailator.Thumbnails;
import org.aspectj.weaver.ast.Or;
import org.omg.CORBA.ORB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.Thymeleaf;
import sun.security.x509.AttributeNameEnumeration;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
/**
 * @Author: FengJie
 * #Description: File
 * #Date: 2021/5/8 17:11
 */



public class InFile {




    private static double a=1f;

    private static double b=0.1f;



    //大文件储存
   private static String ImagepathD="C:\\file\\img\\Imagepath\\";
   //小文件储存
   private static String ImagepathX="C:\\file\\img\\ImagepathX\\";
    private static String URLIMG="http://47.101.198.228/image/Imagepath/";

    public static Resp<String> putFile(MultipartFile file,String... s){
        String Imgpath="";
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
        String filepath=ImagepathD+stringBuffer;
        String OrgainFile=file.getOriginalFilename();

        //文件后缀
        String  or=OrgainFile.substring(OrgainFile.lastIndexOf(".")+1);
        String Token=Ramdnum.getTOken();

        String fileName=Token+"."+or;
        File file1=new File(filepath+fileName);
        if(!file1.getParentFile().exists()){
            file1.getParentFile().mkdirs();
        }
        try {
            file.transferTo(file1);
            if(or.equals("gif") || or.equals("jpg")  || or.equals("bmp")|| or.equals("tiff")||or.equals("ai")|| or.equals("eps")|| or.equals("cdr")){

                fileName=Token+"X"+"."+or;
                File file2=new File(filepath+fileName);
                YaSImg(file1,file2);

            }
            if (or.equals("png")){

                //先将png转换成jpg
                or="jpg";
                fileName=Token+"."+or;
                File file3 = new File(filepath+fileName);
                FileTOjpg(file1,file3);

                //压缩jpg
                fileName=Token+"X"+"."+or;
                File file2=new File(filepath+fileName);
                YaSImg(file3,file2);

            }

        }catch (IOException e) {
            e.printStackTrace();
            return Resp.fail("500","上传失败");
        }
        String sp=URLIMG+stringBuffer+fileName;
        sp=sp.replace("\\","/");

        return Resp.success(sp,"上传成功");
//        String sp="http://localhost"+"/image/"+stringBuffer+fileName;
//        sp=sp.replace("\\","/");
////        http:\\localhost\image\1620646833485\1625035079956.png
//        return Resp.success(sp,"上传成功");
//        System.out.println("ok"+filepath+fileName);
//        return Resp.success("http://"+GetIp.getip()+"/image/"+fileName,"上传成功");
    }


    private static void YaSImg(File From,File To){
        try {
            Thumbnails.of(From).scale(a).outputQuality(b).toFile(To);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Resp<String> putFileApk(MultipartFile file){
        if(file==null){
            return null;
        }

        if(file.isEmpty()){
            return Resp.fail("400","文件为空");
        }
        String OrgainFile=file.getOriginalFilename();
        String fileName="bee"+"."+OrgainFile.substring(OrgainFile.lastIndexOf(".")+1);
        String filepath="C:\\file\\img\\apk\\";
        File file1=new File(filepath+fileName);
        if(!file1.getParentFile().exists()){
            file1.getParentFile().mkdirs();
        }
        try {
            file.transferTo(file1);


        }catch (IOException e) {
            e.printStackTrace();
            return Resp.fail("500","上传失败");
        }
        return Resp.success("http://47.101.198.228"+"/image/"+fileName,"上传成功");
//        return Resp.success("http://"+GetIp.getip()+"/image/"+fileName,"上传成功");
    }

    public static void main(String[] args) {
        String filepath1="D:\\imgs\\壁纸\\pic.png";
        String filepath2="D:\\imgs\\壁纸\\pic.jpg";
        File file1=new File(filepath1);
        File file2=new File(filepath2);
        long l = System.currentTimeMillis();

        FileTOjpg(file1,file2);

        long s=System.currentTimeMillis();
        System.out.println("所需时间:"+(s-l)+" ms");
    }


    public static void FileTOjpg(File filepng,File filejpg){
        BufferedImage bufferedImage;

        try {

            //read image file
            bufferedImage = ImageIO.read(filepng);

            // create a blank, RGB, same width and height, and a white background
            BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(),
                    bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);

            //TYPE_INT_RGB:创建一个RBG图像，24位深度，成功将32位图转化成24位

            newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);

            // write to jpeg file
            ImageIO.write(newBufferedImage, "jpg", filejpg);

            filepng.delete();

        } catch (IOException e) {

            e.printStackTrace();


        }
    }

    public static String[] putAllFile(MultipartFile[] file,String... pa){
        if(file==null){
            return null;
        }
        String[] strings=new String[file.length];
        Resp s;
        for (int i = 0; i < file.length; i++) {
            s=putFile(file[i],pa);
            if(s==null){
                strings[i]="";
                continue;
            }
            strings[i]= (String) s.getBody();
        }
        return strings;
    }


    public static boolean DeleteFolder(String sPath){
        boolean b=false;
        File file=new File(sPath);
        //判断是目录或者文件是否存在
        if(!file.exists()){
            return b;
        }else {
            //判断是否为文件
            if(file.isFile()){
                return deleteFile(sPath);
            }else {
                return deleDireCtory(sPath);
            }
        }
    }
    //删除单个文件
    public static boolean deleteFile(String sPath){
        boolean b=false;
        File file=new File(sPath);
        //路径为文件且不为空
        if(file.isFile() && file.exists()){
            file.delete();
            b=true;
        }
        return b;
    }
    public static void deleteFileall(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] temp = file.listFiles(); //获取该文件夹下的所有文件
                for (File value : temp) {
                    deleteFile(value.getAbsolutePath());
                }
            } else {
                file.delete(); //删除子文件
            }
            file.delete(); //删除文件夹
        }
    }

    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    //删除文件夹及其下面文件
    public static void deleteFiles(String sPath){
        new Thread(new Runnable() {
            @Override
            public void run() {
                deleteDir(new File(sPath));
            }
        }).start();
    }

    public static boolean deleDireCtory(String sPath){
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符
        if(!sPath.endsWith(File.separator)){
            sPath=sPath+File.separator;
        }
        File dirFile=new File(sPath);
        //如果dir对应的文件不存在，或者不是一个文件夹，则退出
        if(!dirFile.exists() || !dirFile.isDirectory()){
            return false;
        }
        boolean b=true;
        //删除文件夹下的所有文件（包括之目录）
        File[] files=dirFile.listFiles();
        for (File file : files) {
            if(file.isFile()){
                b=deleteFile(file.getAbsolutePath());
                if(!b) break;;
            }else {
                b=deleDireCtory(file.getAbsolutePath());
                if(!b) break;
            }
        }
        if(!b) return false;
        //删除当前目录
        if(dirFile.delete()){
            return true;
        }else {
            return false;
        }
    }

}
