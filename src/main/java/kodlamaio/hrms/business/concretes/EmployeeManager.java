package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.adapters.EmailService;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;
	private EmailService emailService;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, EmailService emailService) {
		super();
		this.employeeDao = employeeDao;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<Employee>> getAll() {

		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), Messages.AllEmployeeListed);
	}

	@Override
	public List<Result> add(Employee employee) {
		AllDataResult allDataResult = new AllDataResult();
		allDataResult = checkALlFields(employee);
		if (allDataResult.isSuccess()==false) {
			emailService.isOkay(employee.getEmail());
			allDataResult.addResult(new SuccessResult());
			employeeDao.save(employee);
			allDataResult.addResult(new SuccessResult(Messages.LoginSuccessful));
			return allDataResult.getSuccessResults();
		} else {

			return allDataResult.getErrorResults();
		}

	}

	@Override
	public AllDataResult checkALlFields(Employee employee) {
		AllDataResult allDataResult = new AllDataResult();
		if (Strings.isNullOrEmpty(employee.getEmail()) == true) {
			allDataResult.addResult(new ErrorResult(Messages.emailIsEmpty));
		}
		if (Strings.isNullOrEmpty(employee.getPassword()) == true) {
			allDataResult.addResult(new ErrorResult(Messages.passwordIsEmpty));
		}
		if (!checkEmail(employee.getEmail())) {
			allDataResult.addResult(new ErrorResult(Messages.ThisEmailAddressIsUsed));
		}
		if (!checkPassword(employee.getEmail())) {
			allDataResult.addResult(new ErrorResult(Messages.ThisPasswordAddressIsUsed));
		}
		if (!emailService.isOkay(employee.getEmail())) {
			allDataResult.addResult(new ErrorResult(Messages.wrogEmail));
		}

		return allDataResult;
	}

	@Override
	public boolean checkEmail(String email) {
		List<Employee> employees = getAll().getData();
		for (Employee employee : employees) {
			if (employee.getEmail().equals(email)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkPassword(String password) {
		List<Employee> employees = getAll().getData();
		for (Employee employee : employees) {
			if (employee.getPassword().equals(password)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Result delete(int id) {
		this.employeeDao.deleteById(id);
		return new SuccessResult();
	}


}
