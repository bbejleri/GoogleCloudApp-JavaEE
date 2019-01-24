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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Cron service to start and end the elections
@WebServlet(name = "HelloAppEngine", urlPatterns = "/operation")


public class HelloAppEngine extends HttpServlet {

	private static final long serialVersionUID = 1L;

@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	
	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      
	 
      //Election time
	  String startDate = request.getParameter("startdate");
	  Date sdate = null;
	try {
		sdate = dateFormat.parse(startDate);
	} catch (ParseException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	  String endDate = request.getParameter("enddate");
	  Date edate = null;
	  try {
		 edate = dateFormat.parse(endDate);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	  
	  Date actualdate = new Date();
	 
	 //Check if dates are the same
     if(actualdate.compareTo(sdate) == 0) {
     
     String button = request.getParameter("button");
   	  
   	  
   	  if (button.equals("Add Candidate")) {
   		  addCandidate();
   	  }
   	  
   	  if(button.contentEquals("Import Email")) {
   		  importEmail();
   	  }
     
     }
	  	  
	  //just for testing
	  RequestDispatcher rs = request.getRequestDispatcher("/results.jsp");
			  try {
				rs.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
  }

      public void addCandidate() {
    	  //Code to add a Candidate
      }
      
      public void importEmail() {
    	  //Code to import an Email
      }
      
  
      
      
      public static String getInfo() {
    	    return "Version: " + System.getProperty("java.version")
    	          + " OS: " + System.getProperty("os.name")
    	          + " User: " + System.getProperty("user.name");
    	  }

}
