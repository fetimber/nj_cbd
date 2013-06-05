package com.fe.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

//import org.apache.log4j.Logger;

/**
* 加密和解密.
* 
*/
public class EncryptDecryptData {

	public final static byte KEY[] = "qwertyui".getBytes();
	public final static byte TXLKEY[] = "KLASJDFIOIUASDKLFJS".getBytes();
	public final static byte CLKEY[]="LADSHITNKAMLGBYO".getBytes();
	public final static byte QYJZKEY[]="JLNLDWQNSLALLQS".getBytes();
	public final static byte ZDSCKEY[]="GCFHXWLXLNYLZJ".getBytes();
	//private final static Logger log = Logger.getLogger(EncryptDecryptData.class);
	
    public static void main(String[] args) throws Exception 
    {
    	String key = createRandomString(32);
    	
    	System.out.println(key);
        //log.debug("密匙===>" + KEY);

        String str = "112233"; // 待加密数据
        // 2.1 >>> 调用加密方法
        byte[] encryptedData = encrypt(KEY, key);
        System.out.println(encryptedData.length);
        String a = byteArr2HexStr(encryptedData);
        System.out.println(a);
        // 3.1 >>> 调用解密方法
        byte[] b = hexStr2ByteArr(a);
        System.out.println(decrypt(KEY, b));
    }

    public static String createRandomString(int randomNum) {
		Random r = new Random();
		int i = 0;
		String str = "";
		String s = "";
		while (i < randomNum) {
			switch (r.nextInt(63)) {
			case (0):
				s = "0";
				break;
			case (1):
				s = "1";
				break;
			case (2):
				s = "2";
				break;
			case (3):
				s = "3";
				break;
			case (4):
				s = "4";
				break;
			case (5):
				s = "5";
				break;
			case (6):
				s = "6";
				break;
			case (7):
				s = "7";
				break;
			case (8):
				s = "8";
				break;
			case (9):
				s = "9";
				break;
			case (10):
				s = "a";
				break;
			case (11):
				s = "b";
				break;
			case (12):
				s = "c";
				break;
			case (13):
				s = "d";
				break;
			case (14):
				s = "e";
				break;
			case (15):
				s = "f";
				break;
			case (16):
				s = "g";
				break;
			case (17):
				s = "h";
				break;
			case (18):
				s = "i";
				break;
			case (19):
				s = "j";
				break;
			case (20):
				s = "k";
				break;
			case (21):
				s = "m";
				break;
			case (23):
				s = "n";
				break;
			case (24):
				s = "o";
				break;
			case (25):
				s = "p";
				break;
			case (26):
				s = "q";
				break;
			case (27):
				s = "r";
				break;
			case (28):
				s = "s";
				break;
			case (29):
				s = "t";
				break;
			case (30):
				s = "u";
				break;
			case (31):
				s = "v";
				break;
			case (32):
				s = "w";
				break;
			case (33):
				s = "l";
				break;
			case (34):
				s = "x";
				break;
			case (35):
				s = "y";
				break;
			case (36):
				s = "z";
				break;
			case (37):
				s = "A";
				break;
			case (38):
				s = "B";
				break;
			case (39):
				s = "C";
				break;
			case (40):
				s = "D";
				break;
			case (41):
				s = "E";
				break;
			case (42):
				s = "F";
				break;
			case (43):
				s = "G";
				break;
			case (44):
				s = "H";
				break;
			case (45):
				s = "I";
				break;
			case (46):
				s = "L";
				break;
			case (47):
				s = "J";
				break;
			case (48):
				s = "K";
				break;
			case (49):
				s = "M";
				break;
			case (50):
				s = "N";
				break;
			case (51):
				s = "O";
				break;
			case (52):
				s = "P";
				break;
			case (53):
				s = "Q";
				break;
			case (54):
				s = "R";
				break;
			case (55):
				s = "S";
				break;
			case (56):
				s = "T";
				break;
			case (57):
				s = "U";
				break;
			case (58):
				s = "V";
				break;
			case (59):
				s = "W";
				break;
			case (60):
				s = "X";
				break;
			case (61):
				s = "Y";
				break;
			case (62):
				s = "Z";
				break;
			}
			i++;
			str = s + str;
		}
		return str;
	}

	/**
    * DES加密方法
    * 
    * @param rawKeyData
    * @param str
    * @return
    * @throws InvalidKeyException
    * @throws NoSuchAlgorithmException
    * @throws IllegalBlockSizeException
    * @throws BadPaddingException
    * @throws NoSuchPaddingException
    * @throws InvalidKeySpecException
    */
    public static byte[] encrypt(byte rawKeyData[], String str)
            throws InvalidKeyException, NoSuchAlgorithmException,
            IllegalBlockSizeException, BadPaddingException,
            NoSuchPaddingException, InvalidKeySpecException {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建一个DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(rawKeyData);
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, key, sr);
        // 现在，获取数据并加密
        byte data[] = str.getBytes();
        // 正式执行加密操作
        byte[] encryptedData = cipher.doFinal(data);
        //log.debug("加密后===>" + encryptedData);
        return encryptedData;
    }

    /**
    * DES解密方法
    * 
    * @param rawKeyData
    * @param encryptedData
    * @throws IllegalBlockSizeException
    * @throws BadPaddingException
    * @throws InvalidKeyException
    * @throws NoSuchAlgorithmException
    * @throws NoSuchPaddingException
    * @throws InvalidKeySpecException
    */
    public static String decrypt(byte rawKeyData[], byte[] encryptedData)
            throws IllegalBlockSizeException, BadPaddingException,
            InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeySpecException {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建一个DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(rawKeyData);
        // 创建一个密匙工厂，然后用它把DESKeySpec对象转换成一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, key, sr);
        // 正式执行解密操作
        byte decryptedData[] = cipher.doFinal(encryptedData);
        //log.debug("解密后===>" + new String(decryptedData));
        return new String(decryptedData);
    }
    
    /**
     * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
     * hexStr2ByteArr(String strIn) 互为可逆的转换过程
     *
     * @param arrB 需要转换的byte数组
     * @return 转换后的字符串
     * @throws Exception 本方法不处理任何异常，所有异常全部抛出
     */
    public static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数需要在前面补0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB)
     * 互为可逆的转换过程
     *
     * @param strIn 需要转换的字符串
     * @return 转换后的byte数组
     * @throws Exception 本方法不处理任何异常，所有异常全部抛出
     * @<a href="mailto:leo841001@163.com">LiGuoQing</a>
     */
    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;

        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

}