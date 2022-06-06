package com.cream.utils;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000117630990";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCHop2LgBmHZz9Ow03ip2wkSbdgIbSPQPOylFbvRaip51/uvG85hbt0H46v5Ts0rylGDSieooNnt3nL0cvz2bcuT6wB7i3VqBu/L/IN4g5JgYkC2o/AChdlBu3WSHoAL3RVzYKwkU2BtWQqBxWgLwLG+viopcgA4OWrMrybW3R9nq+oi0goBqGNYuqfpEfYWXUBnpoa9jijYAuBcS1YyTNO63+qpbA9Cx6gFPKvubSpuQdzuA7pyQwEJTa4ANjSWaz+axO1DK8Cpp+QPIkKHg8fnjExsa69hl+QBO9+FU+0bNUpCKQ+dBcvgkSFpu0LbzRQF2DVCP4jFVgghmVm3/1BAgMBAAECggEAeNEgNqfHlbYhTT5o/TEXAgfr4SSE2moH6ZV7Dq1k/NsNt/F/vaRjAqAtkH7HSzmPsUd9XDj0hgmH40cgvji7k/QCCsInb77L4HSLz1QCV/WbnsAi9fPHPQV8C7kJe2rJ3Lgv5qm3eYejDlC7MbFObwIVRtxNGIM78VBDcrt3O4E3cy52+H2CWttY7Ur26ai3CN1sCCEFgnCcJZYMQPevKJ+jdSjQ4pwSAoBJLesJGO6cD2JziMSZK9FG/CxTBNaUzBhiBniLiNpugpvB0DQQ/0DKReg69o4t0avcFkcvkwtKW86ZjBiJRhYoW5SkhR3bbqxsV1W4s7tQztstB4MQsQKBgQC++zc0CYGtBXTMpoMX6AOAvdm11PlypSMn6HbxgsSAqq1Z6v6qSJLTdBDQ79HajtivgY9Hcgv58NgnMqnsF5Ic36sg8lJ6DQO6hJp3Ve4h77pnsZK4ctkKrz+mbPy2nRWkRx0tlSamuWqClM02bUSNcmd4A/aQTR/hy7vg0GAprQKBgQC1z8Q38V3HF+jEmkEf2dCGOfznytgH2W+ccgWoeiI4EkeBW7Ok2GL+9111CdzU6Jdt668yiJly/QswqJQQRqrpPUeF+bZF82VEQ1aWdJr+Eav0qE0XbGq3pgW4Mrrk0LmRmYBVcJHUpRaKePKoC+yh9fyWDd+tjVIiWQk+3zc8ZQKBgALaV9nEJpbCFRuVhTHPOnYq39yygMNwqhTHiTdUX8EYS5yjQQikKuVTv4iPfJAKQDxm8A/+KSWjrmbvf9BSDdG2maTVWdwO47ZekrwjoXoKTbuM0IdG1+0r7wR6blAACrm4gjwTFU+6R1gKBwLAIR0Hz3ngfUdsj4Rc+cKC+lzFAoGBALOadGcjPBWii+Iz0+PIA1Ol0y2T14chiD1O8kH1rPohLJwgX72XuWvQJ3Wn8Ywt3PHMYn0ULipGyRgfYG0XslzImXBDN4mwoLgnoVDuDfKwuGLvI4DhLCcRjhLhonjJrJelwP4mPxmGoFbYljXl2bRBUW1WdUF4GswtkpGWZnV1AoGBAIb95C8cBrMLdpk2EQ+NGE3fc9y65rz4vShgkDRhOcYxvmDs5NY6RZhXqBnzc7AzKSVuR9bXXPGIWkqZx1ToTsMZnvbEZSoEPsFtGTf6sogR/U75kjtgJHRx6VtIgrTfWSdVxYrvdeS15X+oYtYwKRJtRNRFbDeC28BGbrxwYubf";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuYPJwLwbLBOVpngwf05tuz4HQyrTDVW9yTGAOowuGTI2Z8iR67ECdtCPIic334tm2sPAHDhS31xfQjGRP4q6LckHjhUSdsVK1uLzGzNI+6Z1Q2f//CIuAgqJzb/yUuZRp/wasPcxn/7lJJpIWn8ATOTRT1QvyX4jzfAZjCi36uAhyB+ExOZo4AKArysFyZiLWP9JVhmxuAtHiV4KBTumINm8Vrl0T5KKl1ELjg1t5TRRKkSmfv9uvXwE3XVVm7WpvF4yc08zb2cpVMFEP5gYe8UPydF4G/I8ZK1nLPVUegojI2KYXNOu8jIVhiuovDre5hLmCdgVReTiTAl9Fh0q1wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/order/callBack";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
