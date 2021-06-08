Feature: Upload Meter Read and Generate bill
@MeterRead
Scenario: Upload meter read using batch run & generate Bill
Given Open browser "Chrome"
When Login to CCB under "%ENV%" environment with user as "username" and password as "password"
Then Ensure user will be landed to "Control Central" after successful login
When Select "Account ID" from "Search BY" drop down list under "Control Central"
And Enter "7737321685" in the Account ID input field and click on Search button
And Navigate to below list from top to bottom in order to reach "MR Upload Staging" page
#---------------------------------------------------------------
# | Link               |
#---------------------------------------------------------------
  |Menu                |
  |Meter Read          |
  |MR Upload Staging   |
  |Add                 |
And Enter below values in "MR Upload Staging" page
#-----------------------------------------------------------------
# | Field              |       Values             |
#-----------------------------------------------------------------
  |BADGE NUMBER        |       EC0500             |
  |DATE                |       2019-05-09         |
  |TIME                |       12:57AM            |
  |MR SOURCE           |     Meter reader 19-19   |
And Select "USE ON BILL" check box
And Fill the "Meter Read" as mentioned below ::
#--------------------------------------------------------------------------------------------------------------
# |     SEQUENCE       |       READ TYPE          |  UNIT OF MEASURE | TIME OF USE       |   REGISTER READING  |
#--------------------------------------------------------------------------------------------------------------
  |        1           |        Regular           |  Kilowatt-Hours  |   On peak         |      450            |
  |        2           |        Regular           |  Kilowatt-Hours  |   Off peak        |      250            |
  |        3           |        Regular           |  Kilowatt-Hours  |   Shoulder Peak   |      550            |
  |        4           |        Regular           |  Kilowatt        |   On peak         |      250            |
And Click on "Save" button in "MR Upload Staging" page
Then Navigate to below list from top to bottom in order to reach "Batch Job Submission" page
#---------------------------------------------------------------
# | Link               |
#---------------------------------------------------------------
  |Menu                |
  |Tools               |
  |Batch Job Submission|
  |Add                 |
And Enter below values in "Batch Job Submission" page
#-----------------------------------------------------------------
# | Field              |       Values             |
#-----------------------------------------------------------------
  |BATCH CODE          |       MUP1               |
When Click on "Save" button in "Batch Job Submission" page
Then The value of "BATCH JOB STATUS" is displayed as "Ended" under "Batch Job Submission" page
Then Click on "Batch Control Context Menu - Batch Code" and then select "Go To Batch Run Tree" in "Batch Job Submission" page
And Navigate to below list from top to bottom in order to reach "MR Upload Staging" page
#---------------------------------------------------------------
# | Link               |
#---------------------------------------------------------------
  |Menu                |
  |Meter Read          |
  |MR Upload Staging   |
  |Search              |
And Close the browser