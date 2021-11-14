# Wheel Of Jeopardy Web application - Backend Server

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
- Tomcat 8.0.50

## Frameworks Used
- Spring
- SpringMVC
- MyBatis

## API

- `/category/{categoryId}`
  - return a json object contain one Categories class object correspond to the categoryId 
  - Categories object includes:
    - CategoryID 
    - CategoryName
- `/questions/{categoryId}`
  - return a json object contain a list of Questions class object correspond to the categoryId
  - Questions object contains:
    - QuestionID
    - CategoryID
    - PointValue
    - Question
- `/selectAnswers/{questionId}`
  - return a json object contain a list of Answers class object correspond to the questionId
  - Answers object contains: 
    - AnswerID
    - QuestionID
    - AnswerChoices
    - CorrectAnswer
- `/checkAnswer/{answerId}/{questionId}`
  - return a json object contain a boolean value indicate whether the answer is correct

