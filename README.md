# GiftAFriend - Servlet and JSP Web Application

Welcome to GiftAFriend, a web application built using the Servlet and JSP framework. This application helps organize events where participants can randomly select friends for various activities, such as gift exchanges or special events.

## Features

- **Random Friend Selection**: Randomly assigns friends for various activities.
- **Database Integration**: Uses a database to store and retrieve participant information.
- **Web Interface**: Provides a user-friendly web interface for interacting with the application.
- **Servlet and JSP Framework**: Utilizes the Servlet and JSP framework for server-side processing and dynamic web pages.
- **Customizable**: Easily modify the participant list and other parameters to suit your event.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) version 8 or later.
- Servlet container (e.g., Apache Tomcat).
- Database (e.g., Oracle) for storing participant information.
- Git (optional, if you want to clone the repository).

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/WebSecretSantaApp.git


   Deploy the application to your servlet container (e.g., Tomcat).

   Configure the database connection in ConnectionJDBC.java.

   Access the application through your browser at http://localhost:8080/GiftAFriend.

####  Usage
1. Set up your database and configure the database connection in ConnectionJDBC.java.
2. Customize the participant list in SecretSanta objects within the GetDataServiceImpl class.
3. Run the application to get names with no "ToFriend" and "FromFriend" assignments.
4. Assign ToFriends using the provided methods and update the database accordingly.
5. Retrieve assigned ToFriend names and organize your event with GiftAFriend's web interface.
