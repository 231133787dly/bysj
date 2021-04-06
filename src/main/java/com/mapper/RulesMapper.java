package com.mapper;

import com.pojo.BeatsPhenomenon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
}
