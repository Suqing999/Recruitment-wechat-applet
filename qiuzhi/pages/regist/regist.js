// pages/regist/regist.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    name:'',
    username: '',
    password: '',
    ymz:'',
    code:'',
    password2:""
  },
  name: function (event) {
    console.log(event.detail.value);
    this.setData({
      name: event.detail.value
    })
  },
  password2: function (event) {
    console.log(event.detail.value);
    this.setData({
      password2: event.detail.value
    })
  },
  yzm: function (event) {
    console.log(event.detail.value);
    this.setData({
      yzm: event.detail.value
    })
  },
  username: function (event) {
    console.log(event.detail.value);
    this.setData({
      username: event.detail.value
    })
  },
  password: function (event) {
    console.log(event.detail.value);
    this.setData({
      password: event.detail.value
    })
  },
  registQQ:function(e){
  


    console.log("dianji")
    let that = this;
    if (that.data.password == that.data.password2){
      if (that.data.yzm == that.data.code) {
        wx.request({
          url: 'http://localhost:8080/zhaoping/registQQ',
          method: 'GET',
          data: {
            name: that.data.name,
            username: that.data.username,
            password: that.data.password
          },
          header: {
            'content-type': 'application/json'
          },
          success(res) {
            wx.showToast({
              title: '注册成功',
              icon: 'success',
              duration: 3000
            })

            wx.redirectTo({
              url: '/pages/login/login',
            })
          },
          fail: function (res) {
            console.log("--------fail--------");
          }
        })

      } else {
        wx.showToast({
          title: '验证码错误',
          icon: 'loading',
          duration: 3000
        })

      }

    }else{
      wx.showToast({
        title: '两次密码不一致',
        icon: 'loading',
        duration: 3000
      })
    }
    
  },

  createCode() {

    var code;

    //首先默认code为空字符串

    code = '';

    //设置长度，这里看需求，我这里设置了4

    var codeLength = 4;

    //设置随机字符

    var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

    //循环codeLength 我设置的4就是循环4次

    for (var i = 0; i < codeLength; i++) {

      //设置随机数范围,这设置为0 ~ 36

      var index = Math.floor(Math.random() * 36);

      //字符串拼接 将每次随机的字符 进行拼接

      code += random[index];

    }

    //将拼接好的字符串赋值给展示的code

    this.setData({

      code: code

    })

  },




  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      this.createCode();
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