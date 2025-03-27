import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import bingli from '@/views/modules/bingli/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import yaodan from '@/views/modules/yaodan/list'
    import yaopin from '@/views/modules/yaopin/list'
    import yaopinCollection from '@/views/modules/yaopinCollection/list'
    import yaopinCommentback from '@/views/modules/yaopinCommentback/list'
    import yaopinOrder from '@/views/modules/yaopinOrder/list'
    import yayi from '@/views/modules/yayi/list'
    import yayiCollection from '@/views/modules/yayiCollection/list'
    import yayiCommentback from '@/views/modules/yayiCommentback/list'
    import yayiOrder from '@/views/modules/yayiOrder/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import dictionaryBingli from '@/views/modules/dictionaryBingli/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryJinyong from '@/views/modules/dictionaryJinyong/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryYaopin from '@/views/modules/dictionaryYaopin/list'
    import dictionaryYaopinCollection from '@/views/modules/dictionaryYaopinCollection/list'
    import dictionaryYaopinOrder from '@/views/modules/dictionaryYaopinOrder/list'
    import dictionaryYaopinOrderPayment from '@/views/modules/dictionaryYaopinOrderPayment/list'
    import dictionaryYayiCollection from '@/views/modules/dictionaryYayiCollection/list'
    import dictionaryYayiOrder from '@/views/modules/dictionaryYayiOrder/list'
    import dictionaryYayiOrderYuyue from '@/views/modules/dictionaryYayiOrderYuyue/list'
    import dictionaryZhiwei from '@/views/modules/dictionaryZhiwei/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryBingli',
        name: '状态',
        component: dictionaryBingli
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryJinyong',
        name: '账户状态',
        component: dictionaryJinyong
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryYaopin',
        name: '药品类型',
        component: dictionaryYaopin
    }
    ,{
        path: '/dictionaryYaopinCollection',
        name: '收藏表类型',
        component: dictionaryYaopinCollection
    }
    ,{
        path: '/dictionaryYaopinOrder',
        name: '订单类型',
        component: dictionaryYaopinOrder
    }
    ,{
        path: '/dictionaryYaopinOrderPayment',
        name: '订单支付类型',
        component: dictionaryYaopinOrderPayment
    }
    ,{
        path: '/dictionaryYayiCollection',
        name: '收藏表类型',
        component: dictionaryYayiCollection
    }
    ,{
        path: '/dictionaryYayiOrder',
        name: '订单类型',
        component: dictionaryYayiOrder
    }
    ,{
        path: '/dictionaryYayiOrderYuyue',
        name: '预约类型',
        component: dictionaryYayiOrderYuyue
    }
    ,{
        path: '/dictionaryZhiwei',
        name: '职位',
        component: dictionaryZhiwei
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/bingli',
        name: '病例',
        component: bingli
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/yaodan',
        name: '药单',
        component: yaodan
      }
    ,{
        path: '/yaopin',
        name: '药品',
        component: yaopin
      }
    ,{
        path: '/yaopinCollection',
        name: '药品收藏',
        component: yaopinCollection
      }
    ,{
        path: '/yaopinCommentback',
        name: '药品评价',
        component: yaopinCommentback
      }
    ,{
        path: '/yaopinOrder',
        name: '药品订单',
        component: yaopinOrder
      }
    ,{
        path: '/yayi',
        name: '牙医',
        component: yayi
      }
    ,{
        path: '/yayiCollection',
        name: '牙医收藏',
        component: yayiCollection
      }
    ,{
        path: '/yayiCommentback',
        name: '牙医评价',
        component: yayiCommentback
      }
    ,{
        path: '/yayiOrder',
        name: '牙医挂号',
        component: yayiOrder
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
