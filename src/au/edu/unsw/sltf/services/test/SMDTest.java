package au.edu.unsw.sltf.services.test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import au.edu.unsw.sltf.services.helper.MarketData;

public class SMDTest {

	public static void test() throws FileNotFoundException {
		List<MarketData> m = new ArrayList<MarketData>();
		MarketData md = new MarketData("12345");
	   	 boolean isMixed = false;
	   	 String sec = null;
	   	 Calendar startDate = null;
	   	 Calendar endDate = null;
	   	 String type = null;
	   	 String currCode = null;
	   	 String filesize;
	   	 
	   	 //traverse through the elements
	   	 for (int i = 0; (i < md.size()-1 && !isMixed); i++) {
			 	 md.setIndex(i);
				 //second line, get all the data we can
				 if (i == 1) {
					sec = (md.getSec());
					startDate = (md.getStartTime());
					type = (md.getType());
					currCode = (md.getCurrencyCode());
				 } else {
					 isMixed = !(md.getType()
						 .equals(type));
				 }
	   	 }
	   	 
	   	 //check if mixed
	   	 if (isMixed) {
	   		 type = ("Mixed");
	   	 }
	   	 
	   	 //get end time
	   	 md.setIndex(md.size()-1);
	   	 endDate = (md.getEndTime());
	   	 
	   	 //get file size
	   	 filesize = (Long.toString(md.getFileSize()));
	   
	   	 StringBuilder sbf = new StringBuilder();
	        sbf.append("EventSetId: ").append("12345").append("\n");
	        sbf.append("Security code: ").append(sec).append("\n");
	        sbf.append("Start Date: ").append(startDate).append("\n");
	        sbf.append("End Date: ").append(endDate).append("\n");
	        sbf.append("Market Type: ").append(type).append("\n");
	        sbf.append("Currency code: ").append(currCode).append("\n");
	        sbf.append("File size: ").append(filesize).append("\n");
	   	 
	        System.out.println(sbf.toString());
	}
	
	public static void main(String[] args) {
		try {
			test();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}