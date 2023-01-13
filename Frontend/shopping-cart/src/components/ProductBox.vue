<template>

    <div class="card w-100 h-40" style="margin-top: 10px;">
        <div>
            <img :src="product.imageURL" class="card-img-top" alt="Product Image">
        </div>
        <div class="card-body">
            <h5 class="card-title">{{ product.name}}</h5>
            <p class="card-text">{{ product.description}}</p>
            <p class="card-text">{{ product.price}}</p>
            <a href="#" class="btn btn-secondary">Add to card</a>
        </div>
    </div>

</template>

<script>

export default{
    name: "ProductBox",
    props: ["product"],
    methods: {

    }

}

</script>

<style>

</style>
