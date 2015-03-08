# Disturb
Distributed application based on docker containers. Implements basic distributed algorithms.
```
//building an image
> git clone https://github.com/vrann/disturb.git
> docker build -t "disturb" ./disturb

//Running container
//There are three actors supported: ping, pong and yabaduka. Pass name of the actor when running container
> docker run -P -d disturb ping

//Let's find out what host system port is mapped to the port exposed in container
> docker ps
// 5a12806c6ee2 ....  0.0.0.0:49159->1366/tcp elegant_ptolemy

//If you are on Mac, let's see what ip is used for containers
> boot2docker ip
// 192.168.59.103

//Now, make a request to network socket
> telnet 192.168.59.103 49159
//Escape character is '^]'.
//accepted
//Start by typing a greeting. Hu kouza ping
//Zu hakarin #1

//You can type anything, response will be the same
> test
//ping

//Finish playing with the app. "Bye." is a stop word
>Bye.
//Connection closed by foreign host.
```

