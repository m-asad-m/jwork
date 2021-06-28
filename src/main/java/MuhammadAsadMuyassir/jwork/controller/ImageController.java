package MuhammadAsadMuyassir.jwork.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.*;

/**
 * Class ImageController adalah class yang menghandle seluruh request gambar
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
@RequestMapping("/img")
@RestController
public class ImageController {

    /**
     * Metode untuk mendapatkan data gambar dari file lokal
     *
     * @param filePath      path lokasi file
     * @param fileName      nama file
     * @return              byte array gambar
     * @throws IOException  jika terdapat gagal atau gangguan saat operasi I/O
     */
    @RequestMapping(value = "/{filePath}/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] downloadImg(@PathVariable String filePath,
                              @PathVariable String fileName)
            throws IOException
    {
        File imageFile = new File("src/main/resources/images/" + filePath + '/' + fileName);
        InputStream inputStream = new FileInputStream(imageFile);
        byte[] returnValue = new byte[inputStream.available()];
        IOUtils.readFully(inputStream, returnValue);
        inputStream.close();
        return returnValue;
    }

    /**
     * Metode untuk menyimpan data gambar ke file lokal
     *
     * @param filePath      path lokasi file
     * @param fileName      nama file
     * @param byteStream    byte array gambar
     * @return              boolean status keberhasilan
     * @throws IOException  jika terdapat gagal atau gangguan saat operasi I/O
     */
    @RequestMapping(value = "/{filePath}/{fileName}", method = RequestMethod.POST)
    public boolean uploadImg(@PathVariable String filePath,
                             @PathVariable String fileName,
                             @RequestBody byte[] byteStream)
            throws IOException
    {
        String path = "src/main/resources/images/" + filePath + '/' + fileName;
        System.out.println("file path: " + System.getProperty("user.dir") + path);

        OutputStream outStream = new FileOutputStream(path);
        outStream.write(byteStream);
        outStream.close();
        return true;
    }
}