readme.

Flow:
1:As per given scenario there is no label called recomanded for you hence used recent videos.
2: Clicking on a Recent Video to get into videos page where we can find bunch of videos to work with.
3: Once successfully naviagted to Videos page, collected video title's ,decriptions and clicked on + icon to add to fevoroite(Watch Later).
4:Navigating to My Videos Page to verify fevoroite videos added and verifying the Title and Description by
 asserting the data collected while adding with data after adding to fevoroite.

Issues Faced:
//Elements are Dynamic in nature so struggled with writing XPATH.
//Element are not clickable as video page is getiing refreshed so Browser DOM is getting refreshed.

Used JavaScriptExecuter for clicking ,to over come this element not clickable issue.


How to Run:

Clone the project from GIT HUB 
run the TestRunner file 

 
Note:
As dom is getting refreshed some time we may get "stale element reference :element is not attached to the page document"

to over come this issue we can use try catch block but 99% time this will not work , so i used javascriptexecuter to forcefully click on the element.