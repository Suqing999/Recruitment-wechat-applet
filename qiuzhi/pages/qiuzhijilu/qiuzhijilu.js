// pages/liebiao/liebiao.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    jid: '',
    qid: ""
  },
  getscJob() {
    let that = this;
    wx.request({
      url: 'http://localhost:8080/zhaoping/gettoudijob',
      method: 'GET',
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        qid: app.appdata.userinfo.qid
      },
      success(res) {
        console.log(res);
        var s = [];
        for (var i = 0; i < res.data.length; i++) {
          s[i] = res.data[i];
          // console.log(res.data[i]);
        }
        that.setData({
          jobUrls: s,
        })

        console.log(that.data.jobUrls[0])
      },
      fail: function (res) {
        console.log("--------fail--------");
      }
    })
  },
  /**
   * 投递工作状态
   */
  ztjob: function (event) {
    let value = event.currentTarget.dataset.value;
    console.log("value：" + value);
    wx.request({
      url: 'http://localhost:8080/zhaoping/ztjob',
      method: 'GET',
      data: {
        jid: value,
        qid: app.appdata.userinfo.qid
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success(res) {
        if (res.data == "num1") {
          wx.showModal({
            title: '面试结果',
            content: '简历未被查看',
            success: function (res) {
              if (res.confirm) {
                console.log('用户点击确定')
              } else if (res.cancel) {
                console.log('用户点击取消')
              }
            }
          })
          

        } else if (res.data == "num2") {
          wx.showModal({
            title: '面试结果',
            content: '简历通过筛选将电话通知面试',
            success: function (res) {
              if (res.confirm) {
                console.log('用户点击确定')
              } else if (res.cancel) {
                console.log('用户点击取消')
              }
            }
          })

        } else if (res.data == "num3") {
          wx.showModal({
            title: '面试结果',
            content: '抱歉简历筛选未通过',
            success: function (res) {
              if (res.confirm) {
                console.log('用户点击确定')
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
    this.getscJob();
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