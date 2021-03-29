package com.service;

import com.constant.Constant;
import com.mapper.EssentialDataMapper;
import com.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EssentialDataService {

    @Autowired
    private EssentialDataMapper essentialDataMapper;
    //根据类型插入基础数据
    public void insertEssentialData(List<? extends EssentialData> essentialDataList, String type){
            switch (type){
                case Constant.Type_18H :
                    for (EssentialData essentialData: essentialDataList) {
                        log.info(String.valueOf(essentialData));
                        essentialDataMapper.addEssentialData18H((EssentialData18H) essentialData);
                    }
                    break;
                case Constant.Type_14H :
                    for (EssentialData essentialData: essentialDataList) {
                        log.info(String.valueOf(essentialData));
                        essentialDataMapper.addEssentialData14H((EssentialData14H) essentialData);
                    }
                    break;
                case Constant.Type_12H :
                    for (EssentialData essentialData: essentialDataList) {
                        log.info(String.valueOf(essentialData));
                        essentialDataMapper.addEssentialData12H((EssentialData12H) essentialData);
                    }
                    break;
                case Constant.Type_11H :
                    for (EssentialData essentialData: essentialDataList) {
                        log.info(String.valueOf(essentialData));
                        essentialDataMapper.addEssentialData11H((EssentialData11H) essentialData);
                    }
                    break;
            }
    }
}
