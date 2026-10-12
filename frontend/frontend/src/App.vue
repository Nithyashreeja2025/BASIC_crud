<template>
  <div class="container">
    <h1>Movies</h1>

    <!-- RouterLink changes the URL without reloading the page -->
    <nav>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/add">Add Movie</RouterLink>
    </nav>

    <!-- RouterView is where the matched page appears.
         :key rebuilds the page whenever the URL changes. -->
    <RouterView :key="$route.fullPath" />
  </div>
</template>
