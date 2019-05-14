package pers.zhaoqi.solstice;

import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zhaoqi.solstice.dictionary.controller.DataDictionaryControllerTest;
import pers.zhaoqi.solstice.inventory.entity.InventoryOperation;
import pers.zhaoqi.solstice.inventory.service.IInventoryOperationService;
import pers.zhaoqi.solstice.inventory.service.impl.InventoryOperationServiceImpl;
import pers.zhaoqi.solstice.inventory.service.impl.InventoryOperationServiceImplTest;

@MapperScan("pers.zhaoqi.solstice.*.mapper")
@RunWith(SpringRunner.class)
@SpringBootTest
public class SolsticeApplicationTests {

    @Test
    public void contextLoads() {
    }


}
