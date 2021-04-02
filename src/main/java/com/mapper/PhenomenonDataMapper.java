package com.mapper;

import com.constant.Constant;
import com.pojo.EvidenceData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PhenomenonDataMapper {

    //
    @Insert("insert into evidence_data_14h values(null,"+ Constant.EstimatedBeats_14H +",#{evidenceData.actualBeats},#{evidenceData.maxBeatsLackTime},#{evidenceData.startTime},#{evidenceData.deviceSerial})")
    public void addEvidenceData14H(@Param("evidenceData") EvidenceData evidenceData);


}

