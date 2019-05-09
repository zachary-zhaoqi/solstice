package pers.zhaoqi.solstice.dictionary.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.zhaoqi.solstice.dictionary.entity.DataDictionary;

import java.util.List;

/**
 * @author 陈亮
 * 数据字典树状结构
 */
@Data
@Accessors(chain = true)
public class DataDictionaryTreeDTO {

    private String title;

    private String value;

    private String key;

    public DataDictionary dataDictionary;

    private List<DataDictionaryTreeDTO> children;
}