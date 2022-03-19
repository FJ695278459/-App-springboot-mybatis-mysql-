package com.neuron.etl.model.master;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: FengJie
 * #Description: ApkInfo
 * #Date: 2021/5/25 23:19
 */
//安装包参数
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApkInfo {
    //
    private Integer Code;
    private String Msg;
    //是否更新(0:不更新,1:选择更新,2:强制更新)
    private Integer UpdateStatus;
    //更新版本号(客户端判断标识)
    private Integer VersionCode;
    //更新版本
    private String VersionName;
    //更新提示
    private String ModifyContent;
    //安装包下载地址
    private String DownloadUrl;
    //安装包大小
    private Integer ApkSize;
    //安装包MD5校验值
    private String ApkMd5;


    @JSONField(name = "Code")
    public Integer getCode() {
        return Code;
    }
    @JSONField(name = "Msg")
    public String getMsg() {
        return Msg;
    }
   @JSONField(name = "UpdateStatus")
    public Integer getUpdateStatus() {
        return UpdateStatus;
    }
    @JSONField(name = "VersionCode")
    public Integer getVersionCode() {
        return VersionCode;
    }
    @JSONField(name = "VersionName")
    public String getVersionName() {
        return VersionName;
    }
    @JSONField(name = "ModifyContent")
    public String getModifyContent() {
        return ModifyContent;
    }
    @JSONField(name = "DownloadUrl")
    public String getDownloadUrl() {
        return DownloadUrl;
    }
    @JSONField(name = "ApkSize")
    public Integer getApkSize() {
        return ApkSize;
    }
    @JSONField(name = "ApkMd5")
    public String getApkMd5() {
        return ApkMd5;
    }


}
