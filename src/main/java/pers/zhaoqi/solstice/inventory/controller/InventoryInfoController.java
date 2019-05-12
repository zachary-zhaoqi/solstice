package pers.zhaoqi.solstice.inventory.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.inventory.entity.InventoryInfo;

/**
 * <p>
 * 库存表 前端控制器
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@RestController
@RequestMapping("/inventory/inventoryInfo")
public class InventoryInfoController {

    /**
     * @author zhaoqi
     * @param inventoryInfoInputDTO
     * @return
     */
    @GetMapping
    public ActionResult queryInventoryInfo(@RequestBody InventoryInfoInputDTO inventoryInfoInputDTO){

        return null;
    }
}
