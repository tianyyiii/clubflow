<template>
    
</template>


<script>

export default{
    name:"ClubIndex",
    components:{
    },
    data () {
        return{
            ClubId:0,
        }
    },
    methods:{

    },
    created(){
        this.ClubId=this.$route.query.ClubId
    },
    mounted(){

    }
}

</script>