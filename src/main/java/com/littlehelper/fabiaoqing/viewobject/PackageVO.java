package com.littlehelper.fabiaoqing.viewobject;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 表情包分组VO
 *
 * @author littlehelper
 * @date 2019-05-23
 */
@ToString
@Data
public class PackageVO {
    private String objectId;
    private String name;
    private Integer count;
    private List<EmoticonVO> list;
}
