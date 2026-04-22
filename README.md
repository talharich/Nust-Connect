# 🎓 NUST Connect - Campus Social Network Platform

> A full-featured campus social network platform built for NUST students, faculty, and staff. Connect, collaborate, and thrive!

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Environment Variables](#environment-variables)
- [Database Schema](#database-schema)
- [Authentication](#authentication)
- [Contributing](#contributing)

---

## 🌟 Overview

NUST Connect is a comprehensive campus social network platform designed exclusively for the NUST community. It brings together students, faculty, and staff in one unified platform, enabling them to connect socially, manage club activities, buy and sell items, share rides, report lost and found items, and much more.

---

## ✨ Features

### 👤 User Management
- User registration & login (NUST email only)
- JWT-based authentication
- Role-based access control (Student, Faculty, Admin, Club Admin)
- Email verification
- Password reset via email
- User profiles with bio, profile picture, cover photo

### 📱 Social Features
- Create, edit, delete posts (Public / Friends / Private)
- Like & unlike posts
- Comment & reply on posts
- Friend requests & friend management
- Direct messaging between users
- Real-time notifications

### 🎭 Clubs & Events
- Create and manage clubs (Academic, Cultural, Sports)
- Club membership management (President, Vice President, Member)
- Admin approval for clubs
- Create and manage events
- Event registration & waitlisting
- QR code-based event tickets
- Venue booking system

### 🛒 Marketplace
- Buy & sell items between students
- Item categories & conditions
- Image uploads
- Order management
- Search & filter items by price range

### 🚗 Ride Sharing
- Post available rides
- Request to join rides
- Driver accepts/rejects requests
- Search rides by location

### 🔍 Lost & Found
- Report lost items
- Report found items
- Search & match lost/found items
- Claim found items

### 📢 Announcements
- Create & manage announcements
- Priority levels (High, Normal, Low)
- Department-specific announcements
- Pin important announcements

### 💼 Job Postings
- Post internships, part-time, full-time jobs
- Search & filter by type and location
- Application deadlines
- View count tracking

### 📝 Feedback & Reports
- Submit feedback (Complaints, Suggestions, Bug Reports)
- Admin assignment & resolution workflow
- Report users, posts, comments, events
- Admin moderation tools

---

## 🛠️ Tech Stack

### Backend
| Technology | Purpose |
|-----------|---------|
| Java 17 | Programming Language |
| Spring Boot 3.x | Application Framework |
| Spring Security | Authentication & Authorization |
| Spring Data JPA | Database ORM |
| Hibernate | ORM Implementation |
| MySQL | Database |
| JWT (jjwt 0.12.3) | Token-based Auth |
| BCrypt | Password Hashing |
| Lombok | Boilerplate Reduction |
| Jakarta Validation | Input Validation |
| Spring Mail | Email Service |
| Maven | Build Tool |

### Frontend (Coming Soon)
| Technology | Purpose |
|-----------|---------|
| React.js | UI Framework |
| Next.js | Full-stack Framework |
| Tailwind CSS | Styling |
| Axios | HTTP Client |
| React Query | Data Fetching |

---

## 📁 Project Structure

```
NUSTConnect/
├── Backend/
│   └── nustconnect/
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/com/nustconnect/backend/
│       │   │   │   ├── Config/
│       │   │   │   │   ├── SecurityConfig.java
│       │   │   │   │   ├── JwtAuthenticationFilter.java
│       │   │   │   │   └── GlobalExceptionHandler.java
│       │   │   │   ├── Controllers/
│       │   │   │   │   ├── AuthController.java
│       │   │   │   │   ├── UserController.java
│       │   │   │   │   ├── PostController.java
│       │   │   │   │   ├── ClubController.java
│       │   │   │   │   ├── EventController.java
│       │   │   │   │   ├── MarketplaceController.java
│       │   │   │   │   ├── RideShareController.java
│       │   │   │   │   ├── LostAndFoundController.java
│       │   │   │   │   ├── AnnouncementController.java
│       │   │   │   │   ├── FeedbackController.java
│       │   │   │   │   ├── ReportController.java
│       │   │   │   │   ├── JobPostingController.java
│       │   │   │   │   ├── MessageController.java
│       │   │   │   │   └── NotificationController.java
│       │   │   │   ├── DTOs/
│       │   │   │   │   ├── Auth/
│       │   │   │   │   ├── User/
│       │   │   │   │   ├── Post/
│       │   │   │   │   ├── Club/
│       │   │   │   │   ├── Event/
│       │   │   │   │   ├── Marketplace/
│       │   │   │   │   ├── RideShare/
│       │   │   │   │   ├── LostAndFound/
│       │   │   │   │   ├── Announcement/
│       │   │   │   │   ├── Feedback/
│       │   │   │   │   ├── Report/
│       │   │   │   │   ├── Job/
│       │   │   │   │   ├── Message/
│       │   │   │   │   └── Notification/
│       │   │   │   ├── Enums/
│       │   │   │   │   ├── UserRole.java
│       │   │   │   │   ├── ClubCategory.java
│       │   │   │   │   ├── EventApprovalStatus.java
│       │   │   │   │   ├── PostVisibility.java
│       │   │   │   │   └── [10 more enums]
│       │   │   │   ├── Exceptions/
│       │   │   │   │   ├── ResourceNotFoundException.java
│       │   │   │   │   ├── DuplicateResourceException.java
│       │   │   │   │   ├── UnauthorizedException.java
│       │   │   │   │   ├── ForbiddenException.java
│       │   │   │   │   ├── BadRequestException.java
│       │   │   │   │   └── InvalidTokenException.java
│       │   │   │   ├── Models/
│       │   │   │   │   ├── BaseEntity.java
│       │   │   │   │   ├── User.java
│       │   │   │   │   ├── Profile.java
│       │   │   │   │   ├── Post.java
│       │   │   │   │   ├── Comment.java
│       │   │   │   │   ├── Like.java
│       │   │   │   │   ├── Friendship.java
│       │   │   │   │   ├── Club.java
│       │   │   │   │   ├── ClubMembership.java
│       │   │   │   │   ├── Event.java
│       │   │   │   │   ├── EventRegistration.java
│       │   │   │   │   ├── EventTicket.java
│       │   │   │   │   ├── Venue.java
│       │   │   │   │   ├── VenueBooking.java
│       │   │   │   │   ├── MarketplaceItem.java
│       │   │   │   │   ├── MarketplaceOrder.java
│       │   │   │   │   ├── MarketplaceCategory.java
│       │   │   │   │   ├── RideShare.java
│       │   │   │   │   ├── RideRequest.java
│       │   │   │   │   ├── LostItem.java
│       │   │   │   │   ├── FoundItem.java
│       │   │   │   │   ├── Announcement.java
│       │   │   │   │   ├── Feedback.java
│       │   │   │   │   ├── Report.java
│       │   │   │   │   ├── JobPosting.java
│       │   │   │   │   ├── Message.java
│       │   │   │   │   └── Notification.java
│       │   │   │   ├── Repositories/
│       │   │   │   │   └── [26 Repository interfaces]
│       │   │   │   └── Services/
│       │   │   │       ├── AuthService.java
│       │   │   │       ├── UserService.java
│       │   │   │       ├── ProfileService.java
│       │   │   │       ├── PostService.java
│       │   │   │       ├── CommentService.java
│       │   │   │       ├── LikeService.java
│       │   │   │       ├── FriendshipService.java
│       │   │   │       ├── ClubService.java
│       │   │   │       ├── ClubMembershipService.java
│       │   │   │       ├── EventService.java
│       │   │   │       ├── EventRegistrationService.java
│       │   │   │       ├── EventTicketService.java
│       │   │   │       ├── VenueService.java
│       │   │   │       ├── VenueBookingService.java
│       │   │   │       ├── MarketplaceService.java
│       │   │   │       ├── RideShareService.java
│       │   │   │       ├── LostAndFoundService.java
│       │   │   │       ├── AnnouncementService.java
│       │   │   │       ├── FeedbackService.java
│       │   │   │       ├── ReportService.java
│       │   │   │       ├── JobPostingService.java
│       │   │   │       ├── MessageService.java
│       │   │   │       ├── NotificationService.java
│       │   │   │       ├── EmailService.java
│       │   │   │       ├── JwtService.java
│       │   │   │       └── CustomUserDetailsService.java
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   └── test/
│       └── pom.xml
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

Make sure you have installed:
- [Java 17+](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [MySQL 8.0+](https://dev.mysql.com/downloads/)
- [Git](https://git-scm.com/)

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/nust-connect.git
cd nust-connect
```

### 2. Setup MySQL Database

```sql
CREATE DATABASE nustconnect;
CREATE USER 'nustconnect'@'localhost' IDENTIFIED BY 'yourpassword';
GRANT ALL PRIVILEGES ON nustconnect.* TO 'nustconnect'@'localhost';
FLUSH PRIVILEGES;
```

### 3. Configure Environment Variables

Create a `.env` file in the root or set these environment variables:

```bash
DB_USERNAME=root
DB_PASSWORD=yourpassword
JWT_SECRET=your_super_secret_jwt_key_minimum_32_characters
MAIL_HOST=smtp.gmail.com
MAIL_PORT=587
MAIL_USERNAME=your-email@gmail.com
MAIL_PASSWORD=your-app-password
```

### 4. Update application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nustconnect
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
jwt.secret=${JWT_SECRET}
```

### 5. Build & Run

```bash
cd Backend/nustconnect
mvn clean install
mvn spring-boot:run
```

The server will start at `http://localhost:8080` 🎉

---

## 📡 API Documentation

### Base URL
```
http://localhost:8080/api
```

### Authentication Endpoints
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/auth/register` | Register new user | ❌ |
| POST | `/auth/login` | Login user | ❌ |
| GET | `/auth/verify-email?token=` | Verify email | ❌ |
| POST | `/auth/forgot-password` | Request password reset | ❌ |
| POST | `/auth/reset-password` | Reset password | ❌ |
| POST | `/auth/change-password/{userId}` | Change password | ✅ |
| POST | `/auth/refresh-token` | Refresh JWT token | ✅ |

### User Endpoints
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | `/users/{userId}` | Get user by ID | ✅ |
| GET | `/users` | Get all users | ✅ Admin |
| GET | `/users/search?keyword=` | Search users | ✅ |
| PUT | `/users/{userId}` | Update user | ✅ |
| GET | `/users/{userId}/profile` | Get user profile | ✅ |
| POST | `/users/{userId}/profile` | Create profile | ✅ |
| PUT | `/users/{userId}/profile` | Update profile | ✅ |

### Post Endpoints
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/posts` | Create post | ✅ |
| GET | `/posts/{postId}` | Get post | ✅ |
| GET | `/posts` | Get all posts | ✅ |
| GET | `/posts/user/{userId}` | Get user posts | ✅ |
| PUT | `/posts/{postId}` | Update post | ✅ |
| DELETE | `/posts/{postId}` | Delete post | ✅ |
| POST | `/posts/{postId}/like` | Like post | ✅ |
| DELETE | `/posts/{postId}/unlike` | Unlike post | ✅ |
| POST | `/posts/{postId}/comments` | Add comment | ✅ |
| GET | `/posts/{postId}/comments` | Get comments | ✅ |

### Club Endpoints
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/clubs` | Create club | ✅ |
| GET | `/clubs/{clubId}` | Get club | ✅ |
| GET | `/clubs` | Get all clubs | ✅ |
| PUT | `/clubs/{clubId}` | Update club | ✅ |
| PATCH | `/clubs/{clubId}/approve` | Approve club | ✅ Admin |
| POST | `/clubs/{clubId}/join` | Join club | ✅ |
| DELETE | `/clubs/{clubId}/leave` | Leave club | ✅ |
| GET | `/clubs/{clubId}/members` | Get members | ✅ |

### Event Endpoints
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/events` | Create event | ✅ |
| GET | `/events/{eventId}` | Get event | ✅ |
| GET | `/events` | Get all events | ✅ |
| GET | `/events/upcoming` | Get upcoming events | ✅ |
| PATCH | `/events/{eventId}/approve` | Approve event | ✅ Admin |
| POST | `/events/{eventId}/register` | Register for event | ✅ |
| DELETE | `/events/{eventId}/unregister` | Unregister | ✅ |

### Marketplace Endpoints
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/marketplace/items` | Create listing | ✅ |
| GET | `/marketplace/items` | Get all items | ✅ |
| GET | `/marketplace/items/{itemId}` | Get item | ✅ |
| GET | `/marketplace/items/search?keyword=` | Search items | ✅ |
| POST | `/marketplace/items/{itemId}/order` | Place order | ✅ |
| PATCH | `/marketplace/orders/{orderId}/complete` | Complete order | ✅ |
| PATCH | `/marketplace/orders/{orderId}/cancel` | Cancel order | ✅ |

### Ride Share Endpoints
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/rides` | Post a ride | ✅ |
| GET | `/rides` | Get all rides | ✅ |
| GET | `/rides/upcoming` | Get upcoming rides | ✅ |
| GET | `/rides/search?keyword=` | Search rides | ✅ |
| POST | `/rides/{rideId}/request` | Request ride | ✅ |
| PATCH | `/rides/requests/{requestId}/accept` | Accept request | ✅ |
| PATCH | `/rides/requests/{requestId}/reject` | Reject request | ✅ |

### Lost & Found Endpoints
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/lostandfound/lost` | Report lost item | ✅ |
| GET | `/lostandfound/lost` | Get all lost items | ✅ |
| GET | `/lostandfound/lost/search?keyword=` | Search lost items | ✅ |
| POST | `/lostandfound/found` | Report found item | ✅ |
| GET | `/lostandfound/found` | Get all found items | ✅ |
| PATCH | `/lostandfound/found/{itemId}/claim` | Claim found item | ✅ |

### Other Endpoints
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | `/announcements` | Get announcements | ✅ |
| POST | `/announcements` | Create announcement | ✅ Admin/Faculty |
| GET | `/jobs` | Get job listings | ✅ |
| POST | `/jobs` | Post a job | ✅ |
| POST | `/feedback` | Submit feedback | ✅ |
| POST | `/reports` | Submit report | ✅ |
| GET | `/messages/conversation/{id1}/{id2}` | Get conversation | ✅ |
| POST | `/messages/send/{receiverId}` | Send message | ✅ |
| GET | `/notifications/user/{userId}` | Get notifications | ✅ |

---

## 🔐 Authentication

NUST Connect uses **JWT (JSON Web Token)** for authentication.

### Register & Login Flow:
```
1. POST /api/auth/register → Returns JWT token
2. Use token in header: Authorization: Bearer <token>
3. Token expires after 24 hours
4. Use POST /api/auth/refresh-token to get a new token
```

### Example Request:
```json
POST /api/auth/login
{
  "email": "student@nust.edu.pk",
  "password": "password123"
}
```

### Example Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "userId": 1,
  "email": "student@nust.edu.pk",
  "name": "John Doe",
  "role": "STUDENT",
  "message": "Login successful!"
}
```

### User Roles:
| Role | Access Level |
|------|-------------|
| `STUDENT` | Standard access |
| `FACULTY` | Can create announcements |
| `CLUB_ADMIN` | Can manage clubs |
| `ADMIN` | Full system access |

---

## ⚙️ Environment Variables

| Variable | Description | Required |
|----------|-------------|----------|
| `DB_USERNAME` | MySQL username | ✅ |
| `DB_PASSWORD` | MySQL password | ✅ |
| `JWT_SECRET` | JWT signing secret (32+ chars) | ✅ |
| `MAIL_HOST` | SMTP host | ✅ |
| `MAIL_PORT` | SMTP port | ✅ |
| `MAIL_USERNAME` | Email address | ✅ |
| `MAIL_PASSWORD` | Email app password | ✅ |
| `CORS_ORIGINS` | Allowed origins | ❌ |

---

## 🗄️ Database Schema

### Core Tables
- `users` - User accounts
- `profiles` - User profile details
- `friendship` - Friend connections

### Social Tables
- `posts` - User posts
- `comments` - Post comments
- `likes` - Post likes
- `notifications` - User notifications
- `messages` - Direct messages

### Club & Event Tables
- `clubs` - Student clubs
- `club_membership` - Club members
- `events` - Campus events
- `event_registration` - Event attendees
- `event_ticket` - Event tickets
- `venues` - Campus venues
- `venue_booking` - Venue reservations

### Feature Tables
- `marketplace_item` - Items for sale
- `marketplace_order` - Purchase orders
- `marketplace_category` - Item categories
- `ride_share` - Available rides
- `ride_request` - Ride requests
- `lost_items` - Lost item reports
- `found_items` - Found item reports
- `announcement` - Campus announcements
- `job_posting` - Job listings
- `feedback` - User feedback
- `reports` - Content reports

---

## 🔒 Security Features

- ✅ JWT Token Authentication
- ✅ BCrypt Password Hashing
- ✅ Role-Based Access Control (RBAC)
- ✅ NUST Email Domain Validation
- ✅ Email Verification
- ✅ CORS Configuration
- ✅ Input Validation
- ✅ SQL Injection Prevention (JPA)
- ✅ Soft Delete (data preservation)

---

## 🐛 Error Handling

All API errors return a consistent format:

```json
{
  "timestamp": "2024-11-24T12:20:47",
  "status": 404,
  "error": "Not Found",
  "message": "User not found with id: '123'",
  "path": "/api/users/123"
}
```

### Validation Errors:
```json
{
  "timestamp": "2024-11-24T12:20:47",
  "status": 400,
  "error": "Validation Failed",
  "message": "Invalid input data",
  "path": "/api/auth/register",
  "validationErrors": [
    {
      "field": "email",
      "message": "Invalid email format"
    }
  ]
}
```

### HTTP Status Codes:
| Code | Meaning |
|------|---------|
| 200 | OK |
| 201 | Created |
| 400 | Bad Request |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |
| 409 | Conflict |
| 500 | Internal Server Error |

---

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 👨‍💻 Team

Built with ❤️ by NUST Students

---

## 📄 License

This project is licensed under the MIT License.

---

## 📞 Support

If you have any questions or issues, please open a GitHub issue or contact us at support@nustconnect.com

---

> **Note:** This platform is exclusively for NUST community members. Only `@nust.edu.pk` email addresses are allowed to register.
