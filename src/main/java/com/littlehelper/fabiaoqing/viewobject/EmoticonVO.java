package com.littlehelper.fabiaoqing.viewobject;

import lombok.Data;
import lombok.ToString;

/**
 * 表情包VO
 *
 * @author littlehelper
 * @date 2019-05-23
 */
@ToString
@Data
public class EmoticonVO {
    private String objectId;
    private String name;
    private String url;
}
