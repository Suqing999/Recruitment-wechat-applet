// pages/mine/mine.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    name:"",
    qid:""
  },
  xiugaijianli:function(event){
    let value = event.currentTarget.dataset.value;
    console.log("value：" + value)
    wx.navigateTo({
      url: '/pages/xiugai/xiugai',
    })
  },

  close:function(){
    app.appdata.userinfo =null;
    console.log(app.appdata.userinfo);
    wx.redirectTo({
      url: '/pages/login/login',
    })
  },
  bianxiejianli:function(event){
    let value = event.currentTarget.dataset.value;
    console.log("value：" + value)
    wx.navigateTo({
      url: '/pages/jianli/jianli',
    })
  },
  shoucangzhiwei: function () {
    wx.navigateTo({
      url: '/pages/shoucang/shoucang',
    })
  },
  qiuzhifankui: function () {
    wx.navigateTo({
      url: '/pages/qiuzhijilu/qiuzhijilu',
    })
  },
   yijianfankui: function () {
    wx.navigateTo({
      url: '/pages/yijian/yijian',
    })
  },
  shangchuang: function () {
    wx.navigateTo({
      url: '/pages/wbjianli/wbjianli',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
        console.log(app.appdata.userinfo.u)
        this.setData({
          name: app.appdata.userinfo.name,
          qid: app.appdata.userinfo.qid
        })
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