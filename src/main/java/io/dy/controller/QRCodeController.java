package io.dy.controller;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/qrcode")
@CrossOrigin
public class QRCodeController {
    //todo 根据地址去生成二维码

    @GetMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generate(String address){
        ByteArrayOutputStream stream = QRCode.from(address)
                .to(ImageType.PNG)
                .withSize(256,256)
                .withErrorCorrection(ErrorCorrectionLevel.H)
                .stream();
        byte[] bytes = stream.toByteArray();
        return bytes;
    }
}
