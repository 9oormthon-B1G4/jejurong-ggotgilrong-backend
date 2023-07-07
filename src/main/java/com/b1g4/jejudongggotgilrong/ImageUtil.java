package com.b1g4.jejudongggotgilrong;

import com.b1g4.jejudongggotgilrong.entity.error.ApplicationError;
import com.b1g4.jejudongggotgilrong.entity.error.BadRequestException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageUtil {

    private static final String IMAGE_ROOT_PATH = "/images";
    private static final String POINT = ".";
    private static final String SEPARATOR = "/";
    private static final String IMAGE_JPG = "image/jpg";
    private static final String IMAGE_JPEG = "image/jpeg";
    private static final String IMAGE_PNG = "image/png";
    private static final String IMAGE_REQUEST = "/images";

    public static String saveImage(MultipartFile multipartFile) {
        validateContentType(multipartFile.getContentType());
        StringBuilder imageUploadPath = new StringBuilder(new File(IMAGE_ROOT_PATH).getAbsolutePath());
        File imageFile = new File(imageUploadPath.toString());
        if (!imageFile.exists()) {
            imageFile.mkdir();
        }
        String imageFileName = UUID.randomUUID() + POINT + extractExt(multipartFile.getContentType());
        imageUploadPath.append(File.separator).append(imageFileName);
        try {
            multipartFile.transferTo(new File(imageUploadPath.toString()));
        } catch (IOException e) {
            throw new BadRequestException(ApplicationError.INTERNAL_SERVER_ERROR);
        }
        return IMAGE_REQUEST + File.separator + imageFileName;
    }

    private static String extractExt(String contentType) {
        return contentType.substring(contentType.lastIndexOf(SEPARATOR) + 1);
    }

    private static void validateContentType(String contentType) {
        if (isWrongContentType(contentType)) {
            throw new BadRequestException(ApplicationError.INTERNAL_SERVER_ERROR);
        }
    }

    private static boolean isWrongContentType(String contentType) {
        return !(contentType.contains(IMAGE_JPG) || contentType.contains(IMAGE_JPEG) || contentType.contains(IMAGE_PNG));
    }
}
