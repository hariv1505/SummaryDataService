
/**
 * SummaryMarketDataServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package au.edu.unsw.sltf.services;

import java.util.Calendar;

import au.edu.unsw.sltf.services.SummaryMarketDataDocument.SummaryMarketData;
import au.edu.unsw.sltf.services.SummaryMarketDataResponseDocument.SummaryMarketDataResponse;
import au.edu.unsw.sltf.services.helper.MarketData;
    /**
     *  SummaryMarketDataServiceSkeleton java skeleton for the axisService
     */
    public class SummaryMarketDataServiceSkeleton implements SummaryMarketDataServiceSkeletonInterface{
        
         
        /**
         * Auto generated method signature
         * 
         * @param summaryMarketData0 
         * @return summaryMarketDataResponse1 
         * @throws SummaryMarketDataFaultException 
         */
        
         public au.edu.unsw.sltf.services.SummaryMarketDataResponseDocument summaryMarketData
          (
          au.edu.unsw.sltf.services.SummaryMarketDataDocument summaryMarketData0
          )
            throws SummaryMarketDataFaultException{
        	 SummaryMarketData smd = summaryMarketData0.getSummaryMarketData();
        	 MarketData md = new MarketData(smd.getEventSetId());
        	 
        	 SummaryMarketDataResponseDocument smdRespDoc = SummaryMarketDataResponseDocument.Factory.newInstance();
        	 SummaryMarketDataResponse smdResp = smdRespDoc.addNewSummaryMarketDataResponse();
        	 
        	 smdResp.setEventSetId(smd.getEventSetId());
        	 boolean isMixed = false;
        	 
        	 //traverse through the elements
        	 for (int i = 0; (i < md.size()-1 && !isMixed); i++) {
        		 if (i == 0) {
        			 continue;
        		 }
        		 else {
        			 md.setIndex(i);
        			 //second line, get all the data we can
        			 if (i == 1) {
        				smdResp.setSec(md.getSec());
        				smdResp.setStartDate(stringifyDate(md.getStartTime()));
        				smdResp.setMarketType(md.getType());
        				smdResp.setCurrencyCode(md.getCurrencyCode());
        			 } else {
        				 isMixed = !(md.getType()
        						 .equals(smdResp.getMarketType()));
        			 }
        		 }
        	 }
        	 
        	 //check if mixed
        	 if (isMixed) {
        		 smdResp.setMarketType("Mixed");
        	 }
        	 
        	 //get end time
        	 md.setIndex(md.size()-1);
        	 smdResp.setEndDate(stringifyDate(md.getEndTime()));
        	 
        	 //get file size
        	 smdResp.setFileSize(Long.toString(md.getFileSize()));
        
        	 //TODO: do I have to abstract the response away from the client?
        	 //I have to create a "setReturn"?
        	 StringBuilder sbf = new StringBuilder();
             sbf.append("EventSetId: ").append(smdResp.getEventSetId()).append("\n");
             sbf.append("Security code: ").append(smdResp.getSec()).append("\n");
             sbf.append("Start Date: ").append(smdResp.getStartDate()).append("\n");
             sbf.append("End Date: ").append(smdResp.getEndDate()).append("\n");
             sbf.append("Market Type: ").append(smdResp.getMarketType()).append("\n");
             sbf.append("Currency code: ").append(smdResp.getCurrencyCode()).append("\n");
             sbf.append("File size: ").append(smdResp.getFileSize()).append("\n");
             //TODO: smdResp.setReturn(sbf.toString());
        	 
        	 smdRespDoc.setSummaryMarketDataResponse(smdResp);
        	 
			return smdRespDoc;
        }

		private Calendar stringifyDate(Calendar endTime) {
			// TODO Auto-generated method stub
			return null;
		}
     
    }
    