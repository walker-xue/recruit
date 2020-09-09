<template>
  <div>
    <!-- <el-menu 
    :default-active="this.$route.path"
    class="el-menu-vertical-demo"
    router>
        <MenuItem :routeData="routesInfo"></MenuItem>
    </el-menu>-->

    <div class="menu-con">
      <div class="menu-title">招聘管理</div>
      <div class="menu-navigation-wrap">
        <template v-for="(item,index) in routesInfo">
          <div
            class="navigation"
            :key="index"
            v-if="item.children"
          >
            <div class="navigation-flex" @click.stop="pushRouter(index,item.meta.open)">
              <img class="navigation-img" :src="imgUrl" alt />
              <!-- 900 -->
              <span class="navigation-txt">{{item.meta.title}}</span>
            </div>
            <ul class="sec-list" :class="[{'sec-list-xz':routerIf==index}]">
              <li class="sec-list-li" v-for="(child,childIndex) in item.children" :key="childIndex">
                <img class="sec-list-img" :src="secUrl" alt />
                <router-link :to="child.path">
                  <span class="sec-list-txt">{{child.meta.title}}</span>
                </router-link>
              </li>
            </ul>
          </div>
          <div class="navigation" :key="index" v-else-if="item.meta.hide != true">
            <div class="navigation-flex">
              <img class="navigation-img" :src="imgUrl" alt />
              <router-link :to="item.path">
                <span class="navigation-txt">{{item.meta.title}}</span>
              </router-link>
            </div>
          </div>
        </template>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import MenuItem from "./menuItem.vue";
export default {
  components: {
    MenuItem,
  },
  data() {
    return {
      imgUrl: require("@/assets/image/folder.gif"),
      secUrl: require("@/assets/image/folder1.gif"),
      routerIf: -1,
    };
  },
  computed: {
    routesInfo: function () {
      return this.$router.options.routes[1].children;
    },
  },
  mounted() {
    console.log("路由", this.routesInfo);
  },
  methods: {
    pushRouter(index) {
      if (this.routerIf == index) {
        this.routerIf = -1;
      } else {
        this.routerIf = index;
      }
    },
  },
};
</script>

<style scoped lang='less'>
.menu-con {
  background: #fff;
  height: calc(100vh - 180px);
  .menu-title {
    margin-left: 12px;
    margin-right: 10px;
    font-weight: bold;
    font-size: 18px;
    color: #d81a21;
    height: 35px;
    line-height: 35px;
    border-bottom: 2px solid #d4d4d4;
  }
  .menu-navigation-wrap {
    margin-left: 12px;
    margin-right: 10px;
    .navigation {
      border-bottom: 1px solid #d4d4d4;
      border-left: 1px solid #d4d4d4;
      margin-top: 2px;
      overflow: hidden;
      .navigation-flex {
        display: flex;
        height: 30px;
        line-height: 30px;
        cursor: pointer;
        justify-content: end;
        align-items: center;
        .navigation-img {
          width: 19px;
          height: 18px;
          margin-left: 10px;
        }
        .active {
          .navigation-txt {
            color: #d81a21;
          }
        }
        .navigation-txt {
          margin-left: 7px;
          font-size: 14px;
          font-weight: bold;
          color: #666666;
        }
      }
      .sec-list {
        display: none;
        &.sec-list-xz {
          display: block;
        }
        .sec-list-li {
          display: flex;
          height: 27px;
          line-height: 27px;
          align-items: center;
          padding-left: 36px;
          cursor: pointer;
          .sec-list-img {
            width: 16px;
            height: 15px;
          }
          .active {
            .sec-list-txt {
              color: #d81a21;
            }
          }
          .sec-list-txt {
            color: #596179;
            font-size: 12px;
            font-weight: bold;
          }
        }
      }
    }
  }
}
</style>
