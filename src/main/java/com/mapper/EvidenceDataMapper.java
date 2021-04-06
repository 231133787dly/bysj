package com.mapper;

import com.constant.Constant;
import com.pojo.EssentialData11H;
import com.pojo.EvidenceData;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    //通过设备号和时间获取18H证据表中的数据
    @Select("select * from evidence_data_18h where device_serial=#{deviceSerial} and start_time >= #{startTime} and start_time < #{endTime}")
    @Results({
            @Result(id=true,property="id",column="id",javaType=Integer.class),
            @Result(property="estimatedBeats",column="estimated_beats",javaType=Integer.class),
            @Result(property="actualBeats",column="actual_beats",javaType=Integer.class),
            @Result(property="beatsRate",column="beats_rate",javaType=Double.class),
            @Result(property="maxBeatsLackTime",column="max_beats_lack_time",javaType=Double.class),
            @Result(property="startTime",column="start_time",javaType=String.class),
            @Result(property="deviceSerial",column="device_serial",javaType=String.class),
    })
    public List<EvidenceData> getEvidenceData18HByDAT(@Param("deviceSerial") String deviceSerial, @Param("startTime") String startTime, @Param("endTime") String endTime);

    //通过设备号和时间获取14H证据表中的数据
    @Select("select * from evidence_data_14h where device_serial=#{deviceSerial} and start_time >= #{startTime} and start_time < #{endTime}")
    @Results({
            @Result(id=true,property="id",column="id",javaType=Integer.class),
            @Result(property="estimatedBeats",column="estimated_beats",javaType=Integer.class),
            @Result(property="actualBeats",column="actual_beats",javaType=Integer.class),
            @Result(property="beatsRate",column="beats_rate",javaType=Double.class),
            @Result(property="maxBeatsLackTime",column="max_beats_lack_time",javaType=Double.class),
            @Result(property="startTime",column="start_time",javaType=String.class),
            @Result(property="deviceSerial",column="device_serial",javaType=String.class),
    })
    public List<EvidenceData> getEvidenceData14HByDAT(@Param("deviceSerial") String deviceSerial, @Param("startTime") String startTime, @Param("endTime") String endTime);

    //通过设备号和时间获取12H证据表中的数据
    @Select("select * from evidence_data_12h where device_serial=#{deviceSerial} and start_time >= #{startTime} and start_time < #{endTime}")
    @Results({
            @Result(id=true,property="id",column="id",javaType=Integer.class),
            @Result(property="estimatedBeats",column="estimated_beats",javaType=Integer.class),
            @Result(property="actualBeats",column="actual_beats",javaType=Integer.class),
            @Result(property="beatsRate",column="beats_rate",javaType=Double.class),
            @Result(property="maxBeatsLackTime",column="max_beats_lack_time",javaType=Double.class),
            @Result(property="startTime",column="start_time",javaType=String.class),
            @Result(property="deviceSerial",column="device_serial",javaType=String.class),
    })
    public List<EvidenceData> getEvidenceData12HByDAT(@Param("deviceSerial") String deviceSerial, @Param("startTime") String startTime, @Param("endTime") String endTime);

    //通过设备号和时间获取11H证据表中的数据
    @Select("select * from evidence_data_11h where device_serial=#{deviceSerial} and start_time >= #{startTime} and start_time < #{endTime}")
    @Results({
            @Result(id=true,property="id",column="id",javaType=Integer.class),
            @Result(property="estimatedBeats",column="estimated_beats",javaType=Integer.class),
            @Result(property="actualBeats",column="actual_beats",javaType=Integer.class),
            @Result(property="beatsRate",column="beats_rate",javaType=Double.class),
            @Result(property="maxBeatsLackTime",column="max_beats_lack_time",javaType=Double.class),
            @Result(property="startTime",column="start_time",javaType=String.class),
            @Result(property="deviceSerial",column="device_serial",javaType=String.class),
    })
    public List<EvidenceData> getEvidenceData11HByDAT(@Param("deviceSerial") String deviceSerial, @Param("startTime") String startTime, @Param("endTime") String endTime);

}
