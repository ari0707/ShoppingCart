<template>
    <div>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">¡Start shopping!</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <router-link class="nav-link active" to="/">Home
            <span class="visually-hidden">(current)</span>
          </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/signup">Create Account</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/signin">Sign In</router-link>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">About</a>
        </li>
        
      </ul>
      <form class="d-flex">
        <input class="form-control me-sm-2" type="search" placeholder="Search">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
    </div>
  
</template>

<style>

.navbar {
  background-color: transparent !important;
}
.navbar-brand{
  color: #863596;
  font-size: 1.8rem;
  font-weight: 500;
}
.nav-link{
  color: #e35abc;
  font-size: 1.6rem;
  font-weight: 500;
}
</style>
