# Flix
Flix is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

## Flix Part 2

### User Stories

#### REQUIRED (10pts)

- [X] (8pts) Expose details of movie (ratings using RatingBar, popularity, and synopsis) in a separate activity.
- [X] (2pts) Allow video posts to be played in full-screen using the YouTubePlayerView.

#### BONUS

- [ ] Implement a shared element transition when user clicks into the details of a movie (1 point).
- [ ] Trailers for popular movies are played automatically when the movie is selected (1 point).
  - [ ] When clicking on a popular movie (i.e. a movie voted for more than 5 stars) the video should be played immediately.
  - [ ] Less popular videos rely on the detailed page should show an image preview that can initiate playing a YouTube video.
- [ ] Add a play icon overlay to popular movies to indicate that the movie can be played (1 point).
- [ ] Apply data binding for views to help remove boilerplate code. (1 point)
- [X] Add a rounded corners for the images using the Glide transformations. (1 point)

### App Walkthough GIF

<img src="./demo2.gif" width=250><br>

### Notes

Describe any challenges encountered while building the app.
<ul><li>Ran into a null pointer exception that prevented the details activity from being used that took some time to rectify that required a change to an XML file that was created by Android Studio
   <li>Ran into a problem trying to automatically play a YouTube video using loadVideo() - left the code intact, but still won't function correctly (I believe due to an error: E/YouTubeAndroidPlayerAPI: Embed config is not supported in RemoteEmbeddedPlayer.)
   <li>Kept running into null pointer exceptions when parsing JSON objects when quickly changing from landscape to portrait mode, crashing the app - created an exception to handle this that would repeat the activity one more time to allow parsing to commence; no problems afterwards
</ul>

## Open-source libraries used
- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

---

## Flix Part 1

### User Stories
#### REQUIRED (10pts)
- [X] (10pts) User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

#### BONUS
- [X] (2pts) Views should be responsive for both landscape/portrait mode.
   - [X] (1pt) In portrait mode, the poster image, title, and movie overview is shown.
   - [X] (1pt) In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

- [X] (2pts) Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
- [X] (2pts) Improved the user interface by experimenting with styling and coloring.
- [ ] (2pts) For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.

### App Walkthough GIF
<img src="./demo.gif" width=250><br>

### Notes
Describe any challenges encountered while building the app.
<ul><li>Ran into an error that took some time to rectify that required uninstallation of the app from the emulator
   <li>Ran into a network error 500 that took some time to rectify (had to parse base_url into a secure_base_url format)
   <li>Was challenging to retrieve and parse base_url from JSON array
      <li>Attempted to implement automatic image resizing based upon the detected device size but was unable to obtain functionality (decided to leave it alone for now)
         <li>Attempted to obtain poster colors and create a palette of these colors for the text color of the title and overview of each movie but was unable to obtain functionality (decided to leave it alone due to time constraints)
           </ul>
            

### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids
