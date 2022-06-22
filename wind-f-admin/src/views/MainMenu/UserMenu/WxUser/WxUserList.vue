<template>
  <div class='wind-main'>
    <div class='wind-data-search'>
      <QueryFormItem :label='"微信昵称"'>
        <el-input label='微信昵称'></el-input>
      </QueryFormItem>
    </div>
    <div class='wind-data-table'>
      <el-table :data='accountList'>
        <el-table-column prop='wxNickName' label='微信昵称' width='100' />
        <el-table-column label='微信头像' width='80'>
          <template v-slot:default='{row}'>
            <img :src='row.wxAvatar' height='50' width='50' alt='' />
          </template>
        </el-table-column>
        <el-table-column prop='loginDate' label='最近登录时间' width='180' />
        <el-table-column prop='loginIp' label='最近登录ip' width='130' />
        <el-table-column prop='registerDate' label='注册时间' width='180' />
        <el-table-column prop='registerIp' label='注册ip' width='130'/>
        <el-table-column prop='accountStatusText' label='账号状态'></el-table-column>
        <el-table-column fixed="right" label="操作" width="300">
          <template #default='{row}'>
            <el-button type="text" size="small" v-if='row.userId'>用户详情</el-button>
            <el-button type="text" size="small" v-else>绑定用户</el-button>
            <el-button type='text' size='small'>删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>
<script lang='ts' setup>
import { onMounted, reactive } from 'vue';
import { QueryWxAccount, WxAccount } from '@/views/MainMenu/UserMenu/WxUser/WxUser';
import { apiMethod } from '@/config/api_config/apis';
import { useStoreWithType } from '@/config/store_config';
import { Page } from '@/config/api_config/apis_class';
import QueryFormItem from '@/components/CustomComponent/QueryFormItem.vue';

let accountList = reactive<WxAccount[]>([]);
let page = reactive<Page>({ pageIndex: 1, pageLimit: 10})
let queryWxUser = reactive<QueryWxAccount>({ accountName: null })
onMounted(async () => {
  useStoreWithType().state.user._token = "8"
  let res = await apiMethod.getWxAccountList({...queryWxUser, ...page});
  accountList.push(...res.result);
});
</script>
<style lang='scss' scoped>
.wind-main{
  margin: 10px;
}
.wind-data-search{
  padding: 10px;
  background: #FFF;
  margin-bottom: 20px;
}
</style>
