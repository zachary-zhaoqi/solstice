package pers.zhaoqi.solstice.common.result;

public class Result {
    public Result() {
    }

    public static ActionResult success() {
        return success("处理成功");
    }

    public static ActionResult success(String message) {
        return success(message, (Object)null);
    }

    public static ActionResult success(Object data) {
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(10000);
        actionResult.setMessage("处理成功");
        actionResult.setData(data);
        return actionResult;
    }

    public static ActionResult success(String message, Object data) {
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(10000);
        actionResult.setMessage(message);
        actionResult.setData(data);
        return actionResult;
    }

    public static ActionResult failed(int code) {
        return failed(code, (String)null);
    }

    public static ActionResult failed(int code, String message) {
        return failed(code, message, (Object)null);
    }

    public static ActionResult failed(int code, Object data) {
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(code);
        actionResult.setMessage("失败");
        actionResult.setData(data);
        return actionResult;
    }

    public static ActionResult failed(int code, String message, Object data) {
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(code);
        actionResult.setMessage(message);
        actionResult.setData(data);
        return actionResult;
    }
}
