<template>

    <div class="card w-100 h-70" style="margin-top: 10px;">
        <div>
            <img :src="category.imageUrl" class="card-img-top" alt="Category Image">
        </div>
        <div class="card-body">
            <h3 class="card-title">{{ category.categoryName}}</h3>
            <p class="card-text">{{ category.description}}</p>
            <a href="#" class="btn btn-secondary">See products</a>
        </div>
    </div>

</template>

<script>

export default{
    name: "CategoryBox",
    props: ["category"],
    methods: {

    }

}

</script>

<style>
.card-title {
  color: #524d25;
  font-size: 1.5rem;
  font-weight: 500;
}
.card-body{
    background-color: #dfebbf;
}

</style>
