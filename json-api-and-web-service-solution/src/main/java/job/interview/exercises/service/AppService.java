package job.interview.exercises.service;

import job.interview.exercises.model.Result;

public interface AppService {

	String getMsg();

	Result calculateExpression(String expression);

}
