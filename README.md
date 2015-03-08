# disturb
Distributed application based on docker containers. Implements basic distributed algorithms.
```
> git clone https://github.com/vrann/disturb.git
> docker build -t "disturb" ./disturb
> docker run -P -d disturb ping
> docker ps
// 5a12806c6ee2 ....  0.0.0.0:49159->1366/tcp elegant_ptolemy
> boot2docker ip
// 192.168.59.103
> telnet 192.168.59.103 49159
//Escape character is '^]'.
//accepted
//Start by typing a greeting. Hu kouza ping
//Zu hakarin #1
> test
ping
```

