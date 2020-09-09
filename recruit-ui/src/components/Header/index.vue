<template>
    <div class='header-wrap'>
        <div class='nav'>

        </div>
        <div class='header'>
            <p class='header-title'>
                <span class='header-name-l'>IPSA</span>
                <span class='header-name-r'>招聘管理系统</span>
            </p>
        </div>
    </div>
</template>

<script type="text/ecmascript-6">
  export default {}
</script>

<style scoped lang='less'>
    .header-wrap {
        width: 100%;
    }
    .nav {
        width: 100%;
        height: 40px;
        background: #d61a21;
    }
    .header {
        width: 1000px;
        height: 86px;
        margin: 0 auto;
        background: #e9e9e9;
        border-bottom: 5px solid #d81a21;
        .header-title {
            line-height: 86px;
            .header-name-l {
                padding-left: 20px;
                font-size: 36px;
                font-weight: bold;
                color: #d81a21;
            }
            .header-name-r {
                padding-left: 10px;
                font-size: 24px;
                color: #555555;
            }
        }
    }
</style>
