<template>
  
    <div id="background-div" class="bg-cover">
      <NavBar></NavBar>
      <div class="container">
        </div>
          <div class="container">
            <div class="row">
              <div class="col-12 text-center">
                <h1 class="pt-5">Categories</h1>
            </div>
          </div>
          <div class="row">
            <div v-for="category in categories" :key="category.id"  class="col-xl-4 col-md-6 cold-12 pt-3 d-flex">
              <CategoryBox :category="category"></CategoryBox>
            </div>
          </div>
        </div>
    </div>
    
  <!-- <h4>hola</h4>
    <router-link :to="{name: 'AddProduct'}">
                    <button class ="btn" style="float:right">Add Product</button>
    </router-link> -->
</template>

<script>

import axios from "axios";
import CategoryBox from '../components/CategoryBox.vue';
import NavBar from '../components/NavBar.vue';



export default{
    name: "Category",
    components: {
        CategoryBox,
        NavBar
    },
    data(){
        return {
            categories: [],
        };
    },
    methods: {
        async getCategories(){
            await axios
                .get("http://localhost:8080/category/list")
                .then ((res) => (this.categories = res.data))
                .catch(err => console.log(err))
         },      
    },
    mounted(){
        this.getCategories();
    }
};

</script>

<style>
.page-holder{
  min-height: 100vh;
}

body {
  margin: 0;
  background-image: url("../assets/6.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;

}
.bg-cover{
  background-size: cover !important;
}
.pt-5 {
  color:#15c8f5;;
  font-size: 3.5rem;
  font-weight: 600;
}



</style>

