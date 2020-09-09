<template>
    <div>
        <Information></Information>
        <div class='main'>
            <div class='header'>
                <div class='header-title'>待处理事项</div>
            </div>
            <!-- 待办 -->
            <div class='notice-wrap'>
                <div class='notice'>
                    <div class='notice-title'>待处理任务通知</div>
                    <ul class='notice-ul'>
                        <li class='notice-list' v-for="(item,index) in list" :key='index'>
                            <p>
                                {{index+1}}、简历录入：<span class='notice-list-name'>{{item.name}}</span>
                            </p>
                            <p>{{item.time}}</p>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- 图表 -->
            <div class='chart'>
                <div class='chart-list'>
                    <p>招聘情况统计</p>
                    <div :style="{width: '300px', height: '200px'}" id='recruitLine'></div>
                </div>
                <div class='chart-list'>
                    <p>需求完成情况统计</p>
                    <div :style="{width: '300px', height: '200px'}" id='demandLine'></div>
                </div>
            </div>
        </div>

    </div>
</template>

<script type="text/ecmascript-6">
  import Information from '@/components/Information/index.vue'
  export default {
    components: {
      Information
    },
    data() {
      return {
        list: [
          {name: '张丽华java录入', time: '2020年8月1号'},
          {name: '张丽华c录入', time: '2020年8月2号'},
          {name: '张丽华c++录入', time: '2020年8月3号'},
          {name: '张丽华c#录入', time: '2020年8月4号'},
          {name: '张丽华php录入', time: '2020年8月5号'},
          {name: '张丽华python录入', time: '2020年8月6号'},
        ]
      }
    },
    mounted() {
      this.recruitLine()
      this.demandLine()
    },
    methods: {
      // 招聘图表
      recruitLine() {
        // 基于准备好的dom，初始化echarts实例
        let myChart = this.$echarts.init(document.getElementById('recruitLine'))
        // 绘制图表
        myChart.setOption({
          title: {
            // text: '2016年12月长宁区合规成本分析'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: { // 坐标轴指示器，坐标轴触发有效
              type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
          },
          legend: {
            data: ['包租费', '装修费', '保洁费'],
            align: 'right',
            right: 10
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          xAxis: [{
            type: 'category',
            data: ['新虹桥', '中山公园', '虹桥']
          }],
          yAxis: [{
            type: 'value',
            name: '总价(万元)',
            axisLabel: {
              formatter: '{value}'
            }
          }],
          series: [{
            name: '包租费',
            type: 'bar',
            data: [20, 12, 31]
          }, {
            name: '装修费',
            type: 'bar',
            data: [10, 20, 5]
          }, {
            name: '保洁费',
            type: 'bar',
            data: [1, 1, 2]
          }]
        });
      },
      // 招聘图表
      demandLine() {
        // 基于准备好的dom，初始化echarts实例
        let myChart = this.$echarts.init(document.getElementById('demandLine'))
        // 绘制图表
        myChart.setOption({
          title: {
            // text: '2016年12月长宁区合规成本分析'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: { // 坐标轴指示器，坐标轴触发有效
              type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
          },
          legend: {
            data: ['包租费', '装修费', '保洁费'],
            align: 'right',
            right: 10
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          xAxis: [{
            type: 'category',
            data: ['新虹桥', '中山公园', '虹桥']
          }],
          yAxis: [{
            type: 'value',
            name: '总价(万元)',
            axisLabel: {
              formatter: '{value}'
            }
          }],
          series: [{
            name: '包租费',
            type: 'bar',
            data: [20, 12, 31]
          }, {
            name: '装修费',
            type: 'bar',
            data: [10, 20, 5]
          }, {
            name: '保洁费',
            type: 'bar',
            data: [1, 1, 2]
          }]
        });
      },
    }
  }
</script>

<style scoped lang='less'>
    .main {
        width: calc(100% - 20px);
        margin: 0 auto;
        .header {
            height: 41px;
            line-height: 41px;
            margin-bottom: 10px;
            border-bottom: 3px solid #d4d4d4;
            .header-title {
                padding-left: 25px;
                font-size: 16px;
                font-weight: bold;
                color: #333;
                background: url("~@/assets/image/f_i6.gif") no-repeat center left;
            }
        }

        .notice-wrap {
            position: relative;
            width: 100%;
            box-shadow:0 0 0 1px #d4d4d4,0 0 0 5px #fff;
            padding: 2px;
            height: 300px;
            .notice {
                width: 100%;
                height: 100%;
                .notice-title {
                    background: #e9e9e9;
                    height: 32px;
                    line-height: 32px;
                    font-size: 14px;
                    font-weight: bold;
                    color: #677286;
                    padding-left: 10px;
                }
                .notice-ul {
                    position: relative;
                    width: 100%;
                    .notice-list {
                        height: 30px;
                        line-height: 30px;
                        display: flex;
                        justify-content: space-between;
                        padding: 0 12px;
                        background: #fff;
                        &.notice-list:nth-child(even){
                            background: #f8f8f8;
                        }
                        .notice-list-name {
                            position: relative;
                            color: #667e97;
                            cursor: pointer;
                            &:before {
                                position: absolute;
                                content: '';
                                top: 9px;
                                right: -16px;
                                width: 6px;
                                height: 6px;
                                background: #d51922;
                                border-radius: 50%;
                            }
                        }
                    }
                }
            }
        }
        .chart {
            width: 100%;
            height: 300px;
            display: flex;
            justify-content: space-evenly;
            border: 1px solid #d4d4d4;
            margin-top: 10px;
            background: #f8f8f8;
            .chart-list {
                font-size: 14px;
                padding-top: 30px;
                font-weight: bold;
                p{
                    margin-bottom: 20px;
                }
            }
        }
    }
</style>
