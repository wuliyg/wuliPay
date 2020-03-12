package com.wuligao.work.pay.test;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.BaseClient.Config;
import com.alipay.easysdk.payment.common.models.AlipayTradeCreateResponse;

/**
 * @author wuligao
 * @date 2020/3/12 13:18
 */
public class AliPayTest {
    public static void main(String[] args) {
        // 1. 设置参数（全局只需设置一次）
        Factory.setOptions(getOptions());
        try {
            // 2. 发起API调用（以支付能力下的统一收单交易创建接口为例）
            AlipayTradeCreateResponse response = null;
            // AlipayTradeCreateResponse response = Factory.Payment().create("Apple iPhone11 128G","2234567890", "5799.00", "2088002656718920")
            // 3. 处理响应或异常
            if ("10000".equals(response.code)) {
                System.out.println("调用成功");
            } else {
                System.err.println("调用失败，原因：" + response.msg + "，" + response.subMsg);
            }
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static Config getOptions() {
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipay.com";
        config.signType = "RSA2";

        // 请更换为您的AppId
        config.appId = "2019091767145019";
        // 请更换为您的应用公钥证书文件路径
        config.merchantCertPath = "/home/foo/appCertPublicKey_2019051064521003.crt";
        // 请更换为您的支付宝公钥证书文件路径
        config.alipayCertPath = "/home/foo/alipayCertPublicKey_RSA2.crt";
        // 请更换为您的支付宝根证书文件路径
        config.alipayRootCertPath = "/home/foo/alipayRootCert.crt";
        // 请更换为您的PKCS8格式的应用私钥
        config.merchantPrivateKey = "MIIEvQIBADANB ... ...";

        // 如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        // config.alipayPublicKey = "MIIBIjANBg...";
        return config;
    }
}
