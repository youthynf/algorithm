package leetcode;

import sun.misc.BASE64Encoder;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Code_test {
    public static void main(String[] args) throws IOException {
        String base64Str = "";
        boolean isValid = validateBase64Image(base64Str);
        System.out.println(isValid);
//        generateImage();
    }
    public static boolean validateBase64Image(String base64Str) {
        try {
            byte[] imageBytes = Base64.getDecoder().decode(base64Str.split(",")[1]);
            InputStream in = new ByteArrayInputStream(imageBytes);
            BufferedImage image = ImageIO.read(in);
            if (image != null) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static void generateImage() throws IOException {
        String encoder = "data:image/jpg;base64,"; //定义图片类型，方便前端直接使用
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        URL url = new URL("https://img-home.csdnimg.cn/images/20230817060240.png");//picUrl为图片地址
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream is = connection.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = is.read(bytes)) != -1){
            data.write(bytes,0,len);
        }
        is.close();
        BASE64Encoder base64Encoder = new BASE64Encoder();
        encoder = encoder +  base64Encoder.encode(data.toByteArray()).replace("\r\n","").trim();
        //这里去掉结果里面的"\r\n"，也可以不去，但是不去的话需要使用的时候还是要去掉，所以为了方便就先去掉再存储
        System.out.println(encoder);

        boolean isValid = validateBase64Image(encoder);
        System.out.println(isValid);

    }
}
