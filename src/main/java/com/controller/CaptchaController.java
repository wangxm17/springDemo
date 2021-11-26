package com.controller;

import com.tools.VerifyCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
/**
 * @Author: wangxm
 * @Date: 2021/11/26 14:39
 * 验证码操作处理
 */
@RestController
@Api(value = "CaptchaController",description = "验证码(wxm)")
public class CaptchaController {
    /**
     * 生成验证码
     */
    @RequestMapping(value = "/captchaImage",method = RequestMethod.GET)
    @ApiOperation(value = "验证码")
    public void getVerificationCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            int width=200;
            int height=69;
            BufferedImage verifyImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            //生成对应宽高的初始图片
            String randomText = VerifyCode.drawRandomText(width,height,verifyImg);
            //单独的一个类方法，出于代码复用考虑，进行了封装。// 功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符
            request.getSession().setAttribute("verifyCode", randomText);
            response.setContentType("image/png");//必须设置响应内容类型为图片，否则前台不识别
            OutputStream os = response.getOutputStream(); //获取文件输出流
            ImageIO.write(verifyImg,"png",os);//输出图片流
            os.flush();
            os.close();//关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
