'use strict'

const path = require('path')

function resolve(dir) {
  return path.join(__dirname, dir)
}

module.exports = {
  outputDir: 'target/ui',
  productionSourceMap: false,

  pages: {
    index: {
      // page 的入口
      entry: 'src/views/index/index.js',
      // 模板来源
      template: 'public/index.html',
      // 在 dist/index.html 的输出
      filename: 'index.html',
      // 当使用 title 选项时，
      // template 中的 title 标签需要是 <title><%= htmlWebpackPlugin.options.title %></title>
      title: '软通动力招聘系统',
      // 在这个页面中包含的块，默认情况下会包含
      // 提取出来的通用 chunk 和 vendor chunk。
      chunks: ['chunk-vendors', 'chunk-common', 'index']
    },
    // 当使用只有入口的字符串格式时，
    // 模板会被推导为 `public/subpage.html`
    // 并且如果找不到的话，就回退到 `public/index.html`。
    // 输出文件名会被推导为 `subpage.html`。
    // login: 'src/views/login/login.js',
    // subpage: 'src/views/login/login.js',
    // demo: 'src/views/demo/demo.js'
  },

  configureWebpack: (config) => {
    if (process.env.NODE_ENV === 'production') {
      // 为生产环境修改配置...
      config.mode = 'production'
    } else {
      // 为开发环境修改配置...
      config.mode = 'development'
    }
    Object.assign(config, {
      // 开发生产共同配置
      resolve: {
        alias: {
          '@': path.resolve(__dirname, './src'),
          '@assets': path.resolve(__dirname, './src/assets')
        } // 别名配置
      }
    })
  },

  devServer: {
    open: true, // 是否自动弹出浏览器页面
    host: 'localhost',
    port: '3000',
    https: false,
    hotOnly: true,
    proxy: {
      '/api': {
        target: process.env.VUE_APP_REQUEST_DEMO,
        ws: true, // 代理websockets
        pathRewrite: {
          '^/api': '' // remove base path
        },
        changeOrigin: true
      }
    }
  }
}
