package com.neuron.etl.service.master.impl;

import com.alibaba.fastjson.JSONArray;
import com.neuron.etl.mapper.master.SysSonMapper;
import com.neuron.etl.model.master.*;
import com.neuron.etl.service.master.SysSonService;
import com.neuron.etl.service.master.web.WebScoteAll;
import com.neuron.etl.util.InFile;
import com.neuron.etl.util.Inti;
import com.neuron.etl.util.Ramdnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author: FengJie
 * #Description: SysSonServiceImpl
 * #Date: 2021/5/21 22:39
 */
@Service
public class SysSonServiceImpl implements SysSonService {
    @Autowired
    private SysSonMapper sysSonMapper;
    @Autowired
    private WebScoteAll webScoteAll;

    @Override
    public void insertSon(Son son) {
        sysSonMapper.insert(son);
    }

    @Override
    public void UpdatePak(String id) {
        sysSonMapper.updataPak(id);
    }

    @Override
    public Zf selectNumPak(String id) {
        return sysSonMapper.selectNum(id);
    }

    @Override
    public Son selectSon(String id) {
        return sysSonMapper.selectSon(id);
    }

    @Override
    public void InsertNotecard(Notecard notecard) {
         sysSonMapper.insertnotecard(notecard);
    }

    @Override
    public Notecard SelectNotecard(String id) {
        return sysSonMapper.selectnotecard(id);
    }
    @Override
    public void updatazf(String id) {
        sysSonMapper.updatazf(id);
    }

    @Override
    public Mag selectmag() {
        return sysSonMapper.selectmag();
    }

    @Override
    public void updatahomemag(Mag mag) {
        try {
            webScoteAll.onMessage(String.valueOf(Inti.GetJson(mag)),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sysSonMapper.updatahomemag(mag);
    }

    @Override
    public List<Object> selectnotecardall() {
        return sysSonMapper.selectnotecardall();
    }

    @Override
    public List<Object> selectfeedbackall() {
        return sysSonMapper.selectfeedbackall();
    }

    @Override
    public void insertFeedback(Feedback feedback){
        sysSonMapper.insertfeedback(feedback);
    }

    @Override
    public List<Object> selectFeedbackUserid(String userid) {
        return sysSonMapper.selectfeedbackUserid(userid);
    }

    @Override
    public List<Object> SelsctAllLike(String str) {
        return sysSonMapper.SelsctAllLike(str);
    }

    @Override
    public String SelectToken(String userid) {
        return sysSonMapper.SelsctToken(userid);
    }
}
