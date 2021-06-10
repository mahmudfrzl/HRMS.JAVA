package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCvTechnelogy;

public interface TechnelogyService {
DataResult<List<CandidateCvTechnelogy>> getAll();
}
