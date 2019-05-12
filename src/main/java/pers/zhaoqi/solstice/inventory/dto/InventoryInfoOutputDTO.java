package pers.zhaoqi.solstice.inventory.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class InventoryInfoOutputDTO {
    private String name;
    private String batchSn;
    private String barCode;
    private String categoryName;
    private String brandName;
    private String specification;
    private Integer number;
    private LocalDateTime modifyTime;
}
