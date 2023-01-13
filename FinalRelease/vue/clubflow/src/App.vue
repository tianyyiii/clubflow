<template>
  <!-- <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  </nav> -->
  <div id="app">
    <router-view/>
  </div>
  <!-- <router-view/> -->
</template>

<script>

import NavMenu from '@/components/common/NavMenu'

  export default {
    name: 'App',
    components: {NavMenu},
    methods:{
      
    }
  }

</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  // text-align: center;
  color: #2c3e50;
}
button {
    border: 0; background-color: inherit;
    color: inherit;
}
.textlines-overflow-2 {
    /* 最多两行 */
    display: -webkit-box;  /*弹性伸缩盒子*/
    -webkit-box-orient: vertical;/*垂直排列*/
    line-clamp: 2;
    -webkit-line-clamp: 2;  /*只显示2行*/
    overflow: hidden;   /*溢出隐藏*/
    text-overflow: ellipsis;   /*省略号代替*/
}

// nav {
//   padding: 30px;

//   a {
//     font-weight: bold;
//     color: #2c3e50;

//     &.router-link-exact-active {
//       color: #42b983;
//     }
//   }
// }
</style>
