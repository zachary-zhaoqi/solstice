package pers.zhaoqi.solstice.common.enums;

public class ResultCodeAndMessage {

    public static final Integer FAIL_CODE = 500;//错误代码
    public static final Integer WANT_CORRECT_INPUT = 501;//输入错误的代码
    public static final Integer LOGIN_ERROR = 401;//登录信息错误
    public static final Integer ID_ERROR = 503;//用于查询的ID错误

    public static final Integer FAIL_SAVA = 511;
    public static final String FAIL_SAVA_MESSAGE = "数据保存失败;";
    public static final String SUCCESS_SAVA_MESSAGE = "数据保存成功;";
    public static final Integer FAIL_REMOVE = 512;
    public static final String SUCCESS_REMOVE_MESSAGE = "数据删除成功;";
    public static final String FAIL_REMOVE_MESSAGE = "数据删除失败;";
    //todo 陈亮：帮我加个
    // 数据修改
    public static final Integer FAIL_QUERY = 514;
    public static final String FAIL_QUERY_MESSAGE = "数据查询失败;";
    public static final String SUCCESS_QUERY_MESSAGE = "数据查询成功;";

    public static final String FAIL_INPUT_DATA_REPEAT = "传入数据发生重复;";
    public static final String SELECT_NULL = "查询为空;";
}
