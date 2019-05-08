package pers.zhaoqi.solstice.common.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ActionResult implements Serializable {
    private static final long serialVersionUID = 7033836260796589570L;
    public static final int SUCCESS_CODE = 10000;
    private int code;
    private String message;
    private Object data;
    private long timestamp = System.currentTimeMillis();

    public <T> T getData(Class<T> dataType) {
        return dataType.cast(this.data);
    }

    public boolean isSuccess() {
        return this.code == 10000;
    }
}
