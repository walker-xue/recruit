<template>
    <div class='information-wrap'>
        <div class='information'>
           <span class='information-name'>欢迎您，{{name}}</span> <span class='information-time'>[{{time}}]</span>
        </div>
    </div>
</template>

<script type="text/ecmascript-6">
  export default {
    data(){
      return {
        name:'胡鹏',
        // timer: null,
        time: null
      }
    },
    mounted() {
      // this.timer = setInterval(() => {
        let date = new Date();
        let dateYear = date.getFullYear(); //获取年
        let dateMonth = this.repair(date.getMonth() + 1); //获取月
        let dateDate = this.repair(date.getDate()); //获取当日
        // let dateHours = this.repair(date.getHours()); //获取小时
        // let dateMinutes = this.repair(date.getMinutes()); //获取分钟
        // let dateSeconds = this.repair(date.getSeconds()); //获取秒
        // ${dateHours}:${dateMinutes}:${dateSeconds}
        this.time = `${dateYear}-${dateMonth}-${dateDate}`;
      // }, 1000);
    },
    methods: {
      repair(data) {
        return data < 10 ? "0" + data : data;
      },
    },
    beforeDestroy() {
      // if (this.timer) {
      //   clearInterval(this.timer); // 在Vue实例销毁前，清除我们的定时器
      // }
    }
  }
</script>

<style scoped lang='less'>
.information-wrap {
    width: 100%;
    background: linear-gradient(top,#e9e9e9,#fff);
    background: -webkit-linear-gradient(top,#e9e9e9,#fff);
    background: -ms-linear-gradient(top,#e9e9e9,#fff);
}
.information {
    width: calc(100% - 20px);
    margin: 0 auto;
    height: 40px;
    line-height: 40px;
    border-bottom: 1px solid #d4d4d4;
    font-size: 12px;

    .information-name {
        color: #455e6d;
    }
    .information-time {
        color: #afafaf;
        margin-left: 5px;
    }
}
a{

}
</style>
