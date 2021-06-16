package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.entities.concretes.Photo;
import kodlamaio.hrms.entities.dtos.PhotoDto;

@Service
public class PhotoManager implements PhotoService {
	private PhotoDao photoDao;

	@Autowired
	public PhotoManager(PhotoDao photoDao) {
		super();
		this.photoDao = photoDao;
	}

	@Override
	public DataResult<List<Photo>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<>(photoDao.findAll());
	}

	@Override
	public DataResult<Photo> getById(Integer id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<>(photoDao.getOne(id));
	}

	@Override
	public Result add(Photo photo) {
		photoDao.save(photo);
		return new SuccessResult();
	}

	@Override
	public Result delete(Photo photo) {
		photoDao.delete(photo);
		return new SuccessResult();
	}

	@Override
	public Result update(PhotoDto photoDto) {
		Photo photo = photoDtoTophotoConverter(photoDto);
		photoDao.save(photo);
		return new SuccessResult();
	}

	@Override
	public Result exist(Integer id) {
		if (!photoDao.existsById(id)) {
			return new ErrorResult();

		}
		return new SuccessResult();
	}

	private Photo photoDtoTophotoConverter(PhotoDto photoDto) {
		int photoId = 3;

		return new Photo(photoId, photoDto.getName(), photoDto.getUrl(), photoDto.getPublicId());
	}

}
