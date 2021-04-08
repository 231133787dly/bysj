package com.mapper;

import com.pojo.PhenomenonData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FaultDataMapper {
    //写入现象
    @Insert("insert into phenomenon_data values(null,#{phenomenonData.phenomenonId},#{phenomenonData.startTime},#{phenomenonData.deviceSerial},#{phenomenonData.evidenceNum},#{phenomenonData.evidenceFrom},#{phenomenonData.phenomenonThreshold})")
    public void addPhenomenonData(@Param("phenomenonData") PhenomenonData phenomenonData);

}
