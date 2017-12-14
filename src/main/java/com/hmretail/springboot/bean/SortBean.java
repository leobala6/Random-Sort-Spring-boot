package com.hmretail.springboot.bean;

public class SortBean {
	private String sortedNumbers;
	private String timeTaken;
	private String noOfChanges;

	public String getSortedNumbers() {
		return sortedNumbers;
	}

	public void setSortedNumbers(String sortedNumbers) {
		this.sortedNumbers = sortedNumbers;
	}

	public String getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}

	public String getNoOfChanges() {
		return noOfChanges;
	}

	public void setNoOfChanges(String noOfChanges) {
		this.noOfChanges = noOfChanges;
	}
}
