# NoteBook Entry Simulator

___An app to simulate the frequency of a word in notebook and also find similar words related to it.___

## Features
- Update notebook entry.
- Find frequency of a given word.
- Find similar words related to given word.


## Demo

## Setup

Below instructions will help you get started with the application and run in local system.

1. Install following on your local machine
	-  	[Git](https://git-scm.com)
	- [Node.js](https://nodejs.org/en/download/) (which comes with [npm](http://npmjs.com))
  -[Java](https://www.oracle.com/java/technologies/downloads/)
  -[Maven](https://maven.apache.org/download.cgi)
2. Clone the repository by running this following command
	```bash
	git clone https://github.com/hamzicio/labForward 
	```
  
3. Start backend  by running following commands
	```bash
	cd labforward/api/labNotebook
   mvn org.springframework.boot:spring-boot-maven-plugin:run
 
		
	# This will install dependencies and start backend server at port 8080 , in case your port is already allocated please change port inside application.properties file.
	```
  
4. Start frontend  by running following commands
	```bash
	cd labforward/ui/
	npm install -f
		
	# once node_modules gets install, run next command
	npm start
	```
5. Once your app is running, you can access it on the following address in your browser
	[http://localhost:3000](http://localhost:3000)

## Versions
Following versions are being used while creating this guide. 
```
java@11.0.x or higher
git@2.x.x or higher
node@v16.x.x or higher
npm@6.x.x or higher
maven@3.6.x or higher
```

## Branches
Current branches and their purposes are as follow.
```
main -> contains latest changes
stable -> reserved for production only
```

## Assumptions
```
By default when backend is started , notebook contains the following entry : "Word Words Wor word"
This can be updated from UI by clicking on update notebook button.
```

## Futher enhancements
```
1) Due to limited time , authentication mechanism could have been added
2) The notebook entries could have been saved into db and this would allow creation of new entries
3) Better test cases for Backend as well as new cases for frontend could have been written
4) Project could have been dockerized for single point of startup
```
