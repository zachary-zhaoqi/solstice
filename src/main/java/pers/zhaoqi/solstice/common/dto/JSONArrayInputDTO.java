package pers.zhaoqi.solstice.common.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: starr
 * @Date: 2019/5/11 20:12
 **/
@Data
@Accessors(chain = true)
public class JSONArrayInputDTO<T> implements Serializable {
    private List<T> list;
}
