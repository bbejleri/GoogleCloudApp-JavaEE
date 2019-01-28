/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.appengine.java8;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.mail.MailService.Message;


//Cron service to start and end the elections
@WebServlet(name = "HelloAppEngine", urlPatterns = "/operation")


public class HelloAppEngine extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(HelloAppEngine.class.getName());
	
	



    private List<String> emails = new ArrayList<String>();
    
@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	
	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      
	 
      //Getting start date from user input
	  String startDate = request.getParameter("startdate");
	  Date sdate = null;
	  if (startDate != null) {
	try {
		sdate = dateFormat.parse(startDate);
	} catch (ParseException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	}
	
	 //Getting end date from user input
	  String endDate = request.getParameter("enddate");
	  Date edate = null;
	  if(endDate != null) {
	  try {
		 edate = dateFormat.parse(endDate);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  }
	 
	 Date actualdate = new Date();
	 
	 //checks if actual date is between the given interval
     if(sdate.compareTo(actualdate) * actualdate.compareTo(edate) > 0) {
     
     String button = request.getParameter("button");
   	  
   	  
   	  if (button.equals("Add Candidate")) {
   		  String fname = request.getParameter("firstname");
   		  String lname = request.getParameter("lastname");
   		  String faculty = request.getParameter("faculty");
   		  addCandidate(fname, lname, faculty);
   	  }
   	  
   	  if(button.contentEquals("Import Email")) {
   		  
   	      String email = request.getParameter("emails");
   		  importEmail(email);
   	  }
   	  
   	  if (button.contentEquals("Send Emails")) {
   		  if(emails.size() > 0) {
   			  sendEmail();
   		  }
   		  else {
   			  LOGGER.info("No imported emails.");
   		  }
   	  }
     
     }
     
     else {
    	 LOGGER.info("This service only works between the selected interval of elections, i.e " + startDate + "-" + endDate);
     }
	  	        
  }

   DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
   Transaction txn = datastore.beginTransaction();
   
      public void addCandidate(String firstname, String lastname, String faculty) {
    	  try {
    	 Entity candidate = new Entity("Candidate");
    	 candidate.setProperty("firstname", firstname);
    	 candidate.setProperty("lastname", lastname);
    	 candidate.setProperty("faculty", faculty);
    	 datastore.put(txn, candidate);
         txn.commit();
         LOGGER.info("Uploaded Successfully!");
      }
      finally {if (txn.isActive()) {
    	    txn.rollback();
    	    LOGGER.warning("An error occured while uploading candidate.");
      } 
    }
  }
      //Each email will be stored in a list
      public void importEmail(String email) {
    	  emails.add(email);
    	  System.out.println(emails);
      }
      
      
      public void sendEmail() {
    	  
    	  Properties props = new Properties();
    	  Session session = Session.getDefaultInstance(props, null);


    	  
    	  for (int i=0; i<emails.size(); i++) {
    		  try {
    			  MimeMessage msg = new MimeMessage(session);
    			  msg.setFrom(new InternetAddress("admin@example.com", "Example.com Admin"));
    			  msg.addRecipient(RecipientType.TO,
    			                   new InternetAddress(emails.get(i), "Mr/Ms. User"));
    			  msg.setSubject("University Elections");
    			  msg.setText("This is a test");
    			  Transport.send(msg);
    	  }catch (AddressException e) {
    	        e.printStackTrace();
    	    } catch (MessagingException e) {
    	        e.printStackTrace();
    	    } catch (UnsupportedEncodingException e) {
    	        e.printStackTrace();
    	    }
      }
      }
      
  
      
      
      
      
      
       
      public static String getInfo() {
    	    return "Version: " + System.getProperty("java.version")
    	          + " OS: " + System.getProperty("os.name")
    	          + " User: " + System.getProperty("user.name");
    	  }

}
