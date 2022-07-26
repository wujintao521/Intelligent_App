import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class QRCodeGeneratorImpl2 {
    static MapCache mapCache = new MapCache();

    public static String encode(long userId, Date currentTime) {
        if (StringUtils.isEmpty(userId)) {
            return null;
        }
        mapCache.add( setEncryptionBase64(String.valueOf(userId)),String.valueOf(userId), 6 * 100000);
        return setEncryptionBase64(String.valueOf(userId));
    }

    public static long decode(String code, Date currentTime) {

        if (StringUtils.isEmpty(code)) {
            return 0;
        }
        //缓存中获取的值
        String cacheCode = String.valueOf(mapCache.get(code));
        return StringUtils.isEmpty(cacheCode) ? 0 :Long.valueOf(cacheCode);
    }

    //加密
    public static String setEncryptionBase64(String str){
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if( b != null){
            s = new BASE64Encoder().encode(b);
        }
        return s;

    }

    //解密
    public static String getDecodeBase64(String str){
        byte[] b = null;
        String result = null;
        if(str != null){
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(str);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Date currentTime = new Date();
        String encode = encode(1001,currentTime);
        System.out.println(encode);
        long code = decode(encode,currentTime);
        System.out.println(code);
    }

}
