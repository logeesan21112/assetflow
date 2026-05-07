<div align="center">
  <h1>AssetFlow</h1>
  <p>A digital asset vendor management system built with Spring Boot and Thymeleaf.</p>

  ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.6-6DB33F?style=flat&logo=springboot)
  ![Java](https://img.shields.io/badge/Java-17-007396?style=flat&logo=java)
  ![MySQL](https://img.shields.io/badge/MySQL-8-4479A1?style=flat&logo=mysql)
  ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3-005F0F?style=flat&logo=thymeleaf)
  ![Maven](https://img.shields.io/badge/Maven-3.8-C71A36?style=flat&logo=apachemaven)
</div>

---

## About

AssetFlow is a full-stack web application for managing digital asset vendors and their categories. It allows users to add, view, edit, and delete vendors with photo uploads, manage product categories, and maintain a clean organized vendor directory — all through a minimal and responsive UI.

---

## Features

- Full CRUD for digital asset vendors
- Full CRUD for vendor categories
- Vendor photo upload and preview
- Category duplicate validation with friendly error messages
- Form validation on all inputs
- Responsive dashboard with vendor table
- Vendor detail view with profile card
- Clean minimal UI with Inter font

---

## Screenshots

<div align="center">

<img src="screenshots/dashboard.png" width="45%"/>
<img src="screenshots/vendor-details.png" width="45%"/>

<img src="screenshots/vendor-add.png" width="45%"/>
<img src="screenshots/vendor-edit.png" width="45%"/>

<img src="screenshots/categories.png" width="45%"/>
<img src="screenshots/category-add.png" width="45%"/>

</div>

---

## Tech Stack

**Backend**
- Java 17
- Spring Boot 3.3.6
- Spring Data JPA and Hibernate
- Spring Validation
- Maven

**Frontend**
- Thymeleaf
- HTML5 and CSS3
- JavaScript (vanilla)
- Inter (Google Fonts)

**Database**
- MySQL 8

---

## Project Structure

```
assetflow/
├── src/
│   ├── main/
│   │   ├── java/com/group8/assetflow/
│   │   │   ├── controller/
│   │   │   │   ├── CategoryController.java
│   │   │   │   └── DigitalVendorController.java
│   │   │   ├── exception/
│   │   │   │   └── CategoryAlreadyExistsException.java
│   │   │   ├── model/
│   │   │   │   ├── Category.java
│   │   │   │   └── DigitalVendor.java
│   │   │   ├── repository/
│   │   │   │   ├── CategoryRepository.java
│   │   │   │   └── DigitalVendorRepository.java
│   │   │   ├── service/
│   │   │   │   ├── CategoryService.java
│   │   │   │   ├── DigitalVendorService.java
│   │   │   │   └── FileUploadService.java
│   │   │   ├── MvcConfig.java
│   │   │   └── AssetflowApplication.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── vendor/
│   │       │   │   ├── form.html
│   │       │   │   └── details.html
│   │       │   ├── category/
│   │       │   │   ├── form.html
│   │       │   │   └── categories.html
│   │       │   └── dashboard.html
│   │       └── application.properties
│   └── test/
├── screenshots/
├── pom.xml
└── README.md
```

---

## Getting Started

### Prerequisites
- Java 17+
- MySQL 8+
- Maven 3.8+

### Database Setup

1. Open MySQL and create the database
```sql
CREATE DATABASE digital_vendors;
```

2. Configure your database credentials in `src/main/resources/application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/digital_vendors
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### Run the Application

1. Clone the repository
```
git clone https://github.com/YOUR_USERNAME/assetflow.git
```

2. Navigate to the project folder
```
cd assetflow
```

3. Run with Maven
```
mvnw spring-boot:run
```

4. Open in your browser
```
http://localhost:8080
```

---

## Author

**Logeesan R.**
- GitHub: [@logeesan21112](https://github.com/logeesan21112)
- Email: r.logeesan21112@gmail.com

---

## License

This project is open source and available under the MIT License.
