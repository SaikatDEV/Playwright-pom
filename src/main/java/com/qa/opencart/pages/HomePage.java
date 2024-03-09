package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

import jline.internal.Log;

public class HomePage {
	
	private Page page;

    //	PAGE LOCATORs are located Here
    //	*********************************ICONs[icn]*******************************
	private String icn_Search = "span.input-group-btn";
	
    //	*********************************HEADERs[hdr]******************************
	private String hdr_SearchPage = "#content h1";	

    //	*********************************CONTAINERs[ctn]***************************

    //	*********************************MENUs[mnu]********************************

    //	*********************************CHECKBOXes[chk]***************************

    //	*********************************FIELDs[fld]*******************************
	private String fld_Search = "input[name='search']";

    //	*********************************TEXTFIELDs[txt]***************************

    //	*********************************BUTTONs[btn]******************************


    //	*********************************FORMs[frm]********************************

    //	*********************************LINKs[lnk]********************************

    //	*********************************DDLs[ddl]*********************************

	//	Page Constructor
	public HomePage(Page page) {
		this.page = page;		
	}
	
	//	Methods/Actions
	public String getHomePageTitle() {
		String title = page.title();
		Log.info("Page Title is: " + title);
		return title;
	}

	public String getHomePageURL() {
		String url = page.url();
		Log.info("Home Page URL: " + url);
		return url;
	}
	
	public String doSearch(String productName) {
		page.fill(fld_Search, productName);
		page.click(icn_Search);
		Log.info("Search icon has been clicked");
		
		String header = page.textContent(hdr_SearchPage);
		Log.info("Header is: " + header);
		return header;
	}
	
	

	
	
}
