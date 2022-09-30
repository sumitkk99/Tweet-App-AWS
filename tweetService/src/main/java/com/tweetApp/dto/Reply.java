package com.tweetApp.dto;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@DynamoDBDocument
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
	@DynamoDBAttribute(attributeName = "replied")
	private String replied;
	@DynamoDBAttribute(attributeName = "dateReplied")
	private Date dateReplied;

	public String getReplied() {
		return replied;
	}

	public void setReplied(String replied) {
		this.replied = replied;
	}

	public Date getDateReplied() {
		return dateReplied;
	}

	public void setDateReplied(Date dateReplied) {
		this.dateReplied = dateReplied;
	}

}
