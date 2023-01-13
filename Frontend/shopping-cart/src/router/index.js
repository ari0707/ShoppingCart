import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AddCategory from '../views/AddCategory.vue'
import Category from '../views/Category.vue'
import AddProduct from '../views/AddProduct.vue'
import Product from '../views/Product.vue'
import SignUp from '../views/SignUp.vue'
import SignIn from '../views/SignIn.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/category/add',
      name: 'AddCategory',
      component: AddCategory
    },
    {
      path: '/category',
      name: 'Category',
      component: Category
    },
    {
      path: '/product/add',
      name: 'AddProduct',
      component: AddProduct
    },
    {
      path: '/product',
      name: 'Product',
      component: Product
    },
    {
      path: '/signup',
      name: 'Signup',
      component: SignUp
    },
    {
      path: '/signin',
      name: 'Signin',
      component: SignIn
    },

  ]
})

export default router
