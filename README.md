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
Windows Platform Or Linux Distributions.

### ARCHITECTURAL REQUIREMENT :
INTEL 32/64 Bit Processor Or Higher.

### USER INTERFACE :
Web Based User Interface (Angular).

### TECHNOLOGY USED :
Java, Spring Boot, MySQL, Angular, REST APIs, Spring Cache.

#
![](https://i.imgur.com/waxVImv.png)

<div align="center">
    <h1>ABOUT DISTRIBUTED FEATURE FLAG MANAGEMENT SYSTEM</h1>
</div>

![](https://i.imgur.com/waxVImv.png)

#

In This Project I Built A Distributed Feature Flag Management System To Control Application Features Dynamically Without Redeploying Code.

The System Allows Administrators To Create, Update, Enable, Disable And Manage Feature Flags From A Centralized Dashboard.

I Implemented Environment Based Configuration So That Every Feature Can Behave Differently In Development, Staging And Production.

The Project Supports Percentage Based Rollout Where A Feature Can Be Released To A Specific Percentage Of Users Before Full Release.

I Used Deterministic Hash Based Evaluation Logic To Ensure The Same User Gets A Consistent Feature Experience Across Requests.

The Backend Is Developed Using Spring Boot With Layered Architecture Such As Controller, Service And Repository.

For Persistent Storage I Used MySQL Database To Store Feature Flags, Environment Configurations And Audit Logs.

I Added Audit Logging To Track Who Performed Changes, What Action Was Performed And When The Change Happened.

I Used Spring Cache To Reduce Repeated Database Access And Improve Low Latency Feature Evaluation.

The Frontend Is Developed Using Angular To Provide Dashboard, Configuration, Evaluation And Audit Log Pages.

This Project Demonstrates Enterprise Backend Design, REST API Development, Database Modeling, Caching Strategies And Full Stack Integration.


#
![](https://i.imgur.com/waxVImv.png)

<div align="center">
    <h1>CORE FEATURES</h1>
</div>

![](https://i.imgur.com/waxVImv.png)

#

Feature Flag Creation And Management : Create, Update, Delete And Toggle Features Instantly.

Environment Specific Configuration : Separate Settings For Development, Staging, And Production.

Percentage Based Rollout : Controlled Release (10%, 25%, 50%, 100%) Using Hash-Based Evaluation.

Feature Evaluation API : Real-Time Evaluation Based On User ID And Environment Context.

Audit Logging : Full History Tracking Including Action Type, User, And Timestamp.

Performance Optimization : Implementation of Spring Cache For Low-Latency API Responses.


#
![](https://i.imgur.com/waxVImv.png)

<div align="center">
    <h1>SYSTEM ARCHITECTURE</h1>
</div>

![](https://i.imgur.com/waxVImv.png)

#

   [ Angular UI ]
          ↓
  [ REST Controller ]
          ↓
   [ Service Layer ] <-----> [ Spring Cache ]
          ↓
  [ Repository Layer ]
          ↓
  [ MySQL Database ]

#
![](https://i.imgur.com/waxVImv.png)

<div align="center">
    <h1>DATABASE DESIGN</h1>
</div>

![](https://i.imgur.com/waxVImv.png)

#

TABLES USED :

feature_flags  2) environments  3) feature_configs  4) audit_logs

RELATIONSHIPS :

FeatureFlag (1) → (N) FeatureConfig

Environment (1) → (N) FeatureConfig

FeatureFlag (1) → (N) AuditLog


#
![](https://i.imgur.com/waxVImv.png)

<div align="center">
    <h1>DEMO OUTPUT</h1>
</div>

![](https://i.imgur.com/waxVImv.png)

#

![]([https://github.com/Prasad-Yeole/Customised_Virtual_File_System/blob/main/CVFS1.png](https://github.com/Prasad-Yeole/distributed-feature-flag-management-system/blob/main/Screenshot%20from%202026-03-22%2021-29-11.png)

#

![]([https://raw.githubusercontent.com/Prasad-Yeole/distributed-feature-flag-management-system/main/docs/screenshots/config.png](https://github.com/Prasad-Yeole/distributed-feature-flag-management-system/blob/main/Screenshot%20from%202026-03-22%2021-25-31.png))

#

![]([https://raw.githubusercontent.com/Prasad-Yeole/distributed-feature-flag-management-system/main/docs/screenshots/audit-logs.png](https://github.com/Prasad-Yeole/distributed-feature-flag-management-system/blob/main/Screenshot%20from%202026-03-22%2021-26-02.png))

#
![]([https://i.imgur.com/waxVImv.png](https://github.com/Prasad-Yeole/distributed-feature-flag-management-system/blob/main/Screenshot%20from%202026-03-22%2021-25-51.png))

#
![]([[https://i.imgur.com/waxVImv.png](https://github.com/Prasad-Yeole/distributed-feature-flag-management-system/blob/main/Screenshot%20from%202026-03-22%2021-25-51.png)](https://github.com/Prasad-Yeole/distributed-feature-flag-management-system/blob/main/Screenshot%20from%202026-03-22%2021-29-22.png))

<div align="center">
    <h1>AUTHOR</h1>
</div>

![](https://i.imgur.com/waxVImv.png)

#

Name    : Prasad Yeole

Project : Distributed Feature Flag Management System

Role    : Full Stack Developer
