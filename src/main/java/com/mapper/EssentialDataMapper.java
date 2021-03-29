package com.mapper;

import com.pojo.EssentialData11H;
import com.pojo.EssentialData12H;
import com.pojo.EssentialData14H;
import com.pojo.EssentialData18H;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EssentialDataMapper {
    //插入18H数据
    @Insert("insert into essential_data_18h values(#{essentialData18H.id},#{essentialData18H.gpsStatus},#{essentialData18H.deviceSerial},#{essentialData18H.datetime})")
    @Options(keyProperty="essentialData18H.id",useGeneratedKeys=true)
    public void addEssentialData18H(@Param("essentialData18H") EssentialData18H essentialData18H);

    //插入14H数据
    @Insert("insert into essential_data_14h values(#{essentialData14H.id},#{essentialData14H.latitude},#{essentialData14H.longitude},#{essentialData14H.speed},#{essentialData14H.vehicleStatus},#{essentialData14H.deviceSerial},#{essentialData14H.datetime})")
    @Options(keyProperty="essentialData14H.id",useGeneratedKeys=true)
    public void addEssentialData14H(@Param("essentialData14H") EssentialData14H essentialData14H);

    //插入12H数据
    @Insert("insert into essential_data_12h values(#{essentialData12H.id},#{essentialData12H.latitude},#{essentialData12H.longitude},#{essentialData12H.deviceSerial},#{essentialData12H.datetime})")
    @Options(keyProperty="essentialData12H.id",useGeneratedKeys=true)
    public void addEssentialData12H(@Param("essentialData12H") EssentialData12H essentialData12H);

    //插入11H数据
    @Insert("insert into essential_data_11h values(#{essentialData11H.id},#{essentialData11H.latitude},#{essentialData11H.longitude},#{essentialData11H.speed},#{essentialData11H.vehicleStatus},#{essentialData11H.deviceSerial},#{essentialData11H.datetime},#{essentialData11H.routeId})")
    @Options(keyProperty="essentialData11H.id",useGeneratedKeys=true)
    public void addEssentialData11H(@Param("essentialData11H") EssentialData11H essentialData11H);

    //获取所有的18H表中的数据
    @Select("select * from essential_data_18h")
    @Results({
            @Result(id=true,property="id",column="id",javaType=Integer.class),
            @Result(property="gpsStatus",column="gps_status",javaType=String.class),
            @Result(property="deviceSerial",column="device_serial",javaType=String.class),
            @Result(property="datetime",column="datetime",javaType=String.class)
    })
    public List<EssentialData18H> getAllEssentialData18H();

    //通过设备号获取18H表中的数据
    @Select("select * from essential_data_18h where device_serial=#{deviceSerial}")
    @Results({
            @Result(id=true,property="id",column="id",javaType=Integer.class),
            @Result(property="gpsStatus",column="gps_status",javaType=String.class),
            @Result(property="deviceSerial",column="device_serial",javaType=String.class),
            @Result(property="datetime",column="datetime",javaType=String.class)
    })
    public List<EssentialData18H> getEssentialData18HByDeviceSerial(@Param("deviceSerial") String deviceSerial);


    //获取所有的设备号
    @Select("select device_serial from device_serial_list")
    public List<String> getAllDeviceSerial();
}
