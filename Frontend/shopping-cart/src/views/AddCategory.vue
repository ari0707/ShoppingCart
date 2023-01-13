<template>
    <NavBar></NavBar>
    
    <div class="container ">
        <div class="row">
            <div class="col-12 text-center ">
                <h3 class="pt-3">Add Category</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <form>
                    <div class="form-group">
                        <label class="Name">Name</label>
                        <input type="text" class="form-control" v-model="categoryName" />
                    </div>
                    <div class="form-group">
                        <label class="Name">Description</label>
                        <textarea type="text" class="form-control" v-model="description"></textarea>
                    </div>
                    <div class="form-group">
                        <label class="Name" >Image</label>
                        <input type="text" class="form-control" v-model="imageUrl" />
                    </div>
                    <button type ="button" class="btn btn-secondary" @click="addCategory">Submit
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
            categoryName:"",
            description: "",
            imageUrl: "",
        }
    },
    methods: {
        addCategory(){
            const newCategory = {
                categoryName: this.categoryName,
                description: this.description,
                imageUrl: this.imageUrl,
            };

            axios ({
                method:'post',
                url: "http://localhost:8080/category/create",
                data: JSON.stringify(newCategory),
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(() => {
                swal({
                    text: "Category added sucessfully",
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