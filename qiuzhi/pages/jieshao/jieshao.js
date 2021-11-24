var app = getApp();

// pages/jieshao/jieshao.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    companyxiangxi:"",
    companyname:"",
    companyfuli:"",
    companyyewu: "",
    companyjianjie: "",
    nickname:"",
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    isHide: false,
    imgUrls: [
      '../../images/jianzhi.jpg',
      '../../images/guanggao.png',
      '../../images/guanggao.png'
    ],
    indicatorDots: true, //是否显示面板指示点
    autoplay: true, //是否自动切换
    interval: 3000, //自动切换时间间隔,3s
    duration: 1000, //  滑动动画时长1s
  },

  getPic(){
    let that = this;
    wx.request({
      url: 'http://localhost:8080/zhaoping/getpic',
      method: 'GET',
      header: {
        'content-type': 'application/json'
      },
      success(res) {
        console.log(res);
       var s=[];
       for(var i =0;i<res.data.length;i++){
         s[i] = res.data[i].wxpic;
         console.log(res.data[i].wxpic);
       }
       
        that.setData({
            imgUrls:s,
        })
        

      },
      fail: function (res) {
        console.log("--------fail--------");
      }
    })
  },

  getlocate: function () {
    console.log("dianjilog")
    wx.getLocation({
      type: 'wgs84',
      success: function (res) {
        console.log("dianjilog2")
        wx.openLocation({//​使用微信内置地图查看位置。
          latitude: 25.074568 ,//要去的纬度-地址
          longitude:102.730063,//要去的经度-地址
          name: "昆明同德广场",
          address: '昆明同德广场'
        })
      }
       
    });
    console.log("dianjilog3");
  },



  getCompany() {
    let that = this;
    wx.request({
      url:'http://localhost:8080/zhaoping/getcompany',
      method: 'GET',
      header: {
        'content-type': 'application/json'
      },
      success(res) {
        console.log(res);
        console.log(res.data.id);
        that.setData({
          companyxiangxi: res.data.companyxiangxi,
          companyfuli:res.data.companyfuli,
          companyname:res.data.companyname,
          companyyewu: res.data.companyyewu,
          companyjianjie:res.data.companyjianjie
        })
       
      },
      fail: function (res) {
        console.log("--------fail--------");
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    this.getCompany(),   //获得公司信息
    this.getPic();       //获得公司图片
    if(app.appdata.userinfo==null){   //如果用户没有登陆，做了一个拦截
      wx.redirectTo({
        url: '../login/login',
      })
    }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})