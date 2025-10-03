# Uber-like Backend Microservices (Work-in-Progress)

This is a **microservices-based backend** for an Uber-like application, built using **Spring Boot**, **Spring Cloud Gateway**, **Eureka**, and **JWT security**. The project demonstrates my understanding of microservices, API gateways, service discovery, and role-based authentication.

---

## Key Highlights

- Built a **microservices architecture** with independent services for Riders, Drivers, Auth, and API Gateway  
- Implemented **JWT-based authentication** and partial role-based authorization  
- Configured **Eureka Service Discovery** for dynamic service registration  
- Designed REST APIs for **CRUD operations** on Rider and Driver data  
- Implemented **API Gateway routing** and request filtering  
- Project structured for **scalability** and easy addition of new services  

---

## Tech Stack

- **Backend**: Java, Spring Boot, Spring Security  
- **Microservices & Cloud**: Spring Cloud Gateway, Eureka  
- **Security**: JWT, role-based access control  
- **Database**: H2 (in-memory, ready to migrate to PostgreSQL/MySQL)  
- **Build & Version Control**: Maven, Git/GitHub  

---

## Current Status

- Partial security implemented (JWT + API Gateway filters)  
- Rider and Driver services functional  
- Auth server implemented for registration and login  
- API Gateway routes configured  

---

## Future Work

- Complete **role-based authorization** through API Gateway  
- Add **ride booking and management services**  
- Integrate **persistent databases** and caching  
- Add **unit/integration tests**  
- Implement **Dockerization** for microservices
- Build Frontend for this

---

## Project Repository

[GitHub Link](https://github.com/theXunnY/uber-backend-microservices-theXunnY)  

---

**Note:** This project showcases backend microservices skills, security implementation, and cloud-native architecture concepts.
