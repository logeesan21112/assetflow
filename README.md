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

<table>
<tr>
<td align="center"><b>Dashboard</b></td>
<td align="center"><b>Vendor Details</b></td>
</tr>
<tr>
<td><img src="https://github.com/user-attachments/assets/d512b17e-e169-47b9-8dac-c67c9c2e0397" width="100%"/></td>
<td><img src="https://github.com/user-attachments/assets/294fe2b4-bbab-433b-8713-ca69472ff09f" width="100%"/></td>
</tr>
<tr>
<td align="center"><b>Add Vendor</b></td>
<td align="center"><b>Edit Vendor</b></td>
</tr>
<tr>
<td><img src="https://github.com/user-attachments/assets/cd93d014-731c-48b5-b82e-ffefe69208e0" width="100%"/></td>
<td><img src="https://github.com/user-attachments/assets/44afef6d-036e-4935-a3ed-5ea6941a7c73" width="100%"/></td>
</tr>
<tr>
<td align="center"><b>Categories</b></td>
<td align="center"><b>Add Category</b></td>
</tr>
<tr>
<td><img src="https://github.com/user-attachments/assets/a9536b79-3011-444d-9206-cfa5634aadfa" width="100%"/></td>
<td><img src="https://github.com/user-attachments/assets/4aaca428-ace8-4863-b4aa-d275acee94fe" width="100%"/></td>
</tr>
</table>

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

2. Open `src/main/resources/application.properties` and update your database credentials
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/digital_vendors
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

3. The tables will be created automatically when you run the application

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
