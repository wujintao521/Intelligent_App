import java.util.Date;


public interface QRCodeGenerator {
    /**
     * 根据用户ID，为用户生成临时的授权码
     *
     * @param userId      用户ID
     * @param currentTime 当前时间
     * @return 临时授权码
     */
    String encode(long userId, Date currentTime);


    /**
     * 根据临时授权码，获取用户身份
     *
     * @param code 临时授权码
     * @param currentTime 当前时间
     * @return 用户ID
     */
    long decode(String code, Date currentTime);

}