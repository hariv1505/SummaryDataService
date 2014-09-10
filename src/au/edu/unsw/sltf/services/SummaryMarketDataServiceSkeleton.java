
/**
 * SummaryMarketDataServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package au.edu.unsw.sltf.services;

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
        			 md.get(i);
        			 //second line, get all the data we can
        			 if (i == 1) {
        				smdResp.setSec(md.getSec());
        				smdResp.setStartDate(md.getDate());
        				smdResp.setMarketType(md.getMarketType());
        				smdResp.setCurrencyCode(md.getCurrencyCode());
        			 } else {
        				 isMixed = !(md.getMarketType()
        						 .equals(smdResp.getMarketType()));
        			 }
        		 }
        	 }
        	 
        	 //check if mixed
        	 if (isMixed) {
        		 smdResp.setMarketType("Mixed");
        	 }
        	 
        	 //get end time
        	 md.get(md.size()-1);
        	 smdResp.setEndDate(md.getDate());
        	 
        	 //get file size
        	 smdResp.setFileSize(md.getFileSize());
        	 
        	 smdRespDoc.setSummaryMarketDataResponse(smdResp);
			return smdRespDoc;
        }
     
    }
    