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

    public DataDictionary getDataDictionary() {
        return dataDictionary;
    }

    public void setDataDictionary(DataDictionary dataDictionary) {
        this.dataDictionary = dataDictionary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<DataDictionaryTreeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<DataDictionaryTreeDTO> children) {
        this.children = children;
    }
}
