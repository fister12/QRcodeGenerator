import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QRCodeReaderExample {
    public static void main(String[] args) {
        String imagePath = "qrcode_example.png"; // Provide the path to your QR code image

        try {
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);

            Reader reader = new MultiFormatReader();
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            
            Result result = reader.decode(binaryBitmap);
            
            System.out.println("QR Code content: " + result.getText());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
