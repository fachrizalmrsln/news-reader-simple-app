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
  
# Issues
I'm still cannot figure it out how to keep the bookmark state in the News-List Screen. So the UI will look wierd overthere. 

Lets said the item with id 223 get bookmarked from the list. The bookmark icon should be on the state bookmark (with icon bookmark fully white and the text appear is Bookmarked), but whenever the item get recyling or the app get close, the bookmark state on that item with id 223 is not on the bookmark state. I get it that i need to compare the list from the server with the list from my local database, i just can't figure it out how to do that approach.

Feel free to give me some clues or just contribute to this project!

# Authors
Fachrizal A. Z. Mursalin
