package com.vinyoles.webdev.dynamicSitemap.models;

public class Url {
	private String loc; //Specify the location of url
	private String lastmod; //Specify the last modification date of the url. Date should be specified in ISO_8601 format. It can be reduced to YYYY-MM-DD
	private String changefreq; //always, hourly, daily,	weekly,	monthly, yearly, never
	private double priority; //Priority of the url relative to other urls in the same web site. Between 1 and 0. -1 for null
	
	
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getLastmod() {
		return lastmod;
	}
	public void setLastmod(String lastmod) {
		this.lastmod = lastmod;
	}
	public String getChangefreq() {
		return changefreq;
	}
	public void setChangefreq(String changefreq) {
		this.changefreq = changefreq;
	}
	public double getPriority() {
		return priority;
	}
	public void setPriority(double priority) {
		this.priority = priority;
	}
	
	
	public String toXML() {
		String xml = "<loc>"+loc+"</loc>\r\n";
		if (lastmod != null && !lastmod.equals("")) xml+= "<lastmod>"+lastmod+"</lastmod>\r\n";
		if (changefreq != null && !changefreq.equals("")) xml+= "<changefreq>"+changefreq+"</changefreq>\r\n";
		if (priority != -1) xml+= "<priority>"+priority+"</priority>\r\n";
		
		return xml;
	}
}
