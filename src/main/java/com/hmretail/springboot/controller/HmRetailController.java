package com.hmretail.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hmretail.springboot.bean.SortBean;
import com.hmretail.springboot.service.HmRetailService;

@Controller
public class HmRetailController {

	public static final Logger logger = LoggerFactory.getLogger(HmRetailController.class);

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "RandomNumbers";
	}

	/**
	 * @param model
	 * @param randomNum
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String randomSort(ModelMap model, @RequestParam String randomNum) {
		logger.info("Inside Random Sort: " + randomNum);
		SortBean sortBean = new SortBean();
		HmRetailService hmService = new HmRetailService();
		try {
			sortBean = hmService.doSorting(randomNum);
			logger.info("Sorted numbers: " + sortBean.getSortedNumbers());
			logger.info("Time Taken: " + sortBean.getTimeTaken());
			logger.info("No of Shuffle: " + sortBean.getNoOfChanges());
			model.put("sortedNumbers", sortBean.getSortedNumbers());
			model.put("timeTaken", sortBean.getTimeTaken());
			model.put("noOfChanges", sortBean.getNoOfChanges());
		} catch (Exception ex) {
			logger.info("Exception occured in  randomSort method");
		}
		logger.info("End Random Sort: ");
		return "sortedList";
	}

}
