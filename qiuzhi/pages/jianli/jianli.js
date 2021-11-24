// pages/jianli/jianli.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    qid: "",
    address: "",
    content: "",
    nianfeng:"",
    email: "",
    gender: "",
    gzjy: "",
    jobtitle: "",
    mqzt: "",
    name: "",
    qwxz: "",
    qzxz: "",
    tel: "",
    zgxl: "",
    currentstatus: ["我目前已离职,可快速到岗", "我目前在职，但考虑换个新环境", "观望有好的机会再考虑", "目前暂无跳槽打算", "应届毕业生"],
    currentstatusindex: -1,
    express: ["无经验", "1年以下", "1-3年", "3-5年", "5-10年", "10年以上"],
    expressindex: -1,
    expressname: "",
    education: ["初中", "高中", "中技", "中专", "大专", "本科", "硕士", "博士", "博后"],
    educationindex: -1,
    sex: 1,
    birthday: ["1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018","2019","2020"],
    birthdayindex: -1, 
    worktype: ["校园招聘", "社会招聘", "实习"],
    worktypeindex: -1,
    money: ["1千~2千/月", "2千~3千/月", "3千~4千/月", "4千~5千/月", "5千~1万/月", "1万以上/月"],
    moneyindex: -1,
  },

  bindWorktypeChange: function (e) {
    var a = this.data.worktype;
    a && (this.data.worktypeindex = e.detail.value, this.data.worktypename = a[e.detail.value]),
      console.log(this.data.worktypename), this.setData({
        worktype: a,
        worktypeindex: e.detail.value
      });
  },
/**
 * 提交表单
 */
  formSubmit:function(e){
    console.log('form发生了submit事件，携带数据为：', e.detail.value);
    wx.request({
      url: 'http://localhost:8080/zhaoping/toudijianli',
      method: 'GET',
      data:{
        qid: app.appdata.userinfo.qid,
        address: e.detail.value.address,
        content: e.detail.value.content,
        email: e.detail.value.email,
        gender: e.detail.value.gender,
        gzjy: e.detail.value.gzjy,
        jobtitle: e.detail.value.jobtitle,
        mqzt: e.detail.value.mqzt,
        name: e.detail.value.name,
        qwxz: e.detail.value.qwxz,
        qzxz: e.detail.value.qzxz,
        tel: e.detail.value.tel,
        zgxl: e.detail.value.zgxl,
        nianfeng: e.detail.value.nianfeng
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success(res) {
        console.log(res);
        
       
      },
      fail: function (res) {
        console.log("--------fail--------");
      }
    })
  },


  bindBirthdayChange: function (e) {
    var a = this.data.birthday;
    a && (this.data.birthdayindex = e.detail.value, this.data.birthdayname = a[e.detail.value]),
      this.setData({
        birthday: a,
        birthdayindex: e.detail.value
      });
  },
  radioChange: function (e) {
    this.data.sex = e.detail.value;
  },
  bindEducationChange: function (e) {
    var a = this.data.education;
    a && (this.data.educationindex = e.detail.value, this.data.educationname = a[e.detail.value]),
      console.log(this.data.educationname), this.setData({
        education: a,
        educationindex: e.detail.value
      });
  },
  bindExpressChange: function (e) {
    var a = this.data.express;
    a && (this.data.expressindex = e.detail.value, this.data.expressname = a[e.detail.value]),
      console.log(this.data.expressname), this.setData({
        express: a,
        expressindex: e.detail.value
      });
  },
  bindMoneyChange: function (e) {
    var a = this.data.money;
    a && (this.data.moneyindex = e.detail.value, this.data.moneyname = a[e.detail.value]),
      console.log(this.data.moneyname), this.setData({
        money: a,
        moneyindex: e.detail.value
      });
  },
  bindCurrentstatusChange: function (e) {
    var a = this.data.currentstatus;
    a && (this.data.currentstatusindex = e.detail.value, this.data.currentstatusname = a[e.detail.value]),
      console.log(this.data.currentstatusname), this.setData({
        currentstatus: a,
        currentstatusindex: e.detail.value
      });
  },


  ishavejianli(){
    wx.request({
      url: 'http://localhost:8080/zhaoping/ishavejianli',
      method: 'GET',
      data: {
        qid: app.appdata.userinfo.qid
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success(res) {
        console.log(res);
        if(res.data=="success"){
          wx.showModal({
            title: '提示',
            content: '您已有简历是否修改',
            success: function (res) {
              if (res.confirm) {
                wx.switchTab({
                  url: '/pages/mine/mine',
                })
                wx.navigateTo({
                  url: '/pages/xiugai/xiugai',
                })
              } else if (res.cancel) {
                wx.switchTab({
                  url: '/pages/mine/mine',
                })
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
        this.ishavejianli();
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