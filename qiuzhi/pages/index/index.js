// pages/message/message.js
var app=getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
      searchjob:"",
      imgUrls: [
      '../../images/guanggao.png',
      '../../images/guanggao.png'
      ],
      indicatorDots: true, //是否显示面板指示点
      autoplay: true, //是否自动切换
      interval: 3000, //自动切换时间间隔,3s
      duration: 1000, //  滑动动画时长1s

  },
  //搜索内容
  find:function(e){
     let that = this;
      console.log("点击搜索");
      console.log("模糊搜索"+that.data.searchjob);
      app.searchData.searchdata = that.data.searchjob;
      wx.navigateTo({
        url: '/pages/liebiao3/liebiao3',
      })      
  },

  searchInput: function (e) {
    this.setData({
      searchjob: e.detail.value
    })
  },

  tiaozhuan: function () {
    wx.navigateTo({
      url: '/pages/liebiao/liebiao',
    })
  },
  tiaozhuan2:function(){
    wx.navigateTo({
      url: '/pages/liebiao2/liebiao2',
    })
  },







  /**
   * 生命周期函数--监听页面加载
   */
  
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