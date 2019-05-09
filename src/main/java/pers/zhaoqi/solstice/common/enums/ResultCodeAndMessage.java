package pers.zhaoqi.solstice.common.enums;

public class ResultCodeAndMessage {

    public static final Integer FAIL_CODE = -500;//错误代码
    public static final Integer WANT_CORRECT_INPUT = -501;//输入错误的代码
    public static final Integer LOGIN_ERROR = 666;//登录信息错误
    public static final Integer ID_ERROR = 503;//用于查询的ID错误

    public static final Integer FAIL_SAVA = -510;
    public static final String FAIL_SAVA_MESSAGE = "数据保存失败;";
    public static final String SUCCESS_SAVA_MESSAGE = "数据保存成功;";
    public static final Integer FAIL_QUERY = -514;
    public static final String FAIL_QUERY_MESSAGE = "查询数据失败;";
    public static final String SUCCESS_QUERY_MESSAGE = "数据保存成功;";

    public static final String FAIL_ENTITY_REPEAT = "数据发生重复;";
}
