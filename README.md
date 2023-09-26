
# Verkada Android take home project

Mikhail Szugalew

## App details

### Home page

The state for the home page is held by `HomeViewModel` and observed by the `HomeScreen` composable.

To populate the list of pictures on the homescreen, the `HomeViewModel` calls the `ImageRepository` which calls `RemoteImagePagingSource` to return a paging source for the pictures. 

The pictures are fetched using the provided Retrofit interface. Note that the URL from the starter code seems to fetch random images instead of cats and birds.

To implement infinite scroll and paging logic for the home page I used the [Jetpack Paging Library](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) which has nice support for `LazyColumn` and `LazyVerticalGrid`.

### Favorites page

The state for the favorites page is held by `FavoritesViewModel` and observed by the `FavoritesScreen` composable.

To get the list of favorites, the `FavoritesViewModel` calls the `FavoritesRepository` which returns a flow of favorite images. 

The set of favorite images is stored in a static variable for simplicity. In a larger project it would be better to save them in a local database or the server.

To keep the home page and favorites page in sync, the `FavoritesRepository` exposes the set of favorite images as a flow. Whenever an image is added or removed from the set, the flow emits the updated value so that the observers know to update their UI.
