

### App Name : Relevant

We live in a world where information and articles are in abundance, we also encounter
colleagues and friends with an abundant variety of interest, this App wil allow the user to
find top trending articles for a given topic that will allow him to stay relevant in
his social circle. The user has different choices to conduct their search. he/she could
just scroll over the most viewed articles, input a keyword to find a specific topic or find
the most shared through emails, or social media( facebook and twitter)



## Current Development of Relevant

The current state of Relevant is running well, the user is able to switch between fragments,
as well as choose between different buttons to pick a search method, or input a keyword to search
for articles based on their typed in keyword. A history option can be selected to view the history of
articles searched previously by the user. The user can also flip the screen for better resolution.

### Unimplemented/Incomplete Elements of Relevant

+ Need to find a better way to make the keyword search more interactive.
+ Need to update screen where the user can put comments and see other users comments on a
particular articles


### Known Issues/Bugs

+ There are no known issues and bugs


## Android API version and Hardware

For this application, the following were used to test UI and function.
+ Android API 27
+ Nexus 5x emulator

## Third Party Libraries

+ [Retrofit](https://square.github.io/retrofit/) (includes OkHttp and Retrofit)

  Retrofit is designed to establish and perform requests to CoolClimate API web service.

+ [Stetho](https://github.com/facebook/stetho/blob/master/README.md)

  Stetho is a developmental tool that examines the local display resources and database
   contents.

+ [Deep Dive Android Utilites](https://github.com/deep-dive-coding-java/android-utilities/blob/master/README.md)

+ Room


## External Services

This app accesses the NYTimes API, the NYTimes developer network offers different choices
 API's based on the search criteria.

 + [NY Times APIs](https://developer.nytimes.com/?it=a)



## Potential Future of Relevant

As this application progresses in development, the focus will start to implement a
social network application base, where users can interact and express their opinion
on certain topics of their interest. The application is based only on APIs published by
 the NYTimes, future application could be implementing other resources such as the
 Washington Post. The user can also write their own articles and post them
so other users can see their point of view or side of their story. Different social circle
 network could be set up where users can be part of, they can share their life experience
  or post pictured and videos. A database could be set to collect demographic data that could
  be essential for marketing or political purposes.

### Goals

+ Main User Profile: the user can put their pictures and information that could be accessible
 to other users,if they choose, based on their social circle. This can help bring people
 together and make their social interactions more meaningful.
+ Relevant keeps the users up to date on any subject they choose, having all the information
relevant to their interest in one place will not only save them the time surfing the internet
 or other resources, but also brings them all they need to know with a push of a button.
+ Users will get notification if a subject of their interest is mentioned on social media.



### User Interface Improvements

+ Use Google Sign-in API
+ Relevant logo
+ History fragment that displays dates and articles visited by the user.
+ Buttons to push for different search options

## Design Documentation

+ [Relevant wireframe](docs/WireFrameRelevant.pdf)

+ [Relevant ERD](docs/My_App_ERD.pdf)

+ [DDL](docs/ddl.md)

+ [User Story 1,2](docs/User_Story.md)
+ [ Licenses/Copyright] (Licenses_Copyright.md)

+ [Data Model ](Data-Model.md)


## Javadoc Page

+ [Javadoc](index.html)

+



## Instructions for Building Relevant

+ Clone the Git repository (located at https://github.com/deep-dive-coding-java/Relevant) to your
local development machine.

+ Run the command git clone git@github.com:deep-dive-coding-java/Relevant.git (manually, or via the
Git features in IntelliJ IDEA/Android Studio)to create the local clone.

+ Obtain a NY Times API key and prepare it for use by the Gradle build of the project.
+ Import into IntelliJ IDEA
+ Insert a period (1 day, 7 days, 30 days)to review the corresponding articles.

## Instructions for Using Relevant

+ On installation, the app name appears as “Relevant”. The launcher icon will use the rounded style
 on some devices, and the rectangular (or rounded rectangular) on others.

+ When the app is first launched a Google Sign-In  icon will be appear
+ Sign-In using your google mail credentials, if you don't have an account, sign-up for a new account
with google, use those same credentials to sign-in to start using the application.

+ After granting the permission to access the application a list of buttons is displayed
    Click the Search by Keyword to find articles based on the keyword you inserted
    click the Most Viewed button to access the most viewed articles
    click the Most Shared by Emails if you wish to view most emailed articles
    click the Most Shared on Facebook if you wish to view the most shared articles on facebook
    click the Most Shared on Twitter if you wish to view the most shared articles on Twitter

+ The history view displays all search items retrieved to-date, the view includes the calendar date.



