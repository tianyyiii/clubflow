<template>
    <div>
      <NavMenu></NavMenu>
      <router-view/>
      <Footer></Footer>
    </div>
  </template>
  <script>
  
    import NavMenu from '@/components/common/NavMenu.vue'
    import Footer from '@/components/common/About.vue'
    export default {
      components: {NavMenu,Footer}
    }
  </script>
  
  <style>
    
  </style>
  