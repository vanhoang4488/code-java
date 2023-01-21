package hoc.spring_001;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hoc.beans.Bean;

@Controller
public class ApiCRD {

	@RequestMapping(value = "/crd", method = RequestMethod.POST)
	@ResponseBody
	public Bean addData(@RequestBody Bean model) {
		return model;
	}
}
