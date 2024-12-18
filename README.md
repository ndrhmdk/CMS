# Cinema Management System (CMS)

## Overview

The **Cinema Management System (CMS)** is a Java-based application designed to automate and streamline various operations in a movie theatre. Developed as a part of the **Object-Oriented Programming (OOP)** module, the project leverages Java Swing for the user interface and SQL Server for database management. The CMS enables online ticket booking, real-time seat availability tracking, and efficient management of movie screenings, showtimes, and customer data.

---

## Features

### **For Customers**
- **Account Management**: Register, log in, and log out.
- **Movie Browsing**: View detailed movie information (trailers, genres, duration, etc.).
- **Ticket Booking**: Book tickets by selecting a movie, schedule, and seat.
- **Booking History**: View past bookings and details.
- **Notifications**: Receive updates about bookings, cancellations, and promotions.
- **Secure Payments**: Support for multiple payment methods.\

### **For Admins**
- **Movie Management**: Add, update, and delete movie details.
- **Schedule Management**: Create, update, and delete showtimes.
- **Revenue Management**: View transaction history and generate financial reports.
- **Ticket Pricing**: Set and update ticket prices.
- **Notification System**: Send updates to users about bookings, payments, and promotions.
- **Cancellation Requests**: Approve or disapprove refund requests.

### **For Staff**
- **Customer Support**: Assist customers with queries and ticket booking issues.
- **Booking Management**: Confirm, verify, and manage ticket bookings.
- **Schedule Monitoring**: Access information about movie schedules and showtimes.

### **System Features**
- **Real-Time Seat Availability**: Display available seats for each schedule.
- **Reporting Tools**: Generate detailed revenue reports.
- **Notifications**: Automated notifications for booking confirmations, cancellations, and transactions.

---

## Technical Details

### **Development Environment**
- **Programming Language**: Java
- **Database**: SQL Server (connected via JDBC)
- **IDE**: NetBeans & IntelliJ IDEA Ultimate
- **UI Framework**: Java Swing

### **System Architecture**
- **Object-Oriented Design**: Implements principles like encapsulation, inheritance, and polymorphism.
- **Use Case Diagram**: Visualizes system interactions for actors (Admins, Customers, Staff).
- **ER Diagram**: Defines database relationships for movies, schedules, tickets, and users.

### **Non-Functional Requirements**
- **Performance**: Handles up to 10,000 concurrent requests with <1 second response time.
- **Security**: User data is encrypted; only authorized users can access admin features.
- **Usability**: Intuitive interface with a maximum of 3 clicks to access features.
- **Reliability**: Daily automated backups and high system availability.
