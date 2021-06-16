package kodlamaio.hrms.core.utilities.cloudinaryAdapter;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.apache.tomcat.util.http.fileupload.impl.SizeException;
import org.hibernate.engine.jdbc.Size;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryService {
	private Cloudinary cloudinary;
	private Map<String, String> valuesMap = new HashMap<>();
	
	public CloudinaryManager() {
        valuesMap.put("cloud_name", "mahmud123");
        valuesMap.put("api_key", "123268637218949");
        valuesMap.put("api_secret", "qPehsvJ5_4oXN58rPIu2uwm8Sqs");
        cloudinary = new Cloudinary(valuesMap);
	}
	@Override
	public DataResult<Map> upload(MultipartFile multipartFile) throws IOException {
        Map<String, Object> options = new HashMap<>();
        var allowedFileFormats = Arrays.asList("jpeg", "png", "jpg");
        options.put("allowed_formats", allowedFileFormats);
        File file = convert(multipartFile);
        Map result;
        try {
            result = cloudinary.uploader().upload(file, options);
        }catch(Exception exception){
            return new ErrorDataResult<>("This file type is not supported, your file can only be jpeg, png, jpg");
        }

        file.delete();
        return new  SuccessDataResult<>(result);
	}

	@Override
	public DataResult<Map> delete(String id) throws IOException {
        Map<String, Boolean> options = new HashMap<>();
        options.put("invalidate", true);
        Map result = cloudinary.uploader().destroy(id, options);

        return new SuccessDataResult<>(result);
	}
	

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fileOutput = new FileOutputStream(file);
        fileOutput.write(multipartFile.getBytes());
        fileOutput.close();

        return file;
    }

}
