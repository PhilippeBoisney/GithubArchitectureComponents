# GithubArchitectureComponents
This application is my implementation of the Architecture Components use-case : https://developer.android.com/topic/libraries/architecture/guide.html 

You can find the related article on my Medium : https://medium.com/@Phil_Boisney/the-missing-google-sample-of-android-architecture-components-guide-c7d6e7306b8f

## PRESENTATION
This simple app is composed of a single screen. When this screen appears, we will fetch (Retrofit) the Github information of Jake Wharton and persist those immediately in the application storage (Room).

Next, when the screen is re-launched (or recreated due to rotation), we will get those same information, *first* in Room database and only if necessary, refresh those from the Github Api.
## PREVIEW
<p align="center">
 <img src ="https://raw.githubusercontent.com/PhilippeBoisney/GithubArchitectureComponents/master/image/architecture.png", height=500/>
</p>

### Architecture Components
This application implements the following concepts :
- ViewModel
- LiveData
- Room

### Libraries
* [Android Support Library][support-lib]
* [Android Architecture Components][arch]
* [Dagger 2][dagger2] for dependency injection
* [Retrofit][retrofit] for REST api communication
* [Glide][glide] for image loading

[support-lib]: https://developer.android.com/topic/libraries/support-library/index.html
[arch]: https://developer.android.com/arch
[dagger2]: https://google.github.io/dagger
[retrofit]: http://square.github.io/retrofit
[glide]: https://github.com/bumptech/glide
