package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Photo;
import kodlamaio.hrms.entities.dtos.PhotoDto;

public interface PhotoService {
    DataResult<List<Photo>> getAll();
    DataResult<Photo> getById(Integer id);
    Result add(Photo photo);
    Result delete(Photo photo);

	Result update(PhotoDto photoDto); 
    Result exist(Integer id);
}
