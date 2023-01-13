<template>
    <NavBar></NavBar>
    
  <div id="background-div" class="bg-cover"> 
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h3 class="pt-3">Products</h3>
                <router-link :to="{name: 'AddProduct'}">
                    <button class ="btn btn-secondary" style="float:right">Add Product</button>
                </router-link>
            </div>
            <!-- <div>{{ categories }}</div>  -->
        </div>
        <div class="row">
           <div v-for="product in products" :key="product.id"  class="col-xl-4 col-md-6 cold-12 pt-3 d-flex">
                <ProductBox :product="product"></ProductBox>
           </div>
        </div>
    </div>
  </div>

</template>

<script>

import axios from "axios";
import ProductBox from '../components/ProductBox.vue';
import NavBar from '../components/NavBar.vue';



export default{
    name: "Product",
    components: {
        ProductBox,
        NavBar
    },
    data(){
        return {
            products: [],
        };
    },
    methods: {
        async getProducts(){
            await axios
                .get("http://localhost:8080/product/list")
                .then ((res) => (this.products = res.data))
                .catch(err => console.log(err))
         },      
    },
    mounted(){
        this.getProducts();
    }
};

</script>

<style scoped>
.page-holder{
  min-height: 100vh;
}
.bg-cover{
  background-size: cover !important;
}

</style>