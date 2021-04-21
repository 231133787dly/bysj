package com.mapper;

import com.pojo.BeatsFault;
import com.pojo.BeatsPhenomenon;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RulesMapper {
    //获取所有的设备号
    @Select("select device_serial from device_serial_list")
    public List<String> getAllDeviceSerial();

    //获取所有的心跳现象规则
    @Select("select * from beats_phenomenon")
    @Results({
            @Result(id=true,property="phenomenonId",column="phenomenon_id",javaType=Integer.class),
            @Result(property="phenomenonName",column="phenomenon_name",javaType=String.class),
            @Result(property="beatsRateMax",column="beats_rate_max",javaType=Double.class),
            @Result(property="beatsRateMin",column="beats_rate_min",javaType=Double.class),
            @Result(property="lackTimeMax",column="lack_time_max",javaType=Double.class),
            @Result(property="lackTimeMin",column="lack_time_min",javaType=Double.class),
    })
    public List<BeatsPhenomenon> getAllBeatsPhenomenon();

    //获取所有的心跳故障规则
    @Select("select * from beats_fault_rule")
    @Results({
            @Result(id=true,property="id",column="id",javaType=Integer.class),
            @Result(property="faultId",column="fault_id",javaType=Integer.class),
            @Result(property="needPhenomenonId",column="need_phenomenon_id",javaType=Integer.class),
            @Result(property="needPhenomenonNum",column="need_phenomenon_num",javaType=Integer.class),
            @Result(property="needPhenomenonThreshold",column="need_phenomenon_threshold",javaType=Integer.class),
    })
    public List<BeatsFault> getAllBeatsFault();

    //删除11H基础数据
    @Delete("Delete from essential_data_11h where 1=1")
    public void deleteEssentialData11H();

    //删除12H基础数据
    @Delete("Delete from essential_data_12h where 1=1")
    public void deleteEssentialData12H();

    //删除14H基础数据
    @Delete("Delete from essential_data_14h where 1=1")
    public void deleteEssentialData14H();

    //删除18H基础数据
    @Delete("Delete from essential_data_18h where 1=1")
    public void deleteEssentialData18H();

    //删除11H证据
    @Delete("Delete from evidence_data_11h where 1=1")
    public void deleteEvidenceData11H();

    //删除12H证据
    @Delete("Delete from evidence_data_12h where 1=1")
    public void deleteEvidenceData12H();

    //删除14H证据
    @Delete("Delete from evidence_data_14h where 1=1")
    public void deleteEvidenceData14H();

    //删除18H证据
    @Delete("Delete from evidence_data_18h where 1=1")
    public void deleteEvidenceData18H();

    //删除现象
    @Delete("Delete from phenomenon_data where 1=1")
    public void deletePhenomenonData();

    //删除故障
    @Delete("Delete from fault_data where 1=1")
    public void deleteFaultData();
}
