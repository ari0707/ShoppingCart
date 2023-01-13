<template>

    <NavBar></NavBar>

    <div class="container">
          
            <div class="row">
                <div class="col-12 justify-content-center d-flex pt-3">
                    <div id="signup" class="flex-item border">
                        <h2 class="pt-4 pl-4 text-center">Create Account</h2>
                            <form @submit= "signUp" class="pt-4 pl-4 pr-4">
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="email" v-model="email" class="form-control" required />
                                </div>
                                <div class="form-row">
                                    <div class="col">
                                        <div class="form-group">
                                            <label>First Name</label>
                                            <input type="text" v-model="firstName" class="form-control" required />
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group">
                                            <label>Last Name</label>
                                            <input type="text" v-model="lastName" class="form-control" required />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="Password">Password</label>
                                    <input type="password" v-model="password" class="form-control" required />
                                </div>
                                <div class="form-group">
                                    <label for="Password">Confirm Password</label>
                                    <input type="password" v-model="confirmPassword" class="form-control" required />
                                </div>
                               
                                <button type ="submit" class="btn btn-secondary" style="float:center">Create Account
                                </button>
                            </form>
                    </div>
                </div>
            <div class="col-6">
                  
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
        return{
            email: "",
            firstName: "",
            lastName: "",
            password: "",
            confirmPassword: "",
        }
    },
    methods: {
        async signUp(e){
            e.preventDefault();
            if (this.password === this.confirmPassword){
                // call signup api
                const user = {
                    email: this.email,
                    firstName: this.firstName,
                    lastName: this.lastName,
                    password: this.password,
                }
                await axios
                    .post("http://localhost:8080/user/signup", user)
                    .then(() => {
                        // redirect to home page
                        this.$router.replace("/");
                        swal({
                            text: "User signup successful. Please Login",
                            icon: "success",
                        });
                    })
                    .catch((err) => {
                    console.log(err);
                    });
            } else {
                // passwords are not matching
                swal({
                    text: "Error! Passwords are not matching",
                    icon: "error",
                });
            }
        },
    },
};

</script>

<style>
.pt-4{
    color: #15c8f5;
    font-size: 1.6rem;
    font-weight: 500;
}
@media screen {
    #signup{
        width: 40%;
    }
}

</style>