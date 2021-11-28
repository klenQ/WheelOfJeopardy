# Wheel Of Jeopardy Web application - Backend Server

Backend Part of Project for Johns Hopkins EN 605.601 Fall 2021

- Minimal increment - 2021.11.14

## Programming Languages
- Java

## Environment:
Developed with IntelliJ IDEA
> IntelliJ IDEA 2021.2.3 (Ultimate Edition)
> Build #IU-212.5457.46, built on October 12, 2021
> Runtime version: 11.0.12+7-b1504.40 amd64
> VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
> Windows 10 10.0
> GC: G1 Young Generation, G1 Old Generation
> Memory: 2048M
> Cores: 16
> Non-Bundled Plugins: coderead.IdeaPlugins.maven (1.0), MavenRunHelper (4.18.212.000.3), org.jetbrains.kotlin (212-1.5.31-release-546-IJ4638.7), com.intellij.bigdatatools (212.4037.68), com.intellij.spring.webflow (212.5080.8)
> Kotlin: 212-1.5.31-release-546-IJ4638.7

- JDK 1.8
- Tomcat 8.0.50 / Springboot embed Tomcat

## Frameworks Used
- ~~SSM Version - Deprecated after minimal increment~~
  - ~~Spring~~
  - ~~SpringMVC~~
  - ~~MyBatis~~
- Springboot Version - Will be use for final increment 
  - Springboot2
  - Mybatis

## API

### Minimal Increment:

- `/category/{categoryId}`
  - GET
    - return a json object contain one Categories class object correspond to the categoryId 
    - Categories object includes:
      - CategoryID 
      - CategoryName
- `/questions/{categoryId}`
  - GET
    - return a json object contain a list of Questions class object correspond to the categoryId
    - Questions object contains:
      - QuestionID
      - CategoryID
      - PointValue
      - Question
- `/selectAnswers/{questionId}`
  - GET
    - return a json object contain a list of Answers class object correspond to the questionId
    - Answers object contains: 
      - AnswerID
      - QuestionID
      - AnswerChoices
      - CorrectAnswer
- `/checkAnswer/{answerId}/{questionId}`
  - GET
    - return a json object contain a boolean value indicate whether the answer is correct

### Target Increment:

> From last increment
> - `/category/{categoryId}`
> - `/questions/{categoryId}`
> - `/selectAnswers/{questionId}`
> - `/checkAnswer/{answerId}/{questionId}`
------
- `/category`
  - GET
- `/game/getAllGames`
  - GET
    - get all games that is created
- `/game/start`
  - POST
    - accept a login name representing a player in request body
    - return a game object with game status in json
- `/game/connect`
  - POST
    - accept a login name in request body and a gameId as param in url representing a player and which game room to join
      - do not accept player with same login name 
    - return a game object with game status in json
- `/game/gameplay`
  - POST
    - accept an object that contain Player object with login name, game ID, and the score earned for that player
    - Example post request body: 
      - ```json
        {
            "player": {
            "login":"jack"
            },
            "scoreEarned":30,   
            "gameId": "9305d040-b2d3-491f-8ea4-a151797bfb6b"
        }
      
    - return a game object with game status in json
    - when all 30 questions were answered, the game finished. winner's status would be also included in the game object.  
- ...
- maybe more to implement

---
### Possible extra functions
- websocket implementation
  - endpoint: `/gameplay`
  - `registry.setApplicationDestinationPrefixes("app").enableSimpleBroker("/topic");`
  - `simpMessagingTemplate.convertAndSend("/topic/game-progress" + game.getGameId(),game);`