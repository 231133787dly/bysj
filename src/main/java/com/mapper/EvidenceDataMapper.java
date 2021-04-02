package com.mapper;

import com.constant.Constant;
import com.pojo.EssentialData11H;
import com.pojo.EvidenceData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EvidenceDataMapper {
    //插入18H的证据数据
    @Insert("insert into evidence_data_18h values(null,"+ Constant.EstimatedBeats_18H +",#{evidenceData.actualBeats},#{evidenceData.beatsRate},#{evidenceData.maxBeatsLackTime},#{evidenceData.startTime},#{evidenceData.deviceSerial})")
    public void addEvidenceData18H(@Param("evidenceData") EvidenceData evidenceData);

    //插入14H的证据数据
    @Insert("insert into evidence_data_14h values(null,"+ Constant.EstimatedBeats_14H +",#{evidenceData.actualBeats},#{evidenceData.beatsRate},#{evidenceData.maxBeatsLackTime},#{evidenceData.startTime},#{evidenceData.deviceSerial})")
    public void addEvidenceData14H(@Param("evidenceData") EvidenceData evidenceData);

    //插入12H的证据数据
    @Insert("insert into evidence_data_12h values(null,"+ Constant.EstimatedBeats_12H +",#{evidenceData.actualBeats},#{evidenceData.beatsRate},#{evidenceData.maxBeatsLackTime},#{evidenceData.startTime},#{evidenceData.deviceSerial})")
    public void addEvidenceData12H(@Param("evidenceData") EvidenceData evidenceData);

    //插入11H的证据数据
    @Insert("insert into evidence_data_11h values(null,"+ Constant.EstimatedBeats_11H +",#{evidenceData.actualBeats},#{evidenceData.beatsRate},#{evidenceData.maxBeatsLackTime},#{evidenceData.startTime},#{evidenceData.deviceSerial})")
    public void addEvidenceData11H(@Param("evidenceData") EvidenceData evidenceData);

}
