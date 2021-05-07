package com.mapper;

import com.pojo.BeatsFault;
import com.pojo.BeatsFaultName;
import com.pojo.FaultData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FaultDataMapper {
    //写入故障
    @Insert("insert into fault_data values(null,#{faultData.faultId},#{faultData.startTime},#{faultData.deviceSerial},#{faultData.faultCount})")
    public void addFaultData(@Param("faultData") FaultData faultData);

    //故障+1 UPDATE Person SET FirstName = 'Fred' WHERE LastName = 'Wilson'
    @Update("update fault_data set fault_count = fault_count + 1 where fault_id =#{faultId}")
    public void plusFaultData(@Param("faultId") int faultId);

    //通过故障id、设备号和时间获取故障
    @Select("select COUNT(*) from fault_data where fault_id =#{faultId} and device_serial=#{deviceSerial} and start_time >= #{startTime} and start_time < #{endTime}")
    public int hasFault(@Param("faultId") int faultId,@Param("deviceSerial") String deviceSerial, @Param("startTime") String startTime, @Param("endTime") String endTime);

    //获取故障数据
    @Select("select * from fault_data")
    @Results({
            @Result(id=true,property="id",column="id",javaType=Integer.class),
            @Result(property="faultId",column="fault_id",javaType=Integer.class),
            @Result(property="startTime",column="start_time",javaType=String.class),
            @Result(property="deviceSerial",column="device_serial",javaType=String.class),
            @Result(property="faultCount",column="fault_count",javaType=Integer.class),
    })
    public List<FaultData> getFaultData();

    //获取故障规则
    @Select("select * from beats_fault_rule")
    @Results({
            @Result(id=true,property="id",column="id",javaType=Integer.class),
            @Result(property="faultId",column="fault_id",javaType=Integer.class),
            @Result(property="needPhenomenonId",column="need_phenomenon_id",javaType=Integer.class),
            @Result(property="needPhenomenonNum",column="need_phenomenon_num",javaType=Integer.class),
            @Result(property="needPhenomenonThreshold",column="need_phenomenon_threshold",javaType=Double.class),
    })
    public List<BeatsFault> getFaultRules();

    //获取故障名
    @Select("select * from fault_info")
    @Results({
            @Result(id=true,property="faultId",column="fault_id",javaType=Integer.class),
            @Result(property="faultName",column="fault_name",javaType=String.class),
            @Result(property="faultDevice",column="fault_device",javaType=String.class),
    })
    public List<BeatsFaultName> getFault();
}
