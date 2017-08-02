package com.gzr.controller;

import com.gzr.util.Constant;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

/**
 * Created by GZR on 2017/3/9.
 */
@Controller
public class CommonController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "common/imgCode")
    // 产生登录验证码
    public String getCode(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Cache-Control", "no-cache");
        int width = 75; // 图片宽度
        int height = 40; // 图片高度
        // 生成前景和背景颜色，形成反色
        int red = (int) (Math.random() * 1000 % 64);
        int green = (int) (Math.random() * 1000 % 64);
        int blue = (int) (Math.random() * 1000 % 64);
        //Color backColor = new Color(red, green, blue);
        //底色固定为#F1FCFF
        Color backColor = new Color(0xF1, 0xFC, 0xFF);
        Color fontColor = new Color(255 - red, green, blue);

        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.createGraphics();
        graphics.setColor(backColor); // 背景颜色
        graphics.fillRect(0, 0, width, height);

        int fontSize=21;

        graphics.setFont(new Font("Sans-Serif", Font.BOLD, fontSize));
        //固定验证码颜色为绿色
        graphics.setColor(Color.GREEN); // 前景颜色
        Random random = new Random();//
        // 图片背景上随机生成5条线条，避免通过图片识别破解验证码
        for (int i = 0; i < 5; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            graphics.drawLine(x, y, x + xl, y + yl);
        }
        String code = getCodeString();
        //暂时这么写
        session.setAttribute(Constant.IMG_CODE.getValue(), code); // 写入session中
        graphics.drawString(code, (int) (width * 0.1), (int) (height * 0.8));
        graphics.dispose();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(response
                .getOutputStream());
        encoder.encode(image);
        response.getOutputStream().flush(); // 刷新到页面生成图片
        response.getOutputStream().close(); // 关闭writer
        return null;
    }

    // 产生验证图片上面的随机字符
    protected String getCodeString() {
        Random random = new Random();
        String old = "0123456789qwertyuioplkjhgfdsazxcvbnm";
        StringBuffer sb = new StringBuffer();
        int j = 0;
        for (int i = 0; i < 5; i++) {
            j = random.nextInt(old.length());
            sb.append(old.substring(j, j + 1));
        }
        return sb.toString();
    }

    @RequestMapping("/common/test")
    @ResponseBody
    public String test(HttpServletRequest request){
        String s=ClassUtils.getDefaultClassLoader().getResource("").getPath();
        return request.getServletContext().getRealPath("/static/bootstrap-3.3.7-dist"+",,,,"+s);
    }

    @RequestMapping("download/{fileName}")
    public String download(@PathVariable String fileName,HttpServletRequest request,
                           HttpServletResponse response){
        logger.info("fileName:"+fileName);
        String requestUrl=request.getRequestURI();
        String suffix=requestUrl.substring(requestUrl.lastIndexOf("."),requestUrl.length());
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
        try {
            InputStream inputStream=this.getClass().getResourceAsStream("/telm/"+fileName+suffix);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }

            // 这里主要关闭。
            os.close();

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        //  返回值要注意，要不然就出现下面这句错误！
        //java+getOutputStream() has already been called for this response
        return null;
    }

}