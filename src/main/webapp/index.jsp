<!DOCTYPE html>
<!-- [START_EXCLUDE] -->
<%--
  ~ Copyright 2017 Google Inc.
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License"); you
  ~ may not use this file except in compliance with the License. You may
  ~ obtain a copy of the License at
  ~
  ~     http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
  ~ implied. See the License for the specific language governing
  ~ permissions and limitations under the License.
  --%>
<!-- [END_EXCLUDE] -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.appengine.java8.HelloAppEngine" %>
<html>
<head>
  <link href='//fonts.googleapis.com/css?family=Marmelad' rel='stylesheet' type='text/css'>
  <title>Log In</title>
  <style>

body {
 background-color:#bfeda8;
 font-family: "Lucida Sans Unicode";
 }
</style>
</head>
<body>
    
    <h2>Welcome to our voting system!</h2>
  
   
    <p><b>If you are an administrator of the system, use your google mail address to log in to backend page:</b></p>
    <a href="/backend.jsp"><input type="button" value="Go to backend page"></a>
    
 
 <p><b>If you are a User, you are eligible to only view the pages below:</b></p>
    <a href="/voting.jsp"><input type="button" value="Go to voting page"></a><br>
    <a href="/results.jsp"><input type="button" value="Go to results page"></a>
    


</body>
</html>
