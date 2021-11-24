// pages/wbjianli/wbjianli.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    qid: "",
    u:"http://localhost:8080/zhaoping/webview/wenjian.jsp"
  },
  jianceshifouyoujianli(){
    let that = this;
    wx.request({
      url: 'http://localhost:8080/zhaoping/shifouyoujianli',
      method: 'GET',
      header: {
        'content-type': 'application/json'
      },
      data: {
        qid: app.appdata.userinfo.qid
      },
      success(res) {
        console.log(res);
        if(res.data=="meiyou"){
          wx.showModal({
            title: '提示',
            content: '您没有简历',
            success: function (res) {
              if (res.confirm) {
                wx.switchTab({
                  url: '/pages/mine/mine',
                })
              } else if (res.cancel) {
                wx.switchTab({
                  url: '/pages/mine/mine',
                })
              }
            }
          })
          
        } else {
     wx.showModal({
            title: '提示',
            content: '您上传的简历以最新的为准',
            success: function (res) {
              if (res.confirm) {
                console.log('用户点击确定');
                that.setData({
                  qid: app.appdata.userinfo.qid
                })
              } else if (res.cancel) {
                console.log('用户点击取消')
              }
            }
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
   
    this.jianceshifouyoujianli()
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