package assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Call {
	private Contact contact;
	private String type;
	private String callType;
	private Double cost;
	private Date duration;
	private Date date;

	public Call() {
	}
	
	public Call(Contact contact, String type, String callType, Double cost, Date duration, Date date) {
		super();
		this.contact = contact;
		this.type = type;
		this.callType = callType;
		this.cost = cost;
		this.duration = duration;
		this.date = date;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public Map<String, Integer> monthCount(List<Call> callList) {
		Map<String, Integer> months = new TreeMap<>();
		String month[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		callList.forEach((call) -> {
			Date dt = call.getDate();
			SimpleDateFormat dat = new SimpleDateFormat("yyyy-mm-dd");  
			String ss[] = dat.format(dt).split("-");

			int givenmonth = Integer.parseInt(ss[1]);
			if (months.containsKey(month[givenmonth - 1])) {
				int x = months.get(month[givenmonth - 1]);
				months.put(month[givenmonth - 1], x + 1);
			} else {
				months.put(month[givenmonth - 1], 1);
			}
		});
		return months;
	}


	public Call createCall(String line)  {
		String split[] = line.split(",");
		Date time = null;
		Date date = null;
		try {
			time = new SimpleDateFormat("hh:mm:ss").parse(split[4]);
			date = new SimpleDateFormat("yyyy-mm-dd").parse(split[5]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Call(new Contact(split[0], null, null, null), split[1], split[2], Double.parseDouble(split[3]), time, date);
	}
}

