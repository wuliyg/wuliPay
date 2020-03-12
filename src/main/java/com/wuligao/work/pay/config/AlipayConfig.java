package com.wuligao.work.pay.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author wuligao
 * @date 2020-03-11
 */
@Configuration
public class AlipayConfig {

    /**
     * 网关沙箱(测试环境)
     */
    private static final String URL = "";

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
    private static final String SIGNTYPE = "RSA";

    /**
     * 请求数据格式
     */
    private static final String FORMAT = "json";
    /**
     * 编码格式
     */
    private static final String CHARSET = "utf-8";


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

