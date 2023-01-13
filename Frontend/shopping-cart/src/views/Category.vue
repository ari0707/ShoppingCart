<template>
    <NavBar></NavBar>
    
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h3 class="pt-3">Categories</h3>
                <router-link :to="{name: 'AddCategory'}">
                    <button class ="btn btn-secondary" style="float:right">Add Category</button>
                </router-link>
            </div>
            <!-- <div>{{ categories }}</div>  -->
        </div>
        <div class="row">
           <div v-for="category in categories" :key="category.id"  class="col-xl-4 col-md-6 cold-12 pt-3 d-flex">
                <CategoryBox :category="category"></CategoryBox>
           </div>
        </div>
    </div>

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
.pt-3 {
  color:#15c8f5;;
  font-size: 2rem;
  font-weight: 600;
}


</style>