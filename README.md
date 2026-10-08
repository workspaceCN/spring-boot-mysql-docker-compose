# Spring Boot + MySQL with Docker Compose

**CLOUD NATION** &mdash; Docker Class | Created by Mohammed Mubashir
WhatsApp: +91 78878 01551 | Email: cloudnation46@gmail.com

A Spring Boot application and a MySQL database started together by **Docker Compose**.

## Run it on your EC2 (Amazon Linux) machine

```bash
sudo yum install git maven -y
git clone https://github.com/WorkspaceCN/spring-boot-mysql-docker-compose.git
cd spring-boot-mysql-docker-compose
mvn clean package
docker build -t spring-boot-mysql-app .
docker-compose up -d
docker-compose ps
```

Open in the browser: `http://<EC2-public-ip>:8080/`

Remember to open the port in the EC2 **Security Group** (Inbound rule, Custom TCP, Anywhere IPv4).

---
*Cloud Nation: learn, practise, get hired.*

> **Note:** MySQL needs about 20-30 seconds to start. The app has `restart: always`, so if it starts too early it restarts itself until the database is ready.
