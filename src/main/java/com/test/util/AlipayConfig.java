package com.test.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *������AlipayConfig
 *���ܣ�����������
 *��ϸ�������ʻ��й���Ϣ������·��
 *�޸����ڣ�2017-04-05
 *˵����
 *���´���ֻ��Ϊ�˷����̻����Զ��ṩ���������룬�̻����Ը����Լ���վ����Ҫ�����ռ����ĵ���д,����һ��Ҫʹ�øô��롣
 *�ô������ѧϰ���о�֧�����ӿ�ʹ�ã�ֻ���ṩһ���ο���
 */

public class AlipayConfig {
	
//�����������������������������������Ļ�����Ϣ������������������������������

	// Ӧ��ID,����APPID���տ��˺ż�������APPID��Ӧ֧�����˺�
	public static String app_id = "2021000117698789";
	
	// �̻�˽Կ������PKCS8��ʽRSA2˽Կ
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCZFtVyzihwPicJ1OrZzAJMPxRhi7DQpeagATBuWH1ZIVkScg/8ejg3a127rvQwi7oIT38QupR6BxAo0soxLjsYE5XZvBWtZfVX54vsHrNRmdqe/GwZxINOQOqm/Y0/f2noWFtc5rYEX8kDbXCRwA44PMB+IMV8LfX8vojeTpu3HB0p9NWYulg6n7ZKO63l+82hwjxdwueWBv/xkoTSke4hdr/OVmEBOpCcHgGhELQ7NZiSbHHwlntQuwL0OfAkwIBx/6GDzClpvT8+kWhXRHYLdYRzv8kYcV9rBnfdpBH5NLD4ImC+SxFXrWW9uhiofRtp9gncaNOB4Mm6shz4jiihAgMBAAECggEAe1Fhb7GR8ZifadQRupAT6ceGa21TaT+6n3lVwg2WK44paipnpkHttvbN8rnkCpcDrF4dRSSHJiU6Zyglp6hOAf8E3vgbnipbkAv9Mp8oY7tD2H4NtlQOUaMJYqssdNH2RiumrRdL2Aowqool+8Jxset+RBux+W4skQQKzMkVtlG3mfLUuIzKqlUIWrHGOj4Yb+bXkPIcIAIqA7H5srgf0k+Hr52rJrq/6OU145HIbQjiDDzKQ5yJu9IU6tZpv/vBni1gz5xGkHTVbAjYhO9qA+mgHV57Y702RbCewGv9fD7HerN/vFxKXElj7lmye1GbmONvgeVrfyhLmsN0wtc6gQKBgQDUE2AI1H2hZJpD1NpkCzvg7jGdx5kZZVlsjGLsik8lOe0j+WdUosY9egv7GHHsm2W92yjtnRb4Q8mgSKnlHs1d9G6ovub6oj8CGPXOvKjGiWSGUeQtJkt+GSGgoV5e7dySIMMcTwNGimltPEUP8DxPPH2y9WPPko77o01SvyAXdQKBgQC4y+Q3lpHP5qpOuxUD96s8C1vS4a/GRBVM6tmQHOFwXYMytG/8P4vDRKZNGIIDpNlJIwnWfUjnNtxHLipDyUnUvQmp/lzou8y6mglJY6NBZS+otpmUGUm3QN5rEsnXULm/DWW7645dPtXffCdnWiiOhbEXwlXpuhN9JxwXvhXS/QKBgQC350FNBu8WiIXZsnfbb35yVDvEZbSWuDNulOKn2lw9nNjObFU1qJ2d6/r9uDn6gtscYzM/sgycJzRuAPULEcXm5rMbM8haqV1YNUrbBvCYkcYRUGw81st6QtLNV4Hdcgjm0vA+2Smu/xHjPvNomdvCnmMmT/NIqf/BqN/BlKmAjQKBgQCvmfAvcoD0kjhbwCLkNkEdOZ3z8knZmXC0Oqaq7wa6g+HcGOIhTTE+SMnOkO9bDxb7DLSYgUz5iYQgj5nR+ECUS14Xj4IyFeMhnqYcevXzenejVoDx3mXSIW45SQ1L8YXQKqb1v4z0xnTtfUjkSSQo6pmx/hUtmIhUcQmc9iA+8QKBgHD740iUp5FAbR4hn5zpcFvjg5ME6g4zDbqkyzGTnglefmNNiZSyNiqWU7fsX5klGmM6RFOOpzilZ1jo+C4qPg2GzaTMQX/Av4Du9rPNls7QDv3YAmvy2YuW1jly2k+ExsXpohqY36phyIHR4MbQ2Hy9xPP/17tM0fhb/GL+kZZ7";
	
	// ֧������Կ,�鿴��ַ��https://openhome.alipay.com/platform/keyManage.htm ��ӦAPPID�µ�֧������Կ��
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnoThzb1Z5hJyB7+1L9PNJoUfpS4m8ZaSQG93y6UzZ8G5uWoVBUtibInRbr0P2TmOWZUfw+2bTG0Etyu2ESBoW3RazFD1XAhsxPBYH70eDyOFPVUnYJ0EOlzL/vNDGaPPa81Ar7oz69tk7TUpc54JweNhKCp1Z+b3Z9JizM4F+JRz011rZMuAfCL3yJXCvGCFETkVmo8Y8krgssrl0LDGADS4tOWFOktKsHld0qzTAfDBFVFr1ISzaZJXLd03Ef2fqp4KFT8DTDKLlXvfKNv2xcS5TxZBp77ZWYmH7MTLCLhk4Y9jJmaeOcITVoz4sXlE54deYyEJz6laI8Pqn9elmwIDAQAB";

	// �������첽֪ͨҳ��·��  ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
	//支付宝付款成功后，将结果返回给商户的指定路径
    public static String notify_url = "http://localhost:8080/testShop/pay/notifyUrl";

	// ҳ����תͬ��֪ͨҳ��·�� ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
	//支付宝付款成功后，跳转到商户的指定路径
    public static String return_url = "http://localhost:8080/testShop/pay/returnUrl";

	// ǩ����ʽ
	public static String sign_type = "RSA2";
	
	// �ַ������ʽ
	public static String charset = "utf-8";
	
	// ֧��������
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// ֧��������
	public static String log_path = "C:\\";


//�����������������������������������Ļ�����Ϣ������������������������������

    /** 
     * д��־��������ԣ�����վ����Ҳ���ԸĳɰѼ�¼�������ݿ⣩
     * @param sWord Ҫд����־����ı�����
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

