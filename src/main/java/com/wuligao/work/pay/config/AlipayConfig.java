package com.wuligao.work.pay.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author wuligao
 * @date 2020-03-11
 */
public class AlipayConfig {

    /**
     * 网关沙箱(测试环境)
     */
    private static final String URL = "https://openapi.alipaydev.com/gateway.do";

    /**
     * appId
     */
    private static final String ALIPAY_APPID = "";
    /**
     * 私钥
     */
    private static String APP_PRIVATE_KEY = "";

    /**
     * 支付宝公钥
     */
    private static String ALIPAY_PUBLIC_KEY = "";

    /**
     * 签名算法类型(根据生成私钥的算法,RSA2或RSA)
     */
    private static final String SIGNTYPE = "RSA2";

    /**
     * 请求数据格式
     */
    private static final String FORMAT = "json";
    /**
     * 编码格式
     */
    private static final String CHARSET = "utf-8";

    /**
     * 服务器异步通知页面路径  需http://或者https://格式的完整路径
     * 不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static final String OWnotify_url = "";//网站扫码
    /**
     * 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，
     * 不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
     */
    public static final String OWreturn_url = "";//网站扫码

    // 统一收单交易创建接口
    private static AlipayClient alipayClient = null;

    /**获得初始化的AlipayClient
     * @return 支付宝客户端
     */
    public static AlipayClient getAlipayClient() {
        if (alipayClient == null) {
            synchronized (AlipayConfig.class) {
                if (null == alipayClient) {
                    alipayClient = new DefaultAlipayClient(URL, ALIPAY_APPID, APP_PRIVATE_KEY, FORMAT, CHARSET,ALIPAY_PUBLIC_KEY,SIGNTYPE);
                }
            }
        }
        return alipayClient;
    }
}

