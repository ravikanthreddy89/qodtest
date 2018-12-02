# qodtest
QuoteOfTheDay app.

Running Instructions :
  Issue "mvn clean package" command from the project home directory.
  Deploy the generated web archive (WAR) file onto your container (tested on tomcat)

Dependenices :
1. Mongodb running on localhost at default port.

End points :
/qodtest/api/quote/

method : POST

payload : 

{"fields" : {
  "quote" : "Simplicity is the prerequisite of reliability.", 
  "author" : "Edsger W. Dijkstra"}
}

