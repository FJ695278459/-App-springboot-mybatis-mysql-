package com.neuron.etl.service.master;

import com.neuron.etl.model.master.AppMag;
import java.util.*;
/**
 * @Author: FengJie
 * #Description: SysMapSercice
 * #Date: 2021/6/7 14:27
 *
 */

//app的一些属性，版本号的使用个数
public interface SysMapSercice {
    void inserAppmag(AppMag appMag);
    AppMag selectAppmagOne(String versioncode);
    List<Object> selectAppmagAll();
    void updateAppmagnum(String version);
}
