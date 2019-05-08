package pers.zhaoqi.solstice.dictionary.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DataDictionaryInputDTO {
    private String key;
    private boolean isTree;
}
