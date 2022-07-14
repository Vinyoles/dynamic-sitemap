package com.vinyoles.webdev.dynamicSitemap.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinyoles.webdev.dynamicSitemap.models.Sitemap;
import com.vinyoles.webdev.dynamicSitemap.models.Url;

@RestController
@RequestMapping("/api")
public class MainController {
	
	@GetMapping("/test1")
	public String test() {
		
		return "test";
	}

	
	
	
	@GetMapping(value="/sitemap.xml", produces={MediaType.APPLICATION_XML_VALUE})
	public String sitemap() {
		
		//get files and folders names TODO in progress
		String path = "../";
		File origin = new File(path);
		File[] files = origin.listFiles();

		for (File file : files) {
			String tempPath = path;
			do {
				if (file!=null && !file.getName().startsWith(".") && file.isFile()) {
					System.out.println(tempPath+file.getName());
					System.out.println("URI"+file.toURI());
				} else if (file!=null && !file.getName().startsWith(".") && file.isDirectory()) {
					tempPath += "/"+file.getName();
					file = file.listFiles()[0];
				} else {
					System.err.println("ERROR ON READING FILE PATH");
					break;
				}
			}
			while(file.isDirectory());
		}
		
		
		List<Url> urls = new ArrayList<Url>();
		Sitemap newSitemap = new Sitemap();
		
		Url newUrl = new Url();
		newUrl.setLoc("www.vinyoles.com"); //TODO hardcoded
		newUrl.setLastmod("2022-07-09"); //TODO hardcoded
		newUrl.setChangefreq("daily"); //TODO hardcoded
		newUrl.setPriority(0.8); //TODO hardcoded
		
		urls.add(newUrl);
		
		newSitemap.setUrlSet(urls);
		
		return newSitemap.toXML();
	}

}
