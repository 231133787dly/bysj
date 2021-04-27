package com.mapper;

import com.constant.Constant;
import com.pojo.BeatsPhenomenon;
import com.pojo.EvidenceData;
import com.pojo.PhenomenonData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PhenomenonDataMapper {

    //写入现象
    @Insert("insert into phenomenon_data values(null,#{phenomenonData.phenomenonId},#{phenomenonData.startTime},#{phenomenonData.deviceSerial},#{phenomenonData.evidenceNum},#{phenomenonData.evidenceFrom},#{phenomenonData.phenomenonThreshold})")
    public void addPhenomenonData(@Param("phenomenonData") PhenomenonData phenomenonData);

    //通过设备号和时间获取现象表中的数据
    @Select("select * from phenomenon_data where device_serial=#{deviceSerial} and start_time >= #{startTime} and start_time < #{endTime}")
    @Results({
            @Result(id=true,property="id",column="id",javaType=Integer.class),
            @Result(property="phenomenonId",column="phenomenon_id",javaType=Integer.class),
            @Result(property="startTime",column="start_time",javaType=String.class),
            @Result(property="deviceSerial",column="device_serial",javaType=String.class),
            @Result(property="evidenceNum",column="evidence_num",javaType=Integer.class),
            @Result(property="evidenceFrom",column="evidence_from",javaType=String.class),
            @Result(property="phenomenonThreshold",column="phenomenon_threshold",javaType=Integer.class)
    })
    public List<PhenomenonData> getPhenomenonDataByDAT(@Param("deviceSerial") String deviceSerial, @Param("startTime") String startTime, @Param("endTime") String endTime);

    //获取现象表中的数据
    @Select("select * from phenomenon_data")
    @Results({
            @Result(id=true,property="id",column="id",javaType=Integer.class),
            @Result(property="phenomenonId",column="phenomenon_id",javaType=Integer.class),
            @Result(property="startTime",column="start_time",javaType=String.class),
            @Result(property="deviceSerial",column="device_serial",javaType=String.class),
            @Result(property="evidenceNum",column="evidence_num",javaType=Integer.class),
            @Result(property="evidenceFrom",column="evidence_from",javaType=String.class),
            @Result(property="phenomenonThreshold",column="phenomenon_threshold",javaType=Integer.class)
    })
    public List<PhenomenonData> getPhenomenonData();

    //获取现象规则
    @Select("select * from beats_phenomenon")
    @Results({
            @Result(id=true,property="phenomenonId",column="phenomenon_id",javaType=Integer.class),
            @Result(property="phenomenonName",column="phenomenon_name",javaType=String.class),
            @Result(property="beatsRateMax",column="beats_rate_max",javaType=Double.class),
            @Result(property="beatsRateMin",column="beats_rate_min",javaType=Double.class),
            @Result(property="lackTimeMax",column="lack_time_max",javaType=Double.class),
            @Result(property="lackTimeMin",column="lack_time_min",javaType=Double.class)
    })
    public List<BeatsPhenomenon> getPhenomenonRules();
}