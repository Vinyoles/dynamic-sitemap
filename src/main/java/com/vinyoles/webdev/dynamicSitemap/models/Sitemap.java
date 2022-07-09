package com.vinyoles.webdev.dynamicSitemap.models;

import java.util.List;

public class Sitemap {
	
	private List<Url> urlSet; //list of all the urls on the site
	private String sitemapindex; //You can specify other sitemaps location in this tag.
	private String sitemap; //Specify the details of sitemap
	
	
	public List<Url> getUrlSet() {
		return urlSet;
	}
	public void setUrlSet(List<Url> urlSet) {
		this.urlSet = urlSet;
	}
	public String getSitemapindex() {
		return sitemapindex;
	}
	public void setSitemapindex(String sitemapindex) {
		this.sitemapindex = sitemapindex;
	}
	public String getSitemap() {
		return sitemap;
	}
	public void setSitemap(String sitemap) {
		this.sitemap = sitemap;
	}
	
	
	public String getHeader() {
		String header = "<?xml version='1.0' encoding='UTF-8'?>\r\n";
		return header;
	}
	
	public String getValidation() {
		String validation = "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.sitemaps.org/schemas/sitemap/0.9 http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd\" xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\"";
		return validation;
	}
	
	public String toXML() {
		String xml = getHeader();
		xml += "<sitemap "+getValidation()+">\r\n";
		
		for (Url url : urlSet) {
			xml += "<url>";
			xml += url.toXML();
			xml += "</url>";
		}
		
		xml += "</sitemap>";
		
		return xml;
	}
	
}
