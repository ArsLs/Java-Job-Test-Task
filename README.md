# REST service counting occurences of each letter found in given string.
Simple REST Service. No database needed.  
#### Running:
1)Run "mvnw package" command and you'll get a jar in "target" folder.  
2)Run java -jar "jarname"  
#### Using:
By default service is running on 8080 port. Port can be changed by creating application.properties file in "" folder, and writing there a "server.port=" with the desired port. Service is waiting for GET requests with only one parameter "string".  
#### Example
Send: http://your-host:your-port/?string=iojkpjohuygftausgdhiojiasiod.,  
And get json in response :  
{
    "o": 4,
    "i": 4,
    "j": 3,
    "u": 2,
    "s": 2,
    "h": 2,
    "g": 2,
    "d": 2,
    "a": 2,
    "y": 1,
    "t": 1,
    "p": 1,
    "k": 1,
    "f": 1,
    ".": 1,
    ",": 1
}
