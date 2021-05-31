package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;
@Service
public class CityManager implements CityService{
	@Autowired
	private CityDao cityDao;
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}
	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}
	@Override
	public Result add(@RequestBody City city) {
		this.cityDao.save(city);
		return new SuccessResult(Messages.CityAdded);
	}


}
