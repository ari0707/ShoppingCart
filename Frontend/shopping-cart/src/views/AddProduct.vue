<template>
    <NavBar></NavBar>

<div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h3 class="pt-3">Add new product</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <form>
                    <div class="form-group">
                        <label class="Name">Category Id</label>
                        <input type="text" class="form-control" v-model="categoryId" />
                    </div>
                    <div class="form-group">
                        <label class="Name">Name</label>
                        <input type="text" class="form-control" v-model="name" required>
                    </div>
                    <div class="form-group">
                        <label class="Name">Description</label>
                        <textarea type="text" class="form-control" v-model="description"></textarea>
                    </div>
                    <div class="form-group">
                        <label class="Name">Image</label>
                        <input type="text" class="form-control" v-model="imageURL" />
                    </div>
                    <div class="form-group">
                        <label class="Name">Price</label>
                        <input type="number" class="form-control" v-model="price" required>
                    </div>
                    <button type ="button" class="btn btn-secondary" style="float:center" @click="addProduct">Submit
                    </button>
                </form>
            </div>
            <div calss="col-3"></div>
        </div>
    </div>
    
</template>

<script>   

import axios from "axios";
import swal from "sweetalert";
import NavBar from '../components/NavBar.vue';

export default{
    components: {
        NavBar
    },
    data(){
        return {
            categoryId :"",
            name : "",
            description : "",
            imageURL : "",
            price : ""
        }
    },
    methods: {
        addProduct(){
            const newProduct = {
                categoryId : this.categoryId,
                name : this.name,
                description : this.description,
                imageURL : this.imageURL,
                price : this.price
            };

            axios ({
                method:'post',
                url: "http://localhost:8080/product/create",
                data: JSON.stringify(newProduct),
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(() => {
                swal({
                    text: "Product added sucessfully",
                    icon: "sucess",
                });
            })
            .catch((err) => {
                console.log(err);
            });
        },
    },
};


</script>

<style>

.Name{
    color:#15c8f5;;
    font-size: 1.5rem;
    font-weight: 400;
}

</style>