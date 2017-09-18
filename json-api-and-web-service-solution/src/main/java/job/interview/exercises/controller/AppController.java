package job.interview.exercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import job.interview.exercises.service.AppService;

@Controller
public class AppController {

	@Autowired
	@Qualifier("AppService")
	AppService appService;

	@RequestMapping(value = "/")
	public ModelAndView main() {

		final ModelAndView mav = new ModelAndView("main");
		mav.addObject("test", appService.getMsg());

		return mav;
	}

}
