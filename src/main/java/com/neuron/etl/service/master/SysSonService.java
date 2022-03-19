package com.neuron.etl.service.master;

import com.alibaba.fastjson.JSONArray;
import com.neuron.etl.model.master.*;
import com.neuron.etl.util.InFile;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: FengJie
 * #Description: SysSonService
 * #Date: 2021/5/21 22:36
 */
public interface SysSonService {
    void insertSon(Son son);
    void UpdatePak(String id);
    Zf selectNumPak(String id);
    Son selectSon(String id);
    void InsertNotecard(Notecard notecard);
    Notecard SelectNotecard(String id);
    void updatazf(String id);
    Mag selectmag();
    void updatahomemag(Mag mag);
    List<Object> selectnotecardall();
    List<Object> selectfeedbackall();
    void insertFeedback(Feedback feedback);
    List<Object>  selectFeedbackUserid(String userid);
    List<Object>   SelsctAllLike(String str);
    String SelectToken(String userid);
}
