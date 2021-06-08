Feature: I want to login to CC&B 2.7.1
@Login
Scenario:  Login to CC&B with valid credential

Given Open browser "Chrome"
When Login to CCB under "%ENV%" environemnt with user as "" and password as ""
Then close the browser 