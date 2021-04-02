package com.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RulesMapper {
    //获取所有的设备号
    @Select("select device_serial from device_serial_list")
    public List<String> getAllDeviceSerial();
}
