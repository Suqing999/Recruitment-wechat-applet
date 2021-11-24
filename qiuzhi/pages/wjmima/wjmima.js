// pages/regist/regist.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    name: '',
    username: '',
    newpassword: ''
  },
  name: function (event) {
    console.log(event.detail.value);
    this.setData({
      name: event.detail.value
    })
  },
  username: function (event) {
    console.log(event.detail.value);
    this.setData({
      username: event.detail.value
    })
  },
  newpassword: function (event) {
    console.log(event.detail.value);
    this.setData({
      newpassword: event.detail.value
    })
  },
  wangjiQQ: function (e) {
    console.log("dianji")
    let that = this;
    wx.request({
      url: 'http://localhost:8080/zhaoping/wangjiQQ',
      method: 'GET',
      data: {
        name: that.data.name,
        username: that.data.username,
        newpassword: that.data.newpassword
      },
      header: {
        'content-type': 'application/json'
      },
      success(res) {
        console.log(res);
         if(res.data=='成功'){
           wx.showToast({
             title: '成功',
             icon: 'success',
             duration: 3000
           })

           wx.redirectTo({
             url: '/pages/login/login',
           })
         }else{
           wx.showToast({
             title: '失败',
             icon: 'loading',
             duration: 3000
           })

           wx.redirectTo({
             url: '/pages/wjmima/wjmima',
           })
         }

        
      },
      fail: function (res) {
        console.log("--------fail--------");
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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