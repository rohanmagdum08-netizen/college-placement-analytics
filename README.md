# College Placement Analytics Platform

Monitor placement readiness, skill gaps, interview activity, and student progress.

## Run in VS Code

1. Install JDK 17 or newer, Maven 3.9 or newer, and the VS Code Extension Pack for Java.
2. Open this project folder in VS Code.
3. Open the integrated terminal and run these commands:

   cd api
   mvn spring-boot:run

4. When Spring Boot reports that it started, open http://localhost:8190.

The browser dashboard is served by Java. No separate frontend server or database install is needed. On first run, Maven downloads Spring dependencies from Maven Central, so an internet connection is needed. Keep the terminal open. App data is saved under api/data.

Demo administrator: admin / admin123 (can add, edit, and delete).
Demo viewer: demo / demo123 (read only).

Includes a Spring Boot REST API, local H2 database, sample data, access roles, reminders, and reports. Eligibility prediction, coding-platform sync, and interview integrations are not connected yet.
