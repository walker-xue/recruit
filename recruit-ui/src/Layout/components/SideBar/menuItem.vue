<template>
  <div>
    <template v-for="(child,index) in routeData">
      <el-submenu v-if="child.children" :key="index" :index="child.path">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>{{child.meta.title}}</span>
        </template>
        <MenuItem :routeData="child.children"></MenuItem>
      </el-submenu>
      <el-menu-item :index="child.path" :key="index" v-else-if="child.meta.hide != true">
        <i class="el-icon-menu"></i>
        <span slot="title">{{child.meta.title}}</span>
      </el-menu-item>
    </template>
  </div>
</template>

<script>
export default {
  name: "MenuItem",
  props: {
    routeData: {
      type: [Object, Array],
      required: {},
    },
  },

  datta() {
    return {
      // routeData: this.routeData
    };
  },
  mounted() {
    console.log("内部", this.routeData);
  },
};
</script>