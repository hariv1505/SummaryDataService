package au.edu.unsw.sltf.services.test;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import au.edu.unsw.sltf.services.helper.MarketData;

public class SMDTest {

	public static void test() throws FileNotFoundException, ParseException {
		MarketData m = new MarketData("311359");
		List<MarketData> md = m.getMd();
	   	 boolean isMixed = false;
	   	 String sec = null;
	   	 Calendar startDate = null;
	   	 Calendar endDate = null;
	   	 String type = null;
	   	 String currCode = null;
	   	 String filesize;
	   	 
		sec = (md.get(0).getSec());
		startDate = (m.getStartTime());
		type = (md.get(0).getType());
		currCode = (m.getCurrencyCode());
	   	 
	   	 //traverse through the elements
	   	 for (int i = 1; (i < md.size()-1 && !isMixed); i++) {
			 //second line, get all the data we can
			 isMixed = !(md.get(i).getType()
				 .equals(type));
	   	 }
	   	 
	   	 //check if mixed
	   	 if (isMixed) {
	   		 type = ("Mixed");
	   	 }
	   	 
	   	 //get end time
	   	 endDate = (m.getEndTime());
	   	 
	   	 //get file size
	   	 filesize = (Long.toString(m.getFileSize()));
	   
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
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}