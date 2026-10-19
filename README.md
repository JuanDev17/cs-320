# Contact Management Application

## Overview

The Contact Management Application is a Java-based backend application that allows users to create, retrieve, update, and delete contact information.

Originally developed as part of my CS-320 Software Testing, Automation, and Quality Assurance course, the application was later enhanced to demonstrate improvements in software design, database integration, and maintainability.

The original application stored contacts in memory. I enhanced the application by integrating a relational database, allowing contact information to persist between application sessions.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- REST API
- JUnit
- Maven

## Features

- **Create Contacts:** Add new contacts with validation.
- **Retrieve Contacts:** Access stored contact information.
- **Update Contacts:** Modify existing contact details.
- **Delete Contacts:** Remove contacts from the database.
- **Input Validation:** Validate contact information to prevent invalid data.
- **Persistent Storage:** Store contacts in a PostgreSQL database instead of memory.

## Application Architecture

The application follows a layered backend architecture to separate responsibilities and improve maintainability.

- **Controller Layer:** Handles incoming HTTP requests and API endpoints.
- **Service Layer:** Contains business logic, validation, and contact management operations.
- **Repository Layer:** Communicates with the database using Spring Data JPA.
- **Database Layer:** Uses PostgreSQL to persist contact information.

## Reflection

### How can I ensure that my code, program, or software is functional and secure?

To ensure my code is functional and secure, I focus on writing automated tests, validating user input, performing code reviews, and following software development best practices. Testing helps identify bugs early, while validation prevents invalid data from entering the application. I also believe keeping code organized and maintainable makes it easier to identify and resolve potential issues.

### How do I interpret user needs and incorporate them into a program?

I start by gathering requirements and understanding what users need from the application. Creating user stories helps break those requirements into smaller, manageable tasks. I also believe gathering feedback throughout development is important because it helps ensure the application meets user expectations.

### How do I approach designing software?

When designing software, I start by defining the problem and outlining the requirements. From there, I create documentation, diagrams, or models to help visualize how the application should work. I also consider how different components will communicate with each other and how the application can be maintained or expanded in the future.

## Future Improvements

- Build an Angular frontend for managing contacts.
- Implement search and filtering functionality.
- Expand automated test coverage.
- Improve API documentation and error handling.
