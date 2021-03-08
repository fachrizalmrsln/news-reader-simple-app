# News Reader Simple App
News Reader Simple App is just news-based application. I'm using this [API](https://www.cnnindonesia.com/ucnews/listapi.json) in this project. 

# Screenshot
![Alt text](/screenshots/Splash_Screen.jpg?raw=true "Splash Screen") ![Alt text](/screenshots/News_List.jpg?raw=true "News List ") ![Alt text](/screenshots/News_List_Bookmark.jpg?raw=true "News List Bookmark") ![Alt text](/screenshots/News_List_Detail.jpg?raw=true "News Detail") 

# Features
1. News List
   - Inside News-List, there is news data which can be bookmarked into an existing local database. The bookmarked data can be seen on the bookmark page and there can be actions to delete the data from the local database.

2. News Detail
   - Inside News-Details, there is a webview that is used to load existing data details, the webview can be cached too, so in the offline mode the detail still can be loaded only if the url has been cached. There is the same bookmark function like the news-list page on this page.

# Teach Stack
  - [Kotlin](https://developer.android.com/kotlin)
  - [Endless Scroll View](https://github.com/fachrizalmrsln/news-reader-simple-app/blob/master/component/base/src/main/java/com/fachrizalmrsln/component/base/util/RecyclerViewPaging.kt)
  - [Skeleton Loading](https://github.com/Faltenreich/SkeletonLayout)
  - [Swipe Layout](https://github.com/anzaizai/EasySwipeMenuLayout)
  - [Local Database](https://developer.android.com/training/data-storage/room#setup)
  - [Pagination](https://developer.android.com/topic/libraries/architecture/paging)
  - [Live Data](https://developer.android.com/topic/libraries/architecture/livedata)
  - [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines)
  - [Dependencies Injection](https://github.com/InsertKoinIO/koin)
  - [WebView](https://developer.android.com/reference/android/webkit/WebView)
  
# Architecture
  - Model View Viewmodel 
  
  ![Alt text](/screenshots/Viewmodel.png?raw=true "Viewmodel")
  
  Get to know more about [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel)
  
  - App Modularization
  
  ![Alt text](/screenshots/Modularization.png?raw=true "Modularization")
  
  Found this beautiful ilustration from this [article](https://proandroiddev.com/modularization-of-android-applications-in-2021-a79a590d5e5b) go give it a clap!
  
  - Repository Pattern 
  
  ![Alt text](/screenshots/Repository_Pattern.png?raw=true "Repository Pattern")
  
  Get to know more about [Repository Pattern](https://developer.android.com/jetpack/guide)
  
  - Offline First
  
  ![Alt text](/screenshots/Offline_First.png?raw=true "Repository Pattern")
  
  Found this beautiful ilustration from this [article](https://medium.com/@jeremyrempel/offline-first-applications-pt-1-the-blueprint-9f518aa374dd) go give it a clap!
  
# Authors
Fachrizal A. Z. Mursalin
