package com.hmretail.springboot.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hmretail.springboot.bean.SortBean;
import com.hmretail.springboot.util.HmRetailUtil;

@Service
public class HmRetailService {
	public static final Logger logger = LoggerFactory.getLogger(HmRetailService.class);

	/**
	 * @param randomNumbers
	 * @return
	 */
	public SortBean doSorting(String randomNumbers) {
		logger.info("Entering doSorting Method");
		HmRetailUtil hmValidator = new HmRetailUtil();
		List<Integer> inputNumberList = new ArrayList<Integer>();
		Map<String, Object> outputMap = new HashMap<String, Object>();
		String sortedOrder = null;
		SortBean sb = new SortBean();
		String time = null;
		try {
			inputNumberList = hmValidator.validateNumbers(randomNumbers);
			long startTime = System.currentTimeMillis();
			outputMap = this.sortNumbers(inputNumberList);
			logger.info("outputMap: " + outputMap);
			long endTime = System.currentTimeMillis();
			long duration = endTime - startTime;
			Date execTime = new Date(duration / 1000);
			sortedOrder = hmValidator.constructStringFromList(outputMap.get("sortedList"));
			logger.info("sortedOrder: " + sortedOrder);
			Integer noOfChanges = (Integer) outputMap.get("noOfChanges");
			logger.info("noOfChanges: " + noOfChanges);
			sb.setNoOfChanges(noOfChanges.toString());
			sb.setSortedNumbers(sortedOrder);
			time = Long.toString(execTime.getTime());
			sb.setTimeTaken(time);
		} catch (Exception ex) {
			logger.info("Exception in doSorting Method");
		}
		logger.info("End doSorting Method");
		return sb;
	}

	/**
	 * @param numList
	 * @return
	 */
	public Map<String, Object> sortNumbers(List<Integer> numList) {
		logger.info("Entering sortNumbers Method :" + numList);
		Map<String, Object> sortedListMap = new HashMap<String, Object>();
		int count;
		try {
			count = 1;
			while (!isSorted(numList)) {
				Collections.shuffle(numList);
				count++;
			}
			sortedListMap.put("sortedList", numList);
			sortedListMap.put("noOfChanges", count);

		} catch (Exception ex) {
			logger.info("Exception sortNumbers Method");
		}
		logger.info("End sortNumbers Method");
		return sortedListMap;
	}

	/**
	 * @param numList
	 * @return
	 */
	private boolean isSorted(List<Integer> numList) {
		logger.info("Entering isSorted Method");
		try {
			if (numList.isEmpty()) {
				return true;
			}
			Iterator<Integer> it = numList.iterator();
			Integer lastVal = it.next();
			logger.info("lastVal : " + lastVal);
			while (it.hasNext()) {
				Integer currentVal = it.next();
				logger.info("currentVal : " + currentVal);
				if (lastVal.compareTo(currentVal) > 0) {
					return false;
				}
				lastVal = currentVal;
			}

		} catch (Exception ex) {
			logger.info("Exception isSorted Method");
		}
		logger.info("End isSorted Method");
		return true;
	}

}
