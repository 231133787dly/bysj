package com.utils;

import com.constant.Constant;
import com.pojo.*;
import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Excel {

    public static List<? extends EssentialData> csvReadOperation(String pathname,String type) throws IOException {
        File file = new File(pathname);
        CsvReader csvReader = new CsvReader();
        CsvContainer csv = csvReader.read(file, StandardCharsets.UTF_8);
        switch (type){
            case Constant.Type_18H: {
                List<EssentialData18H> listEssentialData = new ArrayList<>();
                for (CsvRow row : csv.getRows()) {
                    //log.info("Read line: " + row);log.info("First column of line: " + row.getField(0));
                    if (row.getOriginalLineNumber() != 1) {
                        EssentialData18H resultInfo = new EssentialData18H();
                        resultInfo.setId(Integer.parseInt(row.getField(0)));
                        resultInfo.setGpsStatus(row.getField(1));
                        resultInfo.setDeviceSerial(row.getField(2));
                        resultInfo.setDatetime(row.getField(3));
                        listEssentialData.add(resultInfo);
                    }
                }
                return listEssentialData;
            }
            case Constant.Type_14H: {
                List<EssentialData14H> listEssentialData = new ArrayList<>();
                for (CsvRow row : csv.getRows()) {
                    if (row.getOriginalLineNumber() != 1) {
                        EssentialData14H resultInfo = new EssentialData14H();
                        resultInfo.setId(Integer.parseInt(row.getField(0)));
                        resultInfo.setLatitude(row.getField(1));
                        resultInfo.setLongitude(row.getField(2));
                        resultInfo.setSpeed(Integer.parseInt(row.getField(3)));
                        resultInfo.setVehicleStatus(row.getField(4));
                        resultInfo.setDeviceSerial(row.getField(5));
                        resultInfo.setDatetime(row.getField(6));

                        listEssentialData.add(resultInfo);
                    }
                }
                return listEssentialData;
            }
            case Constant.Type_12H: {
                List<EssentialData12H> listEssentialData = new ArrayList<>();
                for (CsvRow row : csv.getRows()) {
                    if (row.getOriginalLineNumber() != 1) {
                        EssentialData12H resultInfo = new EssentialData12H();
                        resultInfo.setId(Integer.parseInt(row.getField(0)));
                        resultInfo.setLatitude(row.getField(1));
                        resultInfo.setLongitude(row.getField(2));
                        resultInfo.setDeviceSerial(row.getField(3));
                        resultInfo.setDatetime(row.getField(4));

                        listEssentialData.add(resultInfo);
                    }
                }
                return listEssentialData;
            }
            case Constant.Type_11H: {
                List<EssentialData11H> listEssentialData = new ArrayList<>();
                for (CsvRow row : csv.getRows()) {
                    if (row.getOriginalLineNumber() != 1) {
                        EssentialData11H resultInfo = new EssentialData11H();
                        resultInfo.setId(Integer.parseInt(row.getField(0)));
                        resultInfo.setLatitude(row.getField(1));
                        resultInfo.setLongitude(row.getField(2));
                        resultInfo.setSpeed(Integer.parseInt(row.getField(3)));
                        resultInfo.setVehicleStatus(row.getField(4));
                        resultInfo.setDeviceSerial(row.getField(5));
                        resultInfo.setDatetime(row.getField(6));
                        resultInfo.setRouteId(Integer.parseInt(row.getField(7)));

                        listEssentialData.add(resultInfo);
                    }
                }
                return listEssentialData;
            }
            default: return null;
        }
    }

}
