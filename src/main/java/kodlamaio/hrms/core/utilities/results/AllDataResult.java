package kodlamaio.hrms.core.utilities.results;

import java.util.ArrayList;
import java.util.List;

public class AllDataResult {
	private List<DataResult> dataResult;
	private List<Result> result;
	private boolean error;
	public AllDataResult() {
		this.dataResult=new ArrayList<DataResult>();
		this.result= new ArrayList<Result>();
		this.error=false;
	}
	public void addResult(DataResult result) {
		this.dataResult.add(result);
		if(result.isSuccess()==false) this.error=true;
	}
	public void addResult(Result result) {
		this.result.add(result);
		if(result.isSuccess()==false) this.error=true;
	}
	public boolean isSuccess() {
		return this.error;
	}
	public List<DataResult> getDataResults(){
		return this.dataResult;
	}
	public List<Result> getResults(){
		return this.result;
	}
	public List<DataResult> getErrorDataResults(){
		List<DataResult> errordataResult=new ArrayList<DataResult>();
		for(DataResult dataResult:this.dataResult) {
			if(!dataResult.isSuccess()) errordataResult.add(dataResult);
		}
		return errordataResult;
	}
	public List<Result> getErrorResults(){
		List<Result> errorResult=new ArrayList<Result>();
		for(Result result:this.result) {
			if(!result.isSuccess()) errorResult.add(result);
		}
		return errorResult;
	}
	public List<DataResult> getSuccessDataResults(){
		List<DataResult> successDataResult=new ArrayList<DataResult>();
		for(DataResult dataResult:this.dataResult) {
			if(dataResult.isSuccess()) successDataResult.add(dataResult);
		}
		return successDataResult;
	}
	public List<Result> getSuccessResults(){
		List<Result> successResult=new ArrayList<Result>();
		for(Result result:this.result) {
			if(result.isSuccess()) successResult.add(result);
		}
		return successResult;
	}
	
}
