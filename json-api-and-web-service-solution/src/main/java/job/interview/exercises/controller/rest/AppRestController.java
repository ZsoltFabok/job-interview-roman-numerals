package job.interview.exercises.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import job.interview.exercises.model.Result;
import job.interview.exercises.service.AppService;

@RestController
@RequestMapping(value = "/rest")
public class AppRestController {

	@Autowired
	@Qualifier("AppService")
	AppService appService;

	@RequestMapping(value = "/calculateExpression", method = RequestMethod.POST, produces = "application/json")
	public Result getTestInJSON(@RequestBody String expression) {

		final Result calculatedExpression = appService.calculateExpression(expression);
		return calculatedExpression;
	}

}
