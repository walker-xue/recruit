<template>
    <div>
        <Header></Header>
        <div class='main-wrap'>
            <SideBar class='sidebar-container'></SideBar>
            <div class='main-container'>
                <router-view />
            </div>

        </div>

    </div>
</template>

<script type="text/ecmascript-6">
  import Header from '@/components/Header/index'
  import SideBar from './components/SideBar/index'
  export default {
    components:{
      Header,
      SideBar
    }
  }
</script>

<style scoped lang='less'>
    .main-wrap {
        position: relative;
        width: 1000px;
        margin: 0 auto;
        height: calc(100vh - (94px + 40px));
        background: #e9e9e9;

        .sidebar-container {
            position: absolute;
            left: 10px;
            padding-top: 10px;
            width: 220px;
        }
        .main-container {
            position: absolute;
            left: 240px;
            top: 10px;
            /*减去左边导航然宽度*/
            width: calc(1000px - 250px);
            height: calc(100% - 15px);
            background: #fff;
        }
    }

</style>
