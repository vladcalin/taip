Laborator 3
===========

Problem 2
---------

Components:

- server application
  - user registration
  - user personal information management (storing, retrieving, mondifying on demand)
  - group management (creation, deleting, modifying)
  - secret sharing scheme configuration (selecting the desired scheme and its parameters)
  - specialized API for subsecret manipulation - submitting the subsecret
  - direct communication with the cryptographic parameters manager (see below)
  
- cryptographic parameters manager
  - key generation
  - secret generation
  - subsecret generation based on secret
  - subsecret validation
  - secret composition based on subsecrets
  
- email manager
  - queuing and sending email notifications
  - new account confirmation
  
- client application
  - a web application that interracts with the server
  - *secret compsition request (one user request other users to submit their subsecrets* (TBD)

