<template>
    <!-- 副标题 -->
    <div class="subtitle container d-flex flex-column justify-content-center " style="margin-top: 100px; margin-bottom: 70px;">
        <div class="mt-0 d-flex justify-content-center d-inline-flex text-center align-items-center">
            <!-- Unnamed (线) -->
            <div class="myline me-3 px-0">
                <img class="img" src="@/assets/images/shetuanshequ_index/u95.svg"/>
            </div>
            <div class="subtitle text text-center">
                <span>{{subtitle}}</span>
            </div>
            <!-- Unnamed (线) -->
            <div class="myline ms-3 px-0">
                <img class="img " src="@/assets/images/shetuanshequ_index/u95.svg"/>
            </div>
        </div>
        
        <!-- Unnamed (矩形) -->
        <div class="d-flex mt-1 justify-content-center text-center">
            <div id="u107_div" class="myunderline"></div>
        </div>
    </div>
</template>

<script>
export default {
    name:"SubTitle",
    components:{},
    props:["subtitle"]
}

</script>

<style scoped>
.subtitle.text {
    font-size:28px;
}
.myline > img {
    width:79px;
    height:7px;
  }
.myline {
    border-width:0px;
    padding: 0;
    width:75px;
    height:3px;
    display:flex;
    -webkit-transform:rotate(0.0074067811916994deg);
    -moz-transform:rotate(0.0074067811916994deg);
    -ms-transform:rotate(0.0074067811916994deg);
    transform:rotate(0.0074067811916994deg);
  }
  .myunderline {
    width:63px;
    height:10px;
    background:inherit;
    background-color:rgba(184, 45, 41, 1);
    border:none;
    border-radius:8px;
    -moz-box-shadow:none;
    -webkit-box-shadow:none;
    box-shadow:none;
  }

</style>