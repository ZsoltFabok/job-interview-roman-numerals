package job.interview.exercises.service;

import org.springframework.stereotype.Service;

import job.interview.exercises.model.Result;

@Service("AppService")
public class AppServiceImpl implements AppService {

	@Override
	public String getMsg() {
		return "Test msg";
	}

	@Override
	public Result calculateExpression(String expression) {
		final Result result = new Result();
		result.setResult(expression + " test");

		return result;
	}

}
