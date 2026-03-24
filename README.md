<div align="center">
    <h1>DISTRIBUTED FEATURE FLAG MANAGEMENT SYSTEM</h1>
</div>

![](https://i.imgur.com/waxVImv.png)

<div align="center">
    <sup>More Info</sup>
    <br />
    <sup>Copyright (c) 2026 Prasad_Yeole</sup>
    
  Licensed Under The [MIT License](https://github.com/Prasad-Yeole/distributed-feature-flag-management-system/blob/main/LICENSE)
  
  [![MIT License](https://img.shields.io/badge/license-MIT-blue.svg?style=flat)](https://github.com/Prasad-Yeole/distributed-feature-flag-management-system/blob/main/LICENSE)
  ![GitHub language count](https://img.shields.io/github/languages/count/Prasad-Yeole/distributed-feature-flag-management-system?color=g&label=Languages)
  ![Platforms](https://img.shields.io/badge/Platforms-Web-yellowgreen?style=flat-square)
  ![GitHub top language](https://img.shields.io/github/languages/top/Prasad-Yeole/distributed-feature-flag-management-system?color=9cf)
  ![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/Prasad-Yeole/distributed-feature-flag-management-system)
  ![GitHub repo size](https://img.shields.io/github/repo-size/Prasad-Yeole/distributed-feature-flag-management-system)
  ![Lines of code](https://img.shields.io/tokei/lines/github/Prasad-Yeole/distributed-feature-flag-management-system?color=g&label=No%20Of%20Lines)
  ![GitHub contributors](https://img.shields.io/github/contributors/Prasad-Yeole/distributed-feature-flag-management-system?color=red)
  ![GitHub User's stars](https://img.shields.io/github/stars/Prasad-Yeole?color=yellow)
  ![GitHub commit activity](https://img.shields.io/github/commit-activity/w/Prasad-Yeole/distributed-feature-flag-management-system?color=purple)
  ![GitHub last commit](https://img.shields.io/github/last-commit/Prasad-Yeole/distributed-feature-flag-management-system?color=yellow)
</div>

![](https://i.imgur.com/waxVImv.png)

#

### PLATFORM REQUIRED :
```text
Windows Platform Or Linux Distributions.
ARCHITECTURAL REQUIREMENT :
INTEL 32/64 Bit Processor Or Higher.
USER INTERFACE :
Web Based User Interface.
TECHNOLOGY USED :
Java, Spring Boot, MySQL, Angular, REST APIs, Spring Cache.

<div align="center"> <h1>ABOUT DISTRIBUTED FEATURE FLAG MANAGEMENT SYSTEM</h1> </div>

1) In This Project I Built A Distributed Feature Flag Management System To Control Application Features Dynamically Without Redeploying Code.

2) The System Allows Administrators To Create, Update, Enable, Disable And Manage Feature Flags From A Centralized Dashboard.

3) I Implemented Environment Based Configuration So That Every Feature Can Behave Differently In Development, Staging And Production.

4) The Project Supports Percentage Based Rollout Where A Feature Can Be Released To A Specific Percentage Of Users Before Full Release.

5) I Used Deterministic Hash Based Evaluation Logic To Ensure The Same User Gets A Consistent Feature Experience Across Requests.

6) The Backend Is Developed Using Spring Boot With Layered Architecture Such As Controller, Service And Repository.

7) For Persistent Storage I Used MySQL Database To Store Feature Flags, Environment Configurations And Audit Logs.

8) I Added Audit Logging To Track Who Performed Changes, What Action Was Performed And When The Change Happened.

9) I Used Spring Cache To Reduce Repeated Database Access And Improve Low Latency Feature Evaluation.

10) The Frontend Is Developed Using Angular To Provide Dashboard, Configuration, Evaluation And Audit Log Pages.

11) This Project Demonstrates Enterprise Backend Design, REST API Development, Database Modeling, Caching Strategies And Full Stack Integration.

<div align="center"> <h1>CORE FEATURES</h1> </div>

1) Feature Flag Creation And Management
   - Create New Feature Flags
   - Update Existing Features
   - Delete Features
   - Globally Enable Or Disable Features

2) Environment Specific Configuration
   - Separate Settings For Development
   - Separate Settings For Staging
   - Separate Settings For Production

3) Percentage Based Rollout
   - Controlled Release For Limited Users
   - Supports Gradual Rollout Like 10%, 25%, 50%, 100%

4) Feature Evaluation API
   - Client Applications Can Check Whether A Feature Is Enabled
   - Evaluation Based On User ID And Environment

5) Audit Logging
   - Stores Feature Change History
   - Records Action Type, Changed By And Timestamp

6) Performance Optimization
   - Spring Cache For Frequently Accessed Configurations
   - Improved Response Time For Evaluation Requests

<div align="center"> <h1>SYSTEM ARCHITECTURE</h1> </div>

[Angular UI]
      ↓
[REST Controller]
      ↓
[Service Layer]
      ↓
[Repository Layer]
      ↓
[MySQL Database]

      ↘
   [Spring Cache]

<div align="center"> <h1>API ENDPOINTS</h1> </div>

FEATURE APIs
POST    /api/features
GET     /api/features
PUT     /api/features/{id}
DELETE  /api/features/{id}
CONFIG APIs
POST    /api/v1/configs
GET     /api/v1/configs?featureName=&env=
EVALUATION API
GET     /api/v1/features/evaluate
AUDIT LOG APIs
GET     /api/audit-logs
GET     /api/audit-logs?featureName=

<div align="center"> <h1>DATABASE DESIGN</h1> </div>

TABLES USED :

1) feature_flags
2) environments
3) feature_configs
4) audit_logs

RELATIONSHIPS :

1) FeatureFlag (1) → (N) FeatureConfig
2) Environment (1) → (N) FeatureConfig
3) FeatureFlag (1) → (N) AuditLog

<div align="center"> <h1>PERCENTAGE ROLLOUT LOGIC</h1> </div>

int hash = Math.abs((userId + featureName).hashCode()) % 100;
return hash < rolloutPercentage;

<div align="center"> <h1>HOW TO RUN PROJECT</h1> </div>

BACKEND SETUP
1) Open Backend Project In IDE
2) Configure application.properties
3) Make Sure MySQL Server Is Running
4) Run Spring Boot Application
FRONTEND SETUP
1) Open Frontend Project
2) Run npm install
3) Run ng serve
4) Open Browser On http://localhost:4200

<div align="center"> <h1>PROJECT STRUCTURE</h1> </div>

distributed-feature-flag-management-system/
├── backend/
│   ├── src/
│   ├── pom.xml
│   └── README.md
├── frontend/
│   ├── src/
│   ├── package.json
│   └── README.md
├── database/
│   ├── schema.sql
│   ├── sample-data.sql
│   └── er-diagram.png
├── docs/
│   ├── screenshots/
│   ├── project-report.docx
│   └── api-docs.md
├── README.md
└── LICENSE

<div align="center"> <h1>DEMO OUTPUT</h1> </div>

DASHBOARD
Feature Creation And Feature List Management

CONFIGURATION PAGE
Environment Specific Configuration With Rollout Percentage

EVALUATION PAGE
Feature Evaluation For User And Environment

AUDIT LOGS PAGE
Track All Feature Changes With Timestamp

FEATURE LIST
Displays Existing Features, Status, Owner And Actions

<div align="center"> <h1>FUTURE ENHANCEMENTS</h1> </div>

1) Role Based Access Control
2) Redis Based Distributed Cache
3) Advanced User Segment Targeting
4) Docker Deployment
5) Monitoring And Analytics Dashboard

<div align="center"> <h1>AUTHOR</h1> </div>

Name : Prasad Yeole
Project : Distributed Feature Flag Management System
Role : Full Stack Developer

<div align="center"> <h1>LICENSE</h1> </div>

This project is licensed under the MIT License.


A few things you should update before pushing:
- replace `Prasad-Yeole/distributed-feature-flag-management-system` with your exact repo name
- add screenshot files inside `docs/screenshots/`
- if your screenshot names are different, update the image paths
- add a `LICENSE` file if you want the MIT badge to work properly

Your screenshot filenames should ideally be:

```text
docs/screenshots/dashboard.png
docs/screenshots/config.png
docs/screenshots/evaluate.png
docs/screenshots/audit-logs.png
docs/screenshots/feature-list.png
