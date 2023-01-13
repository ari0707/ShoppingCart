<template>
    <NavBar></NavBar>

    <div class="container">
            <!-- <div class="row">
                <div class="col-12 text-center">
                    
                </div>
            </div> -->
            <div class="row">
                <div class="col-12 justify-content-center d-flex pt-3">
                    <div id="signup-div" class="flex-item border">
                        <h2 class="pt-4 text-center">Sign-In</h2>
                            <form @submit="signIn" class="form-group pt-4 pl-4 pr-4">
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="email" v-model="email" class="form-control" required />
                                </div>
                                <div class="form-group">
                                    <label for="Password">Password</label>
                                    <input type="password" v-model="password" class="form-control" required />
                                </div>
                            
                                <button type="submit" class="btn btn-secondary">Continue
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
            password: "",
        }
    },
    methods: {
        async signIn(e){
            e.preventDefault();
            const body = {
                email: this.email,
                password: this.password,
            }
            await axios
            .post("http://localhost:8080/user/signin", body)
            .then(() => {
                this.$router.replace("/");
                    swal({
                        text: "Login succesful",
                        icon: "success",
                        });
            })
            .catch((err) => {
            console.log(err);
            });
        },
    },
}

</script>

<style>

@media screen {
    #signin{
        width: 40%;
    }
}

</style>