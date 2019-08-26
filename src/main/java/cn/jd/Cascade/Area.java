package cn.jd.Cascade;

import lombok.Data;

import java.util.List;

@Data
public class Area {

    int ID;
    int TopID;
    String AddName;

    //下级列表
    List<Area> downList;
}
