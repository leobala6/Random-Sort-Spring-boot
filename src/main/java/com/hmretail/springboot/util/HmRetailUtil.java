package com.hmretail.springboot.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HmRetailUtil {
	public static final Logger logger = LoggerFactory.getLogger(HmRetailUtil.class);

	/**
	 * @param randomNumbers
	 * @return
	 */
	public List<Integer> validateNumbers(String randomNumbers) {
		logger.info("Entering validateNumbers Method : "+randomNumbers);
		ArrayList<Integer> numList = new ArrayList<Integer>();
		try {

			String[] numbers = randomNumbers.split(",");
			logger.info("The size of number list is: " + numbers.length);
			for (String numVal : numbers) {
				logger.info("numVal: " + numVal);
				numList.add(Integer.parseInt(numVal));
			}
			logger.info("List before Sorting:" +numList);
		} catch (Exception ex) {
			logger.info("Exception in validateNumbers Method");
		}
		logger.info("End validateNumbers Method");
		return numList;
	}

	/**
	 * @param sortedList
	 * @return
	 */
	public String constructStringFromList(Object sortedList) {
		logger.info("Entering constructStringFromList Method");
		String sortedString = null;
		StringBuffer sBuffer = new StringBuffer(" ");
		try {
			List<Integer> lst = (List<Integer>) sortedList;
			logger.info("Sorted list:"+ lst);
			//String sortedNumbersArray[] = ((List<Integer>) sortedList)
				//	.toArray(new String[((List<Integer>) sortedList).size()]);
			for (Integer str : lst) {
				sBuffer.append(str.toString()).append(",");
			}
			sortedString = sBuffer.toString();
		} catch (Exception ex) {
			logger.info("Exception constructStringFromList Method"+ex.getMessage());
		}
		logger.info("End constructStringFromList Method");
		return sortedString;
	}

}
