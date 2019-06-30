package io.dy.controller;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/qrcode")
@CrossOrigin
public class QRCodeController {
    //todo 根据地址去生成二维码

    @GetMapping(value = "/generate/{address}", produces = MediaType.IMAGE_PNG_VALUE)
    public String generate(@PathVariable String address){
        ByteArrayOutputStream stream = QRCode.from(address)
                .to(ImageType.PNG)
                .withSize(256,256)
                .withErrorCorrection(ErrorCorrectionLevel.H)
                .stream();
        byte[] bytes = stream.toByteArray();
        //转成BASE64编码
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(bytes);
        return encode;
    }
}
