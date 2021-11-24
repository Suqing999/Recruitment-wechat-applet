// pages/liebiao/liebiao.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    jobUrls: [],
    jid: '',
    qid: ""
  },
  getJob() {
    let that = this;
    wx.request({
      url: 'http://localhost:8080/zhaoping/getjobsh',
      method: 'GET',
      header: {
        'content-type': 'application/x-www-form-urlencoded'
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
   * 投递工作
   */
  tdjob: function (event) {
    wx.request({
      url: 'http://localhost:8080/zhaoping/chakantoudishuliang',
      method: 'GET',
      data: {
        qid: app.appdata.userinfo.qid
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success(res) {
        if (res.data == "you") {
          wx.showToast({
            title: '请等待面试审核',
            icon: 'loading',
            duration: 1000
          })

        } else if (res.data == "meiyou") {
          let value = event.currentTarget.dataset.value;
          console.log("value：" + value);
          wx.request({
            url: 'http://localhost:8080/zhaoping/toudijob',
            method: 'GET',
            data: {
              jid: value,
              qid: app.appdata.userinfo.qid
            },
            header: {
              'content-type': 'application/x-www-form-urlencoded'
            },
            success(res) {
              if (res.data == "error1") {
                wx.showToast({
                  title: '已经投递',
                  icon: 'loading',
                  duration: 1000
                })

              } else if (res.data == "成功") {
                wx.showToast({
                  title: '投递成功',
                  icon: 'success',
                  duration: 3000
                })
              }
            },
            fail: function (res) {
              console.log("--------fail--------");
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
   * 收藏工作
   */
  scjob: function (event) {
    let value = event.currentTarget.dataset.value;
    console.log("value：" + value);
    wx.request({
      url: 'http://localhost:8080/zhaoping/shoucangjob',
      method: 'GET',
      data: {
        jid: value,
        qid: app.appdata.userinfo.qid
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success(res) {
        if (res.data == "error1") {
          wx.showToast({
            title: '已经收藏',
            icon: 'loading',
            duration: 1000
          })

        } else if (res.data == "成功") {
          wx.showToast({
            title: '收藏成功',
            icon: 'success',
            duration: 3000
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
    this.getJob();
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