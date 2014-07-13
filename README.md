How to run GoManager
1. Make sure you have Maven installed and runnable from command line (refer to Maven documentation on how to do this)
2. Make sure you are connected to the internet to download project's dependencies
3. Open command line and navigate to project's root directory
4. Run the following command:
   mvn -e clean tomcat:run
5. Open the following link in your browser:
   http://localhost:8080/GoManager/
6. For this GoManager demo, in-memory database is used, therefore keep in mind that data will be gone once you stop/restart the app/server.

Framework: Spring Roo