package pers.zhaoqi.solstice.common.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ActionResult implements Serializable {
    private static final long serialVersionUID = 7033836260796589570L;
    public static final int SUCCESS_CODE = 10000;
    private int code;//标记代码
    private String message;//返回的消息
    private Object data;//当成功的时候放的对象
    private long timestamp = System.currentTimeMillis();//时间戳

    public <T> T getData(Class<T> dataType) {
        return dataType.cast(this.data);
    }

    public boolean isSuccess() {
        return this.code == 10000;
    }
}
