/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.CaptchaController;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Ao
 */
public class CreateCaptchaServlet extends HttpServlet {

    static char[] SYMBOLS = "?=.*".toCharArray();
    static char[] LOWERCASE = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static char[] UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static char[] NUMBERS = "0123456789".toCharArray();
    static char[] ALL_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789?=.*".toCharArray();
    static Random rand = new SecureRandom();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // tạo đối tượng BufferedImage để vẽ mã captcha 
        int width = 200;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Lấy đối tươngj graphic để vẽ trên bufferedImage 
        Graphics g = image.getGraphics();

        // Thiết lập màu nền cho captcha 
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // Thiết lập phông chữ cho mã captcha  
        Font font = new Font("Verdana", Font.BOLD + Font.ITALIC, 30);
        g.setFont(font);

        // Tạo mã captcha 
        String captchaCode = getCaptcha(4);

        // Lưu mã captcha vào session 
        session.setAttribute("captcha", captchaCode);

        // Vẽ mã CAPTCHA lên BufferedImage
        int x = 20;
        int y = 35;
        for (int i = 0; i < captchaCode.length(); i++) {
            g.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            g.drawString(Character.toString(captchaCode.charAt(i)), x, y);
            x += 25;
        }

        // Thêm các nhiễu vào CAPTCHA
        for (int i = 0; i < 100; i++) {
            int randomX = rand.nextInt(width);
            int randomY = rand.nextInt(height);
            g.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            g.drawLine(randomX, randomY, randomX + 1, randomY + 1);
        }

        // Thiết lập kiểu định dạng của ảnh CAPTCHA
        resp.setContentType("image/jpeg");

        // Ghi ảnh CAPTCHA vào ServletOutputStream
        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(image, "jpeg", out);

        // Giải phóng tài nguyên
        out.close();
        g.dispose();
    }

    public static String getCaptcha(int length) {
        assert length >= 4;
        char[] captcha = new char[length];

        captcha[0] = LOWERCASE[rand.nextInt(LOWERCASE.length)];
        captcha[1] = UPPERCASE[rand.nextInt(UPPERCASE.length)];
        captcha[2] = NUMBERS[rand.nextInt(NUMBERS.length)];
        captcha[3] = SYMBOLS[rand.nextInt(SYMBOLS.length)];

        for (int i = 4; i < length; i++) {
            captcha[i] = ALL_CHARS[rand.nextInt(ALL_CHARS.length)];
        }

        for (int i = 0; i < captcha.length; i++) {
            int randomPosition = rand.nextInt(captcha.length);
            char temp = captcha[i];
            captcha[i] = captcha[randomPosition];
            captcha[randomPosition] = temp;
        }
        return new String(captcha);
    }
}
