import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class QRCodeGenerator {
    public static void main(String[] args) {
        String data = "https://www.example.com";
        generateQRCode(data, "qrcode_example.png");
    }

    public static void generateQRCode(String data, String filePath) {
        ByteArrayOutputStream out = QRCode.from(data)
                .withSize(250, 250)
                .to(ImageType.PNG)
                .stream();

        try {
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            fos.write(out.toByteArray());
            fos.flush();
            fos.close();
            System.out.println("QR code saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//Author @Aaditya kapruwan
//Text field of string object form is text is the text to be encoded while width and height specify the size of the image produced
//We convert the text into a bit matrix and this bitmatrix is subsequently encoded ushing graphics2D into a white background as black spots
